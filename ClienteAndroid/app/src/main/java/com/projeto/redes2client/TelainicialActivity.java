package com.projeto.redes2client;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.EditText;

public class TelainicialActivity extends AppCompatActivity {
    static public EditText campo_nick;
    static public EditText campo_chave;
    static public int ServidorLocal = 0;
    Vibrator vibrator;
    private int milliseconds = 30;//'30' é o tempo em milissegundos, é basicamente o tempo de duração da vibração.

    public void Logar(View view){
        vibrator.vibrate(milliseconds);
        if (campo_chave.getText().length() != 0 && campo_nick.getText().length() != 0){
            Intent it = new Intent(TelainicialActivity.this, MainActivity.class);
            startActivity(it);
        }
        else
            return;
    }

    public void LogarLocal(View view){
        vibrator.vibrate(milliseconds);
        ServidorLocal = 1;
        Intent it = new Intent(TelainicialActivity.this, ServidorLocalActivity.class);
        startActivity(it);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.telainicial);

        campo_nick = findViewById(R.id.Campo_Nick);
        campo_chave = findViewById(R.id.Campo_Chave);
        vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
    }
}
