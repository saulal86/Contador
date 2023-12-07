package com.example.contador;

public class jugador {
    String nick;
    String monedas;
    public jugador(String nick, String monedas) {
        this.nick = nick;
        this.monedas = monedas;
    }
    public  String getNick() {
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
}
