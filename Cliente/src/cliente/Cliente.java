/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente;
import Cripto.Criptografar;
import Cripto.Descriptografar;

/**
 *
 * @author MarcosBrendon
 */
public class Cliente {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        main atual=new main();
        atual.setVisible(true);
        
        String texto = Criptografar.Vigenere("Eae pessoal, tudo bem? Aqui quem fala é o Edu!", "senha");
        Descriptografar.Vigenere(texto, "senha");
        
    }
    
}
