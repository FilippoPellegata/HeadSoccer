/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progettoheadsoccer;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author Pellegata_Filippo
 */
public class Campo extends javax.swing.JFrame {
Palla p; // e' necessario avere la palla qui o basterebbe averla dentro il threadpalla? Che se la crea autonomamente
Disegna d;
ThreadPalla tp;
PersonaggioProva player;
Porta porta;
Porta porta2;
    /**
     * Creates new form Campo
     */
    public Campo() {
         
        initComponents();
      this.setExtendedState(this.MAXIMIZED_BOTH);
        porta=new Porta(this,0,700,100,20,80,700,20,220);
        porta2=new Porta(this,1830,700,100,20,1830,700,20,220);
        p=new Palla(getWidth()+500, getHeight()+450);
        initComponents();
        d = new Disegna(this);
        d.start();
        
        
        
        
       tp=new ThreadPalla(p, this);
        tp.start();
        player = new PersonaggioProva(getWidth()+500, getHeight()+450, 50, 100);
     
       
    }
 @Override
    public void paint(Graphics g) {
         Image immagine = createImage(this.getWidth(),this.getHeight());
        Graphics gImmagine = immagine.getGraphics();
        
        Image img = null;
    try {
         img= ImageIO.read(new File("background.jpg"));
    } catch (IOException ex) {
        Logger.getLogger(Campo.class.getName()).log(Level.SEVERE, null, ex);
    }
       
        //scorri tutta la lista e ogni volta che trovi una pallina fai questo 
        gImmagine.clearRect(0, 0, this.getWidth(), this.getHeight());
        //sfondo
       gImmagine.drawImage(img, 0, 0, null);
       
        
        //campo
         gImmagine.setColor(Color.green.darker());
        gImmagine.fill3DRect(0, 850, 1950, 900, rootPaneCheckingEnabled);
        
        //palla
          gImmagine.setColor(Color.black.darker());
            gImmagine.fillOval((int)p.getX(), (int)p.getY(), 25, 25);
            //player
         gImmagine.setColor(Color.red);
        gImmagine.fillRect(player.getX(), player.getY(), player.getLunghezza(), player.getAltezza());
        
        
        //porta
        //rete
        gImmagine.setColor(Color.white);
        int cont=5;
        for (int i = 0; i < 43; i++) {
            
          gImmagine.fillRect(porta.getxTraversa(), porta.getyTraversa()+cont ,porta.getLarghezzaTraversa()-20, 2);
           
            cont = cont+5;
     }
        cont=0;
       for (int i = 0; i < 20; i++) {
         gImmagine.fillRect(porta.getxTraversa()+cont, porta.getyTraversa(),2, porta.getLunghezzaPalo());
         cont=cont+5;
     }
         
                
           //traversa
      gImmagine.setColor(Color.red);
        gImmagine.fillRect(porta.getxTraversa(), porta.getyTraversa() ,porta.getLarghezzaTraversa(), porta.getLunghezzaTraversa());
        //palo
       gImmagine.setColor(Color.red);
        gImmagine.fillRect(porta.getxPalo(), porta.getyPalo() ,porta.getLarghezzaPalo(), porta.getLunghezzaPalo());
        
        //porta 2
        //rete
        gImmagine.setColor(Color.white);
         cont=5;
        for (int i = 0; i < 43; i++) {
            
          gImmagine.fillRect(porta2.getxTraversa(), porta2.getyTraversa()+cont ,porta2.getLarghezzaTraversa(), 2);
           
            cont = cont+5;
     }
        cont=0;
       for (int i = 0; i < 20; i++) {
         gImmagine.fillRect(porta2.getxTraversa()+cont, porta2.getyTraversa(),2, porta2.getLunghezzaPalo());
         cont=cont+5;
     }
             //traversa2
      gImmagine.setColor(Color.red);
        gImmagine.fillRect(porta2.getxTraversa(), porta2.getyTraversa() ,porta2.getLarghezzaTraversa(), porta2.getLunghezzaTraversa());
        //palo2
       gImmagine.setColor(Color.red);
        gImmagine.fillRect(porta2.getxPalo(), porta2.getyPalo() ,porta2.getLarghezzaPalo(), porta2.getLunghezzaPalo());
        
        
        
        g.drawImage(immagine, 0, 0, this);
      
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public boolean checkTop(int x, int y) {
        return player.isTop(x, y);
    }
    
    public boolean checkBot(int x, int y) {
        return player.isTop(x, y);
    }
    public boolean checkLeft(int x, int y) {
        return player.isTop(x, y);
    }
    public boolean checkRight(int x, int y) {
        return player.isTop(x, y);
    }
    
    public double getVelocita() {
        return p.getVelocita();
    }
    
    public int getX1(){
        return p.getX();
    }
    
    public int getY1(){
        return p.getY();
    }
    
    public int getDirezione(){
        return p.getDirezione();
    }
    
    
    
    
    
    
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Campo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Campo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Campo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Campo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Campo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
