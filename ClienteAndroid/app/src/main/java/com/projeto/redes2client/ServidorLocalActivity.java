package com.projeto.redes2client;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class ServidorLocalActivity extends AppCompatActivity {

    static public EditText campo_ip;
    static public EditText campo_porta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.logarlocal);

        campo_ip = findViewById(R.id.Campo_Ip);
        campo_porta = findViewById(R.id.Campo_Porta);

    }
}
