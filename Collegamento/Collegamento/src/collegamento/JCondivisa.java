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
    InetAddress indirizzo;
    boolean collegato;
    boolean inAttesa;
    String nome_avversario;

    public JCondivisa() {
        indirizzo = null;
        collegato = false;
        inAttesa = false;
        nome_avversario = "...";
    }

    public InetAddress getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(InetAddress indirizzo) {
        this.indirizzo = indirizzo;
    }

    public String getNome_avversario() {
        return nome_avversario;
    }

    public void setNome_avversario(String nome_avversario) {
        this.nome_avversario = nome_avversario;
    }
}
//= InetAddress.getByName("localhost");