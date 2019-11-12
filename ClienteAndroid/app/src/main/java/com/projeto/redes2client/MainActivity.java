package com.projeto.redes2client;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import EasySocket.*;

public class MainActivity extends AppCompatActivity {
    public EasySocket cliente;
    public EditText ipporta;
    public EditText nome;
    public static Button ConnectBtn;
    public EditText campo;
    public EditText Texto;
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
                    Thread.sleep(300);
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
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        ipporta = findViewById(R.id.editText);
        nome = findViewById(R.id.editText3);
        ConnectBtn = findViewById(R.id.button);
        campo = findViewById(R.id.editText4);
        Texto = findViewById(R.id.editText5);
        EnviarBtn = findViewById(R.id.button2);
        Monitora = new Thread(Atualizador);

        ConnectBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] x = (ipporta.getText()+"").split(":");
                cliente = new EasySocket(x[0],Integer.parseInt(x[1]),"cliente");
                if(cliente.ClientStart())
                    ConnectBtn.setText("Conectado");
                cliente.startVerificador();
                Monitora.start();
            }
        });

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
