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
public class ThreadRiceviPalla extends Thread {

    JFrame campo;
    int x;
    int y;
    double velocita;
    int direzione;
    JCondivisa cond;
    int larghezza_frame;

    public ThreadRiceviPalla(JFrame campo, JCondivisa cond, int larghezza_frame) {
        this.campo = campo;
        x = campo.getX1();
        y = campo.getY1();
        direzione = campo.getDirezione();
        velocita = campo.getVelocita();
        this.cond = cond;
        this.larghezza_frame = larghezza_frame;
    }

    @Override
    public void run() {
        byte[] buffer = new byte[1500];

        //ascoltare
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length);

        try {
            cond.server.receive(packet);
        } catch (IOException ex) {
            Logger.getLogger(ThreadRiceviPalla.class.getName()).log(Level.SEVERE, null, ex);
        }

        byte[] dataReceived = packet.getData(); // copia del buffer dichiarato sopra

        String messaggioRicevuto = new String(dataReceived, 0, packet.getLength());

        String[] mex = messaggioRicevuto.split(";");
        
        int pos_palla = Integer.parseInt(mex[1]);
        int new_pos = (larghezza_frame - (pos_palla*larghezza_frame)/cond.larghezza_frame_avversario);
        
        campo.p.setX(new_pos);
        campo.p.setY(Integer.parseInt(mex[2]));
        
        int direzione = Integer.parseInt(mex[3]);
        int new_direzione = 0;
        if(direzione == 3){
            new_direzione = 4;
        }
        if(direzione == 4){
            new_direzione = 3;
        }
        campo.p.setDirezione(new_direzione);
        campo.p.setVelocita(Integer.parseInt(mex[4]));

        try {
            Thread.sleep(20);
        } catch (InterruptedException ex) {
            Logger.getLogger(ThreadRiceviPalla.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
