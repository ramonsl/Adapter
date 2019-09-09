package com.example.adpater;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class CarrosDao {

    private SQLiteDatabase db;
    private  DbHelper banco;


    public CarrosDao(Context context){
        banco = new DbHelper(context);
    }

    public String save(Carros carros){
        ContentValues valores;
        long resultado;
        db = banco.getWritableDatabase();

        valores=new ContentValues();
        valores.put(banco.NOME, carros.getNome());
        valores.put(banco.MARCA, carros.getMarca());
        int ano= Integer.valueOf(carros.getAno());
        valores.put(banco.ANO,ano );
        resultado= db.insert(banco.TABELA,null,valores);
        db.close();
        if (resultado ==-1){
           return  "erro ao inserir";
        }else {
            return "Carro inserido ="+ carros.getNome();
        }

    }

}
