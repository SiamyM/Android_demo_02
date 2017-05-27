package com.example.alexae.demo_07_01;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //variable creada para pasar por el forresult valor entero
    private final int REQUEST_CODE = 1;

    //DECLARA VARIABLE QUE RELACIONARA AL BOTON DE MI LAYOUT
    private Button btMain;

    //dDECLARAMOS LA VARIABLE DE LA LISTA

    private ListView lvMain;

    //DECLARAR LA VARIABLE DEL ADAPTADOR

    private LVMainAdapter mLVMainAdapter;




    private final View.OnClickListener btMainOnClickListener = new View.OnClickListener(){

        @Override
        public void onClick(View v) {
            Intent intent= new Intent(MainActivity.this,SecondActivity.class);
            startActivityForResult(intent,REQUEST_CODE);
        };
    };
    private final AdapterView.OnItemClickListener lvMainOnItemClickListener= new AdapterView.OnItemClickListener(){


        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


            Toast.makeText(MainActivity.this, "posiciÃ³n -> " +position,Toast.LENGTH_SHORT).show();
            Persona persona = mLVMainAdapter.getItem(position);

            Intent intent= new Intent(MainActivity.this,ThrirdActivtity.class);

            intent.putExtra("nombre",persona.getNombre().toString());
            intent.putExtra("apellido", persona.getApellido().toString());
            intent.putExtra("documento", persona.getDocumento().toString());
            intent.putExtra("edad",String.valueOf(persona.getEdad()));
            startActivityForResult(intent,1);

        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //RECONOCER QUIEN ES LA LISTA
        lvMain= (ListView) findViewById(R.id.lvMain);
        //RECONOSCO QUIEN ES EL BOTON
        btMain = (Button) findViewById(R.id.btMain);
        //AL BOTON LE CREO UNA ACCION DE ONCLICKLISTENER
        btMain.setOnClickListener(btMainOnClickListener);
        //LISTA CREAMOS UN ONCLICK PARA SU ITEM

        lvMain.setOnItemClickListener(lvMainOnItemClickListener);

        mLVMainAdapter=new LVMainAdapter(MainActivity.this);

        lvMain.setAdapter(mLVMainAdapter);
    }




    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE) {
            if (resultCode == RESULT_OK) {

                Persona persona= new Persona();

                persona.setId(java.util.UUID.randomUUID().toString());
                persona.setNombre(data.getStringExtra("etNombre"));
                persona.setApellido(data.getStringExtra("etApellido"));
                persona.setDocumento(data.getStringExtra("etDocumento"));
                persona.setEdad(Integer.valueOf(data.getStringExtra("etEdad")));
                mLVMainAdapter.add(persona);


            }
        }
    }


}
