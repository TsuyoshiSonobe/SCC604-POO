/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceinvaders;

/**
 *
 * @author tsuyo
 */
public class SpaceInvaders {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Jogo jogo = new Jogo();
        Invasores invasor = new Invasores(jogo);
        DiscoVoador disco = new DiscoVoador(jogo, 1);
        Canhao canhao = new Canhao(jogo);
        jogo.LoopJogo(jogo, invasor, disco, canhao);
    }
    
}
