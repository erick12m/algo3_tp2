package edu.fiuba.algo3.modelo.preguntas;

import edu.fiuba.algo3.modelo.correccion.Respuesta;
import edu.fiuba.algo3.modelo.correccion.Corrector;

import java.util.ArrayList;

public class VerdaderoFalso extends Pregunta {

    public VerdaderoFalso(String enunciado, Respuesta respuestaCorrecta, ArrayList<String> opciones, Corrector corrector){
        this.enunciado = enunciado;
        this.opciones = opciones;
        this.respuestaCorrecta = respuestaCorrecta;
        this.corrector = corrector;
    }

    @Override
    public void imprimirRespuestaCorrecta() {
        String respuestaCorrecta = (this.respuestaCorrecta.getRespuesta()).get(0);
    }
}