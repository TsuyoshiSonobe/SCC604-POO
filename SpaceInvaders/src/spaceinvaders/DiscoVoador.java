/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceinvaders;

/**
 * Classe responsavel pelo disco voador que da pontuacao extra ao jogador que acerta-lo. Herda caracteristicas de Elementos e implementa Movimentacao
 * @author tsuyo
 */
public class DiscoVoador extends Elementos implements Movimentacao{
    private final int pontuacao = 50;   //Pontuacao dada ao jogador caso atinja o disco
    
    /**
     * Inicializa o disco voador sempre na primeira linha da matriz do jogo, a coluna e determinada de acordo com a direcao do disco
     * @param jogo Jogo em que as alteracoes serao feitas
     * @param direcao Direcao em que o disco se movera
     */
    DiscoVoador(Jogo jogo, int direcao){
        simbolo = 'D';
        x = 0;
        this.direcao = direcao;
        if(direcao == 1){
            y = 0;
        }
        else{
            y = 18;
        }
        jogo.alterarJogo(x, y, simbolo);
    }
    
    /**
     * Retorna a linha em que o disco voador esta na matriz do jogo
     * @return 
     */
    public int getPosicaox(){
        return x;
    }
    
    /**
     * Retorna a coluna em que o disco voador esta na matriz do jogo
     * @return 
     */
    public int getPosicaoy(){
        return y;
    }
    
    /**
     * Implementa a movimentacao do disco e remove ele ao chegar aos limites da matriz do jogo
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
                    jogo.alterarJogo(x, y, '.');
                    remover();
                }
            }
            else if(direcao == 2){
                if(y > 0){
                    jogo.alterarJogo(x, y, '.');
                    y -= 1;
                    jogo.alterarJogo(x, y, simbolo);
                }
                else{
                    jogo.alterarJogo(x, y, '.');
                    remover();
                }
            }
        }
    }
    
    /**
     * Implementa a mudanca de direcao do disco
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
     * Implenta a remocao do disco voador do jogo
     */
    public void remover(){
        removido = true;
    }
}
