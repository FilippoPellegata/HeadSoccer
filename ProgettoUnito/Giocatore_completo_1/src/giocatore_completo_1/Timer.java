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
public class Timer extends Thread{
    private int milliSec;
    private boolean terminato;
    private boolean isRunning;
    private boolean visto;
    public int tempo=120;
    JFrame campo;
    public Timer(int milliSec, JFrame campo) {
        this.milliSec = milliSec;
        terminato = false;
        isRunning = false;
        visto = true;
        this.campo=campo;
    }

    @Override
    public void run() {
        while(terminato==false){
           
            terminato = false;
            isRunning = true;
            
         if((isRunning==true)&&(Integer.parseInt(campo.porta.getRisultato())<6||Integer.parseInt(campo.porta2.getRisultato())<6)){
                
                tempo--;
                try {
                    sleep(milliSec);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Timer.class.getName()).log(Level.SEVERE, null, ex);
                }
                if((tempo==1||Integer.parseInt(campo.porta.getRisultato())==5||Integer.parseInt(campo.porta2.getRisultato())==5)){
                isRunning = false;
                terminato=true;
            }
            }
         
        }        
    }

    public boolean isTerminato() {
        return terminato;
    }

    
   
}
