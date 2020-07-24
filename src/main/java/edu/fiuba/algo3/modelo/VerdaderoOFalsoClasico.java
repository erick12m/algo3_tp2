package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.Iterator;

public class VerdaderoOFalsoClasico extends Pregunta {

    public VerdaderoOFalsoClasico(String enunciado, Respuesta respuestaCorrecta, ArrayList<String> opciones){
        this.enunciado = enunciado;
        this.opciones = opciones;
        this.respuestaCorrecta = respuestaCorrecta;
        super.puntos = 1;
    }

    @Override
    public void evaluarRespuesta(ArrayList<Respuesta> respuestasJugadores) {
        for(Respuesta respuestaJugador: respuestasJugadores){ //Obtengo un objetoRespuesta
            if (this.respuestaCorrecta.compararCon(respuestaJugador)){
                respuestaJugador.asignarPuntaje(this.puntos);
            }

        }
    }

    @Override
    public void imprimirRespuestaCorrecta() {
        String respuestaCorrecta = (this.respuestaCorrecta.getRespuesta()).get(0);
    }
}