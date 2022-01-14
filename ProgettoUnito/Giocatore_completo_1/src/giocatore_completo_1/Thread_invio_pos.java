/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package giocatore_completo_1;

import java.io.IOException;
import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HP
 */
public class Thread_invio_pos extends Thread {

    Gestore_messaggio gm;
    JGiocatore g;
    int FPS;
    int vecchia_pos;

    public Thread_invio_pos(JGiocatore g, int i, int lf, Gestore_messaggio gm) {
        this.gm = gm;
        this.g = g;
        FPS = 1000 / i;
        vecchia_pos = -1;
    }

    @Override
    public void run() {
        while (true) {
            //g.Update();
            int pos = g.getPos_x();
            if (pos != vecchia_pos) {
                /*System.out.println("Larghezza frame --> " + larghezza_frame);
                System.out.println("pos --> " + pos);
                System.out.println("pos_inviare --> " + pos_inviare);*/
                try {
                    gm.invia("m", pos);
                } catch (IOException ex) {
                    Logger.getLogger(Thread_invio_pos.class.getName()).log(Level.SEVERE, null, ex);
                }
                vecchia_pos = pos;
            }

            /*
            SERVE PER CONTROLLARE CHE L'UPDATE FUNZIONI
            System.out.println(data);
             */
            try {
                sleep(100);
            } catch (InterruptedException ex) {
                Logger.getLogger(Thread_invio_pos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
