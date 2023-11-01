package com.example.sqldatabase.vision;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.sqldatabase.R;
import com.example.sqldatabase.controller.NotaController;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;

    FloatingActionButton floatingActionButton;

    NotaController notaController;

    protected void OnCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(listView);
        floatingActionButton = findViewById(floatingActionButton);
        notaController = new NotaController(this);

        floatingActionButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent intent = new Intent(this, Cadastro.class);
                startActivity(intent);
            }
        });
    }




/*
    SQLiteDatabase db;
    Button button;

    EditText editText;
    ListView listView;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = openOrCreateDatabase("meubd",MODE_PRIVATE,null);
        db.execSQL("CREATE TABLE IF NOT EXISTS notas (id INTEGER PRIMARY KEY AUTOINCREMENT, titulo VARCHAR, txt var)");
        button = findViewById(R.id.botao);
        listView = findViewById(R.id.lista);
        editText = findViewById(R.id.editText);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insereNota();
            }
        });
    }

    public void insereNota(){
        ContentValues cv = new ContentValues();
        cv.put("titulo", String.valueOf(editText.getText()));
        db.insert("notas", null, cv);
        loadListView();
    }

    public void loadListView(){
        Cursor cursor = db.rawQuery("SELECT * FROM notas", null);
        cursor.moveToFirst();
        ArrayList<String> listaNotas = new ArrayList<>();
        while(!cursor.isAfterLast()){
            listaNotas.add(cursor.getString(cursor.getColumnIndex("titulo")));
            cursor.moveToNext();
        }
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, android.R.id.text1,listaNotas);
        listView.setAdapter(arrayAdapter);
    }*/
}