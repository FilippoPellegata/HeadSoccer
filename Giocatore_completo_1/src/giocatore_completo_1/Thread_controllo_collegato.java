/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package giocatore_completo_1;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HP
 */
public class Thread_controllo_collegato extends Thread{
    JCondivisa cond;
    FrameCollegamento fc;

    public Thread_controllo_collegato(JCondivisa cond, FrameCollegamento fc) {
        this.cond = cond;
        this.fc = fc;
    }

    @Override
    public void run() {
        while(!cond.collegato){
            try {
                sleep(10);
            } catch (InterruptedException ex) {
                Logger.getLogger(Thread_controllo_collegato.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        FrameGioco fg = new FrameGioco(cond);
        fg.setVisible(true);
        fc.setVisible(false);
    }
}
