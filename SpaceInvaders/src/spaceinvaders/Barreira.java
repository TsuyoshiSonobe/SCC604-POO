/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceinvaders;

/**
 * Classe que representa as barreiras que protegem o canhao no jogo
 * @author tsuyo
 */
public class Barreira extends Elementos{
    
    /**
     * Inicializa a barreira em uma posicao na matriz do jogo passada por parametro 
     * @param jogo Jogo em que as alteracoes serao feitas
     * @param x Posicao da barreira na linha da matriz
     * @param y Posicao da barreira na coluna da matriz
     */
    Barreira(Jogo jogo, int x, int y){
        simbolo = 'B';
        this.x = x;
        this.y = y;
        direcao = 0;    //Esse elemento nao se move
        jogo.alterarJogo(x, y, simbolo);
    }
    
    /**
     * Retorna a linha em que a barreira esta na matriz do jogo
     * @return 
     */
    public int getPosicaox(){
        return x;
    }
    
    /**
     * Retorna a coluna em que a barreira esta na matriz do jogo
     * @return 
     */
    public int getPosicaoy(){
        return y;
    }
    
    /**
     * Implementa a remocao da barreira do jogo
     */
    public void remover(){
        removido = true;
        simbolo = '.';
    }
}
