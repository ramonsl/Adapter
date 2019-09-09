package com.example.adpater;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class CarrosAdapter extends ArrayAdapter {
    public CarrosAdapter( Context context,  List<Carros> objetcts) {
        super(context, 0, objetcts);
    }

    public View getView(int position, View convertView, ViewGroup parent){
        View listItemView =convertView;

        if(listItemView==null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_carro, parent, false);
        }
        Carros current = (Carros) getItem(position);
            TextView nome = (TextView) listItemView.findViewById(R.id.txtNome);
            TextView ano = (TextView) listItemView.findViewById(R.id.txtAno);
            TextView marca = (TextView) listItemView.findViewById(R.id.txtMarca);
            nome.setText(current.getNome().toString());
            ano.setText(current.getAno().toString());
            marca.setText(current.getMarca().toString());

            return  listItemView;


    }

}
