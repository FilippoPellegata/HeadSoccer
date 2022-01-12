/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package giocatore_completo_1;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dippolito_mattia
 */
public class keyEvent_salta implements KeyListener {

    JGiocatore giocatore;
    JCondivisa condivisa;

    public keyEvent_salta(JGiocatore g, JCondivisa c) {
        giocatore = g;
        condivisa = c;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        //System.out.println("premuto tasto " + e.getKeyChar());
        if (e.getKeyChar() == ' ') {
            if (!condivisa.saltando) {
                condivisa.saltando = true;
                Thread_salta ts = new Thread_salta(giocatore, condivisa);
                ts.start();
            }

        }
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

}
