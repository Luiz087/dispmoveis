package com.example.sqldatabase.controller;

import android.content.Context;

import com.example.sqldatabase.model.Nota;
import com.example.sqldatabase.model.NotaDao;

import java.util.ArrayList;

public class NotaController {
    NotaDao notaDao;
    public NotaController(Context c){
        notaDao = new NotaDao(c);
    }
    public void cadastrarNota(Nota n){
        if(n.getTitulo().legth()>3){
            notaDao.inserirNota(n);
        }
    }
    public void getNota(int idNota){
        notaDao.getNota(idNota);
    }

    public void excluirNota(Nota nota){
        notaDao.excluirNota(nota);
    }

    public ArrayList<Nota> recuperaTodasNotas(){
        return notaDao.listarNotas();
    }

    public ArrayList<String> recuperaTitulosNotas(){

    }
}
