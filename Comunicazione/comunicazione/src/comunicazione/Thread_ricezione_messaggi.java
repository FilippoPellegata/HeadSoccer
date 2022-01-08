/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comunicazione;

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

    Condivisa cond;
    DatagramSocket server;

    public Thread_ricezione_messaggi(Condivisa cond) {
        this.cond = cond;
        try {
            server = new DatagramSocket(666);
        } catch (SocketException ex) {
            Logger.getLogger(Thread_ricezione_messaggi.class.getName()).log(Level.SEVERE, null, ex);
        }
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
                System.out.println(campi[1]);
            }
            if(/*cond.collegato &&*/ campi[0].equals("s")){
                System.out.println(campi[1]);
            }
            try {
                sleep(2);
            } catch (InterruptedException ex) {
                Logger.getLogger(Thread_ricezione_messaggi.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}