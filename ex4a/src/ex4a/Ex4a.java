/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex4a;

/**
 *
 * @author tsuyo
 */
public class Ex4a {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Classe minha_classe = new Classe();
        
        try{
            minha_classe.recursividadeInfinita();
        }catch(StackOverflowError error){
            System.out.println("Erro de StackOverflow devido a recursividade infinita");
        }
    }
    
}
