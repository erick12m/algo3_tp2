package edu.fiuba.algo3.modelo;
import java.util.ArrayList;

public abstract class Pregunta {

    public String enunciado;
    public ArrayList<String> opciones; //cuando creamos la pregunta se le pasa una lista de opciones
    //protected ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>(); // Por simplicidad lo coloque momentaneamete unico y protegido
    protected int puntos;
    protected Respuesta respuestaCorrecta;


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
            respuestaJugador.asignarPuntaje(resultado);
        }
    }

    public abstract void imprimirRespuestaCorrecta();






}
