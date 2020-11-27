/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex2;

/**
 *
 * @author Robson
 */
import java.util.ArrayList;

public class Pilha {
    private ArrayList<String> dados;
    private int tamanho;
    private int topo;
    
    Pilha(int pTamanho) {
        dados = new ArrayList();
        tamanho = pTamanho;
        topo = -1;
    }
    
    public void push(String elemento) throws PilhaCheia {
        if (tamanho == topo + 1)
            throw new PilhaCheia("Pilha cheia");
        topo++;
        dados.add(elemento);
    }
    
    public String pop() throws PilhaVazia {
        if (topo == -1)
            throw new PilhaVazia("Pilha vazia");
        topo--;
        return dados.remove(topo+1);
    }
            
}
