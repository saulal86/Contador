package com.example.contador;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.math.BigInteger;

public class PantallaMejoras extends AppCompatActivity {

    BigInteger cont = BigInteger.ZERO;
    int valorMejora = 100;
    int valorsuma = 1;
    Button botonmultiplicador;
    TextView textoContador;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_mejoras);
        textoContador = (TextView)findViewById(R.id.textoContador);
        Bundle param = getIntent().getExtras();
        textoContador.setText(" " + param.getString("pts"));

    }
    public void multiplicador(View v) {
        if (cont.compareTo(BigInteger.valueOf(valorMejora)) >= 0) {
            cont = cont.subtract(BigInteger.valueOf(valorMejora));
            valorsuma *= 2;
            valorMejora += 20;
            botonmultiplicador.setText("La mejora cuesta " + valorMejora + " puntos");
        }
    }

    public void usarMejora(){
        Intent i = new Intent(this, MainActivity.class);
        i.putExtra("mejora", );
        startActivity(i);
    }
}