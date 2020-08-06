package edu.fiuba.algo3.modelo.preguntas;
import edu.fiuba.algo3.modelo.correccion.Corrector;
import edu.fiuba.algo3.modelo.correccion.Respuesta;
import edu.fiuba.algo3.modelo.correccion.Resultado;

import java.util.ArrayList;

public abstract class Pregunta {

    public String enunciado;
    public ArrayList<String> opciones;
    protected Respuesta respuestaCorrecta;
    protected Corrector corrector;
    protected String nombre;

    public void evaluarRespuesta(ArrayList<Respuesta> respuestasJugadores){
        for(Respuesta respuestaJugador: respuestasJugadores) {
            Resultado resultado = respuestaCorrecta.compararCon(respuestaJugador);
            int puntosObtenidos = corrector.corregirPregunta(resultado);
            respuestaJugador.asignarPuntaje(puntosObtenidos);
        }
    }

    public boolean tienePenalidad(){
        return corrector.tienePenalidad();
    }

    public String getNombre (){
        return this.nombre;
    }

    public ArrayList<String> getOpciones(){
        return this.opciones;
    }

    public String getEnunciado(){
        return this.enunciado;
    }

    public Respuesta getRespuestaCorrecta() {
        return this.respuestaCorrecta;
    }

    public Corrector getCorrector() {
        return this.corrector;
    }

    public void setEnunciado(String enunciado){
        this.enunciado = enunciado;
    }

    public void setOpciones(ArrayList<String> opciones){
        this.opciones = opciones;
    }

    public void setRespuestaCorrecta(Respuesta respuestaCorrecta){
        this.respuestaCorrecta = respuestaCorrecta;
    }

    public void setCorrector (Corrector corrector){
        this.corrector = corrector;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
