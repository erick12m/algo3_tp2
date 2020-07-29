package edu.fiuba.algo3.modelo.preguntas;

import edu.fiuba.algo3.modelo.correccion.Corrector;
import edu.fiuba.algo3.modelo.correccion.Respuesta;
import edu.fiuba.algo3.modelo.correccion.Resultado;

import java.util.ArrayList;

public class OrderedChoice extends Pregunta{
    public OrderedChoice(String enunciado, Respuesta respuestasCorrectas, ArrayList<String> opciones, Corrector corrector){
        this.enunciado = enunciado;
        this.opciones = opciones;
        this.respuestaCorrecta = respuestasCorrectas;
        this.corrector = corrector;
    }
    @Override
    public void evaluarRespuesta(ArrayList<Respuesta> respuestasJugadores){
        for(Respuesta respuestaJugador: respuestasJugadores){
            Resultado resultado = this.respuestaCorrecta.compararOrden(respuestaJugador);
            int puntosObtenidos = corrector.corregirPregunta(resultado);
            respuestaJugador.asignarPuntaje(puntosObtenidos);
        }
    }
}
