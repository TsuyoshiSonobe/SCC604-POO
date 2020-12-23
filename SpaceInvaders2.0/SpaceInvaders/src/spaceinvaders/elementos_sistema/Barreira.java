/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceinvaders.elementos_sistema;

import java.io.File;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

/**
 * Cria as 3 barreiras do jogo
 * @author tsuyo
 */
public class Barreira extends Elementos{
    private double L = 50;
    private final File directory1 = new File("./\\src\\spaceinvaders\\elementos_sistema\\images\\barreira0.png");
    private final File directory2 = new File("./\\src\\spaceinvaders\\elementos_sistema\\images\\barreira1.png");
    private final File directory3 = new File("./\\src\\spaceinvaders\\elementos_sistema\\images\\barreira2.png");
    private final File directory4 = new File("./\\src\\spaceinvaders\\elementos_sistema\\images\\barreiras3.png");
    private final Image imagem[] = {
        new Image("file:" + directory1.getAbsolutePath()),
        new Image("file:" + directory2.getAbsolutePath()),
        new Image("file:" + directory3.getAbsolutePath()),
        new Image("file:" + directory4.getAbsolutePath())
    };
    public int vida[] = {0, 0, 0};
    
    /**
     * Imprime as barreiras na tela de jogo
     * @param gc 
     */
    public void imprimir(GraphicsContext gc){
        if(vida[0] < 4){
            gc.drawImage(imagem[vida[0]], 180, 700, L, L);
        }
        if(vida[1] < 4){
            gc.drawImage(imagem[vida[1]], 380, 700, L, L);
        }
        if(vida[2] < 4){
            gc.drawImage(imagem[vida[2]], 580, 700, L, L);
        }
    }
    
    /**
     * Remove as barreiras
     */
    public void remover(){
        removido = true;
    }
}
