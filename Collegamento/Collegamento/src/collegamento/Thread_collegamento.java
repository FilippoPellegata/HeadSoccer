/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collegamento;

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
    DatagramSocket server;
    Gestore_messaggio gm;
    boolean valido;

    public Thread_collegamento(JCondivisa cond) {
        this.cond = cond;
        try {
            server = new DatagramSocket(666);
        } catch (SocketException ex) {
            Logger.getLogger(Thread_collegamento.class.getName()).log(Level.SEVERE, null, ex);
        }
        gm = new Gestore_messaggio();
        valido = false;
    }

    @Override
    public void run() {
        while (true) {
            byte[] bufferRicezione = new byte[1500];
            DatagramPacket pacchettoRicezione = new DatagramPacket(bufferRicezione, bufferRicezione.length);

            try {
                server.receive(pacchettoRicezione);
            } catch (IOException ex) {
                Logger.getLogger(Thread_collegamento.class.getName()).log(Level.SEVERE, null, ex);
            }

            String IPClient = pacchettoRicezione.getAddress().toString();
            int portClient = pacchettoRicezione.getPort();
            String messaggio = new String(pacchettoRicezione.getData());
            //System.out.println(messaggio);

            String[] campi = messaggio.split(";");

            if (campi[0].equals("c") && !cond.inAttesa) {
                cond.setIndirizzo(pacchettoRicezione.getAddress());
                if (!campi[1].equals("")) {
                    cond.setNome_avversario(campi[1]);
                    valido = true;
                } else {
                    try {
                        gm.invia("n", "");
                    } catch (IOException ex) {
                        Logger.getLogger(Thread_collegamento.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if (valido) {
                    try {
                        int dialogResult = JOptionPane.showConfirmDialog(null, "Vuoi parlare con " + campi[1] + "?", "Warning", JOptionPane.YES_NO_OPTION);
                        if (dialogResult == JOptionPane.YES_OPTION) {
                            gm.invia("y", "D'Ippolito");
                            cond.inAttesa = true;
                        } else if (dialogResult == JOptionPane.NO_OPTION) {
                            try {
                                gm.invia("n", "");
                            } catch (IOException ex) {
                                Logger.getLogger(Thread_collegamento.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    } catch (IOException ex) {
                        Logger.getLogger(Thread_collegamento.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }

            valido = false;

            if (cond.inAttesa && campi[0].equals("y")) {
                try {
                    gm.invia("y", "collegato");
                } catch (IOException ex) {
                    Logger.getLogger(Thread_collegamento.class.getName()).log(Level.SEVERE, null, ex);
                }
                cond.inAttesa = false;
                cond.collegato = true;
            }

            if (cond.collegato) {
                System.out.println("Nome: " + cond.getNome_avversario());
                System.out.println("Indirizzo: " + cond.getIndirizzo());
            }
        }
    }
}
