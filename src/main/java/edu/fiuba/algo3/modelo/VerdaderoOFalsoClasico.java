package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class VerdaderoOFalsoClasico extends VerdaderoOFalso {

    public VerdaderoOFalsoClasico(String enunciado, Respuesta respuestaCorrecta, ArrayList<String> opciones) {
        super(enunciado, respuestaCorrecta, opciones);
        this.puntos = 1;
    }
}
