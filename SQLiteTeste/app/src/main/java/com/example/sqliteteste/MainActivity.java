package com.example.sqliteteste;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    SQLiteDatabase sqLitedb;
    ListView listView;
    @SuppressLint({"Range", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.lista);
        sqLitedb=openOrCreateDatabase("meubd",MODE_PRIVATE,null);
        sqLitedb.execSQL("CREATE TABLE IF NOT EXISTS usr (id INTEGER PRIMARY KEY AUTOINCREMENT, " + " nome VARCHAR);");
        ContentValues cv = new ContentValues();
        cv.put("nome","João");
        sqLitedb.insert("usr",null,cv);
        Cursor cursor = sqLitedb.rawQuery("SELECT * FROM usr",null);
        cursor.moveToFirst();
        ArrayList<String> listaUsuario = new ArrayList<>();

        while(!cursor.isAfterLast()){
            listaUsuario.add(cursor.getString(cursor.getColumnIndex("nome")));
            Log.d("tableusr", cursor.getString(cursor.getColumnIndex("id"))+cursor.getString(cursor.getColumnIndex("nome")));
            cursor.moveToNext();
        }

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, android.R.id.text1, listaUsuario);

        listView.setAdapter(arrayAdapter);
    }
}