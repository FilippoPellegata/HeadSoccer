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
 * @author HP
 */
public class Gestore_messaggio {
    private DatagramSocket client;
    JCondivisa cond;

    public Gestore_messaggio(JCondivisa cond){
        try {
            client = new DatagramSocket();
        } catch (SocketException ex) {
            Logger.getLogger(Gestore_messaggio.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.cond = cond;
    }
    
    public void invia(String operazione, int data) throws UnknownHostException, IOException{
        String messaggio = operazione + ";" + data + ";";
        byte[] Buffer = messaggio.getBytes();
        
        DatagramPacket pacchetto = new DatagramPacket(Buffer, Buffer.length);
        //pacchetto.setAddress(InetAddress.getByName("localhost"));
        pacchetto.setAddress(InetAddress.getByName(cond.getIndirizzo_avversario()));
        pacchetto.setPort(666);

        client.send(pacchetto);
    }
    
    public void invia(String operazione, String data) throws UnknownHostException, IOException{
        String messaggio = operazione + ";" + data + ";";
        byte[] Buffer = messaggio.getBytes();
        
        DatagramPacket pacchetto = new DatagramPacket(Buffer, Buffer.length);
        //pacchetto.setAddress(InetAddress.getByName("localhost"));
        pacchetto.setAddress(InetAddress.getByName(cond.getIndirizzo_avversario()));
        pacchetto.setPort(666);

        client.send(pacchetto);
    }
    
    public void invia(String operazione, String data, int larghezza_frame) throws UnknownHostException, IOException{
        String messaggio = operazione + ";" + data + ";" + larghezza_frame + ";";
        byte[] Buffer = messaggio.getBytes();
        
        DatagramPacket pacchetto = new DatagramPacket(Buffer, Buffer.length);
        //pacchetto.setAddress(InetAddress.getByName("localhost"));
        pacchetto.setAddress(InetAddress.getByName(cond.getIndirizzo_avversario()));
        pacchetto.setPort(666);

        client.send(pacchetto);
    }
}
