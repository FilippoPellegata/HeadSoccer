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
    
    int xTraversa;
    int yTraversa;
    int larghezzaTraversa;
    int lunghezzaTraversa;
    Campo campo;
    int xPalo;
    int yPalo;
    int lunghezzaPalo;
    int larghezzaPalo;

    public Porta(Campo campo, int x, int y, int larghezza, int lunghezza, int xp, int yp, int larp, int lungp) {
        this.campo = campo;
        xTraversa=x;
       larghezzaTraversa=larghezza;
       yTraversa=y;
       lunghezzaTraversa=lunghezza;
       
       xPalo=xp;
       larghezzaPalo=larp;
       yPalo=yp;
       lunghezzaPalo=lungp;
    }

    public int getxTraversa() {
        return xTraversa;
    }

    public int getyTraversa() {
        return yTraversa;
    }

    public int getLarghezzaTraversa() {
        return larghezzaTraversa;
    }

    public int getLunghezzaTraversa() {
        return lunghezzaTraversa;
    }

    public int getxPalo() {
        return xPalo;
    }

    public int getyPalo() {
        return yPalo;
    }

    public int getLunghezzaPalo() {
        return lunghezzaPalo;
    }

    public int getLarghezzaPalo() {
        return larghezzaPalo;
    }

    
    
    
    
}
