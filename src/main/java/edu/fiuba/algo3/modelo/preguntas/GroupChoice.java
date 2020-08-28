package edu.fiuba.algo3.modelo.preguntas;

import edu.fiuba.algo3.modelo.correcciones.Corrector;
import edu.fiuba.algo3.modelo.correcciones.Respuesta;
import edu.fiuba.algo3.modelo.correcciones.Resultado;
import java.util.ArrayList;

public class GroupChoice extends Pregunta{
    public GroupChoice(String enunciado, Respuesta respuestasCorrectas, ArrayList<String> opciones, Corrector corrector){
        this.enunciado = enunciado;
        this.opciones = opciones;
        this.respuestaCorrecta = respuestasCorrectas;
        this.corrector = corrector;
        this.nombre = "Group Choice";
    }

    @Override
    public Resultado obtenerResultado(Respuesta respuestaJugador){
        return respuestaCorrecta.compararGrupos(respuestaJugador);
    }
}
