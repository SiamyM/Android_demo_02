package com.example.alexae.demo_07_01;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Alex.ae on 24/05/2017.
 */

//extend de AppCompany
public class SecondActivity extends AppCompatActivity {


    Button btSecond;
    EditText nombre,apellido,documento,edad;


    //metodo onCreate

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);

        nombre=(EditText) findViewById(R.id.etNombre);
        apellido=(EditText) findViewById(R.id.etApellido);
        documento=(EditText) findViewById(R.id.etDocumento);
        edad=(EditText) findViewById(R.id.etEdad);
        btSecond= (Button) findViewById(R.id.btSecond);
        btSecond.setOnClickListener(btSeconOnClickListener);
    }

    public final View.OnClickListener btSeconOnClickListener = new View.OnClickListener(){


        @Override
        public void onClick(View view) {

            Intent intent = new Intent();

            intent.putExtra("etNombre", nombre.getText().toString());
            intent.putExtra("etApellido",apellido.getText().toString());
            intent.putExtra("etDocumento",documento.getText().toString());
            intent.putExtra("etEdad",edad.getText().toString());

            setResult(RESULT_OK,intent);
            finish();

        }
    };



}
