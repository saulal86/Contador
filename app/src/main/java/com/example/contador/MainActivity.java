package com.example.contador;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.MediaParser;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity {
    TextView contador;
    BigInteger cont = BigInteger.ZERO;
    int valorsuma = 1;
    Button botonmultiplicador;
    ImageView imageView2;
    int valorMejora = 100;
    int incrementoAutomatico = 1;
    MediaPlayer sonido;
    DataBaseHelper db;
    private String logueado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        db = new DataBaseHelper(this);
        setContentView(R.layout.activity_main);
        contador = findViewById(R.id.textoContador);
        botonmultiplicador = findViewById(R.id.botonmultiplicador);
        imageView2 = findViewById(R.id.imageView2);
        contador.setText(String.valueOf(cont));
        ejecutarHilo();
        sonido = MediaPlayer.create(this, R.raw.sonidomoneda);
        logueado = getIntent().getStringExtra("logueado");
    }
    public void sumar(View v) {
        ScaleAnimation fade_in = new ScaleAnimation(0.7f, 1.2f, 0.7f, 1.2f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        fade_in.setDuration(100);
        imageView2.startAnimation(fade_in);
        cont = cont.add(BigInteger.valueOf(valorsuma));
        actualizarTextoContador();
        sonido.start();
        db.ActualizarMonedas(contador, logueado);
    }
    public void multiplicador(View v) {
        Intent i = new Intent(this, PantallaMejoras.class);   //clase para cambiar de pantalla
        startActivity(i);
    }
    private String actualizarTextoContador() {
        String textoContador;
        if (cont.compareTo(BigInteger.valueOf(1000)) >= 0) {
            BigInteger mil = BigInteger.valueOf(1000);
            BigInteger cantidad = cont.divide(mil);
            textoContador = cantidad + " k";
        }
        if (cont.compareTo(BigInteger.valueOf(1000000)) >= 0) {
            BigInteger Mill = BigInteger.valueOf(1000000);
            BigInteger cantidad_2 = cont.divide(Mill);
            textoContador = cantidad_2 + " Mill";
        } else {
            textoContador = cont.toString();
        }
        contador.setText(textoContador);
        return textoContador;
    }
    public void ejecutarHilo() {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Handler handler = new Handler(Looper.getMainLooper());
        executor.execute(() -> {
            //Background work here
            while (true) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                cont = cont.add(BigInteger.valueOf(incrementoAutomatico));

                handler.post(() -> {
                    //UI Thread work here
                    contador.setText(actualizarTextoContador());
                });
            }
        });
    }
    public void salir(View v) {
        finish();
    }
    public void menuMejoras() {
        Intent i = new Intent(this, PantallaMejoras.class);   //clase para cambiar de pantalla
        startActivity(i);
    }
    public void IrMenuMejoras(View v) {
        Intent intent = new Intent(this, PantallaMejoras.class);
        intent.putExtra("pts", contador.getText());
        startActivity(intent);
    }
    public void irRanking(View v) {
        Intent intent = new Intent(this, recycler_view_juagdor.class);
        startActivity(intent);
    }
}