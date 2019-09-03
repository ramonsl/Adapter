package com.example.adpater;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class CustomActivity extends AppCompatActivity {
   public CarrosAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom);
        ArrayList<Carros> myCars= new ArrayList<>();
        Carros a = new Carros("Celta", 1.0, "GM");
        myCars.add(a);
        myCars.add(new  Carros("Corsa",1.6,"GM"));
        myCars.add(new  Carros("Palio",1.6,"FIAT"));
        myCars.add(new  Carros("Astra",2.0,"GM"));
        myCars.add(new  Carros("2008",1.4,"PEUGEOT"));
        myCars.add(new  Carros("308",2.0,"PEUGEOT"));
        adapter = new CarrosAdapter(this,myCars);
        ListView list = findViewById(R.id.listaCarros);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Carros a = (Carros) parent.getItemAtPosition(position);
                Toast.makeText(getApplicationContext(),a.toString(), Toast.LENGTH_LONG).show();
            }
        });




    }
}
