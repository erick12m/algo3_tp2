package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class MultipleChoice extends Pregunta{
    public MultipleChoice(String enunciado, Respuesta respuestasCorrectas, ArrayList<String> opciones){
        this.enunciado = enunciado;
        this.opciones = opciones;
        this.respuestaCorrecta = respuestasCorrectas;
    }

    @Override
    public void imprimirRespuestaCorrecta() {
        String respuestaCorrecta = (this.respuestaCorrecta.getRespuesta()).get(0);
    }
}
