package com.example.contador;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class JugadoresAdaptadorLista extends ArrayAdapter<jugador> {

    public JugadoresAdaptadorLista(@NonNull Context context, int resource, @NonNull List<jugador> objects) {
        super(context, resource, objects);

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        jugador j = getItem(position);
        if (convertView == null)
            convertView = LayoutInflater.from(this.getContext()).inflate(R.layout.item, parent, false);
        ((ImageView) convertView.findViewById(R.id.imageView)).setImageResource(j.getImagen());
        ((TextView) convertView.findViewById(R.id.nombreTextView)).setText(j.getNick());
        ((TextView) convertView.findViewById(R.id.dirTextView)).setText(j.getMonedas());
        return super.getView(position, convertView, parent);
    }
}
