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
    private int direzione;
    Campo campo;
    int AltezzaCampo;
    int LarghezzaCampo;

    public Palla(Campo campo) {
        x = campo.getWidth()+500;
        y = campo.getHeight()+450;
        velocita = 0.2;
        this.campo = campo;
        LarghezzaCampo = campo.getWidth();
        AltezzaCampo = campo.getHeight();
        direzione = 0;
    }

    void MovimentoInizioPartita() {
        int stato = 0;//0= sale //1=scende //2=libero
 

        while (stato == 0) {
            velocita=1;
            if (y>130) {
                y--;
                
                System.out.println("sale");
                try {
                    Thread.sleep(1);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Palla.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                stato = 1;
                System.out.println("stop salita");
            }
        }
        while (stato == 1) {
            velocita=0.2;
            System.out.println("scende");
            
            y++;
            try {
                    Thread.sleep(1);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Palla.class.getName()).log(Level.SEVERE, null, ex);
                }
            if (y > campo.getHeight() - 100) {
                stato = 2;
                System.out.println("stop discesa");
            }
        }

    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public double getVelocita() {
        return velocita;
    }

}
