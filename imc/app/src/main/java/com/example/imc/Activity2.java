package com.example.imc;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Activity2 extends AppCompatActivity {
    
    TextView textResultado;

    @SuppressLint("MissingInflatedId")
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Bundle bundle= getIntent().getExtras();
        String reultadoimc = bundle.getString("msg");

        textResultado = findViewById(R.id.textResultadoT);

        textResultado.setText(reultadoimc);
        


    }
}
