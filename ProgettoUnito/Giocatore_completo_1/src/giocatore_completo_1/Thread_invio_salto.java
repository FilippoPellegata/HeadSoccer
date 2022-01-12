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
public class Thread_invio_salto extends Thread{
    Gestore_messaggio gm;
    JGiocatore g;
    int vecchia_pos_y;

    public Thread_invio_salto(JGiocatore g) {
        gm = new Gestore_messaggio();
        this.g = g;
        vecchia_pos_y = 500;
    }

    @Override
    public void run() {
        while (true) {
            int pos_y = g.getPos_y();

            if (g.getPos_y() != vecchia_pos_y) {
                try {
                    gm.invia("s", pos_y);
                } catch (IOException ex) {
                    Logger.getLogger(Thread_invio_salto.class.getName()).log(Level.SEVERE, null, ex);
                }
                //System.out.println(pos_y);
                vecchia_pos_y = pos_y;
            }

            try {
                sleep(2);
            } catch (InterruptedException ex) {
                Logger.getLogger(Thread_invio_salto.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
