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
public class impressao extends driver{
    private int tinta = 100;  //quantidade de tinta em porcentagem
  
    public void imprimePaginas(int numPaginas){
        int paginasImprimidas = 0;
        
        if(verificaStatus()){
            System.out.println("Imprimindo...");
            for(int i = 0; i < numPaginas; i++){
                if(tinta <= 0){
                    System.out.println("Acabou a tinta para impressão");
                    break;
                }
                tinta -= 5; 
                paginasImprimidas++;
            }
            System.out.println("Foram imprimidas " + paginasImprimidas + " páginas com sucesso");
        }
        else{
            System.out.println("O dispositivo está desligado");
        }
    }
    
    public void recarregaTinta(){
        if(tinta == 100){
            System.out.println("O dispositivo já está com tinta");
        }
        else{
            tinta = 100;
            System.out.println("Recarregando a tinta... Dispositivo recarregado");
        }
    }
    
    public int getTinta(){
        return tinta;
    }
}
