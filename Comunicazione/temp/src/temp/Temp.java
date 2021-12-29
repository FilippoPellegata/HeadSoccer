/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package temp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

/**
 *
 * @author HP
 */
public class Temp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SocketException, UnknownHostException, IOException {
        DatagramSocket client = new DatagramSocket();
        String p = "a;Mattia;";
        //String p = "c;;";

        byte[] buffer = p.getBytes();
        DatagramPacket pacchetto = new DatagramPacket(buffer, buffer.length);
        InetAddress indirizzo = InetAddress.getByName("localhost");
        pacchetto.setAddress(indirizzo);
        pacchetto.setPort(666);

        client.send(pacchetto);
        
        boolean ricevuto = false;
        
        DatagramSocket server = new DatagramSocket(12345);

        while (!ricevuto) {
            byte[] bufferRicezione = new byte[1500];
            DatagramPacket pacchettoRicezione = new DatagramPacket(bufferRicezione, bufferRicezione.length);

            server.receive(pacchettoRicezione);

            String IPClient = pacchettoRicezione.getAddress().toString();
            int portClient = pacchettoRicezione.getPort();
            String messaggio = new String(pacchettoRicezione.getData());

            System.out.println(messaggio);
            ricevuto = true;
        }
    }

}
