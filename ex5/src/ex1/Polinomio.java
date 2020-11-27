/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex1;

import java.util.ArrayList;

/**
 *
 * @author tsuyo
 */
public class Polinomio {
    
    private ArrayList<Double> polinomio = new ArrayList<>();
    
    Polinomio(){
        for(int i = 0; i < 5; i++){
            polinomio.add(0.0);
        }
    }
    
    public void add(int pos, Double valor){
        polinomio.set(pos, valor);
    }
    
    public String mostra(){
        int j = 5;
        String poli = String.valueOf(polinomio.get(0)) + "*x^" + j;
        j--;
        for(int i = 1; i < 5; i++){
            poli += " + " + String.valueOf(polinomio.get(i)) + "*x^" + j;
            j--;
        }
        return poli; 
    }
    
    public String calcula(double x){
        double resultado = 0;
        String result;
        double aux;
        int j = 5;
        for(int i = 0; i < 5; i++){
            aux = polinomio.get(i);
            resultado += (aux * Math.pow(x, j));
            j--;
        }
        result = String.valueOf(resultado);
        return result;
    }
}
