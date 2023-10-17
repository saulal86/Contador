package com.example.contador;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class PantallaInicio extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_inicio);
    }
    public void irMainActivity(View v){
        Intent i = new Intent(this, MainActivity.class);   //clase para cambiar de pantalla
        startActivity(i);
    }
    public void irPantalla2(View v){
        Intent i = new Intent(this, PantallaOpciones.class);   //clase para cambiar de pantalla
        startActivity(i);
    }
    public void irPantallaAutores(View v){
        Intent i = new Intent(this, PantallaAutores.class);   //clase para cambiar de pantalla
        startActivity(i);

    }
    public void salir(View v){
        finish();

    }
}