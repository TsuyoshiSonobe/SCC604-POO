/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceinvaders.elementos_sistema;

/**
 * 
 * @author tsuyo
 */
public interface Movimentacao {
    void mover(double ALTURA, double LARGURA, double MARGEMX, int vel);  //Metodo que faz a acao de mover o objeto na tela de jogo
    void mudarDirecao(double ALTURA, double LARGURA, double MARGEMX);   //Metodo que determina os limites da movimentacao de acordo com a tela do jogo
}
