/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceinvaders;

/**
 * Classe que representa os aliens individualmente, com seus atributos (simbolo e pontuacao) proprios. Herda caracteristicas de Elementos e tem relacao de agregacao com Invasores
 * @author tsuyo
 */
public class Aliens extends Elementos{
    private int pontuacao;  //Pontuacao dada ao jogador caso atinja o alien
    
    /**
     * Atribui valores ao simbolo e a pontuacao do alien e inicia 
     * @param simbolo Simbolo que representa o alien
     * @param pontuacao Pontuacao dada ao jogador caso atinja o alien
     */
    Aliens(char simbolo, int pontuacao){
        direcao = 1;
        this.simbolo = simbolo;
        this.pontuacao = pontuacao;
    }
    
    /**
     * Atribui um caractere ao simbolo 
     * @param simbolo 
     */
    public void setSimbolo(char simbolo){
        this.simbolo = simbolo;
    }
    
    /**
     * Retorna o simbolo do alien
     * @return 
     */
    public char getSimbolo(){
        return this.simbolo;
    }
    
    /**
     * Atribui valor a pontuacao que o alien vale
     * @param pontuacao 
     */
    public void setPontuacao(int pontuacao){
        this.pontuacao = pontuacao;
    }
    
    /**
     * Retorna a pontuacao que o alien vale
     * @return 
     */
    public int getPontuacao(){
        return pontuacao;
    }
    
    /**
     * Implementacao da remocao do alien do jogo
     */
    public void remover(){
        removido = true;
        simbolo = '.';
    }
    
}
