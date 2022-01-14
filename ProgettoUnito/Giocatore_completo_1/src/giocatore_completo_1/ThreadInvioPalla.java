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

/**
 *
 * @author Pelle
 */
public class ThreadInvioPalla extends Thread {

    JFrame campo;
    /*int x;
    int y;*/
    double velocita;
    int direzione;
    Gestore_messaggio gm;
    Palla p;
    int vecchia_pos;

    public ThreadInvioPalla(Palla p, Gestore_messaggio gm) {
        //this.campo = campo;
        this.p = p;
        /*x = campo.getX1();
        y = campo.getY1();*/
        direzione = p.getDirezione();
        velocita = p.getVelocita();
        this.gm = gm;
        vecchia_pos = -1;
    }

    @Override
    public void run() {
        int x = p.getX();
        int y = p.getY();
        if (x != vecchia_pos) {
            byte[] buffer = new byte[1500];
            String risposta = x + ";" + y + ";" + direzione + ";" + velocita + ";";

            byte[] responseBuffer = risposta.getBytes();

            DatagramPacket responsePacket = new DatagramPacket(responseBuffer, responseBuffer.length);

            try {
                responsePacket.setAddress(InetAddress.getByName("localhost"));
            } catch (UnknownHostException ex) {
                Logger.getLogger(ThreadInvioPalla.class.getName()).log(Level.SEVERE, null, ex);
            }

            responsePacket.setPort(666);

            try {
                gm.invia("P", risposta);
            } catch (IOException ex) {
                Logger.getLogger(ThreadInvioPalla.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        try {
            Thread.sleep(20);
        } catch (InterruptedException ex) {
            Logger.getLogger(ThreadInvioPalla.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
