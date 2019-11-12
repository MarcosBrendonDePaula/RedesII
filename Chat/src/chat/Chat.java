/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chat;


import EasyEvents.EasyEvents;
import EasyEvents.Event;

/**
 *
 * @author MarcosBrendon
 */
public class Chat {
    static nsocket atual=null;
    static EasyEvents eventos=new EasyEvents();
    static EasyMultServer servidor=null;
    
    static Runnable resposta=new Runnable() {
        @Override
        public void run() {
            String msg = atual.getEntrada();
            for(int i=0;i<servidor.getConecxoes().size();i++){
                if(servidor.getConecxoes().get(i).getId()!=atual.getId())
                    servidor.getConecxoes().get(i).Enviar(msg);
            }
        }
    };
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        eventos.addEvent(new String("TemAlgo"), new Event(resposta));
        servidor = new EasyMultServer(25718);
        servidor.start();
    }
    
}
