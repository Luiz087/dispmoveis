package com.example.sqldatabase.model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class NotaDao {
    SQLiteDatabase db;
    public  NotaDao(Context context){
        db=context.openOrCreateDatabase("db",0,);
    }

    public void inserirNota(Nota nota){

    }

    public void excluirNota(Nota nota){

    }

    public Nota getNota(int id){

        return null;
    }

    public ArrayList<Nota> ListarNotas(){

        return null;
    }
}
