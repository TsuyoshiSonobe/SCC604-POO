/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex4b;

/**
 *
 * @author tsuyo
 */
public class Ex4b {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try{
            Classe1 stackOverflow = new Classe1();
        }catch(StackOverflowError error){
            System.out.println("Erro de StackOverflow causado pela instanciação repetitiva entre duas classes");
        }
    }
    
}
