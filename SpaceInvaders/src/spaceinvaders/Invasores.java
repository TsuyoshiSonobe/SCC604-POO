/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceinvaders;

/**
 * Classe formada por uma matriz de objetos da classe Aliens (Relacao de agregacao com Aliens)
 * @author tsuyo
 */
public class Invasores implements Movimentacao{
    private Aliens aliens[][];  //matriz de objetos da classe Aliens
    private int x1 = 2;     //posicao do inicio da matriz de invasores na matriz do jogo
    private int y1 = 0;
    private int x2 = 6;     //posicao do final da matriz de invasores na matriz do jogo
    private int y2 = 10; 
    private int direcao = 1;    //direcao == 1 (Indo para a direita), direcao == 2 (Indo para a esquerda)
    private int pontuacao[] = {25, 20, 15, 10, 5};  //vetor com as pontuacoes dos aliens por linha 
    private final char simbolo[] = {'a', 'b', 'c', 'd', 'e'};   //simbolo que representa os aliens por linha na matriz do jogo
    
    /**
     * Inicializa a matriz de objetos da classe Aliens com seus simbolos e pontuacoes. Os aliens iniciam o jogo em posicao ja determinada 
     * @param jogo Jogo em que as alteracoes serao feitas
     */
    Invasores(Jogo jogo){
        x1 = 2;
        x2 = 6;
        y1 = 0;
        y2 = 10;
        direcao = 1;
        aliens = new Aliens[5][11];
       
        for(int j = 0; j < 11; j++){
            aliens[0][j] = new Aliens(simbolo[0], pontuacao[0]);
            aliens[1][j] = new Aliens(simbolo[1], pontuacao[1]);
            aliens[2][j] = new Aliens(simbolo[2], pontuacao[2]);
            aliens[3][j] = new Aliens(simbolo[3], pontuacao[3]);
            aliens[4][j] = new Aliens(simbolo[4], pontuacao[4]);
        }       
        imprimirInvasores(jogo);
    } 
    
    /**
     * Imprime os simbolos da matriz de aliens
     * @param jogo Jogo em que as alteracoes serao feitas
     */
    private void imprimirInvasores(Jogo jogo){
        int x = 0, y = 0;
        for(int i = x1; i <= x2; i++){
            for(int j = y1; j <= y2; j++){
                jogo.alterarJogo(i , j, aliens[x][y].getSimbolo());
                y++;
            }
            x++;
            y = 0;
        }
    }
    
    /**
     * Implementa a movimentacao dos aliens
     * @param jogo Jogo em que as alteracoes serao feitas
     */
    public void mover(Jogo jogo){
        if(direcao == 1){
            if( (y2 + 1) < jogo.getTamy() ){
                for(int i = x1; i <= x2; i++){
                    jogo.alterarJogo(i, y1, '.');
                }            
                y1++;
                y2++;
                imprimirInvasores(jogo);
            }
            else if( (y2 + 1) == jogo.getTamy() ){
                mudarDirecao(jogo);
            }
        }
        else if(direcao == 2){
            if( y1 > 0 ){
                for(int i = x1; i <= x2; i++){
                    jogo.alterarJogo(i, y2, '.');
                }
                y1--;
                y2--;
                imprimirInvasores(jogo);
            }
            else if( y1 == 0 ){
                mudarDirecao(jogo);
            }
        }
    }
    
    /**
     * Implementa a mudanca de linha e de direcao ao chegar aos limites de coluna da matriz do jogo
     * @param jogo Jogo em que as alteracoes serao feitas
     */
    public void mudarDirecao(Jogo jogo){
        for(int i = y1; i <= y2; i++){
            jogo.alterarJogo(x1, i, '.');
        }
        x1++;
        x2++;
        imprimirInvasores(jogo);
        if(direcao == 1){
            direcao = 2;
        }
        else{
            direcao = 1;
        }
    }
    
    /**
     * Remove o alien do jogo e soma sua pontuacao a pontucao do jogador
     * @param jogo Jogo em que as alteracoes serao feitas
     * @param x Posicao do objeto na linha da matriz de aliens
     * @param y Posicao do objeto na coluna da matriz de aliens
     */
    public void remover(Jogo jogo, int x, int y){
        x = x - x1;
        y = y - y1 + 1;
        jogo.setPontuacao(jogo.getPontuacao() + aliens[x][y].getPontuacao());
        aliens[x][y].remover();
        imprimirInvasores(jogo);
    }
    
}

