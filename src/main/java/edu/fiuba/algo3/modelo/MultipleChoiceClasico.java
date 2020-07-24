package edu.fiuba.algo3.modelo;
import java.util.ArrayList;


public class MultipleChoiceClasico extends Pregunta{
    public MultipleChoiceClasico(String enunciado, Respuesta respuestasCorrectas, ArrayList<String> opciones){
        this.enunciado = enunciado;
        this.opciones = opciones;
        this.respuestaCorrecta = respuestasCorrectas;
        super.puntos = 1;
    }
    @Override
    public void evaluarRespuesta(ArrayList<Respuesta> respuestasJugadores) {
        for(Respuesta respuestaJugador: respuestasJugadores){
            if (this.respuestaCorrecta.compararConVarias(respuestaJugador).diferencia() == 0){
                respuestaJugador.asignarPuntaje(this.puntos);
            }
        }
    }

    @Override
    public void imprimirRespuestaCorrecta() {
        String respuestaCorrecta = (this.respuestaCorrecta.getRespuesta()).get(0);
    }
}
