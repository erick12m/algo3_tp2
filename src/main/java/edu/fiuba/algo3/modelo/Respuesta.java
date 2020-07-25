package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class Respuesta {

    private ArrayList<String> respuesta;
    private int puntosObtenidos = 0;
    private Boolean respuestaCorrecta; //Quizas sirve despues
    private Corrector tipoPuntaje;
    public Respuesta(ArrayList<String> respuesta) {
        this.tipoPuntaje = tipoPuntaje;
        this.respuesta = respuesta;
    }
    public Respuesta(ArrayList<String> respuesta, Corrector tipoPuntaje) {
        this.tipoPuntaje = tipoPuntaje;
        this.respuesta = respuesta;
    }

    public ArrayList<String> getRespuesta() {
        return this.respuesta;
    }


    protected Resultado compararCon(Respuesta respuestasJugador){
        Resultado resultado = new Resultado(0, 0, this.respuesta.size());
        for(String respuestaJugador: respuestasJugador.getRespuesta()){
            if(this.respuesta.contains(respuestaJugador)){
                resultado.sumarCorrecta();
            }else{
                resultado.sumarIncorrecta();
            }
        }
        return resultado;
    }




    public void asignarPuntaje(Resultado resultado){
        this.puntosObtenidos = tipoPuntaje.corregirPregunta(resultado);
    }

    public int getPuntosObtenidos() {
        return this.puntosObtenidos;
    }
}
