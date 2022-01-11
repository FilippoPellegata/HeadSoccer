/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collegamento;

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
 * @author HP
 */
public class Gestore_messaggio {
    private DatagramSocket client;

    public Gestore_messaggio(){
        try {
            client = new DatagramSocket();
        } catch (SocketException ex) {
            Logger.getLogger(Gestore_messaggio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void invia(String operazione, int data) throws UnknownHostException, IOException{
        String risposta = operazione + ";" + data + ";";
        byte[] responseBuffer = risposta.getBytes();
        
        DatagramPacket pacchetto = new DatagramPacket(responseBuffer, responseBuffer.length);
        //pacchetto.setAddress(InetAddress.getByName("localhost"));
        pacchetto.setAddress(InetAddress.getByName("192.168.1.17"));
        pacchetto.setPort(666);

        client.send(pacchetto);
        
        /*if(cond.destinatario.getIndirizzo()!=null){
            DatagramPacket responsePacket = new DatagramPacket(responseBuffer, responseBuffer.length);
            responsePacket.setAddress(cond.destinatario.getIndirizzo());
            responsePacket.setPort(12345);
            try {
                server.send(responsePacket);
            } catch (IOException ex) {
                Logger.getLogger(Gestore_messaggio.class.getName()).log(Level.SEVERE, null, ex);
            }
            return true;
        }
        return false;*/
    }
    
    public void invia(String operazione, String data) throws UnknownHostException, IOException{
        String risposta = operazione + ";" + data + ";";
        byte[] responseBuffer = risposta.getBytes();
        
        DatagramPacket pacchetto = new DatagramPacket(responseBuffer, responseBuffer.length);
        //pacchetto.setAddress(InetAddress.getByName("localhost"));
        pacchetto.setAddress(InetAddress.getByName("192.168.1.17"));
        pacchetto.setPort(666);

        client.send(pacchetto);
        
        /*if(cond.destinatario.getIndirizzo()!=null){
            DatagramPacket responsePacket = new DatagramPacket(responseBuffer, responseBuffer.length);
            responsePacket.setAddress(cond.destinatario.getIndirizzo());
            responsePacket.setPort(12345);
            try {
                server.send(responsePacket);
            } catch (IOException ex) {
                Logger.getLogger(Gestore_messaggio.class.getName()).log(Level.SEVERE, null, ex);
            }
            return true;
        }
        return false;*/
    }
}
