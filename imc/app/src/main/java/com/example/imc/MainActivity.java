package com.example.imc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.net.URISyntaxException;

public class MainActivity extends AppCompatActivity {

    EditText peso, altura;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        peso = findViewById(R.id.textPeso);
        altura = findViewById(R.id.textAltura);

    }

    public void imc(View v) throws URISyntaxException {
        Double pesoC = Double.valueOf(R.id.textPeso);
        Double alturaC = Double.valueOf(R.id.textAltura);


        String StringIMC = String.valueOf(pesoC/(alturaC*alturaC));

        Intent i = new Intent(MainActivity.this, Activity2.class);
        i.putExtra("imc",StringIMC);
        startActivity(i);

    }
}