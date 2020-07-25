package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class VerdaderoOFalso extends Pregunta {

    protected int puntosPenalidad;

    protected VerdaderoOFalso(String enunciado, Respuesta respuestaCorrecta, ArrayList<String> opciones){
        this.enunciado = enunciado;
        this.opciones = opciones;
        this.respuestaCorrecta = respuestaCorrecta;
    }

    @Override
    public void imprimirRespuestaCorrecta() {
        String respuestaCorrecta = (this.respuestaCorrecta.getRespuesta()).get(0);
    }
}