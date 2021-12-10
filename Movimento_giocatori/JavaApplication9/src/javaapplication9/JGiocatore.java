/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication9;

import java.awt.Frame;
import java.awt.Graphics;

/**
 *
 * @author dippolito_mattia
 */
public class JGiocatore {
    private String Personaggio;
    private int pos_x;
    private int pos_y;
    private Frame f;
    //immagine

    public JGiocatore(String Personaggio, Frame f) {
        this.Personaggio = Personaggio;
        this.f = f;
        this.pos_x = 80;
        this.pos_y = 280;
    }
    
    public void incrementa(){
        if(!(pos_x>f.getWidth()))
            pos_x++;
    }
    
    public void decrementa(){
        if(!(pos_x<=0))
            pos_x--;
    }
    
    public void disegnati(Graphics g){
        
    }
}
