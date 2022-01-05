/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progettoheadsoccer;

/**
 *
 * @author Pelle
 */
public class PersonaggioProva {
    private int x;
    private int y;
    private int lunghezza;
    private int altezza;

    public PersonaggioProva(int x, int y, int lunghezza, int altezza) {
        this.x = x;
        this.y = y;
        this.lunghezza = lunghezza;
        this.altezza = altezza;
    }
    
    public boolean isInside(int x, int y) {
        if (x >= this.x && x <= this.x + lunghezza && y >= this.y && y <= this.y + altezza) {
            return true;
        } else {
            return false;
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getLunghezza() {
        return lunghezza;
    }

    public int getAltezza() {
        return altezza;
    }
    
    
}
