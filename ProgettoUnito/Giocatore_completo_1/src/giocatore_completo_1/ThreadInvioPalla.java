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
public class ThreadInvioPalla extends Thread{
    JFrame campo;
    int x;
    int y;
    double velocita;
    int direzione;
    
    public ThreadInvioPalla(JFrame campo) {
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
            Logger.getLogger(ThreadInvioPalla.class.getName()).log(Level.SEVERE, null, ex);
        }

byte[] buffer = new byte[1500];
        String risposta = "P;"+x+";"+y+";"+direzione+";"+velocita+";";

byte[] responseBuffer = risposta.getBytes();

DatagramPacket responsePacket = new DatagramPacket(responseBuffer, responseBuffer.length);

        try {
            responsePacket.setAddress(InetAddress.getByName("localhost"));
        } catch (UnknownHostException ex) {
            Logger.getLogger(ThreadInvioPalla.class.getName()).log(Level.SEVERE, null, ex);
        }

     responsePacket.setPort(12346); //porta oricchio
     
     try {
            server.send(responsePacket);
        } catch (IOException ex) {
            Logger.getLogger(ThreadInvioPalla.class.getName()).log(Level.SEVERE, null, ex);
        }
   
        
        try {
            Thread.sleep(20);
        } catch (InterruptedException ex) {
            Logger.getLogger(ThreadInvioPalla.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    
}
