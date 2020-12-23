/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceinvaders.interface_grafica;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.util.Duration;
import spaceinvaders.engine.Jogo;

/**
 * Classe que controla a tela inicial de menu e depois a tela de jogo
 * @author tsuyo
 */
public class TelaJogoController implements Initializable {
    private final double LARGURA = 800;   // Dimensoes da tela
    private final double ALTURA = 900;
    private final double MARGEMX = 50;
    private GraphicsContext gc;     // Objeto que altera a tela 
    private Jogo jogo = new Jogo(); // Objeto que controla as acoes do jogo
    
    @FXML
    private Button bJogarMouse;
    
    @FXML
    private Button bJogarTeclado;
    
    @FXML
    private Button bSair;
    
    /**
     * Quando o usuario clica em Jogar com o mouse, o canhao do jogo sera controlado atraves do mouse e os tiros sao dados com cliques
     * @param e Acao de clicar no botao
     */
    @FXML
    private void clicouJogarMouse(ActionEvent e) {
        // Fecha a tela de menu
        Stage stage = (Stage) bJogarMouse.getScene().getWindow();
        stage.close();
        
        // Inicia a tela de jogo
        Stage stage1 = new Stage();
        Group root = new Group();
        Canvas canvas = new Canvas(LARGURA, ALTURA);
        gc = canvas.getGraphicsContext2D();
        
        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(100), event -> jogo.run(gc)));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
     
        root.getChildren().add(canvas);
        
        Scene scene = new Scene(root);
        scene.setOnMouseMoved(event -> jogo.posicaoMouse(event, gc));
        scene.setOnMouseClicked(event -> jogo.clicouMouse(event, gc));
        
        stage1.setTitle("Space Invaders");
        stage1.setScene(scene);
        stage1.show();
    }
    
    /**
     * Quando o usuario clica em Jogar com o teclado, o canhao do jogo sera controlado atraves das setas do teclado
     * e os tiros sao dados com a tecla espaco
     * @param e Acao de clicar no botao
     */
    @FXML
    private void clicouJogarTeclado(ActionEvent e) {
        // fecha a tela de menu
        Stage stage = (Stage) bJogarTeclado.getScene().getWindow();
        stage.close();
        
        // inicia a tela de jogo
        Stage stage1 = new Stage();
        Group root = new Group();
        Canvas canvas = new Canvas(LARGURA, ALTURA);
        gc = canvas.getGraphicsContext2D();
        
        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(100), event -> jogo.run(gc)));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
     
        root.getChildren().add(canvas);
        
        Scene scene = new Scene(root);
        scene.setOnKeyPressed(event -> jogo.leTeclado(event, gc));
        
        stage1.setTitle("Space Invaders");
        stage1.setScene(scene);
        stage1.show();
    }
    
    /**
     * Funcao que fecha a janela caso o jogador clique em Sair
     * @param e Acao de clicar no botao 
     */
    @FXML
    public void clicouSair(ActionEvent e){
        Stage stage = (Stage) bSair.getScene().getWindow();
        stage.close();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
