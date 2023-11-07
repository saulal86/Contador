package com.example.contador;

public class jugador {

    String nick;
    String monedas;
    int imagen;
    public jugador(String nick, String monedas, int imagen) {
        this.nick = nick;
        this.monedas = monedas;
        this.imagen = imagen;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getMonedas() {
        return monedas;
    }

    public void setMonedas(String monedas) {
        this.monedas = monedas;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }
}
