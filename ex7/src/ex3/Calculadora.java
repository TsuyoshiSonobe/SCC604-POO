/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex3;

import java.util.ArrayList;

/**
 *
 * @author tsuyo
 */
public class Calculadora {
    
    public double soma(double num1, double num2){
        return num1 + num2;
    }
    
    public double subtracao(double num1, double num2){
        return num1 - num2;
    }
    
    public double multiplicacao(double num1, double num2){
        return num1 * num2;
    }
    
    public double divisao(double numerador, double denominador){
        return numerador/denominador;
    } 
    
    public double calculos(double num1, char operacao, double num2){
        double resultado = 0.0;
        switch(operacao){
            case '+':{
                resultado = soma(num1, num2);
            }break;
            case '-':{
                resultado = subtracao(num1, num2);
            }break;
            case 'x':{
                resultado = multiplicacao(num1, num2);
            }break;
            case '/':{
                if(num2 == 0){
                    throw new ArithmeticException("Divisao por zero");
                }
                else{
                    resultado = divisao(num1, num2);
                }
            }break;
        }
        return resultado;
    }
    
    public ArrayList<Character> getExpressao(String expressao){
        ArrayList<Character> digitado = new ArrayList<>();
        for(int i = 0; i < expressao.length(); i++){
            digitado.add(expressao.charAt(i));
        }
        
        return digitado;
    }
    
    public ArrayList<String> getNumeros(ArrayList<Character> arrayExpressao){
        ArrayList<String> numeros = new ArrayList<>();
        String num = "";
        int cont = 0;
        while(cont < arrayExpressao.size()){
            if(arrayExpressao.get(cont) == '+' || arrayExpressao.get(cont) == '-' || arrayExpressao.get(cont) == 'x' || arrayExpressao.get(cont) == '/'){
                if(num != ""){
                    numeros.add(num);
                    num = "";
                }
            }
            else{
                num += arrayExpressao.get(cont);
            }
            cont++;
        }
        if(num != ""){
            numeros.add(num);
        }
        return numeros;
    }
    
    public ArrayList<Character> getOperacoes(ArrayList<Character> arrayExpressao){
        ArrayList<Character> operacoes = new ArrayList<>();
        for(int i = 0; i < arrayExpressao.size(); i++){
            if(ehOperacao(arrayExpressao.get(i))){
                operacoes.add(arrayExpressao.get(i));
            }
        }
        return operacoes;
    }
    
    public boolean ehOperacao(char caractere){
        if(caractere == '+' || caractere == '-' || caractere == 'x' || caractere == '/'){
            return true;
        }
        else{
            return false;
        }
    }
    
    public String resultado(ArrayList<Character> operacoes, ArrayList<String> numeros) throws IndexOutOfBoundsException{
        String resultado = "";
        double resultadoParcial = 0;
        int i = 0;
        int j = 0;
        if(!operacoes.isEmpty()){
            resultadoParcial = Double.valueOf(calculos(Double.valueOf(numeros.get(i)), operacoes.get(j), Double.valueOf(numeros.get(i + 1))));
            i += 2;
            j++;
            for(int cont = j; cont < operacoes.size(); cont++){
                resultadoParcial = Double.valueOf(calculos(resultadoParcial, operacoes.get(j), Double.valueOf(numeros.get(i))));
                i++;
                j++;
            }
            resultado = String.valueOf(resultadoParcial);
        }
        return resultado;
    }
    
}
