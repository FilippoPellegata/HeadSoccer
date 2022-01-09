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
public class Porta {
    
    int x;
    int y;
    int x1;
    int y1;
    Campo campo;

    public Porta(Campo campo) {
        this.campo = campo;
        x=0;
       x1=100;
       y=700;
       y1=220;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getX1() {
        return x1;
    }

    public int getY1() {
        return y1;
    }
    
    
    
}
