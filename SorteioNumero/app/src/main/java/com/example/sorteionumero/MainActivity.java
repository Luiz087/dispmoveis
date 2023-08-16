package com.example.sorteionumero;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView tvResultado;
    EditText n1,n2;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        n1=findViewById(R.id.n1);
        n2=findViewById(R.id.n2);
        tvResultado = findViewById(R.id.numSorteado);
    }

    public void sortear(View w){

        int num1 = Integer.parseInt(n1.getText().toString());
        int num2 = Integer.parseInt(n2.getText().toString());

        Random rand = new Random();
        int randomNum = rand.nextInt((num2 - num1) + 1) + num1;
        tvResultado.setText(Integer.toString(randomNum));
    }
}