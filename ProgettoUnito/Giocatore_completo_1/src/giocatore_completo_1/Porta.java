/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package giocatore_completo_1;

/**
 *
 * @author Pelle
 */
public class Porta {
    
    private int xTraversa;
    private int yTraversa;
    private int larghezzaTraversa;
    private int lunghezzaTraversa;
    JFrame campo;
    private int xPalo;
    private int yPalo;
    private int lunghezzaPalo;
    private int larghezzaPalo;

    public Porta(JFrame campo, int x, int y, int larghezza, int lunghezza, int xp, int yp, int larp, int lungp) {
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

    public boolean Gol(int xPalla, int yPalla){
        if(xPalla<xPalo&& yPalla>yTraversa){
          System.out.println("gol");
                campo.p.setX(campo.getWidth()+500);
                campo.p.setY(campo.getHeight()+450);
                campo.p.setDirezione(0);
               
        
        return true;
        }else{
            return false;
        }
    }
    
    
    
}
