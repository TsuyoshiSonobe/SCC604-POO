package ex3;

import java.util.*;

/**
 * 
 */
public class Personagem {

    /**
     * Default constructor
     */
    public Personagem() {
    }

    /**
     * 
     */
    private String nome;

    /**
     * 
     */
    private ArrayList<Superpoder> poderes = new ArrayList<>();

    /**
     * 
     */
    private int vida;


    /**
     * @return
     */
    public String getNome() {
        // TODO implement here
        return nome;
    }

    /**
     * @param pNome 
     * 
     */
    public void setNome(String pNome) {
        // TODO implement here
        nome = pNome;
    }

    /**
     * @return
     */
    public int getTotalPoder() {
        // TODO implement here
        int total = 0;
        for(int j = 0; j < poderes.size(); j++){
            total += poderes.get(j).getCategoria();
        }
        return total;
    }

    /**
     * @return
     */
    public int getVida() {
        // TODO implement here
        return vida;
    }

    /**
     * @param pVida 
     * 
     */
    public void setVida(int pVida) {
        // TODO implement here
        vida = pVida;
    }

    /**
     * @param pSuperpoder 
     * 
     * 
     */
    public void addSuperpoder(Superpoder pSuperpoder) {
        // TODO implement here
        poderes.add(pSuperpoder);
    }

    /**
     * @param pIntensidade 
     * @param pNomeSuperpoder 
     * @param pInimigo 
     * 
     */
    public void atacar(int pIntensidade, Superpoder pNomeSuperpoder, Personagem pInimigo) {
        // TODO implement here
        
        // Verifica se o poder é válido para aquele personagem
        int cont = 0, j = 0;
        while(j < poderes.size() && cont != 1){
            if(pNomeSuperpoder == poderes.get(j)){
                cont = 1;
            } 
            else{
                cont = 0;
            }
            j++;
        }
        if(cont == 0){
            System.out.println("Superpoder Inválido");
        }
        else{
            // Caso o poder seja válido
            // Usa a probabilidade de acerto de 50% para saber se o poder atingiu o inimigo
            int probabilidadeAcerto = (int)(Math.random() * 2);
            if(probabilidadeAcerto == 0){
                System.out.println("O inimigo desviou do ataque!");
            }
            else{
                // Caso o inimigo seja atingido, atualiza a vida dele
                int vidaAtual = pInimigo.getVida();
                vidaAtual -= pIntensidade;
                pInimigo.setVida(vidaAtual); 
                System.out.println("O " + pInimigo.getNome() + " perdeu " + pIntensidade + " de vida");
            }
        }
        
    }

}