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
public class keyEvent_movimento implements KeyListener {

    JGiocatore giocatore;
    boolean a_pressed;
    boolean d_pressed;
    

    public keyEvent_movimento(JGiocatore g) {
        giocatore = g;
        a_pressed = false;
        d_pressed = false;
    }

    @Override
    public void keyTyped(KeyEvent e) {
       
    }

    @Override
    public void keyPressed(KeyEvent e) {
        //System.out.println("premuto tasto " + e.getKeyChar());
         
        if (e.getKeyChar() == 'a') {
            if(!a_pressed){
                giocatore.velocitàX += -1;
                a_pressed = true;
            }
        } else if (e.getKeyChar() == 'd') {
            if(!d_pressed){
                giocatore.velocitàX+=1;
                d_pressed = true;
            }
        }
    }

    
    
    @Override
    public void keyReleased(KeyEvent e) {
        //System.out.println("premuto rilasciato " + e.getKeyChar());
        
        if (e.getKeyChar() == 'a') {
            giocatore.velocitàX+=1;
            a_pressed = false;
        } else if (e.getKeyChar() == 'd') {
            giocatore.velocitàX+=-1;
            d_pressed = false;
        }
    }

}
