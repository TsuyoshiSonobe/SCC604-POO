package ex3;

import java.util.*;

/**
 * 
 */
public class SuperHeroi extends Personagem {

    /**
     * Default constructor
     */
    public SuperHeroi() {
    }

    /**
     * 
     */
    private String nomeVidaReal;

    /**
     * @return
     */
    public String getNomeVidaReal() {
        // TODO implement here
        return nomeVidaReal;
    }

    /**
     * @param pNomeVidaReal 
     * 
     */
    public void setNomeVidaReal(String pNomeVidaReal) {
        // TODO implement here
        nomeVidaReal = pNomeVidaReal;
    }

    /**
     * @return
     */
    public int getTotalPoder() {
        // TODO implement here
        int total = super.getTotalPoder() * 2;  // O poder do heroi é 2 vezes maior 
        return total;
    }

}