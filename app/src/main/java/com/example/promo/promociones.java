package com.example.promo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import Models.NombreCliente;
import Models.Promocion;
public class promociones extends AppCompatActivity {
    private Spinner spinner;
    private EditText edit1;
    private EditText edit2;
    private TextView textv1;
    private TextView textv2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_promociones);

        // Aqui llamo los elementos por id
        spinner = (Spinner) findViewById(R.id.spn);
        edit1 = (EditText) findViewById(R.id.ed1);
        edit2 = (EditText) findViewById(R.id.ed2);
        textv1 = (TextView) findViewById(R.id.tex1);
        textv2 = (TextView) findViewById(R.id.tex2);

        String[] cliente = {"Ramiro", "Rosa", "Robert"};

        // Creamos el objeto adaptador para poder asignar mi diccionario al spinner.
        ArrayAdapter<String> adapt = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, cliente);
        spinner.setAdapter(adapt); // asigno el adaptador.

    }
       // Calculo  de las promociones
    public void CalcularPromocion(View v) {

        int endrada = Integer.valueOf(edit2.getText().toString());
        Promocion p = new Promocion();
        NombreCliente n = new NombreCliente();


        if (spinner.getSelectedItem().toString().equals("Ramiro") && edit1.getText().toString().equals("Pizzas promo")) {
            int suma = endrada + p.getPizzasPromo();
            String result = String.valueOf(suma);
            textv1.setText("Estimado  Ramiro " + n.getCliente1() + " El valor segun promocion y envio es :");
            textv2.setText("$" + result);
        } else if (spinner.getSelectedItem().toString().equals("Ramiro") && edit1.getText().toString().equals("Master pizza")) {
            int suma = endrada + p.getMasterPizza();
            String result = String.valueOf(suma);
            textv1.setText("Estimado Ramiro " + n.getCliente1() + " El valor segun promocion y envio es :");
            textv2.setText("$" +result);
        } else if (spinner.getSelectedItem().toString().equals("Ramiro") && edit1.getText().toString().equals("Pizza max")) {
            int suma = endrada + p.getPizzaMax();
            String result = String.valueOf(suma);
            textv1.setText("Estimado Ramiro " + n.getCliente1() + " El valor segun promocion y envio es :");
            textv2.setText("$" + result);
        } else if (spinner.getSelectedItem().toString().equals("Rosa") && edit1.getText().toString().equals("Pizzas promo")) {
            int suma = endrada + p.getPizzasPromo();
            String result = String.valueOf(suma);
            textv1.setText("Estimada Rosa " + n.getCliente2() + " El valor segun promocion y envio es :");
            textv2.setText("$" + result);
        } else if (spinner.getSelectedItem().toString().equals("Rosa") && edit1.getText().toString().equals("Master pizza")) {
            int suma = endrada + p.getMasterPizza();
            String result = String.valueOf(suma);
            textv1.setText("Estimada Rosa" + n.getCliente2() + " El valor segun promocion y envio es :");
            textv2.setText("$" + result);
        } else if (spinner.getSelectedItem().toString().equals("Rosa") && edit1.getText().toString().equals("Pizza max")) {
            int suma = endrada + p.getPizzaMax();
            String result = String.valueOf(suma);
            textv1.setText("Estimada  Rosa" + n.getCliente2() + " El valor segun promocion y envio es :");
            textv2.setText("$" + result);
        } else if (spinner.getSelectedItem().toString().equals("Robert") && edit1.getText().toString().equals("Pizzas promo")) {
            int suma = endrada + p.getPizzasPromo();
            String result = String.valueOf(suma);
            textv1.setText("Estimado Robert " + n.getCliente3() + " El valor segun promocion y envio es :");
            textv2.setText("$" + result);
        } else if (spinner.getSelectedItem().toString().equals("Robert") && edit1.getText().toString().equals("Master pizza")) {
            int suma = endrada + p.getMasterPizza();
            String result = String.valueOf(suma);
            textv1.setText("Estimado Robert " + n.getCliente3() + " El valor segun promocion y envio es");
            textv2.setText("$" + result);
        } else if (spinner.getSelectedItem().toString().equals("Robert") && edit1.getText().toString().equals("Pizza max")) {
            int suma = endrada + p.getPizzaMax();
            String result = String.valueOf(suma);
            textv1.setText("Estimado Robert " + n.getCliente3() + " El  valor segun promocion y envio es:");
            textv2.setText("$" + result);
        } else {
            textv1.setText("Hay que ingresar datos correctos.");
        }

    }
}