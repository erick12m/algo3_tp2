package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.Iterator;

public class VerdaderoOFalso extends Pregunta {

    public VerdaderoOFalso(String enunciado, ArrayList<Respuesta> respuestas) {
        this.enunciado = enunciado;
        this.opciones = new ArrayList<Opcion>();
        this.respuestas = respuestas;
        this.estadoPuntaje = new PuntajeClasico();
    }

    @Override
    public int evaluarRespuesta(Respuesta respuestaJugador) {

        Resultado resultado = new Resultado();

        Iterator<Respuesta> it = this.respuestas.iterator();
        Respuesta respuestaCorrecta = it.next();

        if (respuestaCorrecta.getTexto().equals(respuestaJugador.getTexto())) {
            resultado.setCorrectas(1);
        } else {
            resultado.setIncorrectas(1);
        }
        return this.estadoPuntaje.puntuarPregunta(resultado);
    }
}
