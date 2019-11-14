package com.projeto.redes2client;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class TelainicialActivity extends AppCompatActivity {
    static public EditText campo_nick;
    static public EditText campo_chave;

    public void Logar(View view){
        if (campo_chave.getText().length() != 0 && campo_nick.getText().length() != 0){
            Intent it = new Intent(TelainicialActivity.this, MainActivity.class);
            startActivity(it);
        }
        else
            return;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.telainicial);

        campo_nick = findViewById(R.id.Campo_Nick);
        campo_chave = findViewById(R.id.Campo_Chave);
    }
}
