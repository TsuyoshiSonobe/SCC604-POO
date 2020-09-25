/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex3;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author tsuyo
 */
public class Ex3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        // Criando e setando um personagem
        Personagem player1 = new Personagem();
        player1.setNome("Jogador 1");
        player1.setVida(1000);
        
        // Criando e setando superpoderes
        Superpoder poder1 = new Superpoder();
        poder1.setCategoria(1);
        poder1.setNome("Super soco");
        Superpoder poder2 = new Superpoder();
        poder2.setCategoria(2);
        poder2.setNome("Arma");
        Superpoder poder3 = new Superpoder();
        poder3.setCategoria(3);
        poder3.setNome("Feitiçaria");
        Superpoder poder4 = new Superpoder();
        poder4.setCategoria(3);
        poder4.setNome("Lançar raio");
        Superpoder poder5 = new Superpoder();
        poder5.setCategoria(3);
        poder5.setNome("Lançar fogo");
        Superpoder poder6 = new Superpoder();
        poder6.setCategoria(4);
        poder6.setNome("Visão Laser");
        Superpoder poder7 = new Superpoder();
        poder7.setCategoria(4);
        poder7.setNome("Desintegração");
        
        // Criando um SuperHeroi e adicionando superpoderes
        SuperHeroi heroi = new SuperHeroi();
        heroi.setNome("Homem dos Poderzinho");
        heroi.setNomeVidaReal("Joãozinho");
        heroi.setVida(2000);
        heroi.addSuperpoder(poder1);
        heroi.addSuperpoder(poder4);
        heroi.addSuperpoder(poder6);
        System.out.println("O total poder dos superpoderes do heroi " + heroi.getNome() + " é " + heroi.getTotalPoder());
        
        // Criando um Vilao e adicionando superpoderes
        Vilao vilao = new Vilao();
        vilao.setNome("Homem do Mal");
        vilao.setVida(2000);
        vilao.addSuperpoder(poder2);
        vilao.addSuperpoder(poder3);
        vilao.addSuperpoder(poder7);
        vilao.setAnosDePrisao(100);
        System.out.println("O total poder dos superpoderes do vilao " + vilao.getNome() + " é " + vilao.getTotalPoder());
        System.out.println();
        
        // Loop do duelo entre o heroi e o vilao
        System.out.println("*** Inicio do duelo ***");
        while(true){
            heroi.atacar(100, poder1, vilao);
            if(vilao.getVida() <= 0){
                break;
            }
            vilao.atacar(100, poder2, heroi);
            if(heroi.getVida() <= 0){
                break;
            }
            heroi.atacar(350, poder4, vilao);
            if(vilao.getVida() <= 0){
                break;
            }
            vilao.atacar(300, poder3, heroi);
            if(heroi.getVida() <= 0){
                break;
            }
            heroi.atacar(550, poder6, vilao);
            if(vilao.getVida() <= 0){
                break;
            }
            vilao.atacar(500, poder7, heroi);
            if(heroi.getVida() <= 0){
                break;
            }
        }
        System.out.println("*** Final do duelo ***");
        System.out.println();
        if(vilao.getVida() <= 0){
            System.out.println("O heroi " + heroi.getNome() + " venceu a luta!");
            System.out.println("O vilao passará " + vilao.getAnosDePrisao() + " anos na prisão");
        }
        else{
            System.out.println("O vilao " + vilao.getNome() + " venceu a luta!");
        }
    }
    
}
