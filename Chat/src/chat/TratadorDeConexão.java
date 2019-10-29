/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chat;

import EasySocket.nsocket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MarcosBrendon
 */
public class TratadorDeConexão {
    private nsocket Atual;
    private Thread Tratar;
    private Runnable FuncaoThread = new Runnable() {
        @Override
        public void run() {
            System.out.println("Aguardando MSGS");
            while(true){
                //se o usuario desconectar encerra esta thread
                if(!Atual.getVerificador().isAlive())
                    return;
                //da um tempo de delay para não fuder o processador
                try {
                    Thread.sleep(10);
                } catch (InterruptedException ex) {
                    Logger.getLogger(TratadorDeConexão.class.getName()).log(Level.SEVERE, null, ex);
                }
                //se tiver mensagem responda
                if(!Atual.getBufferEntradas().isEmpty()){
                    System.out.println(Atual.getId()+" Mandou: "+Atual.getEntrada());
                    Atual.Enviar("Recebido");
                }
            }
        }
    };

    public TratadorDeConexão(nsocket Atual) {
        this.Atual = Atual;
        Tratar = new Thread(FuncaoThread);
        Tratar.setPriority(Thread.MIN_PRIORITY);
        Tratar.start();
    }
    
}
