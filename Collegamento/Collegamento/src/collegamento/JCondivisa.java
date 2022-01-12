/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collegamento;

import java.net.InetAddress;

/**
 *
 * @author HP
 */
public class JCondivisa {
    String nome;
    String nome_avversario;
    String indirizzo_avversario;
    boolean collegato;
    boolean inAttesa;
    boolean chiesto_io;

    public JCondivisa() {
        indirizzo_avversario = null;
        collegato = false;
        inAttesa = false;
        chiesto_io = false; 
        nome_avversario = "";
        nome = "";
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
//= InetAddress.getByName("localhost");