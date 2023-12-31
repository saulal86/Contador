package com.example.contador;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
public class PantallaInicio extends AppCompatActivity {

    private String logueado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        logueado = getIntent().getStringExtra("logueado");
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
        }else if(id == R.id.dialog){
            Intent intent = new Intent(this, dialogos.class);
            startActivity(intent);
            }
        return super.onOptionsItemSelected(item);
    }
    public void irMainActivity(View v){
        Intent i = new Intent(this, MainActivity.class);   //clase para cambiar de pantalla
        i.putExtra("logueado", logueado);
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
        //finish();
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}