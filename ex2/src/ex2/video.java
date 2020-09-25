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
public class video extends driver{
    private int brilho; //brilho da tela em porcentagem
 
    video(int pBrilho){
        brilho = pBrilho;
    }
    
    public int getBrilho(){
        return brilho;
    }
    
    public void alteraBrilhoDeExibicao(int alteraBrilho){
        if(verificaStatus()){
            if(alteraBrilho >= 0 && alteraBrilho <= 100){
                brilho = alteraBrilho;
                System.out.println("Brilho alterado com sucesso");
            }
            else{
                System.out.println("Valor de brilho inválido");
            }
        }
        else{
            System.out.println("O dispositivo está desligado");
        }
    }
}
