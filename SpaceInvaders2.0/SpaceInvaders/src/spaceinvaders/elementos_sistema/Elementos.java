/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceinvaders.elementos_sistema;

import javafx.scene.image.Image;

/**
 * Classe abstrata que contem os atributos e metodos pertencentes a todos as classes que representam elementos no jogo
 * @author tsuyo
 */
public abstract class Elementos {
    protected double x;    //Posicao na linha matriz do jogo
    protected double y;    //Posicao na coluna da matriz do jogo
    protected Image imagem; //Imagem que representa o objeto no jogo
    protected double L;     // Tamanho da imagem
    protected int direcao;  //Direcao da movimentacao do objeto
    public boolean removido = false; //Indica se o objeto foi removido do jogo
    
    public abstract void remover(); //Metodo para remover o objeto do jogo
}