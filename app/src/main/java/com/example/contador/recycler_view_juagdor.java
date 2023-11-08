package com.example.contador;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class recycler_view_juagdor extends AppCompatActivity {
    List<jugador> jugadores= new ArrayList<jugador>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recyclerview_jugador);
        RecyclerView rv = findViewById(R.id.recycler);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(new jugadoresAdapter(getApplicationContext(), jugadores));
        jugadores.add(new jugador("hugo", "33",R.drawable.hugin));
    }
    public void volverJuego(View v){
        finish();
    }
}
