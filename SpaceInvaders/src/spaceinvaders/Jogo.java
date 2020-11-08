/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceinvaders;

/**
 * Classe responsavel por criar e fazer alteracoes na matriz do jogo, alem de determinar quando ele acaba e a pontuacao do jogador
 * @author tsuyo
 */
public class Jogo { 
    private char jogo[][];          //matriz do jogo  
    private final int tamx = 12;    //tamanho da matriz do jogo  
    private final int tamy = 19;
    private boolean terminou = false;   //determina o fim do jogo
    private boolean impacto = false;    //determina quando ha impacto entre elementos do jogo
    private int posImpacto[] = new int[2];  //posicao do impacto
    private int pontuacao = 0;      //pontuacao do jogador
    
    /**
     * Inicializa a matriz do jogo e preenche com '.' para melhor visualizacao
     */
    Jogo(){
        jogo = new char[tamx][tamy];
        for(int i = 0; i < tamx; i++){
            for(int j = 0; j < tamy; j++){
                jogo[i][j] = '.';
            }
        }
    }
    
    /**
     * Retorna o tamanho da matriz do jogo em linhas
     * @return 
     */
    public int getTamx(){
        return tamx;
    }
    
    /**
     * Retorna o tamanho da matriz do jogo em colunas
     * @return 
     */
    public int getTamy(){
        return tamy;
    }
    
    /**
     * Atribui um valor a pontuacao
     * @param pontuacao Pontuacao do jogador
     */
    public void setPontuacao(int pontuacao){
        this.pontuacao = pontuacao;
    }
    
    /**
     * Retorna a pontuacao do jogador
     * @return 
     */
    public int getPontuacao(){
        return pontuacao;
    }
    
    /**
     * Retorna true se o jogo acabou ou false se nao
     * @return 
     */
    public boolean getFimDeJogo(){
        return terminou;
    }
    
    /**
     * Altera a matriz do jogo e verifica se o jogo acabou
     * @param x Posicao da linha a ser modificada
     * @param y Posicao da coluna a ser modificada
     * @param c Caractere a ser inserido na posicao
     */
    public void alterarJogo(int x, int y, char c){
        if(c == 'a' || c == 'b' || c == 'c' || c == 'd' || c == 'e'){
            if(jogo[x][y] != 'C'){
                jogo[x][y] = c;
            }
            else{
                terminou = true;
            }
        }
        else if(c == 'l'){
            if(jogo[x][y] == 'C'){
                terminou = true;
            }
            else if(jogo[x][y] == 'a' || jogo[x][y] == 'b' || jogo[x][y] == 'c' || jogo[x][y] == 'd' || jogo[x][y] == 'e'){
                jogo[x][y] = '.';
                impacto = true;
                posImpacto[0] = x;
                posImpacto[1] = y;
            }
            else{
                jogo[x][y] = c;
            }
        }
        else{
            jogo[x][y] = c;
        }
    }
    
    /**
     * Imprime a matriz do jogo
     */
    public void imprimirJogo(){
        for(int i = 0; i < tamx; i++){
            for(int j = 0; j < tamy; j++){
                System.out.print(jogo[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    
    /**
     * Responsavel pela simulacao do jogo
     * @param jogo Objeto da classe Jogo
     * @param invasor Objeto da classe Invasores
     * @param disco Objeto da classe DiscoVoador
     * @param canhao Objeto da classe Canhao
     */
    public void LoopJogo(Jogo jogo, Invasores invasor, DiscoVoador disco, Canhao canhao){
        canhao.mover(jogo);
        canhao.mover(jogo);
        canhao.mover(jogo);
        canhao.mover(jogo);
        Tiro tiro1 = canhao.criaTiro(jogo);
        while(getFimDeJogo() == false){
            disco.mover(jogo);
            System.out.println("Pontuacao: " + pontuacao);
            jogo.imprimirJogo();
            canhao.mover(jogo);
            invasor.mover(jogo);
            if(impacto == false){
                canhao.atirar(jogo, tiro1);
            }
            else{
                invasor.remover(jogo, posImpacto[0], posImpacto[1]);
                tiro1.remover();
                impacto = false;
            }
        }
        
        jogo.imprimirJogo();
        System.out.println("Os invasores alcancaram a nave!");
        System.out.println();
    }
    
    
}
