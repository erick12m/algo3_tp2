package edu.fiuba.algo3.modelo.preguntas;
import edu.fiuba.algo3.modelo.correccion.Respuesta;
import edu.fiuba.algo3.modelo.correccion.Resultado;
import edu.fiuba.algo3.modelo.correccion.Corrector;

import java.util.ArrayList;

public abstract class Pregunta {

    public String enunciado;
    public ArrayList<String> opciones; //cuando creamos la pregunta se le pasa una lista de opciones
    protected int puntos;
    protected Respuesta respuestaCorrecta;
    protected Corrector corrector;

    public void imprimirEnunciado(){
        System.out.println(enunciado);
    }

    public void imprimirOpciones(){
        for (String opcion: opciones){
            System.out.println(opcion);
        }
    }

    public int getPuntos(){
        return puntos;
    }

    //METODOS ABSTRACTOS
    public void evaluarRespuesta(ArrayList<Respuesta> respuestasJugadores){
        for(Respuesta respuestaJugador: respuestasJugadores){
            Resultado resultado = this.respuestaCorrecta.compararCon(respuestaJugador);
            int puntosObtenidos = corrector.corregirPregunta(resultado);
            respuestaJugador.asignarPuntaje(puntosObtenidos);
        }
    }

    public abstract void imprimirRespuestaCorrecta();






}
