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

/**
 *
 * @author Pelle
 */
public class ThreadRiceviPalla extends Thread{
    JFrame campo;
    int x;
    int y;
    double velocita;
    int direzione;
    
    public ThreadRiceviPalla(JFrame campo) {
        this.campo = campo;
        x= campo.getX1();
        y=campo.getY1();
        direzione=campo.getDirezione();
        velocita=campo.getVelocita();
        
    }

    @Override
    public void run() {
        
    DatagramSocket server = null;
        try {
            server = new DatagramSocket();
        } catch (SocketException ex) {
            Logger.getLogger(ThreadRiceviPalla.class.getName()).log(Level.SEVERE, null, ex);
        }

byte[] buffer = new byte[1500];
    
    
    
     //ascoltare
    DatagramPacket packet = new DatagramPacket(buffer, buffer.length);

        try {
            server.receive(packet);
        } catch (IOException ex) {
            Logger.getLogger(ThreadRiceviPalla.class.getName()).log(Level.SEVERE, null, ex);
        }

byte[] dataReceived = packet.getData(); // copia del buffer dichiarato sopra

String messaggioRicevuto = new String(dataReceived, 0, packet.getLength());

    String[] mex=messaggioRicevuto.split(";");
    
    campo.p.setX( Integer.parseInt(mex[1]) );
     campo.p.setY (Integer.parseInt(mex[2]) );
      campo.p.setDirezione(Integer.parseInt(mex[3]) );
       campo.p.setVelocita(Integer.parseInt(mex[4]) );
    
    

        
        
        try {
            Thread.sleep(20);
        } catch (InterruptedException ex) {
            Logger.getLogger(ThreadRiceviPalla.class.getName()).log(Level.SEVERE, null, ex);
        }
}
}