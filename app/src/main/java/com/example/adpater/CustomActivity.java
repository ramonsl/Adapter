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
    ArrayList<Carros> myCars;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom);
        myCars= new ArrayList<>();
        final CarrosDao carrosDao= new CarrosDao(getApplicationContext());
        myCars= carrosDao.list();
       adapter = new CarrosAdapter(this,myCars);
        ListView list = findViewById(R.id.listaCarros);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Carros a = (Carros) parent.getItemAtPosition(position);
                carrosDao.deletar(a);
                Toast.makeText(getApplicationContext(),"removido", Toast.LENGTH_LONG).show();
                 myCars =carrosDao.list();
                 adapter.notifyDataSetChanged();
            }
        });




    }
}
