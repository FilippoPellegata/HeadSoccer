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
    DatagramSocket server;
    JGiocatore giocatore_nemico;
    int larghezza_frame;

    public Thread_ricezione_messaggi(JCondivisa cond, JGiocatore giocatore_nemico, int lf) {
        this.cond = cond;
        this.giocatore_nemico = giocatore_nemico;
        try {
            //server = new DatagramSocket(666);
            
            /*-------------------------------------------------------------------------------------------------------------*/
            
            //TENGO LA PORTA 665 ANZICHE LA 666 PERCHE COSI IL PROGRAMMA NON MANDA LA POSIZIONE DEL GIOCATORE A SE STESSO
            //DATO CHE LAVORO CON DUE PROGRAMMI COMUNICANTI SU UN PC SOLO
            server = new DatagramSocket(665);
            
            /*-------------------------------------------------------------------------------------------------------------*/
            
        } catch (SocketException ex) {
            Logger.getLogger(Thread_ricezione_messaggi.class.getName()).log(Level.SEVERE, null, ex);
        }
        larghezza_frame = lf;
    }

    @Override
    public void run() {
        while (true) {
            byte[] bufferRicezione = new byte[1500];
            DatagramPacket pacchettoRicezione = new DatagramPacket(bufferRicezione, bufferRicezione.length);

            try {
                server.receive(pacchettoRicezione);
            } catch (IOException ex) {
                Logger.getLogger(Thread_ricezione_messaggi.class.getName()).log(Level.SEVERE, null, ex);
            }

            String IPClient = pacchettoRicezione.getAddress().toString();
            int portClient = pacchettoRicezione.getPort();
            String messaggio = new String(pacchettoRicezione.getData());

            String[] campi = messaggio.split(";");

            /*if (!cond.collegato && campi[0].equals("a")) {
                int dialogResult = JOptionPane.showConfirmDialog(null, "Vuoi giocare con " + campi[1] + "?", "Warning", JOptionPane.YES_NO_OPTION);
                if (dialogResult == JOptionPane.YES_OPTION) {
                    try {
                        cond.collegato = true;
                        String p = "y;Ciao;";

                        byte[] buffer = p.getBytes();
                        DatagramPacket pacchetto = new DatagramPacket(buffer, buffer.length);
                        InetAddress indirizzo = InetAddress.getByName("localhost");
                        pacchetto.setAddress(indirizzo);
                        pacchetto.setPort(12345);

                        server.send(pacchetto);
                    } catch (UnknownHostException ex) {
                        Logger.getLogger(Thread_ricezione_messaggi.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                        Logger.getLogger(Thread_ricezione_messaggi.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else if (dialogResult == JOptionPane.NO_OPTION) {
                    try {
                        String p = "n;No;";

                        byte[] buffer = p.getBytes();
                        DatagramPacket pacchetto = new DatagramPacket(buffer, buffer.length);
                        InetAddress indirizzo = InetAddress.getByName("localhost");
                        pacchetto.setAddress(indirizzo);
                        pacchetto.setPort(12345);

                        server.send(pacchetto);
                    } catch (UnknownHostException ex) {
                        Logger.getLogger(Thread_ricezione_messaggi.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                        Logger.getLogger(Thread_ricezione_messaggi.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }*/
            if(/*cond.collegato &&*/ campi[0].equals("m")){
                //System.out.println(campi[1]);
                int pos_x_avversario = Integer.parseInt(campi[1]);
                //int new_pos = (pos_avversario*larghezza_frame)/cond.larghezza_frame_avversario;
                int new_pos = larghezza_frame - pos_x_avversario;
                giocatore_nemico.setPos_x(new_pos);
            }if(/*cond.collegato &&*/ campi[0].equals("s")){
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