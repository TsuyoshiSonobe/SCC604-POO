/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceinvaders.elementos_sistema;

import javafx.scene.image.Image;

/**
 * Classe de aliens
 * @author tsuyo
 */
public class Aliens extends Elementos{
    private int pontuacao;
    
    /**
     * Inicia um novo alien com uma imagem e uma pontuacao dada ao jogar ao atingi-lo
     * @param imagem Imagem que representa o alien
     * @param pontuacao Pontuacao ao acertar um tiro nele
     * @param x Posicao x na tela
     * @param y Posicao y na tela
     */
    Aliens(Image imagem, int pontuacao, double x, double y){
        this.imagem = imagem;
        this.pontuacao = pontuacao;
        this.x = x;
        this.y = y;
        L = 40;
    }
    
    /**
     * Funcao que retorna a pontuacao que o alien vale
     * @return Pontucao do alien
     */
    public int getPontuacao(){
        return pontuacao;
    }
    
    /**
     * Funcao que retorna a posicao em x do alien na tela de jogo
     * @return Posicao x do alien
     */
    public double getX(){
        return x;
    }
    
    /**
     * Funcao que retorna a posicao y do alien na tela de jogo
     * @return Posicao y do alien
     */
    public double getY(){
        return y;
    }
    
    /**
     * Funcao que remove o alien do jogo ao ser atingido
     */
    public void remover(){
        removido = true;
    }
}
