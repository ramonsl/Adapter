package com.example.adpater;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;

import java.util.ArrayList;

public class GridActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid);
        ArrayList<Carros> myCars= new ArrayList<>();
        myCars.add(new  Carros("Corsa",2000,"GM"));
        myCars.add(new  Carros("Palio",2010,"FIAT"));
        myCars.add(new  Carros("Astra",2000,"GM"));
        myCars.add(new  Carros("2008",1989,"PEUGEOT"));
        myCars.add(new  Carros("308",2000,"PEUGEOT"));
        final CarrosAdapter adapter = new CarrosAdapter(this,myCars);

        GridView grid = findViewById(R.id.grid);
        grid.setAdapter(adapter);


    }
}
