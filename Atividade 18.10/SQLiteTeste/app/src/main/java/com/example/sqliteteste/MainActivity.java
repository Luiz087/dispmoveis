package com.example.sqliteteste;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    SQLiteDatabase sqLitedb;
    EditText texto;
    ListView listView;

    @SuppressLint({"Range", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.lista);
        texto = findViewById(R.id.editText);
        sqLitedb=openOrCreateDatabase("meubd",MODE_PRIVATE,null);
        sqLitedb.execSQL("CREATE TABLE IF NOT EXISTS notas (id INTEGER PRIMARY KEY AUTOINCREMENT, " + " txt VARCHAR);");
        /*
        */
    }

    public void inserirNotas(){
        ContentValues cv = new ContentValues();
        cv.put("txt",String.valueOf(texto));
        sqLitedb.insert("usr",null,cv);
        exibirListaNotas();
    }

    @SuppressLint("Range")
    public void exibirListaNotas(){
        Cursor cursor = sqLitedb.rawQuery("SELECT * FROM notas",null);
        cursor.moveToFirst();
        ArrayList<String> listaNotas = new ArrayList<>();

        while(!cursor.isAfterLast()){
            listaNotas.add(cursor.getString(cursor.getColumnIndex("nome")));
            //Log.d("tablenotas", cursor.getString(cursor.getColumnIndex("id"))+cursor.getString(cursor.getColumnIndex("nome")));
            cursor.moveToNext();
        }

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, android.R.id.text1, listaNotas);

        listView.setAdapter(arrayAdapter);
    }
}