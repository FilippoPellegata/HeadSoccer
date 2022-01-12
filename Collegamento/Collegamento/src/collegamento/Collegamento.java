/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collegamento;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HP
 */
public class Collegamento {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JCondivisa cond = new JCondivisa();
        cond.setIndirizzo_avversario("172.16.102.77");
        Thread_collegamento tc = new Thread_collegamento(cond);
        
        /*Gestore_messaggio gm = new Gestore_messaggio(cond);
        try {
            gm.invia("c", "D'Ippolito");
        } catch (IOException ex) {
            Logger.getLogger(Collegamento.class.getName()).log(Level.SEVERE, null, ex);
        }
        cond.chiesto_io = true;*/
        
        tc.start();
    }
    
}
