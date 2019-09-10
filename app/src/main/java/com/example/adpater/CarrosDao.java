package com.example.adpater;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;

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
        try{
            valores=new ContentValues();
            valores.put(banco.NOME, carros.getNome());
            valores.put(banco.MARCA, carros.getMarca());
            int ano= Integer.valueOf(carros.getAno());
            valores.put(banco.ANO,ano );
            resultado= db.insert(banco.TABELA,null,valores);
            db.close();
            if (resultado !=-1){

                return "Carro inserido ="+ carros.getNome();
            }
        }catch (SQLException e){
            Log.e("ERRO",e.getMessage());
        }

        return "Erro!";

    }


    public ArrayList<Carros> list(){
        ArrayList<Carros> lista= new ArrayList<>();
        Cursor cursor;
        String[] campos={DbHelper.ID, DbHelper.NOME, DbHelper.MARCA,DbHelper.ANO};
        db= banco.getReadableDatabase();
        cursor = db.query(DbHelper.TABELA,campos,null,null,null,null,null);
          if (cursor!=null){
              cursor.moveToFirst();
              while (cursor.moveToNext()){
                int id= cursor.getInt(0) ;
                String nome = cursor.getString(1) ;
                String marca = cursor.getString(2) ;
                int ano = cursor.getInt(3) ;
                Carros c= new Carros(id,nome,ano,marca);
                lista.add(c);
              }
              return lista;
          }
          return null;
    }

    public String deletar(Carros c){
        String where = DbHelper.ID+ "= " +c.getId();
        db= banco.getReadableDatabase();
        db.delete(DbHelper.TABELA,where,null);
        db.close();
        return "Removido";
    }



}
