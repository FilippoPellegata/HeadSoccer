/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package giocatore_completo_1;

import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dippolito_mattia
 */
public class JCondivisa {
    boolean saltando;
    String nome;
    String nome_avversario;
    String indirizzo_avversario;
    boolean collegato;
    boolean inAttesa;
    boolean chiesto_io;
    DatagramSocket server;

    public JCondivisa() {
        saltando = false;
        indirizzo_avversario = null;
        collegato = false;
        inAttesa = false;
        chiesto_io = false; 
        nome_avversario = "";
        nome = "";
        try {
            server = new DatagramSocket(666);
        } catch (SocketException ex) {
            Logger.getLogger(JCondivisa.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getIndirizzo_avversario() {
        return indirizzo_avversario;
    }

    public void setIndirizzo_avversario(String indirizzo_avversario) {
        this.indirizzo_avversario = indirizzo_avversario;
    }

    public String getNome_avversario() {
        return nome_avversario;
    }

    public void setNome_avversario(String nome_avversario) {
        this.nome_avversario = nome_avversario;
    }
}
