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
        jugadores.add(new jugador("hugofm_2004", "33",R.drawable.fotohugo));
        jugadores.add(new jugador("danimp", "33,333",R.drawable.fotodani));
        jugadores.add(new jugador("varo_tegana", "-33",R.drawable.fotonistal));
        jugadores.add(new jugador("polalonso_cao", "2",R.drawable.fotopablo));
        jugadores.add(new jugador("lobo_mieres", "0",R.drawable.fotolucia));
    }
    public void volverJuego(View v){
        finish();
    }
}
