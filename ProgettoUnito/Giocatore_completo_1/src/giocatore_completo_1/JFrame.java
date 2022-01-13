/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package giocatore_completo_1;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author dippolito_mattia
 */
public class JFrame extends javax.swing.JFrame {

    static JCondivisa cond;
    JGiocatore giocatore;
    JGiocatore giocatore_avversario;
    Palla p; // e' necessario avere la palla qui o basterebbe averla dentro il threadpalla? Che se la crea autonomamente
ThreadPalla tp;
Porta porta;
Porta porta2;
ThreadInvioPalla tInvio;
ThreadRiceviPalla tRicevi;

    public JFrame(JCondivisa cond) {
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        initComponents();
        
        this.setVisible(true);
        JCondivisa condivisa = new JCondivisa();
       Gestore_messaggio gm = new Gestore_messaggio(condivisa);
        giocatore = new JGiocatore("Personaggio", this, 10, 150, 800, 50, 100);
        giocatore_avversario = new JGiocatore("Avversario", this, 10, 150, 800, 50, 100);
        
        this.addKeyListener(new keyEvent_movimento(giocatore));
        this.addKeyListener(new keyEvent_salta(giocatore, condivisa));
        
       
        
         porta=new Porta(this,0,700,100,20,80,700,20,220);
        porta2=new Porta(this,1830,700,100,20,1830,700,20,220);
        p=new Palla(getWidth()/2, getHeight()-450);
      
        
       
        
           Disegna d = new Disegna(this, 30);
        Thread_invio_pos tip = new Thread_invio_pos(giocatore, 30, this.getWidth(), gm);
        Thread_invio_salto tis = new Thread_invio_salto(giocatore, gm);
         Thread_ricezione_messaggi trm = new Thread_ricezione_messaggi(condivisa, giocatore_avversario, this.getWidth(), gm);
        
        tip.start();
        tis.start();
        trm.start();
        d.start();
        
        
      tp=new ThreadPalla(p, this);
       tp.start();
      tInvio=new ThreadInvioPalla(this);
      tInvio.start();
      tRicevi=new ThreadRiceviPalla(this);
      tRicevi.start();
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
        return giocatore.isTop(x, y);
    }
    
    public boolean checkBot(int x, int y) {
        return giocatore.isBot(x, y);
    }
    public boolean checkLeft(int x, int y) {
        return giocatore.isLeft(x, y);
    }
    public boolean checkRight(int x, int y) {
        return giocatore.isRight(x, y);
    }
    public boolean checkTerreno(int x, int y) {
        return p.toccaTerreno();
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
    
    public boolean checkGol(){
        return porta.Gol(p.getX(),p.getY());
        
    }
    public boolean checkGolDestra(){
        return porta2.Gol2(p.getX(),p.getY());
        
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
            java.util.logging.Logger.getLogger(JFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFrame(cond).setVisible(true);
            }
        });
    }

    @Override
    public void paint(Graphics g) {
        
        //pelle-----------------------------------------------------------------------------------------
        
        Image immagine = createImage(this.getWidth(),this.getHeight());
        Graphics gImmagine = immagine.getGraphics();
        
        Image img = null;
    try {
         img= ImageIO.read(new File("background.jpg"));
    } catch (IOException ex) {
        Logger.getLogger(JFrame.class.getName()).log(Level.SEVERE, null, ex);
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
            
             Image personaggio = null;
    try {
         personaggio= ImageIO.read(new File("personaggio.png"));
    } catch (IOException ex) {
        Logger.getLogger(JFrame.class.getName()).log(Level.SEVERE, null, ex);
    }
    Image personaggio2 = null;
    try {
         personaggio2= ImageIO.read(new File("player2.jpeg"));
    } catch (IOException ex) {
        Logger.getLogger(JFrame.class.getName()).log(Level.SEVERE, null, ex);
    }
            //player
           gImmagine.setColor(Color.green);
           gImmagine.drawImage(personaggio, giocatore.getX(), giocatore.getY(), giocatore.getLunghezza(), giocatore.getAltezza(), rootPane);
        giocatore.Update();
        giocatore.Update();
        
        //player2
       gImmagine.setColor(Color.green);
           gImmagine.drawImage(personaggio2, giocatore_avversario.getX(), giocatore_avversario.getY(), giocatore_avversario.getLunghezza(), giocatore_avversario.getAltezza(), rootPane);
       
        
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
        
        
       // Tabellone
          //aste tabellone
         gImmagine.setColor(Color.black.brighter());
        gImmagine.fillRect((this.getWidth()/2)-30,0,10,70);
        gImmagine.setColor(Color.black.brighter());
        gImmagine.fillRect((this.getWidth()/2)+30,0,10,70);
        
        
          //lavagna tabellone
         gImmagine.setColor(Color.red.brighter());
        gImmagine.fillRect((this.getWidth()/2)-200,70,400,150);
            //divisione
            gImmagine.setColor(Color.black);
            gImmagine.drawLine(this.getWidth()/2, 70, this.getWidth()/2, 220);
            
            
        Font f = new Font(Font.MONOSPACED, Font.BOLD, 20);
            gImmagine.setFont(f);
            //giocatore1
          
            
            gImmagine.drawString(giocatore.getPersonaggio(), (this.getWidth()/2)-150, 100);
            
            //giocatore2
            
            
            gImmagine.drawString(giocatore_avversario.getPersonaggio(), (this.getWidth()/2)+30, 100);
            
            //linea divisione da risultato
            gImmagine.setColor(Color.black);
            gImmagine.drawLine((this.getWidth()/2)-200, 120, this.getWidth()/2+200, 120);
            
            
            //risultato
            Font f2 = new Font(Font.MONOSPACED, Font.BOLD, 50);
            gImmagine.setFont(f2);
            
            
            gImmagine.drawString(porta.getRisultato(), (this.getWidth()/2)-110, 190);
            
             
            
            gImmagine.drawString(porta2.getRisultato(), (this.getWidth()/2)+100, 190);
        
               
        g.drawImage(immagine, 0, 0, this); 
      
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}