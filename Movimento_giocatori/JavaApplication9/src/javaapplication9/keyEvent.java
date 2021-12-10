/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication9;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author dippolito_mattia
 */
public class keyEvent implements KeyListener {

    JGiocatore giocatore;

    public keyEvent(JGiocatore g) {
        giocatore = g;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        if (e.getKeyChar() == 'w') {
            giocatore.decrementa();
        } else if (e.getKeyChar() == 's') {
            giocatore.incrementa();
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

}