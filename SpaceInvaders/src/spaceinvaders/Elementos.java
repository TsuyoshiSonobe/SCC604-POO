/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceinvaders;

/**
 * Classe abstrata que engloba as caracteristicas (Atributos e metodos) em comum de todos os elementos do jogo (Canhao, Aliens, DiscoVoador)  
 * @author tsuyo
 */
public abstract class Elementos {
    protected int x;    //Posicao na linha matriz do jogo
    protected int y;    //Posicao na coluna da matriz do jogo
    protected char simbolo; //Simbolo que representa o objeto no jogo
    protected int direcao;  //Direcao da movimentacao do objeto
    protected boolean removido = false; //Indica se o objeto foi removido do jogo
    
    public abstract void remover(); //Metodo para remover o objeto do jogo
}
