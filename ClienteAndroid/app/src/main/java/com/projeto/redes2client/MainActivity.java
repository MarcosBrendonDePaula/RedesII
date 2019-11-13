package com.projeto.redes2client;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.projeto.redes2client.Cripto.Criptografar;
import com.projeto.redes2client.Cripto.Descriptografar;

import com.projeto.redes2client.EasySocket.EasySocket;

public class MainActivity extends AppCompatActivity {
    public static EasySocket cliente;
    public EditText nome;
    public static EditText campo;
    public EditText Texto;
    public static EditText Key;
    public Button EnviarBtn;
    public final static Criptografar cpt=new Criptografar();
    public final static Descriptografar dct=new Descriptografar();


    //Runable Retido Olhe o EasySocket de dentro do app o codigo foi inserido e modificado so para esse cliente
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //permisao para executar threads
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        //pegando variaveis
        campo = findViewById(R.id.editText4);
        nome = findViewById(R.id.Nome);
        Texto = findViewById(R.id.editText5);
        EnviarBtn = findViewById(R.id.button2);
        Key = findViewById(R.id.Key);

        //criando Socket e iniciando
        cliente = new EasySocket("158.69.246.121",25718,"cliente");
        cliente.ClientStart();
        cliente.startVerificador();

        EnviarBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    campo.append("Voce:" + Texto.getText() + "\n");
                    cliente.Enviar(cpt.Vigenere(nome.getText() + ":" + Texto.getText(), Key.getText() + "") + "");
                    Texto.setText("");
                }catch(Exception e){
                    System.out.println("O correu Algum erro ao enviar");
                }
            }
        });
    }
}
