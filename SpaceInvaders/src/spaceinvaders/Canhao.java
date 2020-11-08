/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceinvaders;

/**
 * Classe que representa o canhao do jogo
 * @author tsuyo
 */
public class Canhao extends Elementos implements Movimentacao{
    private final char simbolo = 'C';   //simbolo que identifica o canhao na matriz do jogo
    
    /**
     * Inicia o canhao no canto inferior esquerdo da matriz do jogo
     * @param jogo Jogo em que as alteracoes serao feitas
     */
    Canhao(Jogo jogo){
        y = 0;
        x = 11;
        direcao = 1;
        jogo.alterarJogo(x, y, simbolo);
    }
    
    /**
     * Retorna a linha em que o canhao esta na matriz do jogo
     * @return 
     */
    public int getPosicaox(){
        return x;
    }
    
    /**
     * Retorna a coluna em que o canhao esta na matriz do jogo
     * @return 
     */
    public int getPosicaoy(){
        return y;
    }
    
    /**
     * Implementa a movimentacao do canhao
     * @param jogo Jogo em que as alteracoes serao feitas
     */
    public void mover(Jogo jogo){
        if(removido != true){
            if(direcao == 1){
                if(y + 1 < jogo.getTamy()){
                    jogo.alterarJogo(x, y, '.');
                    y += 1;
                    jogo.alterarJogo(x, y, simbolo);
                }
                else{
                    mudarDirecao(jogo);
                }
            }
            else if(direcao == 2){
                if(y > 0){
                    jogo.alterarJogo(x, y, '.');
                    y -= 1;
                    jogo.alterarJogo(x, y, simbolo);
                }
                else{
                    mudarDirecao(jogo);
                }
            }
        }
    }
    
    /**
     * Implementa a mudanca de direcao do canhao quando chega ao limite das colunas da matriz
     * @param jogo Jogo em que as alteracoes serao feitas
     */
    public void mudarDirecao(Jogo jogo){
        if(direcao == 1){
            direcao = 2;
        }
        else{
            direcao = 1;
        }
    }
    
    /**
     * Cria um objeto da classe Tiro
     * @param jogo Jogo em que as alteracoes serao feitas
     * @return Um objeto da classe Tiro
     */
    public Tiro criaTiro(Jogo jogo){
        Tiro tiro = new Tiro(jogo, x, y);
        return tiro;
    }
    
    /**
     * Faz a acao do canhao atirar
     * @param jogo Jogo em que as alteracoes serao feitas
     * @param tiro 
     */
    public void atirar(Jogo jogo, Tiro tiro){
        if(tiro.getRemovido() == false){
            tiro.atirar(jogo);
        }
    }
    
    /**
     * Remove o canhao do jogo
     */
    public void remover(){
        removido = true;
    }
}
