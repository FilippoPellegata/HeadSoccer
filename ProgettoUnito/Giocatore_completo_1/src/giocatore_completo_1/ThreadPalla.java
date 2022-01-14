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
            try {
                scendiInizioPartita();
            } catch (InterruptedException ex) {
                Logger.getLogger(ThreadPalla.class.getName()).log(Level.SEVERE, null, ex);
            }
            
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
    
    public void scendiInizioPartita() throws InterruptedException {
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
           if(campo.checkTerreno(p.getX(), p.getY())){
               rimbalzaTerreno();
           }
            
            if (p.getY() > campo.getHeight() - 150) {
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
    public void RimbalzaSopra() throws InterruptedException{
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
            }else if (campo.checkBot(p.getX(), p.getY())) {
                stato = 2;
                RimbalzaSotto();
                return;
            }
                else if (campo.checkLeft(p.getX(), p.getY())) {
                stato = 2;
                RimbalzaSinistra();
                return;
            }
                else if (campo.checkRight(p.getX(), p.getY())) {
                stato = 2;
                RimbalzaDestra();
                return;
            }
                else if(campo.checkTerreno(p.getX(), p.getY())==false){
                        
                        
                p.incY();
                        }else{
                rimbalzaTerreno();
            }
                 try {
                    Thread.sleep(1);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Palla.class.getName()).log(Level.SEVERE, null, ex);
                }
            
        }
        }
        
       
        
    }
    
    
    public void RimbalzaSotto() throws InterruptedException{
         p.setDirezione(2);
       int stato = 0;//0= sale //1=scende //2=libero
        int cont=0;
        if(campo.checkBot(p.getX(), p.getY())){
            System.out.println("rimbalzo sottoooooooooooooooooooooooooooooooooooooooooooo");
        p.incY();
        }
        
        if(stato==1){
            
            while (p.getY() < campo.getHeight() - 200) {
                if (campo.checkTop(p.getX(), p.getY())) {
                stato = 2;
                RimbalzaSopra();
                return;
            }
               
                else if (campo.checkLeft(p.getX(), p.getY())) {
                stato = 2;
                RimbalzaSinistra();
                return;
            }
                else if (campo.checkRight(p.getX(), p.getY())) {
                stato = 2;
                RimbalzaDestra();
                return;
            }
                 else if(campo.checkTerreno(p.getX(), p.getY())==false){
                        if(p.getY()>850){
                   p.decY();
                   Thread.sleep(1);
                        }else if (campo.checkTerreno(p.getX(), p.getY())==true&&p.getY()<850){
                rimbalzaTerreno();
                        }
            }
                 try {
                    Thread.sleep(1);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Palla.class.getName()).log(Level.SEVERE, null, ex);
                }
            
        }
        }
        
        
        
    }
    public void RimbalzaSinistra() throws InterruptedException{
        System.out.println("rimbalzo sinistra");
        int stato = 0;
          p.setDirezione(3);
           
        while (stato==0&&campo.checkGol()==false) {
         
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
             else if (campo.checkBot(p.getX(), p.getY())) {
                stato = 2;
                RimbalzaSotto();
                return;
            }
             
             else if (campo.checkRight(p.getX(), p.getY())) {
                stato = 2;
                RimbalzaDestra();
                return;
            }
             
            
             
        
        
        
      
        }
    }
    
    
    
    public void RimbalzaDestra() throws InterruptedException{
         System.out.println("rimbalzo destra");
        int stato = 0;
          p.setDirezione(4);
           
        while (stato==0&&campo.checkGolDestra()==false) {
         
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
             else if (campo.checkBot(p.getX(), p.getY())) {
                stato = 2;
                RimbalzaSotto();
                return;
            }
             
             else if (campo.checkLeft(p.getX(), p.getY())) {
                stato = 2;
                RimbalzaSinistra();
                return;
            }
             
             
            
        
        
        
        
      
        }
    }
    
    public void rimbalzaTerreno() throws InterruptedException{
        
        int stato=0;
    int sali=0;
        while(stato==0&&sali<101){
            
            p.decY();

         if (campo.checkTop(p.getX(), p.getY())) {
              stato=1;
                RimbalzaSopra();
              
            }
                else if (campo.checkBot(p.getX(), p.getY())) {
               stato=1;
                RimbalzaSotto();
               
            }
                else if (campo.checkLeft(p.getX(), p.getY())) {
               stato=1;
                RimbalzaSinistra();
               
            }
                else if (campo.checkRight(p.getX(), p.getY())) {
                stato=1;
                RimbalzaDestra();
               
            }
         sali++;
         Thread.sleep(1);
        
        while(sali>=100&&sali<=151){
            System.out.println("Terreno scendi");
            p.incY();
            Thread.sleep(1);
            sali++;
            if(sali==100)
            {
                sali=0;
                 
                
            }
            
        }
        
        }
       
    }
     
}
