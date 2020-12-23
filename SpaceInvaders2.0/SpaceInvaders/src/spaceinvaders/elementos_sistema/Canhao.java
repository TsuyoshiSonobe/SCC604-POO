/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceinvaders.elementos_sistema;

import java.io.File;
import java.util.ArrayList;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

/**
 * Classe do canhao controlado pelo jogador
 * @author tsuyo
 */
public class Canhao extends Elementos{
    private final File directory1 = new File("./\\src\\spaceinvaders\\elementos_sistema\\images\\canhao.png");  // caminho para a imagem do canhao
    private final Image imagem = new Image("file:" + directory1.getAbsolutePath());
    private ArrayList<Tiro> tiros = new ArrayList();    // Array que armazena os tiros do canhao
    
    /**
     * Inicia o canhao na parte inferior esquerda da tela de jogo 
     * @param ALTURA Parametro que indica o tamanho da tela de jogo na vertical 
     */
    public Canhao(double ALTURA){
        y = ALTURA - 40;
        x = 50;
    }
    
    /**
     * Funcao que imprime o canhao na tela de jogo
     * @param gc Parametro responsavel por alterar a tela de jogo
     * @param LARGURA Tamanho da tela de jogo na horizontal
     * @param MARGEMX Margem em x da tela 
     * @param xCanhao Posicao do canhao em x na tela de jogo
     */
    public void imprimirCanhao(GraphicsContext gc, double LARGURA, double MARGEMX, double xCanhao){
        x = xCanhao;
        gc.drawImage(imagem, xCanhao, y, 40, 40);
    }
    
    /**
     * Funcao que cria um objeto Tiro e adiciona ao Array de tiros
     */
    public void criaTiro(){
        Tiro tiro = new Tiro(x, y);
        tiros.add(tiro);
    }
    
    /**
     * Funcao que imprime e atualiza os tiros na tela 
     * @param gc Parametro responsavel por alterar a tela de jogo
     */
    public void atirar(GraphicsContext gc){
        for (int i = 0; i < tiros.size(); i++) {
            tiros.get(i).imprimirTiro(gc);
            tiros.get(i).atirar();
        }
    }
    
    /**
     * Funcao que retorna a posicao em x do canhao
     * @return Posicao em x do canhao
     */
    public double getX(){
        return x;
    }
    
    /**
     * Funcao que retorna o Array de objetos Tiro
     * @return Array de objetos da classe Tiro
     */
    public ArrayList<Tiro> getTiros(){
        return tiros;
    }
    
    /**
     * Funcao que remove o canhao do jogo
     */
    @Override
    public void remover(){
        removido = true;
    }
}
