/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progettoheadsoccer;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Daniele
 */
public class Disegna extends Thread {

    Campo f;
    
   

    public Disegna(Campo f) {
        this.f = f;
      
    }

    @Override
    public void run() {
        
        while (true) {
            f.repaint();
            try {
                if (f.getVelocita() == 1) {
                Thread.sleep(1000/33);
                } else {
                    Thread.sleep(10);
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(Disegna.class.getName()).log(Level.SEVERE, null, ex);
            }
           
        }
        
    }

}