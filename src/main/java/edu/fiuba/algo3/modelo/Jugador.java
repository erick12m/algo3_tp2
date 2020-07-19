package edu.fiuba.algo3.modelo;

public class Jugador {

    private String nombre;
    private Puntaje puntaje;

    public Jugador (String nombre) {
        this.nombre = nombre;
        this.puntaje = new Puntaje ();
    }

    public responderPregunta (String enunciado, Opciones opciones) {
        System.out.println(enunciado);
        opciones.presentarOpciones();

    }
}
