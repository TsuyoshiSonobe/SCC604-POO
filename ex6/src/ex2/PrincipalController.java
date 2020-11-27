/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex2;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

/**
 *
 * @author tsuyo
 */
public class PrincipalController implements Initializable {
    
    @FXML
    private Button bPush;
    
    @FXML
    private Button bPop;
    
    @FXML
    private ListView lvPilha;
    
    @FXML
    private TextField tfValor;
    
    private Pilha pilha = new Pilha(3);
    
    private void mostraMensagem(Alert.AlertType tipo, String texto){
        Alert mensagem = new Alert(tipo);
        if(tipo == Alert.AlertType.ERROR){
            mensagem.setTitle("Mensagem de erro");
        }
        else{
            mensagem.setTitle("Mensagem informativa");
        }
        mensagem.setHeaderText(null);
        mensagem.setContentText(texto);
        mensagem.showAndWait();
    }
    
    @FXML
    private void clicouPush(ActionEvent event){
        if(tfValor.getText().equals("")){
            mostraMensagem(Alert.AlertType.ERROR , "Insira um valor no campo de texto");
        }
        else{
            try{
                pilha.push(tfValor.getText());
                lvPilha.getItems().add(0, tfValor.getText());
                tfValor.setText("");
                mostraMensagem(Alert.AlertType.INFORMATION, "Elemento inserido com sucesso");
            }
            catch(PilhaCheia error){
                mostraMensagem(Alert.AlertType.ERROR ,error.getMessage());
            }
        }
    }
    
    @FXML
    private void clicouPop(ActionEvent event){
        if(!tfValor.getText().equals("")){
            mostraMensagem(Alert.AlertType.ERROR , "O campo de texto deve estar vazio");
        }
        else{
            try{
                tfValor.setText(pilha.pop());
                lvPilha.getItems().remove(0);
                mostraMensagem(Alert.AlertType.INFORMATION, "Elemento removido com sucesso");

            }
            catch(PilhaVazia error){
                mostraMensagem(Alert.AlertType.ERROR ,error.getMessage());
            }
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
