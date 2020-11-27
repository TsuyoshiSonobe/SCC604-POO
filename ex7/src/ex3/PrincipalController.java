/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex3;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 *
 * @author tsuyo
 */
public class PrincipalController implements Initializable {
    
    @FXML
    private Label lResultado;
    
    @FXML
    private Label lResultadoParcial;
    
    @FXML
    private Button bDel;
    
    @FXML
    private Button bDivisao;
    
    @FXML
    private Button bMultiplicacao;
    
    @FXML
    private Button bSubtracao;
    
    @FXML
    private Button bSoma;
    
    @FXML
    private Button bIgual;
    
    @FXML
    private Button bPonto;
    
    @FXML
    private Button bZero;
    
    @FXML
    private Button bUm;
    
    @FXML
    private Button bDois;
    
    @FXML
    private Button bTres;
    
    @FXML
    private Button bQuatro;
    
    @FXML
    private Button bCinco;
    
    @FXML
    private Button bSeis;
    
    @FXML
    private Button bSete;
    
    @FXML
    private Button bOito;
    
    @FXML
    private Button bNove;

    private Calculadora calculadora = new Calculadora();
    
    private void mostraMensagem(Alert.AlertType tipo, String texto){
        Alert mensagem = new Alert(tipo);
        mensagem.setTitle("Mensagem de erro");
        mensagem.setHeaderText(null);
        mensagem.setContentText(texto);
        mensagem.showAndWait();
    }
    
    private void mostraResultadoParcial(){
        ArrayList<Character> digitado = new ArrayList<>();
        digitado = calculadora.getExpressao(lResultado.getText());
        int tam = lResultado.getText().length();
        if(!calculadora.ehOperacao(lResultado.getText().charAt(tam - 1))){    //Impede que a ultima coisa digitada seja uma operacao
            try{
                lResultadoParcial.setText(calculadora.resultado(calculadora.getOperacoes(digitado), calculadora.getNumeros(digitado)));
            }
            catch(ArithmeticException error){
                mostraMensagem(AlertType.ERROR, error.getMessage());
                lResultado.setText("");
            }
            catch(IndexOutOfBoundsException error){
                mostraMensagem(AlertType.ERROR, "Erro nas Arrays");
                lResultado.setText("");
            } 
            catch(NumberFormatException error){
                mostraMensagem(AlertType.ERROR, "Erro na conta");
                lResultado.setText("");
            }
        }
    }
    
    private void mostraResultadoFinal(){
        ArrayList<Character> digitado = new ArrayList<>();
        digitado = calculadora.getExpressao(lResultado.getText());
        int tam = lResultado.getText().length();
        if(!calculadora.ehOperacao(lResultado.getText().charAt(tam - 1))){    //Impede que a ultima coisa digitada seja uma operacao
            try{
                lResultado.setText(calculadora.resultado(calculadora.getOperacoes(digitado), calculadora.getNumeros(digitado)));
                lResultadoParcial.setText("");
            }
            catch(ArithmeticException error){
                mostraMensagem(AlertType.ERROR, error.getMessage());
                lResultado.setText("");
            }
            catch(IndexOutOfBoundsException error){
                mostraMensagem(AlertType.ERROR, "Erro nas Arrays");
                lResultado.setText("");
            } 
            catch(NumberFormatException error){
                mostraMensagem(AlertType.ERROR, "Erro na conta");
                lResultado.setText("");
            }
        }
    }
     
    @FXML
    private void clicouDel(ActionEvent event) {
        lResultado.setText("");
        lResultadoParcial.setText("");
    }
    
    @FXML
    private void clicouDivisao(ActionEvent event) {
        if(!calculadora.ehOperacao(lResultado.getText().charAt(lResultado.getText().length() - 1))){    //Impede que a ultima coisa digitada seja uma operacao
            lResultado.setText(lResultado.getText() + "/");
        }
    }
    
    @FXML
    private void clicouMultiplicacao(ActionEvent event) {
        if(!calculadora.ehOperacao(lResultado.getText().charAt(lResultado.getText().length() - 1))){    //Impede que a ultima coisa digitada seja uma operacao
            lResultado.setText(lResultado.getText() + "x");
        }
    }
    
    @FXML
    private void clicouSubtracao(ActionEvent event) {
        if(!calculadora.ehOperacao(lResultado.getText().charAt(lResultado.getText().length() - 1))){    //Impede que a ultima coisa digitada seja uma operacao
            lResultado.setText(lResultado.getText() + "-");
        }
    }
    
    @FXML
    private void clicouSoma(ActionEvent event) {
        if(!calculadora.ehOperacao(lResultado.getText().charAt(lResultado.getText().length() - 1))){    //Impede que a ultima coisa digitada seja uma operacao
            lResultado.setText(lResultado.getText() + "+");
        }
    }
    
    @FXML
    private void clicouIgual(ActionEvent event) {
        mostraResultadoFinal();
    }
    
    @FXML
    private void clicouPonto(ActionEvent event) {
        lResultado.setText(lResultado.getText() + ".");
    }
    
    @FXML
    private void clicouZero(ActionEvent event) {
        lResultado.setText(lResultado.getText() + "0");
        if(lResultado.getText() != ""){
            mostraResultadoParcial();
        }
    }
    
    @FXML
    private void clicouUm(ActionEvent event) {
        lResultado.setText(lResultado.getText() + "1");
        if(lResultado.getText() != ""){
            mostraResultadoParcial();
        }
    }
    
    @FXML
    private void clicouDois(ActionEvent event) {
        lResultado.setText(lResultado.getText() + "2");
        if(lResultado.getText() != ""){
            mostraResultadoParcial();
        }
    }
    
    @FXML
    private void clicouTres(ActionEvent event) {
        lResultado.setText(lResultado.getText() + "3");
        if(lResultado.getText() != ""){
            mostraResultadoParcial();
        }
    }
    
    @FXML
    private void clicouQuatro(ActionEvent event) {
        lResultado.setText(lResultado.getText() + "4");
        if(lResultado.getText() != ""){
            mostraResultadoParcial();
        }
    }
    
    @FXML
    private void clicouCinco(ActionEvent event) {
        lResultado.setText(lResultado.getText() + "5");
        if(lResultado.getText() != ""){
            mostraResultadoParcial();
        }
    }
    
    @FXML
    private void clicouSeis(ActionEvent event) {
        lResultado.setText(lResultado.getText() + "6");
        if(lResultado.getText() != ""){
            mostraResultadoParcial();
        }
    }
    
    @FXML
    private void clicouSete(ActionEvent event) {
        lResultado.setText(lResultado.getText() + "7");
        if(lResultado.getText() != ""){
            mostraResultadoParcial();
        }
    }
    
    @FXML
    private void clicouOito(ActionEvent event) {
        lResultado.setText(lResultado.getText() + "8");
        if(lResultado.getText() != ""){
            mostraResultadoParcial();
        }
    }
    
    @FXML
    private void clicouNove(ActionEvent event) {
        lResultado.setText(lResultado.getText() + "9");
        if(lResultado.getText() != ""){
            mostraResultadoParcial();
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
