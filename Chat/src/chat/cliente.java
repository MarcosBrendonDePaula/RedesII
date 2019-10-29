/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chat;
import EasySocket.EasySocket;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author MarcosBrendon
 */
public class cliente {
    public static void main(String[] args) {
        EasySocket cliente = new EasySocket("127.0.0.1", 25565, "cliente"); 
        boolean resultado = cliente.ClientStart();
        cliente.startVerificador();
        while(true){
            try {
                Thread.sleep(10);
            } catch (InterruptedException ex) {
                Logger.getLogger(cliente.class.getName()).log(Level.SEVERE, null, ex);
            }
            if(!cliente.Buffer.isEmpty()){
                cliente.Enviar("Chegou:"+cliente.getEntrada());
            }
//            System.out.flush();
//            if(!cliente.getBufferEntradas().isEmpty())
//                System.out.println(cliente.getEntrada());
        }
    }
}
