package com.projeto.redes2client;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.projeto.redes2client.Cripto.Criptografar;
import com.projeto.redes2client.Cripto.Descriptografar;

import EasySocket.*;

public class MainActivity extends AppCompatActivity {
    public EasySocket cliente;
    public EditText nome;
    public EditText campo;
    public EditText Texto;
    public EditText Key;
    public Button EnviarBtn;
    public Thread Monitora;
    public Runnable Atualizador=new Runnable() {
        @Override
        public void run() {
            while(true){
                if(cliente.getSocket()==null){
                    return;
                }
                try {
                    Thread.sleep(100);
                    if(!cliente.Buffer.isEmpty())
                        campo.append(cliente.getEntrada()+"\n");
                } catch (Exception ex) {
                    System.out.println("Erro Thread");
                }
            }
        }
    };

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

        Monitora = new Thread(Atualizador);
        //criando Socket e iniciando
        cliente = new EasySocket("158.69.246.121",25718,"cliente");
        cliente.ClientStart();
        cliente.startVerificador();
        //verificando
        Monitora.start();

        EnviarBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                campo.append("Voce:"+Texto.getText()+"\n");
                cliente.Enviar(nome.getText()+":"+Texto.getText());
                Texto.setText("");
            }
        });
    }
}
