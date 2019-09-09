package com.example.adpater;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CadastroActivity extends AppCompatActivity {

    EditText edtNome;
    EditText edtMarca;
    EditText edtAno;
    Button btnSave;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
        edtAno= findViewById(R.id.edtAno);
        edtMarca= findViewById(R.id.edtMarca);
        edtNome= findViewById(R.id.edtNome);
        btnSave= findViewById(R.id.btnSave);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DbHelper db= new DbHelper(getBaseContext());
                Carros carro= new Carros(edtNome.getText().toString(), Integer.valueOf(edtAno.getText().toString()),edtMarca.getText().toString());
                CarrosDao carrosDao= new CarrosDao(getBaseContext());
                String msg= carrosDao.save(carro);
                Toast.makeText(getBaseContext(),msg,Toast.LENGTH_LONG).show();
            }
        });


    }
}
