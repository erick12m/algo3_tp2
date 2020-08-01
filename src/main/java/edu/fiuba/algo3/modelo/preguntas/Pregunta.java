package edu.fiuba.algo3.modelo.preguntas;
import edu.fiuba.algo3.modelo.correccion.Corrector;
import edu.fiuba.algo3.modelo.correccion.Respuesta;
import edu.fiuba.algo3.modelo.correccion.Resultado;

import java.util.ArrayList;

public abstract class Pregunta {

    public String enunciado;
    public ArrayList<String> opciones; //cuando creamos la pregunta se le pasa una lista de opciones
    protected Respuesta respuestaCorrecta;
    protected Corrector corrector;




    public void evaluarRespuesta(ArrayList<Respuesta> respuestasJugadores){
        for(Respuesta respuestaJugador: respuestasJugadores){
            Resultado resultado = this.respuestaCorrecta.compararCon(respuestaJugador);
            int puntosObtenidos = corrector.corregirPregunta(resultado);
            respuestaJugador.asignarPuntaje(puntosObtenidos);
        }
    }







}
