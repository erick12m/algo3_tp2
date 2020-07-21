package edu.fiuba.algo3.modelo;
import java.util.ArrayList;

public abstract class Pregunta {

    private String enunciado;
    private ArrayList<Opcion> opciones;
    protected Respuesta respuestas; // Por simplicidad lo coloque momentaneamete unico y protegido
    protected EstadoPuntaje estadoPuntaje;

    public Pregunta(String enunciado, ArrayList<Opcion> opciones, Respuesta respuestas
            , EstadoPuntaje estadoPuntaje) {

        this.enunciado = enunciado;
        this.opciones = opciones;
        this.respuestas = respuestas;
        this.estadoPuntaje = estadoPuntaje;
    }

    public abstract int evaluarRespuesta (Respuesta respuestaJugador);

}
