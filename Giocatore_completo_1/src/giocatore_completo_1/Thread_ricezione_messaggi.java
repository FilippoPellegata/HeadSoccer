/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package giocatore_completo_1;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author HP
 */
public class Thread_ricezione_messaggi extends Thread {

    JCondivisa cond;
    JGiocatore giocatore_nemico;
    Gestore_messaggio gm;
    boolean valido;
    int larghezza_frame;
    
    public Thread_ricezione_messaggi(JCondivisa cond, JGiocatore giocatore_nemico, int lf, Gestore_messaggio gm) {
        this.cond = cond;
        this.giocatore_nemico = giocatore_nemico;
        this.gm = gm;
        valido = false;
        larghezza_frame = lf;
    }

    @Override
    public void run() {
        while (true) {
            byte[] bufferRicezione = new byte[1500];
            DatagramPacket pacchettoRicezione = new DatagramPacket(bufferRicezione, bufferRicezione.length);
            try {
                cond.server.receive(pacchettoRicezione);
            } catch (IOException ex) {
                Logger.getLogger(Thread_ricezione_messaggi.class.getName()).log(Level.SEVERE, null, ex);
            }

            String IPClient = pacchettoRicezione.getAddress().toString();
            int portClient = pacchettoRicezione.getPort();
            String messaggio = new String(pacchettoRicezione.getData());

            String[] campi = messaggio.split(";");

            valido = false;

            if (cond.inAttesa && campi[0].equals("y")) {
                cond.inAttesa = false;
                cond.collegato = true;
            }
            
            if (cond.collegato && campi[0].equals("m")) {
                //System.out.println(campi[1]);
                int pos_x_avversario = Integer.parseInt(campi[1]);
                int new_pos = (larghezza_frame - (pos_x_avversario*larghezza_frame)/cond.larghezza_frame_avversario);
                
                /*System.out.println("larghezza_frame: " + larghezza_frame);
                System.out.println("pos_x_avversario: " + pos_x_avversario);
                System.out.println("cond.larghezza_frame_avversario: " + cond.larghezza_frame_avversario);
                System.out.println("new_pos: " + new_pos);*/
                
                giocatore_nemico.setPos_x(new_pos);
            }
            if (cond.collegato && campi[0].equals("s")) {
                //System.out.println(campi[1]);
                int pos_y_avversario = Integer.parseInt(campi[1]);
                giocatore_nemico.setPos_y(pos_y_avversario);
            }
            try {
                sleep(2);
            } catch (InterruptedException ex) {
                Logger.getLogger(Thread_ricezione_messaggi.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
