/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chat;

import EasySocket.EasyMultServer;
import EasySocket.nsocket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MarcosBrendon
 */
public class Chat {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner x=new Scanner(System.in);
        //Servidor Basico
        //EasyMultServer servidor = new EasyMultServer(25565);
        
        //servidor medio com edição da funçao de aceitação de clientes
        ExemploSevSobrecarga servidor= new ExemploSevSobrecarga(25565);
        servidor.start();
        x.nextInt();
//        while(true){
//            //da um tempo para não sobrecarregar o processador
//            try {
//                Thread.sleep(100);
//            } catch (InterruptedException ex) {
//                Logger.getLogger(Chat.class.getName()).log(Level.SEVERE, null, ex);
//            }
//            //caso entrar no if significa que chegou mensagem para processar
//            if(!servidor.getOrdem().isEmpty()){
//                nsocket atual = servidor.getConID(servidor.getOrdem().getFirst());
//                System.out.println(atual.getEntrada());
//                //removendo o primeiro pois ja foi processado.
//                servidor.getOrdem().removeFirst();
//            }
//        }
        
    }
    
}
