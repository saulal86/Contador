package com.example.contador;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.TextView;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class DataBaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "BaseDatosUsuarios";
    private static final int DATABASE_VERSION = 1;

    public DataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onConfigure(SQLiteDatabase db) {
        super.onConfigure(db);
        db.setForeignKeyConstraintsEnabled(true);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE usuarios(id INTEGER PRIMARY KEY AUTOINCREMENT,nombre TEXT,clave TEXT, monedas INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS usuarios");
        onCreate(db);
    }

    public boolean RegistrarUsuario(String nombre, String clave) {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("INSERT INTO usuarios(nombre, clave, monedas) VALUES (?,?, 0)", new String[]{nombre, clave});
        return false;
    }

    public boolean checkusername(String nombre) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select * from usuarios where nombre = ?", new String[]{nombre});
        if (cursor.getCount() > 0)
            return true;
        else
            return false;

    }

    public void ActualizarMonedas(TextView monedas, String nombre) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("UPDATE usuarios SET monedas=? WHERE nombre=?", new String[]{String.valueOf(monedas), nombre});
    }

    public List<jugador> findUsers() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select * from usuarios", new String[0]);
        List<jugador> users = new ArrayList<>();
        int posUsername = cursor.getColumnIndex("username");
        int posMonedas = cursor.getColumnIndex("monedas");
        if (cursor.moveToFirst())
            while (cursor.moveToNext()) {
                String usuarios = cursor.getString(posUsername);
                String monedas = cursor.getString(posMonedas);
                jugador nuevoJugador = new jugador(usuarios, monedas);
                users.add(nuevoJugador);
            }
        return users;
    }
}
