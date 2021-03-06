package com.example.promo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText editText;
    private EditText editText1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.id1);
        editText1 = (EditText) findViewById(R.id.id2);
    }

    public void IniciarSession(View v) {
        if (editText.getText().toString().equals("Android") && editText1.getText().toString().equals("123")) {
            Intent i = new Intent(this, menu_act.class);
            startActivity(i);
        } else if (editText.getText().toString().equals("android") && editText1.getText().toString().equals("123")){
        Intent i = new Intent(this, menu_act.class);
        startActivity(i);
    }else{
            Toast.makeText(getBaseContext(),"No existe otra posibiliada de ingresar",Toast.LENGTH_LONG).show();
        }


    }
}