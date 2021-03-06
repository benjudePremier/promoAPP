package com.example.promo;

import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.FirebaseApp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.UUID;

import Models.Clientes;

public class afrebase extends AppCompatActivity {
    private EditText nombre,destino,promocion;
    private Button button;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_afrebase);

        nombre = (EditText)findViewById(R.id.ednombre);
        destino = (EditText)findViewById(R.id.eddestino);
        promocion = (EditText)findViewById(R.id.edpromocion);
        button = (Button)findViewById(R.id.bt);

        InicialFirebase();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!nombre.equals(""))
                {
                    Clientes cl = new Clientes();
                    cl.setId(UUID.randomUUID().toString());
                    cl.setNombre(nombre.getText().toString());
                    cl.setDestino(destino.getText().toString());
                    cl.setPromocion(promocion.getText().toString());
                    Toast.makeText(getBaseContext(),"se ha guardado",Toast.LENGTH_LONG).show();
                    databaseReference.child("Clientes").child(cl.getId()).setValue(cl);

                }
                else
                {
                    Toast.makeText(getBaseContext(),"No se ha guardado",Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public void InicialFirebase(){
        FirebaseApp.initializeApp(this);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();
    }

    public void ListaClientes(View v){
        Intent i = new Intent(this,listcliente.class);
        startActivity(i);

    }

}