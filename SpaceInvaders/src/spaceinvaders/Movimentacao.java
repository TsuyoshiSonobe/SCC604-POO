/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceinvaders;

/**
 * Interface com as acoes de movimentacao dos elementos moveis do jogo
 * @author tsuyo
 */
public interface Movimentacao {
    void mover(Jogo jogo);  //Metodo que faz a acao de mover o objeto na matriz do jogo
    void mudarDirecao(Jogo jogo);   //Metodo que determina os limites da movimentacao de acordo com os limites da matriz do jogo
}

