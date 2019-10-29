/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chat;
import EasySocket.*;
/**
 *
 * @author MarcosBrendon
 */
public class ExemploSevSobrecarga extends EasyMultServer{

    public ExemploSevSobrecarga(int porta) {
        super(porta);
    }

    @Override
    public void funçaoExtra(nsocket Aceitado) {
        System.out.println(Aceitado.getId()+":Conectado ");
    }
    
    
}
