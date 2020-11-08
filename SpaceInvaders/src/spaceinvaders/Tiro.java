/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceinvaders;

/**
 * Classe que representa um tiro no jogo
 * @author tsuyo
 */
public class Tiro extends Elementos{
    
    /**
     * Inicializa a posicao do tiro de acordo com a direcao do tiro
     * @param jogo Jogo em que as alteracoes serao feitas
     * @param x Posicao do tiro na linha da matriz
     * @param y Posicao do tiro na coluna da matriz
     */
    Tiro(Jogo jogo, int x, int y){
        simbolo = 'l';
        this.x = x;
        this.y = y;
        if(this.x == 11){
            direcao = 1;    //tiro para cima
            this.x = x - 1; //se o tiro for para cima, inicia o projetil na linha de cima do objeto que atirou
        }
        else{
            direcao = 2;    //tiro para baixo
            this.x = x + 1; //se o tiro for para baixo, inicia o projetil na linha de baixo do objeto que atirou
        }
        jogo.alterarJogo(this.x, this.y, simbolo);
    }
    
    /**
     * Retorna a linha em que o tiro esta na matriz do jogo
     * @return 
     */
    public int getPosicaox(){
        return x;
    }
    
    /**
     * Retorna a coluna em que o tiro esta na matriz do jogo
     * @return 
     */
    public int getPosicaoy(){
        return y;
    }
    
    /**
     * Implementa a acao de atirar no jogo, ou seja, movimentacao do trio
     * @param jogo Jogo em que as alteracoes serao feitas
     */
    public void atirar(Jogo jogo){
        if(removido == false){
            jogo.alterarJogo(this.x, this.y, '.');
            if(direcao == 1){    
                if(this.x > 0){
                    this.x -= 1;
                    jogo.alterarJogo(this.x, this.y, simbolo);
                }
            }
            else{
                if(this.x + 1 < jogo.getTamy()){
                    this.x += 1;
                    jogo.alterarJogo(this.x, this.y, simbolo);
                }
            }
        }
    }
    
    /**
     * Remove o objeto do jogo
     */
    public void remover(){
        removido = true;
    }
    
    /**
     * Retorna true se o objeto foi removido e false se nao foi
     * @return 
     */
    public boolean getRemovido(){
        return removido;
    }
}
