package com.example.sqldatabase.model;

import static android.content.Context.MODE_PRIVATE;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class NotaDao {
    SQLiteDatabase db;
    public  NotaDao(Context context){
        db = context.openOrCreateDatabase("notas", MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS nota(id INTEGER PRIMARY KEY AUTOINCREMENT, titulo TEXT, texto TEXT)");
    }

    public void inserirNota(Nota nota){
        ContentValues cv = new ContentValues();
        cv.put("titulo", nota.getTitulo());
        cv.put("texto", nota.getTexto());
        db.insert("nota", null, cv);
    }

    public void update(Nota nota){
        ContentValues cv = new ContentValues();
        cv.put("titulo", nota.getTitulo());
        cv.put("texto", nota.getTexto());
        db.update("nota", cv, "id = ?", new String[]{String.valueOf(nota.getId())});
    }

    public void excluirNota(Nota nota){
        db.delete("nota", "id = ?", new String[]{String.valueOf(nota.getId())});
    }

    public Nota getNota(int id){
        String sql="SELECT * FROM notas WHERE id = ?";
        Cursor c = db.rawQuery(sql, new String[]{String.valueOf(id)});
        //Recupenado um registro relacionado e convertendo para objeto Nota
        c.moveToFirst();
        int idNota = c.getInt(c.getColumnIndex("id"));
        String titulo = c.getString(c.getColumnIndex("titulo"));
        String txt = c.getString(c.getColumnIndex("txt"));
        Nota nota = new Nota(idNota, titulo, txt);
        return nota;
    }

    public ArrayList<Nota> ListarNotas(){
        String sql = "SELECT * FROM notas";
        ArrayList<Nota> notas = new ArrayList<>();
        Cursor c = db.rawQuery(sql, null);
        c.moveToFirst();
        while(!c.isAfterLast()){
            int id = c.getInt(c.getColumnIndex("id"));
            String titulo = c.getString(c.getColumnIndex("titulo"));
            String txt = c.getString(c.getColumnIndex("txt"));
            Nota nota = new Nota(id, titulo, txt);
            notas.add(nota);
        }
        return notas;
    }

    public ArrayList<String> recuperaTituloNotas(){
        String sql = "SELECT * FROM notas";
        ArrayList<String> titulos = new ArrayList<>();
        Cursor c = db.rawQuery(sql, null);
        c.moveToFirst();
        while(!c.isAfterLast()){
            String titulo = c.getString(c.getColumnIndex("titulo"));
            titulos.add(titulo);
        }
        return titulos;
    }


}
