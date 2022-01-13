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
     private int lunghezza;
    private int altezza;
    
    public int velocitàX=0;
    public int velocitàY=0;
    
    
    //immagine

    public JGiocatore(String Personaggio, Frame f, int velocita,int x,int y,int lunghezza, int altezza) {
        this.Personaggio = Personaggio;
        this.f = f;
        this.pos_x = x;
        this.pos_y = y;
        this.velocita = velocita;
        this.lunghezza = lunghezza;
        this.altezza = altezza;
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

    public String getPersonaggio() {
        return Personaggio;
    }
    
    
    
    public boolean isTop(int x, int y) {
        if (x >= this.pos_x && x <= this.pos_x + lunghezza && y == this.pos_y && y <= this.pos_y +10) {
            return true;
        } else {
            return false;
        }
    }
    public boolean isBot(int x, int y) {
        if (x >= this.pos_x && x <= this.pos_x + lunghezza && y >= this.pos_y+altezza+10&& y <= this.pos_y+altezza+20) {
            return true;
        } else {
            return false;
        }
    }
    
    public boolean isLeft(int x, int y) {
        if (x <= this.pos_x&& x >= this.pos_x-3 && y > this.pos_y && y < this.pos_y + altezza) {
            return true;
        } else {
            return false;
        }
    }
    
     public boolean isRight(int x, int y) {
        if (x>=pos_x+3&&x<=pos_x+lunghezza&& y>this.pos_y && y < this.pos_y + altezza) {
            return true;
        } else {
            return false;
        }
    }

    public int getX() {
        return pos_x;
    }

    public int getY() {
        return pos_y;
    }

    public int getLunghezza() {
        return lunghezza;
    }

    public int getAltezza() {
        return altezza;
    }
}
