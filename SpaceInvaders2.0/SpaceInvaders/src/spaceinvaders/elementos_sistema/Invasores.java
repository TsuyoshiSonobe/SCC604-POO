/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceinvaders.elementos_sistema;

import java.io.File;
import java.util.ArrayList;
import java.util.Random;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

/**
 * Classe que contem a matriz de objetos da classe Alien do jogo
 * @author tsuyo
 */
public class Invasores implements Movimentacao{
    private Aliens aliens[][]; //matriz de aliens
    private DiscoVoador disco = new DiscoVoador();
    private int discos = 1;
    private double xi = 50;   // posicao inicial em x na matriz de aliens
    private double yi = 150;  // posicao inicial em y na matriz de aliens
    private final double L = 40;    // tamanho do lado da imagem do alien
    private int direcao = 1;        // direcao inicial (direita)
    private final int pontuacao[] = {25, 20, 15, 10, 5};  // pontuacao de cada alien
    private final File directory1 = new File("./\\src\\spaceinvaders\\elementos_sistema\\images\\alien.png");   //caminho para as imagens dos aliens
    private final File directory2 = new File("./\\src\\spaceinvaders\\elementos_sistema\\images\\alien2.png");
    private final File directory3 = new File("./\\src\\spaceinvaders\\elementos_sistema\\images\\alien3.png");
    private final Image imagem[] = {
        new Image("file:" + directory1.getAbsolutePath()),
        new Image("file:" + directory2.getAbsolutePath()),
        new Image("file:" + directory2.getAbsolutePath()),
        new Image("file:" + directory3.getAbsolutePath()),
        new Image("file:" + directory3.getAbsolutePath())
    };
    private ArrayList<Tiro> tiros = new ArrayList();    //Array de objetos da classe tiro  
    private int movimentos = 0;     // quantidade de movimentos da matriz de aliens
    
    /**
     * Inicializa a matriz de aliens com suas imagens, pontuacao e posicao
     * @param gc Parametro responsavel por alterar a tela de jogo
     */
    public Invasores(GraphicsContext gc){
        aliens = new Aliens[5][11]; 
        for(int j = 0; j < 11; j++){
            aliens[0][j] = new Aliens(imagem[0], pontuacao[0], xi + j*L, yi);
            aliens[1][j] = new Aliens(imagem[1], pontuacao[1], xi + j*L, yi + L);
            aliens[2][j] = new Aliens(imagem[2], pontuacao[2], xi + j*L, yi + 2*L);
            aliens[3][j] = new Aliens(imagem[3], pontuacao[3], xi + j*L, yi + 3*L);
            aliens[4][j] = new Aliens(imagem[4], pontuacao[4], xi + j*L, yi + 4*L);
        }       
    }
    
    /**
     * Funcao que imprime os aliens vivos 
     * @param gc Parametro responsavel por alterar a tela de jogo
     */
    public void imprimirInvasores(GraphicsContext gc){
        if(!disco.removido){
            disco.imprimirDisco(gc);
        }
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 11; j++){
                if(!aliens[i][j].removido){
                    gc.drawImage(aliens[i][j].imagem, aliens[i][j].x, aliens[i][j].y, L, L);
                }
            }
        }
    }
    
    /**
     * Funcao responsavel pela movimentacao da matriz de aliens dentro do jogo
     * @param ALTURA Altura da tela de jogo
     * @param LARGURA Largura da tela de jogo
     * @param MARGEMX Margem em x da tela de jogo
     * @param vel Velocidade com que os aliens vao se movimentar (pixels por entrada na funcao)
     */
    public void mover(double ALTURA, double LARGURA, double MARGEMX, int vel){
        movimentos++;   // incrementa o numero de movimentos
        
        double xMaior = -100000;
        double xMenor = 100000;
        
        if(movimentos == 20){   // a cada 20 movimentos gera um tiro de um alien aleatorio
            criaTiro();
            movimentos = 0;
        }
        
        // a cada 10 tiros aparece um disco
        if(tiros.size() == 10*discos){
            if(discos%2 == 0){
                disco.criaDisco(2);
            }
            else{
                disco.criaDisco(1);
            }
            discos++;
        }
        if(!disco.removido){
            disco.mover();
        }
        
        // armazena o menor x e o maior x dos aliens vivos, para que os aliens vivos se movam até as bordas
        // laterais da tela quando outros morrerem
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 11; j++){
                if(!aliens[i][j].removido){
                    if(aliens[i][j].x > xMaior){
                        xMaior = aliens[i][j].x;
                    }
                    if(aliens[i][j].x < xMenor){
                        xMenor = aliens[i][j].x;
                    }
                }
            }
        }
       
        // Movimentacao da matriz de aliens
        if(direcao == 1){   // direcao == 1 -> direita   
            if( (xMaior + L + vel) < (LARGURA - MARGEMX)){
                for(int i = 0; i < 5; i++){
                    for(int j = 0; j < 11; j++){
                        if(!aliens[i][j].removido){
                            aliens[i][j].x += vel;
                        }
                    }
                }
            }
            else{
                mudarDirecao(ALTURA, LARGURA, MARGEMX);
            }
        }
        else if(direcao == 2){  // direcao == 2 -> esquerda
            if( (xMenor - vel) > MARGEMX){
                for(int i = 0; i < 5; i++){
                    for(int j = 0; j < 11; j++){
                        if(!aliens[i][j].removido){
                            aliens[i][j].x -= vel;
                        }
                    }
                }
            }
            else{
                mudarDirecao(ALTURA, LARGURA, MARGEMX);
            }
        }
        else{
            mudarDirecao(ALTURA, LARGURA, MARGEMX);
        }
        
    }
    
    /**
     * Funcao responsavel pela mudanca de direcao da matriz de aliens (vai para baixo e muda de direcao)
     * @param ALTURA Altura da tela de jogo
     * @param LARGURA Largura da tela de jogo
     * @param MARGEMX Margem em x da tela de jogo
     */
    @Override
    public void mudarDirecao(double ALTURA, double LARGURA, double MARGEMX){
        // vai para baixo
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 11; j++){
                if(!aliens[i][j].removido){
                    aliens[i][j].y += 15;
                }
            }
        }
        // muda de direcao
        if(direcao == 1){
            direcao = 2;
        }
        else{
            direcao = 1;
        }
    }
    
    /**
     * Cria um tiro partindo de um alien vivo aleatorio da matriz 
     */
    public void criaTiro(){
        Random gerador = new Random();
        int xRandom = gerador.nextInt(5);
        int yRandom = gerador.nextInt(11);
        if(!aliens[xRandom][yRandom].removido){
            Tiro tiro = new Tiro(aliens[xRandom][yRandom].x, aliens[xRandom][yRandom].y);
            tiros.add(tiro);
        }
    }
    
    /**
     * Funcao que imprime e atualiza os tiros que partem dos aliens
     * @param gc 
     */
    public void atirar(GraphicsContext gc){
        for (int i = 0; i < tiros.size(); i++) {
            tiros.get(i).imprimirTiro(gc);
            tiros.get(i).atirar();
        }
    }
    
    /**
     * Funcao que retorna o Array de tiros dos aliens
     * @return Array de objetos da classe Tiro
     */
    public ArrayList<Tiro> getTiros(){
        return tiros;
    }
    
    /**
     * Funcao que retorna o disco voador
     * @return Objeto da classe DiscoVoador
     */
    public DiscoVoador getDisco(){
        return disco;
    }
    
    /**
     * Funcao que remove um alien que ocupa uma certa posicao x y na tela de jogo
     * @param x Posicao em x do alien a ser removido
     * @param y Posicao em y do alien a ser removido
     */
    public void remover(double x, double y){
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 11; j++){
                if(aliens[i][j].x == x && aliens[i][j].y == y){
                    aliens[i][j].remover();
                }
            }
        }
    }
    
    /**
     * Funcao que retorna a matriz de aliens 
     * @return Matriz de objetos da classe Aliens
     */
    public Aliens[][] getAliens(){
        return aliens;
    }
    
    /**
     * Funcao que retorna o numero de aliens vivos no jogo
     * @return Numero de aliens vivos 
     */
    public int getNumAliens(){
        int nAliens = 0;
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 11; j++){
                if(!aliens[i][j].removido){
                    nAliens++;
                }
            }
        }
        return nAliens;
    }
}
