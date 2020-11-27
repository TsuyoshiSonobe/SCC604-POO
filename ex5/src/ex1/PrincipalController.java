/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex1;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 *
 * @author tsuyo
 */
public class PrincipalController implements Initializable {
    
    @FXML
    private Button bCriarPolinomio;
    
    @FXML
    private Button bApagarPolinomio;
    
    @FXML
    private Button bCalcular;
    
    @FXML
    private Label lPolinomio;
    
    @FXML
    private Label lResultado;
    
    @FXML
    private TextField tfGrau5;
    
    @FXML
    private TextField tfGrau4;
    
    @FXML
    private TextField tfGrau3;
    
    @FXML
    private TextField tfGrau2;
    
    @FXML
    private TextField tfGrau1;
    
    @FXML
    private TextField tfValorX;
    
    private Polinomio polinomio = new Polinomio();
    
    private void mostraMensagem(AlertType tipo, String texto){
        Alert mensagem = new Alert(tipo);
        mensagem.setTitle("Mensagem de erro");
        mensagem.setHeaderText(null);
        mensagem.setContentText(texto);
        mensagem.showAndWait();
    }
    
    @FXML
    private void clicouCriarPolinomio(ActionEvent event) {
        if (tfGrau5.getText().trim().isEmpty() || tfGrau4.getText().trim().isEmpty() || tfGrau3.getText().trim().isEmpty() || 
            tfGrau2.getText().trim().isEmpty() || tfGrau1.getText().trim().isEmpty()){
                mostraMensagem(AlertType.ERROR, "Preencha todos os campos");
        }
        else{
            try{
                polinomio.add(0, Double.valueOf(tfGrau5.getText()));
                polinomio.add(1, Double.valueOf(tfGrau4.getText()));
                polinomio.add(2, Double.valueOf(tfGrau3.getText()));
                polinomio.add(3, Double.valueOf(tfGrau2.getText()));
                polinomio.add(4, Double.valueOf(tfGrau1.getText()));
                lPolinomio.setText(polinomio.mostra());
            }
            catch (NumberFormatException error){
                mostraMensagem(AlertType.ERROR, "Digite valores válidos");
            }
        }
    }
    
    @FXML
    private void clicouApagarPolinomio(ActionEvent event){
        lPolinomio.setText("");
    }
    
    @FXML
    private void clicouCalcular(ActionEvent event){
        if (tfGrau5.getText().trim().isEmpty() || tfGrau4.getText().trim().isEmpty() || tfGrau3.getText().trim().isEmpty() || 
            tfGrau2.getText().trim().isEmpty() || tfGrau1.getText().trim().isEmpty()){
                mostraMensagem(AlertType.ERROR, "Preencha todos os campos");
        }
        else if(tfValorX.getText().trim().isEmpty()){
            mostraMensagem(AlertType.ERROR, "Digite um valor para x");
        }
        else if(lPolinomio.getText().trim().isEmpty()){
            mostraMensagem(AlertType.ERROR, "Crie um polinômio");
        }
        else{
            try{
                lResultado.setText(polinomio.calcula(Double.valueOf(tfValorX.getText())));
            }
            catch (NumberFormatException error){
                mostraMensagem(AlertType.ERROR, "Digite um valor válido para x");
            }
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
