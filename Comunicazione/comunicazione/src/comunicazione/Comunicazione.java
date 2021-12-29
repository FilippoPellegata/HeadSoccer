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

/**
 *
 * @author HP
 */
public class Comunicazione {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SocketException, IOException {
        Condivisa c = new Condivisa();
        Thread_ricezione_messaggi trm = new Thread_ricezione_messaggi(c);
        
        trm.start();
    }
}
