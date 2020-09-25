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
public class driver {
    private boolean ligado = false;
    
    public void ligaDispositivo(){
        ligado = true;
    }
    
    public void desligaDispositivo(){
        ligado = false;
    }
    
    public boolean verificaStatus(){
        return ligado;
    }
    
    public void executaTeste(){
        System.out.println("Testando o dispositivo...");
        System.out.println("Teste finalizado");
    }
}
