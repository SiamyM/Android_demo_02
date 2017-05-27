package com.example.alexae.demo_07_01;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by Alex.ae on 26/05/2017.
 */

public class ThrirdActivtity extends AppCompatActivity{

    TextView tvThirdNombreCompleto,tvThirdDocumento,tvThirdEdad;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.thrird_activity);


        tvThirdNombreCompleto =(TextView)findViewById(R.id.tvThirdNombreCompleto);
        tvThirdDocumento = (TextView)findViewById(R.id.tvThirdDocumento);
        tvThirdEdad = (TextView) findViewById(R.id.tvThirdEdad);

        Intent intent= getIntent();

        tvThirdNombreCompleto.setText( intent.getStringExtra("nombre")+" "+intent.getStringExtra("apellido"));
        tvThirdDocumento.setText(intent.getStringExtra("documento"));
        tvThirdEdad.setText(intent.getStringExtra("edad"));




    }
}
