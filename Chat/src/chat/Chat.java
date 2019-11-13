/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chat;


import EasyEvents.EasyEvents;
import EasyEvents.Event;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author MarcosBrendon
 */
public class Chat {
    static nsocket atual=null;
    static EasyEvents eventos=new EasyEvents();
    static EasyMultServer servidor=null;
    static Map<Integer,String> dict=new HashMap<Integer, String>();
    
    static Runnable resposta=new Runnable() {
        @Override
        public void run() {
            String msg = atual.getEntrada();
            if(msg.contains("Allkey,")){
                String[] chave=msg.split(",");
                String novo="";
                for(int i=0;i<chave[1].length();i++){
                    System.out.println(chave[1].charAt(i)-0);
                    novo += dict.get(chave[1].charAt(i)-0);
                }
                System.out.println(novo);
                for(int i=0;i<servidor.getConecxoes().size();i++){
                    if(servidor.getConecxoes().get(i).getId()!=atual.getId())
                        servidor.getConecxoes().get(i).Enviar("Broadcast:"+novo);
                }
            }else
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
        System.out.println("V0.3");
        String dic="[̲̅𝓪̲̅],[̲̅𝓫̲̅],[̲̅𝓬̲̅],[̲̅𝓭̲̅],[̲̅𝓮̲̅],[̲̅𝓯̲̅],[̲̅𝓰̲̅],[̲̅𝓱̲̅],[̲̅𝓲̲̅],[̲̅𝓳̲̅],[̲̅𝓴̲̅],[̲̅𝓵̲̅],[̲̅𝓶̲̅],[̲̅𝓷̲̅],[̲̅𝓸̲̅],[̲̅𝓹̲̅],[̲̅𝓺̲̅],[̲̅𝓻̲̅],[̲̅𝓼̲̅],[̲̅𝓽̲̅],[̲̅𝓾̲̅],[̲̅𝓿̲̅],[̲̅𝔀̲̅],[̲̅𝔁̲̅],[̲̅𝔂̲̅],[̲̅𝔃̲̅]";
        String[] spli=dic.split(",");
        
        for(int i=0;i<spli.length;i++){
            dict.put((i+65), spli[i]);
            dict.put((i+97), spli[i]);
        }
        
        eventos.addEvent(new String("TemAlgo"), new Event(resposta));
        servidor = new EasyMultServer(25718);
        servidor.start();
    }
    
}
