package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class VerdaderoOFalso extends Pregunta {

    public VerdaderoOFalso(String enunciado, ArrayList<Opcion> opciones, Respuesta respuestas
            , EstadoPuntaje estadoPuntaje) {
        super(enunciado, opciones, respuestas, estadoPuntaje);
    }

    @Override
    public int evaluarRespuesta(Respuesta respuestaJugador) {

        Resultado resultado = new Resultado();

        if (respuestas.getTexto().equals(respuestaJugador.getTexto())) {
            resultado.setCorrectas(1);
        }
        else {
            resultado.setIncorrectas(1);
        }

        return estadoPuntaje.puntuarPregunta(resultado);
    }
}
