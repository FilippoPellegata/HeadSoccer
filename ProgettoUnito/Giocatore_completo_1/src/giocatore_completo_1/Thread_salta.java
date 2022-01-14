/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package giocatore_completo_1;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HP
 */
public class Thread_salta extends Thread {

    JGiocatore g;
    JCondivisa c;
    Gestore_messaggio gm;

    public Thread_salta(JGiocatore g, JCondivisa c) {
        this.g = g;
        this.c = c;
        gm = new Gestore_messaggio(c);
    }

    @Override
    public void run() {
        for (int i = 0; i < 80; i++) {
            g.sali();
            try {
                Thread.sleep(2);
            } catch (InterruptedException ex) {
                Logger.getLogger(keyEvent_movimento.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        for (int i = 0; i < 80; i++) {
            g.scendi();
            try {
                Thread.sleep(2);
            } catch (InterruptedException ex) {
                Logger.getLogger(keyEvent_movimento.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        c.saltando=false;
    }

}
