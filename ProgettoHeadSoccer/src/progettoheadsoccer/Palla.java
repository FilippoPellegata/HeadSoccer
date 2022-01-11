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
//ATTENZIONE!!!!!!
//TUTTI I VALORI DELLA X E DELLA Y SONO DA TESTARE
public class Palla {

    private int x;
    private int y;

    //due velocita 1: velocità palla normale
    //              2: velocità con tiro speciale
    private double velocita;
    private int direzione; //1=sopra  2=sotto  3= sinistra  4=destra

    public Palla(int x, int y) {
        this.x = x;
        this.y = y;
        velocita = 0.2;
        direzione = 0;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getDirezione() {
        return direzione;
    }

    public double getVelocita() {
        return velocita;
    }

    public void incY() {
        y++;
    }
    
    public void decY() {
        y--;
    }
    
    public void incX() {
        x++;
    }
    
    public void decX() {
        x--;
    }

    public void setDirezione(int direzione) {
        this.direzione = direzione;
    }

    
    public void setVelocita(double velocita) {
        this.velocita = velocita;
    }
    
    
}
