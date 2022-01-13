/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package giocatore_completo_1;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author HP
 */
public class Thread_collegamento extends Thread {

    JCondivisa cond;
    Gestore_messaggio gm;
    boolean valido;
    int larghezza_frame;

    public Thread_collegamento(JCondivisa cond, int larghezza_frame) {
        this.cond = cond;
        gm = new Gestore_messaggio(cond);
        valido = false;
        this.larghezza_frame = larghezza_frame;
    }

    @Override
    public void run() {
        while (!cond.collegato) {
            byte[] bufferRicezione = new byte[1500];
            DatagramPacket pacchettoRicezione = new DatagramPacket(bufferRicezione, bufferRicezione.length);

            try {
                cond.server.receive(pacchettoRicezione);
            } catch (IOException ex) {
                Logger.getLogger(Thread_collegamento.class.getName()).log(Level.SEVERE, null, ex);
            }

            String IPClient = pacchettoRicezione.getAddress().toString();
            int portClient = pacchettoRicezione.getPort();
            String messaggio = new String(pacchettoRicezione.getData());
            System.out.println(messaggio);

            String[] campi = messaggio.split(";");

            if (campi[0].equals("c") && !cond.inAttesa && !cond.chiesto_io) {
                String indirizzo = pacchettoRicezione.getAddress().toString().substring(1, pacchettoRicezione.getAddress().toString().length());
                cond.setIndirizzo_avversario(indirizzo);
                if (!campi[1].equals("")) {
                    cond.setNome_avversario(campi[1]);
                    cond.larghezza_frame_avversario = Integer.valueOf(campi[2]);
                    valido = true;
                } else {
                    try {
                        gm.invia("n", "");
                        cond.setIndirizzo_avversario(null);
                    } catch (IOException ex) {
                        Logger.getLogger(Thread_collegamento.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if (valido) {
                    try {
                        int dialogResult = JOptionPane.showConfirmDialog(null, "Vuoi giocare con " + campi[1] + "?", "Warning", JOptionPane.YES_NO_OPTION);
                        if (dialogResult == JOptionPane.YES_OPTION) {
                            String nome = JOptionPane.showInputDialog(null, "Inserisci il tuo nickname");
                            gm.invia("y", nome, larghezza_frame);
                            cond.nome = nome;
                            cond.inAttesa = true;
                        } else if (dialogResult == JOptionPane.NO_OPTION) {
                            try {
                                gm.invia("n", "");
                                cond.setIndirizzo_avversario(null);
                            } catch (IOException ex) {
                                Logger.getLogger(Thread_collegamento.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    } catch (IOException ex) {
                        Logger.getLogger(Thread_collegamento.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }

            if (cond.chiesto_io && campi[0].equals("y")) {
                if (!campi[1].equals("")) {
                    cond.setNome_avversario(campi[1]);
                    cond.larghezza_frame_avversario = Integer.valueOf(campi[2]);
                    try {
                        gm.invia("y", "");
                    } catch (IOException ex) {
                        Logger.getLogger(Thread_collegamento.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    cond.collegato = true;
                } else {
                    try {
                        gm.invia("n", "");
                        cond.setIndirizzo_avversario(null);
                    } catch (IOException ex) {
                        Logger.getLogger(Thread_collegamento.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }

            valido = false;

            if (cond.inAttesa && campi[0].equals("y")) {
                cond.inAttesa = false;
                cond.collegato = true;
            }

            if (cond.collegato) {
                System.out.println("Nome avversario: " + cond.getNome_avversario());
                System.out.println("Indirizzo avversario: " + cond.getIndirizzo_avversario());
            }
        }
    }
}
