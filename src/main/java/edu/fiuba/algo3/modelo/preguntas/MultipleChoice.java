package edu.fiuba.algo3.modelo.preguntas;

import edu.fiuba.algo3.modelo.correcciones.Respuesta;
import edu.fiuba.algo3.modelo.correcciones.Corrector;

import java.util.ArrayList;

public class MultipleChoice extends Pregunta{
    public MultipleChoice(String enunciado, Respuesta respuestasCorrectas, ArrayList<String> opciones, Corrector corrector){
        this.enunciado = enunciado;
        this.opciones = opciones;
        this.respuestaCorrecta = respuestasCorrectas;
        this.corrector = corrector;
        this.nombre = "Multiple Choice";
    }
}
