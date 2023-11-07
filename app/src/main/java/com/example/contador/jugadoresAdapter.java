package com.example.contador;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class jugadoresAdapter extends RecyclerView.Adapter<jugadorViewHolder> {

    Context context;
    List<jugador>jugadores;

    public jugadoresAdapter(Context context, List<jugador> jugadores) {
        this.context = context;
        this.jugadores = jugadores;
    }

    @NonNull
    @Override
    public jugadorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new jugadorViewHolder(LayoutInflater.from(context).inflate(R.layout.jugador_vista, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull jugadorViewHolder holder, int position) {
        holder.nick.setText(jugadores.get(position).getNick());
        holder.monedas.setText(jugadores.get(position).getMonedas());
        holder.imagen.setImageResource(jugadores.get(position).getImagen());
    }

    @Override
    public int getItemCount() {
        return jugadores.size();
    }
}
