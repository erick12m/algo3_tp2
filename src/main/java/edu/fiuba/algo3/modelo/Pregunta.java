package edu.fiuba.algo3.modelo;
import java.util.ArrayList;

public abstract class Pregunta {

    public String enunciado;
    public ArrayList<Opcion> opciones;
    protected ArrayList<Respuesta> respuestas; // Por simplicidad lo coloque momentaneamete unico y protegido
    protected EstadoPuntaje estadoPuntaje;
    protected ArrayList<Respuesta> respuestasCorrectas;


    public abstract int evaluarRespuesta (Respuesta respuestaJugador);

}
