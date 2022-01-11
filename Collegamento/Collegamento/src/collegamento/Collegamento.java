/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collegamento;

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
        Thread_collegamento tc = new Thread_collegamento(cond);
        tc.start();
    }
    
}
