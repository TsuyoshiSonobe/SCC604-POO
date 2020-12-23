/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceinvaders.elementos_sistema;

import java.io.File;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

/**
 * Classe que representa o Disco Voador que vale pontos extra
 * @author tsuyo
 */
public class DiscoVoador extends Elementos{
    private int pontuacao = 50;     // pontuacao do disco voador
    private final File directory1 = new File("./\\src\\spaceinvaders\\elementos_sistema\\images\\discovoador.png");
    private final Image imagem = new Image("file:" + directory1.getAbsolutePath());
    public boolean removido;
    
    /**
     * Inicia a posicao e tamanho
     */
    DiscoVoador(){
        L = 50;             // tamanho da imagem
        x = 20;             // x inicial
        removido = true;
    }
    
    /**
     * Imprime o disco voador na tela de jogo
     * @param gc 
     */
    public void imprimirDisco(GraphicsContext gc){
        if(!removido){
            gc.drawImage(imagem, x, y, L, L);
        }
    }
    
    /**
     * Cria um disco voador 
     * @param direcao Parametro que indica a direcao que vai tomar (inicia na esquerda e vai para direita ou o contrario)
     */
    public void criaDisco(int direcao){
        removido = false;
        if(direcao == 1){   // direcao == 1 -> direita
            y = L;
        }
        else{               // direcao == 2-> esquerda
            y = 800 - L;
        }
    }
    
    /**
     * Funcao que atualiza a posicao do disco na tela de jogo
     */
    public void mover(){
        if(removido == false){
            if(direcao == 1){
                this.x += 20;
                if(x >= 800){
                    removido = true;
                }
            }
            else{
                this.x -= 20;
                if(x <= 0){
                    removido = true;
                }
            }
        }
    }
    
    /**
     * Funcao que remove o disco voador do jogo
     */
    public void remover(){
        removido = true;
    }
}
