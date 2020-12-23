/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceinvaders.elementos_sistema;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * Classe que representa os tiros disparados pelo canhao e pelos aliens
 * @author tsuyo
 */
public class Tiro extends Elementos{
    
    /**
     * Inicia o tiro em certa posicao de acordo com a direcao indicada
     * @param x Posicao x do tiro
     * @param y Posicao y do tiro
     */
    Tiro(double x, double y){
        this.x = x + 18;    // posicao x do tiro deve ser x + 18 para que fique no centro do canhao
        this.y = y;
        if(this.y == 860){
            direcao = 1;    // direcao == 1 representa tiro do canhao (de baixo para cima)
        }
        else{
            direcao = 2;    // direcao == 2 representa tiro do alien (de cima para baixo)
            this.y = y + 40;    // inicia o tiro na parte de baixo do alien
        }
    }
    
    /**
     * Funcao que imprime os tiros que ainda estao na tela de jogo
     * @param gc Parametro responsavel por alterar a tela de jogo
     */
    public void imprimirTiro(GraphicsContext gc){
        if(!removido){
            if(y != 0){
                if(direcao == 1){
                    gc.setFill(Color.GREEN);  // tiro do canhao eh verde
                }
                else{
                    gc.setFill(Color.WHITE);// tiro do alien eh branco
                }
                gc.fillRect(x, y, 3, 15);   // tamanho do tiro: 3 de largura e 15 de altura  
            }
            else{
                removido = true;
            }
        }
    }
    
    /**
     * Funcao que atualiza a posicao do tiro 
     */
    public void atirar(){
        if(removido == false){
            if(direcao == 1){
                this.y -= 30;
            }
            else{
                this.y += 30;
            }
        }
    }
    
    /**
     * Funcao que retorna x
     * @return Posicao em x do tiro na tela de jogo
     */
    public double getX(){
        return x;
    }
    
    /**
     * Funcao que retorna y
     * @return Posicao em y do tiro na tela de jogo
     */
    public double getY(){
        return y;
    }
    
    /**
     * Funcao que remove o tiro de jogo
     */
    @Override
    public void remover(){
        removido = true;
    }
}
