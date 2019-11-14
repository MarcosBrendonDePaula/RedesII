package com.projeto.redes2client;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.os.StrictMode;
import android.os.Vibrator;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.projeto.redes2client.Cripto.Criptografar;
import com.projeto.redes2client.Cripto.Descriptografar;

import EasySocket.*;

public class MainActivity extends AppCompatActivity {
    public EasySocket cliente;
    public EditText campo;
    public EditText Texto;
    public Button EnviarBtn;
    public Thread Monitora;
    Vibrator vibrator;
    private int milliseconds = 30;//'30' é o tempo em milissegundos, é basicamente o tempo de duração da vibração.

    public Runnable Atualizador=new Runnable() {
        @Override
        public void run() {
            while(true){
                if(cliente.getSocket()==null){
                    return;
                }
                try {
                    Thread.sleep(500);
                    if(!cliente.Buffer.isEmpty())
                        campo.append(Descriptografar.Vigenere(cliente.getEntrada(),TelainicialActivity.campo_chave.getText()+"")+"\n\n");
                } catch (Exception ex) {
                    System.out.println("Erro Thread");
                }
            }
        }
    };

    public void Send(View view){
        vibrator.vibrate(milliseconds);
        campo.append("Voce: "+Texto.getText()+"\n\n");
        cliente.Enviar( Criptografar.Vigenere(TelainicialActivity.campo_nick.getText()+": "+Texto.getText(),TelainicialActivity.campo_chave.getText()+""));
        Texto.setText("");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //permisao para executar threads
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        //pegando variaveis
        campo = findViewById(R.id.editText4);
        Texto = findViewById(R.id.editText5);
        EnviarBtn = findViewById(R.id.button2);
        vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);

        Monitora = new Thread(Atualizador);
        //criando Socket e iniciando
        if(TelainicialActivity.ServidorLocal == 1) {
            if (ServidorLocalActivity.campo_ip.length() != 0 && ServidorLocalActivity.campo_porta.length() != 0)
                cliente = new EasySocket(ServidorLocalActivity.campo_ip.getText().toString(), Integer.parseInt(ServidorLocalActivity.campo_porta.getText().toString()), "cliente");
            else
                cliente = new EasySocket("158.69.246.121", 25718, "cliente");
        }
        else
            cliente = new EasySocket("158.69.246.121", 25718, "cliente");

        cliente.ClientStart();
        cliente.startVerificador();
        //verificando
        Monitora.start();

    }
}
