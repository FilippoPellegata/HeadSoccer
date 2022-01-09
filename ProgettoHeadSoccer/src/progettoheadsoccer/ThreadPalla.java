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
    Campo campo;
    int AltezzaCampo;
    int LarghezzaCampo;

    public ThreadPalla(Palla p, Campo campo) {
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
            try {
                    Thread.sleep(1);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Palla.class.getName()).log(Level.SEVERE, null, ex);
                }
            if (p.getY() > campo.getHeight() - 100) {
                stato = 2;
                System.out.println("stop discesa");
            }
        }

    }
    public void RimbalzaSopra(){
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
        }else{
            
            while (p.getY() > campo.getHeight() - 100) {
                p.incY();
                 try {
                    Thread.sleep(1);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Palla.class.getName()).log(Level.SEVERE, null, ex);
                }
            
        }
        }
        
        
        
    }
    
    
    public void RimbalzaSotto(){
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
        }else{
            
            while (p.getY() > campo.getHeight() - 100) {
                p.incY();
                 try {
                    Thread.sleep(1);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Palla.class.getName()).log(Level.SEVERE, null, ex);
                }
            
        }
        }
        
        
        
    }
    public void RimbalzaSinistra(){
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
        }else{
            
            while (p.getY() > campo.getHeight() - 100) {
                p.incY();
                 try {
                    Thread.sleep(1);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Palla.class.getName()).log(Level.SEVERE, null, ex);
                }
            
        }
        }
        
        
        
    }
    public void RimbalzaDestra(){
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
        }else{
            
            while (p.getY() > campo.getHeight() - 100) {
                p.incY();
                 try {
                    Thread.sleep(1);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Palla.class.getName()).log(Level.SEVERE, null, ex);
                }
            
        }
        }
        
        
        
    }
    
}
