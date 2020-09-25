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
public class Ex2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        driver dispositivo = new driver();
        if(dispositivo.verificaStatus()){
            System.out.println("O dispositivo está ligado");
        }
        else{
            System.out.println("O dispositivo está desligado");
        }
        dispositivo.ligaDispositivo();
        if(dispositivo.verificaStatus()){
            System.out.println("O dispositivo está ligado");
        }
        else{
            System.out.println("O dispositivo está desligado");
        }
        System.out.println();
        
        
        rede rede1 = new rede();
        rede1.enviaPacoteDeDados(200);
        rede1.ligaDispositivo();
        rede1.enviaPacoteDeDados(10);
        System.out.println("Foram enviados um total de " + rede1.getNumPacotesEnviados() + " pacotes de dados");
        rede1.executaTeste();
        System.out.println();
        
        impressao impressora = new impressao();
        impressora.ligaDispositivo();
        impressora.imprimePaginas(50);
        impressora.recarregaTinta();
        impressora.imprimePaginas(10);
        System.out.println("A impressora possui " + impressora.getTinta() + "% de tinta");
        impressora.executaTeste();
        System.out.println();
        
        video video1 = new video(100);
        video1.ligaDispositivo();
        System.out.println("O brilho da tela é de " + video1.getBrilho() + "%");
        video1.alteraBrilhoDeExibicao(60);
        System.out.println("O brilho da tela é de " + video1.getBrilho() + "%");
        video1.executaTeste();
    }
    
}
