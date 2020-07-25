package edu.fiuba.algo3.modelo;

public class Puntaje {

    private int puntaje;

    public Puntaje() {
        this.puntaje = 0;
    }

    public int getPuntosObtenidos() {
        return puntaje;
    }

    public void actualizarPuntaje(int puntosAdquiridos) {
        puntaje = (puntaje + puntosAdquiridos < 0) ? 0 : (puntaje + puntosAdquiridos);
    }
}
