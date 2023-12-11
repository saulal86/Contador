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
    DataBaseHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recyclerview_jugador);
        db = new DataBaseHelper(this);
        RecyclerView rv = findViewById(R.id.recycler);
        rv.setLayoutManager(new LinearLayoutManager(this));
        jugadores = db.findUsers();
        rv.setAdapter(new jugadoresAdapter(getApplicationContext(), jugadores));
        //supuestamente en este recycler viewe deberian de aparecer los usuarios registrados pero no se porque no sale
    }
    public void volverJuego(View v){
        finish();
    }
}
