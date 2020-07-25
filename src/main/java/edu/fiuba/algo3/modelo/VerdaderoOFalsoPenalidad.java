package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class VerdaderoOFalsoPenalidad extends VerdaderoOFalso {

    public VerdaderoOFalsoPenalidad(String enunciado, Respuesta respuestaCorrecta, ArrayList<String> opciones) {
        super(enunciado, respuestaCorrecta, opciones);
        this.puntos = 1;
        this.puntosPenalidad = -1;
    }
}