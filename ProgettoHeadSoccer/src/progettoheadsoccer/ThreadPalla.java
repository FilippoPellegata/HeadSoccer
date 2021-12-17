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
 * @author Pellegata_Filippo
 */
public class ThreadPalla extends Thread{

    Palla p;

    public ThreadPalla(Palla p) {
        this.p = p;
    }
    
    
    @Override
    public void run() {
        int stato=0;
        while(stato==0){
            p.MovimentoInizioPartita();
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                Logger.getLogger(ThreadPalla.class.getName()).log(Level.SEVERE, null, ex);
            }
            stato=1;
        }
        
    }
    
    
    
}
