/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex2;

/**
 *
 * @author tsuyo
 */
public class rede extends driver{
    private int numPacotesEnviados = 0;
   
    public void enviaPacoteDeDados(int pNumPacotes){
        if(verificaStatus()){
            numPacotesEnviados += pNumPacotes;
            System.out.println("Enviando " + pNumPacotes + " pacotes de dados");
        }
        else{
            System.out.println("O dispositivo está desligado");
        }
    }
    
    public int getNumPacotesEnviados(){
        return numPacotesEnviados;
    }
}
