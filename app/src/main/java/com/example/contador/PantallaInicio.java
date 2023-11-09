package com.example.contador;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
public class PantallaInicio extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_inicio);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_inicio, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.Ranking) {
            Intent intent = new Intent(this, recycler_view_juagdor.class);
            startActivity(intent);
            return true;
        }else {
            Intent intent = new Intent(this, MyListViewActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
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