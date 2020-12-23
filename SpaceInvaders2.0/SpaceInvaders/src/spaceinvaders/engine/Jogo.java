/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceinvaders.engine;

import javafx.application.Platform;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import spaceinvaders.elementos_sistema.Barreira;
import spaceinvaders.elementos_sistema.Invasores;
import spaceinvaders.elementos_sistema.Canhao;

/**
 * Classe responsavel pela engine do jogo
 * @author tsuyo
 */
public class Jogo {
    private int pontuacao = 0;  // pontuacao total do jogador
    private int terminou = 0;   // 0 = jogo continua, 1 = venceu o jogo, -1 = perdeu o jogo
    private boolean comecou = false;    // indica se o jogo ja iniciou, ou se acabou de entrar na tela de jogo
    private final double LARGURA = 800; // Largura da tela de jogo
    private final double ALTURA = 900;  // Altura da tela de jogo
    private final double MARGEMX = 50;  // Margem em x da tela de jogo
    
    
    private GraphicsContext gc; // Objeto responsavel por desenhar as imagens na tela 
    private Invasores invasores = new Invasores(gc);    // Cria os invasores (aliens)
    private Canhao canhao = new Canhao(ALTURA); // Cria o canhao a ser controlado pelo jogador 
    private Barreira barreira = new Barreira(); // Cria barreiras
    private double xCanhao = canhao.getX();
    private int vidas = 3;
    
    /**
     * Funcao responsavel pela leitura do teclado para controlar o canhao
     * @param event Evento que representa digitar uma tecla
     * @param gc Parametro responsavel por alterar a tela de jogo
     */
    public void leTeclado(KeyEvent event, GraphicsContext gc){
        String teclado = event.getCode().toString();
        if(comecou){
            // o canhao vai para a direita
            if(teclado.compareTo("RIGHT") == 0){
                if((xCanhao + 15) < (LARGURA - MARGEMX - 40)){
                    xCanhao += 15;
                }
            }
            // o canhao vai para a esquerda
            else if(teclado.compareTo("LEFT") == 0){
                if((xCanhao - 15) >= MARGEMX){
                    xCanhao -= 15;
                }
            }
            // o canhao atira
            else if(teclado.compareTo("SPACE") == 0){
                canhao.criaTiro();
            }
        }
        else if(!comecou){
            // inicia o jogo somente apos o jogador apertar espaco depois de entrar na tela de jogo
            if(teclado.compareTo("SPACE") == 0){
                comecou = true;
            }
        }
        else if(terminou != 0){
            if(teclado.compareTo("SPACE") == 0){
                Platform.exit();
            }
        }
    }
    
    /**
     * Funcao que faz a leitura da posicao do mouse do jogador na tela e controla a posicao do canhao com isso
     * @param event Evento que representa mexer o mouse
     * @param gc Parametro responsavel por alterar a tela de jogo
     */
    public void posicaoMouse(MouseEvent event, GraphicsContext gc){
        if(comecou){
            if(event.getX() - 25 < (LARGURA - MARGEMX - 40) && event.getX() - 25 >= MARGEMX){
                xCanhao = event.getX() - 25;
            }
        }
    }
    
    /**
     * Funcao que verifica quando o jogador clica com o mouse e atira
     * @param event Evento que representa clicar com o mouse
     * @param gc Parametro responsavel por alterar a tela de jogo
     */
    public void clicouMouse(MouseEvent event, GraphicsContext gc){
        if(!comecou){
            comecou = true;
        }
        else if(comecou){
            if(terminou != 0){
                Platform.exit();
            }
            canhao.criaTiro();
        }
        
    }
    
    /**
     * Funcao responsavel pelo andamento do jogo, imprimindo a tela e os elementos do jogo, alem da pontuacao e quando o jogo termina
     * @param gc 
     */
    public void run(GraphicsContext gc){
        // Se o jogo nao comecou ainda, deixa a tela de jogo parada
        if(!comecou){
            gc.setFill(Color.BLACK);
            gc.fillRect(0, 0, LARGURA, ALTURA);
            gc.setTextAlign(TextAlignment.CENTER);
            gc.setFont(Font.font(20));
            gc.setFill(Color.WHITE);
            gc.fillText("Pontuação: " + pontuacao, 70, 25);
            invasores.imprimirInvasores(gc);
            canhao.imprimirCanhao(gc, LARGURA, MARGEMX, xCanhao);
            barreira.imprimir(gc);
        }
        // Quando o jogo comeca, inicia as acoes na tela
        else{
            if(terminou == 0){
                gc.setFill(Color.BLACK);
                gc.fillRect(0, 0, LARGURA, ALTURA);
                gc.setTextAlign(TextAlignment.CENTER);
                gc.setFont(Font.font(20));
                gc.setFill(Color.WHITE);
                gc.fillText("Pontuação: " + pontuacao, 70, 25);
                barreira.imprimir(gc);
                if(invasores.getNumAliens() > 1){
                    invasores.mover(ALTURA, LARGURA, MARGEMX, 5);
                }
                else{
                    invasores.mover(ALTURA, LARGURA, MARGEMX, 20);
                }
                colisao();
                invasores.imprimirInvasores(gc);
                invasores.atirar(gc);
                if(canhao.removido){
                    terminou = -1;
                }
                else{
                    canhao.atirar(gc);
                    canhao.imprimirCanhao(gc, LARGURA, MARGEMX, xCanhao);
                }
                if(invasores.getNumAliens() == 0){
                    terminou = 1;
                }
            }
            // O jogador perdeu o jogo
            else if(terminou == -1){
                gc.setFill(Color.BLACK);
                gc.fillRect(0, 0, LARGURA, ALTURA);
                gc.setTextAlign(TextAlignment.CENTER);
                gc.setFont(Font.font(60));
                gc.setFill(Color.WHITE);
                gc.fillText("GAMEOVER", LARGURA/2, ALTURA/2);
            }
            // O jogador ganhou o jogo
            else if(terminou == 1){
                gc.setFill(Color.BLACK);
                gc.fillRect(0, 0, LARGURA, ALTURA);
                gc.setTextAlign(TextAlignment.CENTER);
                gc.setFont(Font.font(60));
                gc.setFill(Color.WHITE);
                gc.fillText("VOCÊ VENCEU!", LARGURA/2, ALTURA/2-30);
                gc.setTextAlign(TextAlignment.CENTER);
                gc.setFont(Font.font(40));
                gc.setFill(Color.WHITE);
                gc.fillText("Pontuação: " + pontuacao, LARGURA/2, ALTURA/2+30);
            }
        }
        
    }
    
    /**
     * Funcao que verifica todas as colisoes do jogo
     */
    public void colisao(){
        
        // verifica se os tiros dos invasores atingiram o canhao 
        for(int n = 0; n < invasores.getTiros().size(); n++){
            if(!invasores.getTiros().get(n).removido){
                double xTiroAlien = invasores.getTiros().get(n).getX();
                double yTiroAlien = invasores.getTiros().get(n).getY();
                if(xTiroAlien >= xCanhao && xTiroAlien <= xCanhao + 50){
                    if(yTiroAlien <= ALTURA && yTiroAlien >= ALTURA - 50){
                        invasores.getTiros().get(n).removido = true;
                        vidas--;
                        if(vidas == 0){
                            canhao.remover();
                            terminou = -1;
                        }
                        else{
                            comecou = false;
                            xCanhao = 50;
                        }
                    }
                }
                if(yTiroAlien <= 750 && yTiroAlien >= 700){
                    if(xTiroAlien >= 180 && xTiroAlien <= 180 + 50){
                        barreira.vida[0]++;
                        invasores.getTiros().get(n).removido = true;
                    }
                    else if(xTiroAlien >= 380 && xTiroAlien <= 380 + 50){
                        barreira.vida[1]++;
                        invasores.getTiros().get(n).removido = true;
                    } 
                    else if(xTiroAlien >= 580 && xTiroAlien <= 580 + 50){
                        barreira.vida[2]++;
                        invasores.getTiros().get(n).removido = true;
                    }
                }
            }
        }
              
        // Verifica se os aliens alcancaram o canhao
        for(int i = 4; i >= 0; i--){
                    for(int j = 10; j >= 0; j--){
                        if(!invasores.getAliens()[i][j].removido){
                            double xAlien = invasores.getAliens()[i][j].getX();
                            double yAlien = invasores.getAliens()[i][j].getY();
                            if(xAlien >= xCanhao && xAlien <= xCanhao + 50){
                                if(yAlien + 40 >= ALTURA - 50 && yAlien + 40 <= ALTURA){
                                    canhao.removido = true;
                                    terminou = -1;
                                }
                            }
                        }
                    }
                }
        
        for(int k = 0; k < canhao.getTiros().size(); k++){
            if(!canhao.getTiros().get(k).removido){
                double xTiro = canhao.getTiros().get(k).getX();
                double yTiro = canhao.getTiros().get(k).getY();        
                //verifica a colisao dos tiros do canhao com os tiros dos aliens
                for(int n = 0; n < invasores.getTiros().size(); n++){
                    if(!invasores.getTiros().get(n).removido){
                        double xTiroAlien = invasores.getTiros().get(n).getX();
                        double yTiroAlien = invasores.getTiros().get(n).getY();
                        if(xTiroAlien <= xTiro + 5 && xTiroAlien >= xTiro - 5){
                            if((yTiroAlien >= yTiro + 5 && yTiroAlien <= yTiro + 20) 
                                        || (yTiroAlien + 15 >= yTiro + 5 && yTiroAlien + 15 <= yTiro + 20)){
                                canhao.getTiros().get(k).remover();
                                invasores.getTiros().get(n).remover();
                            }
                        }
                    }
                }
      
                
                // verifica a colisao dos tiros do canhao com os aliens e com as barreiras
                for(int i = 4; i >= 0; i--){
                    for(int j = 10; j >= 0; j--){
                        if(!invasores.getAliens()[i][j].removido){
                            double xAlien = invasores.getAliens()[i][j].getX();
                            double yAlien = invasores.getAliens()[i][j].getY();
                            if(xTiro <= xAlien + 40 && xTiro >= xAlien){
                                if((yTiro >= yAlien + 20 && yTiro <= yAlien + 50) 
                                        || (yTiro + 15 >= yAlien + 20 && yTiro + 15 <= yAlien + 50)){
                                    canhao.getTiros().get(k).remover();
                                    pontuacao += invasores.getAliens()[i][j].getPontuacao();
                                    invasores.getAliens()[i][j].remover();
                                }
                            }
                        }
                        if(yTiro <= 750 && yTiro >= 700){
                            if(xTiro >= 180 && xTiro <= 180 + 50){
                                barreira.vida[0]++;
                                canhao.getTiros().get(k).remover();
                            }
                            else if(xTiro >= 380 && xTiro <= 380 + 50){
                                barreira.vida[1]++;
                                canhao.getTiros().get(k).remover();
                            } 
                            else if(xTiro >= 580 && xTiro <= 580 + 50){
                                barreira.vida[2]++;
                                canhao.getTiros().get(k).remover();
                            }
                        }
                    }
                }
                
            }
        }
    }
}
