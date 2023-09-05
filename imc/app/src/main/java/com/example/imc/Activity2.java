package com.example.imc;

import android.annotation.SuppressLint;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;

public class Activity2 extends AppCompatActivity {

    TextView textResultado, peso;
    ImageView imagem;

    @SuppressLint({"WrongViewCast", "MissingInflatedId"})
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2); // Certifique-se de usar o layout correto para Activity2
        Bundle bundle = getIntent().getExtras();
        String resultadoimc = bundle.getString("msg");

        peso = findViewById(R.id.textPeso);
        textResultado = findViewById(R.id.textResultadoT);
        imagem = findViewById(R.id.imageView2);

        double imc = Double.parseDouble(resultadoimc);
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        String resultadoFormatado = decimalFormat.format(imc);

        textResultado.setText(resultadoFormatado);

        if(Double.parseDouble(resultadoimc)<18.5){
            peso.setText("Abaixo do Peso");
            imagem.setImageResource(R.drawable.abaixopeso);
        }else if(Double.parseDouble(resultadoimc)<24.9){
            peso.setText("Normal");
            imagem.setImageResource(R.drawable.normal);
        }else if(Double.parseDouble(resultadoimc)<29.9){
            peso.setText("Sobrepeso");
            imagem.setImageResource(R.drawable.sobrepeso);
        }else if(Double.parseDouble(resultadoimc)<34.9){
            peso.setText("Obesidade 1");
            imagem.setImageResource(R.drawable.obesidade1);
        }else if(Double.parseDouble(resultadoimc)<39.9){
            peso.setText("Obesidade 2");
            imagem.setImageResource(R.drawable.obesidade2);
        } else {
            peso.setText("Obesidade 3");
            imagem.setImageResource(R.drawable.obesidade3);
        }
    }
}
