package com.example.promo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import Models.Clientes;

public class listcliente extends AppCompatActivity {
    //Declaracionees de variables

    private ListView listado;

    ArrayList<Clientes> listadocliente = new ArrayList<Clientes>();
    Clientes clienteselect;

    FirebaseDatabase firebase;
    DatabaseReference databaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listcliente);

        // Aqui llamo los elementos por id

        listado=(ListView)findViewById(R.id.lv);
        iniciarBase();
        // Metodo para mostrar clientes
        databaseReference.child("Clientes").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for(DataSnapshot objSnapshot: snapshot.getChildren())
                {
                    Clientes cl = objSnapshot.getValue(Clientes.class);

                    listadocliente.add(cl);

                    ArrayAdapter adapt = new ArrayAdapter(getBaseContext(), android.R.layout.simple_list_item_1, listadocliente);
                    listado.setAdapter(adapt);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


        // Método para obtener la selección del LISTVIEW.

        listado.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                clienteselect = (Clientes) parent.getItemAtPosition(position);

            }
        });

    }
    // Para eliminar clientes en la base de datos
    public void Eliminar(View v)
    {
        Clientes cl = new Clientes();
        cl.setId(clienteselect.getId());
        databaseReference.child("Clientes").child(cl.getId()).removeValue();
        Toast.makeText(this, "Has eliminado un Cliente", Toast.LENGTH_LONG).show();
    }

   // Obtengo la instancia de mi base de datos
    public void iniciarBase()
    {
        FirebaseApp.initializeApp(this);
        firebase = FirebaseDatabase.getInstance();
        databaseReference = firebase.getReference();
    }
}