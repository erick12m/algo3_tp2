package edu.fiuba.algo3.modelo;

public class Puntaje {

    private int puntos;

    public Puntaje () {
        this (0);
    }

    public Puntaje (int puntos) {
        this.puntos = puntos;
    }

    public void sumarPuntos (int puntos) {
        this.puntos += puntos;
    }
}
