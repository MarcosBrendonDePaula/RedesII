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
        Intent it = new Intent(TelainicialActivity.this, MainActivity.class);
        startActivity(it);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.telainicial);

        campo_nick = findViewById(R.id.Campo_Nick);
        campo_chave = findViewById(R.id.Campo_Chave);
    }
}
