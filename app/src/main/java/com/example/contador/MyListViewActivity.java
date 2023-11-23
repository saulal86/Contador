package com.example.contador;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.Arrays;
import java.util.List;

public class MyListViewActivity extends ListActivity implements AdapterView.OnItemClickListener {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview);
        List<jugador> jugadores = Arrays.asList(
                new jugador("hugofm_2004", "33", R.drawable.fotohugo),
                new jugador("danimp", "33,333", R.drawable.fotodani),
                new jugador("varo_tegana", "-33", R.drawable.fotonistal),
                new jugador("polalonso_cao", "2", R.drawable.fotopablo),
                new jugador("lobo_mieres", "0", R.drawable.fotolucia)
        );
        JugadoresAdaptadorLista adapter = new JugadoresAdaptadorLista(this, R.layout.item, jugadores);
        setListAdapter(adapter);
        getListView().setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        jugador jugador = (jugador) adapterView.getItemAtPosition(i);
        Toast.makeText(MyListViewActivity.this, jugador.getNick(), Toast.LENGTH_LONG).show();
    }
}
