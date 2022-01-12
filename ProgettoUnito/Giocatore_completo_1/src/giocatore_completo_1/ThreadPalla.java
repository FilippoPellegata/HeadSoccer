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
 * @author Pellegata_Filippo
 */
public class ThreadPalla extends Thread{

    Palla p;
    JFrame campo;
    int AltezzaCampo;
    int LarghezzaCampo;

    public ThreadPalla(Palla p, JFrame campo) {
        this.p = p;
        this.campo = campo;
        LarghezzaCampo = campo.getWidth();
        AltezzaCampo = campo.getHeight();
    }
    
    
    @Override
    public void run() {
        int stato=0;
        while(stato==0){
            
            saliInizioPartita();
            scendiInizioPartita();
            
            try {
                Thread.sleep(10);
            } catch (InterruptedException ex) {
                Logger.getLogger(ThreadPalla.class.getName()).log(Level.SEVERE, null, ex);
            }
            stato=1;
        }
        
    }
    
    public void saliInizioPartita() {
        int stato = 0;//0= sale //1=scende //2=libero
 
        while (stato == 0) {
            p.setVelocita(1);
            if (p.getY() > 130) {
                p.decY();
                
                System.out.println("sale");
                try {
                    Thread.sleep(1);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Palla.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                stato = 1;
                System.out.println("stop salita");
            }
        
 }
    }
    
    public void scendiInizioPartita() {
        int stato = 1;
        
        while (stato == 1) {
            p.setVelocita(0.2);
            System.out.println("scende");
            
            p.incY();
            
            if (campo.checkTop(p.getX(), p.getY())) {
               
                RimbalzaSopra();
              
                
            }
            if (campo.checkBot(p.getX(), p.getY())) {
               
                RimbalzaSotto();
                
            }
            if (campo.checkLeft(p.getX(), p.getY())) {
               
                RimbalzaSinistra();
               
            }
            if (campo.checkRight(p.getX(), p.getY())) {
             
                RimbalzaDestra();
                
            }
           
            
            if (p.getY() > campo.getHeight() - 100) {
                p.decY();
                
                System.out.println("stop discesa");
            }
            try {
                    Thread.sleep(1);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Palla.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
        
    }
    public void RimbalzaSopra(){
         p.setDirezione(1);
        int stato = 0;//0= sale //1=scende //2=libero
        int cont=0;
        if(stato==0){
        while (cont<200) {
                p.decY();
                 try {
                    Thread.sleep(1);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Palla.class.getName()).log(Level.SEVERE, null, ex);
                }
            cont++;
            if(cont==200){
                stato=1;
            }
        }
        }
        if(stato==1){
            
            while (p.getY() < campo.getHeight() - 100) {
                if (campo.checkTop(p.getX(), p.getY())) {
                stato = 2;
                RimbalzaSopra();
                return;
            }
            if (campo.checkBot(p.getX(), p.getY())) {
                stato = 2;
                RimbalzaSotto();
                return;
            }
            if (campo.checkLeft(p.getX(), p.getY())) {
                stato = 2;
                RimbalzaSinistra();
                return;
            }
            if (campo.checkRight(p.getX(), p.getY())) {
                stato = 2;
                RimbalzaDestra();
                return;
            }
                else{
                        
                        
                p.incY();
                        }
                 try {
                    Thread.sleep(1);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Palla.class.getName()).log(Level.SEVERE, null, ex);
                }
            
        }
        }
        
       
        
    }
    
    
    public void RimbalzaSotto(){
         p.setDirezione(2);
       int stato = 0;//0= sale //1=scende //2=libero
        int cont=0;
        if(stato==0){
        scendiInizioPartita();
        stato=1;
        }
        
        if(stato==1){
            
            while (p.getY() < campo.getHeight() - 200) {
                if (campo.checkTop(p.getX(), p.getY())) {
                stato = 2;
                RimbalzaSopra();
                return;
            }
            if (campo.checkBot(p.getX(), p.getY())) {
                stato = 2;
                RimbalzaSotto();
                return;
            }
            if (campo.checkLeft(p.getX(), p.getY())) {
                stato = 2;
                RimbalzaSinistra();
                return;
            }
            if (campo.checkRight(p.getX(), p.getY())) {
                stato = 2;
                RimbalzaDestra();
                return;
            }
                else{
                        
                        
                p.incY();
                        }
                 try {
                    Thread.sleep(1);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Palla.class.getName()).log(Level.SEVERE, null, ex);
                }
            
        }
        }
        
        
        
    }
    public void RimbalzaSinistra(){
        int stato = 0;
          p.setDirezione(3);
        if(stato==0){
        while (campo.checkGol()==false) {
                p.decX();
                  
                 try {
                    Thread.sleep(1);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Palla.class.getName()).log(Level.SEVERE, null, ex);
                }
             if (campo.checkTop(p.getX(), p.getY())) {
                stato = 2;
                RimbalzaSopra();
                return;
            }
            if (campo.checkBot(p.getX(), p.getY())) {
                stato = 2;
                RimbalzaSotto();
                return;
            }
            if (campo.checkLeft(p.getX(), p.getY())) {
                stato = 2;
                RimbalzaSinistra();
                return;
            }
            if (campo.checkRight(p.getX(), p.getY())) {
                stato = 2;
                RimbalzaDestra();
                return;
            }
        }
        }
        
        
      
    }
    
    
    
    public void RimbalzaDestra(){
        int stato = 0;
          p.setDirezione(3);
        if(stato==0){
        while (campo.checkGol()==false) {
                p.incX();
                  
                 try {
                    Thread.sleep(1);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Palla.class.getName()).log(Level.SEVERE, null, ex);
                }
             if (campo.checkTop(p.getX(), p.getY())) {
                stato = 2;
                RimbalzaSopra();
                return;
            }
            if (campo.checkBot(p.getX(), p.getY())) {
                stato = 2;
                RimbalzaSotto();
                return;
            }
            if (campo.checkLeft(p.getX(), p.getY())) {
                stato = 2;
                RimbalzaSinistra();
                return;
            }
            if (campo.checkRight(p.getX(), p.getY())) {
                stato = 2;
                RimbalzaDestra();
                return;
            }
        }
        }
    }
     
}
