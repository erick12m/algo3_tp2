package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class MultipleChoiceParcial extends Pregunta {
    public MultipleChoiceParcial(String enunciado, Respuesta respuestasCorrectas, ArrayList<String> opciones) {
        this.enunciado = enunciado;
        this.opciones = opciones;
        this.respuestaCorrecta = respuestasCorrectas;
    }
    @Override
    public void evaluarRespuesta(ArrayList<Respuesta> respuestasJugadores) {
        for(Respuesta respuestaJugador: respuestasJugadores){
            Resultado resultado = this.respuestaCorrecta.compararConVarias(respuestaJugador);
            respuestaJugador.asignarPuntaje(resultado.getCorrectas());
        }
    }

    @Override
    public void imprimirRespuestaCorrecta() {
        String respuestaCorrecta = (this.respuestaCorrecta.getRespuesta()).get(0);
    }

}
