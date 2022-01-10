/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package giocatore_completo_1;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Image;

/**
 *
 * @author dippolito_mattia
 */
public class JGiocatore {
    private String Personaggio;
    private int pos_x;
    private int pos_y;
    private Frame f;
    private int velocita;
    
    public int velocitàX=0;
    public int velocitàY=0;
    
    
    //immagine

    public JGiocatore(String Personaggio, Frame f, int velocita) {
        this.Personaggio = Personaggio;
        this.f = f;
        this.pos_x = 80;
        this.pos_y = 500;
        this.velocita = velocita;
    }
    
    public void sali(){
        pos_y--;
    }
    
    public void scendi(){
        pos_y++;
    }

    public int getPos_x() {
        return pos_x;
    }

    public int getPos_y() {
        return pos_y;
    }

    public void setPos_x(int pos_x) {
        this.pos_x = pos_x;
    }

    public void setPos_y(int pos_y) {
        this.pos_y = pos_y;
    }
    public void Update()
    {
        if(velocitàX==-1){
            if(pos_x>0){
                pos_x+=velocitàX*velocita;
            }
        }else if(velocitàX==1){
            if(pos_x<f.getWidth()-20){
                pos_x+=velocitàX*velocita;
            }
        }
            
    }
}
