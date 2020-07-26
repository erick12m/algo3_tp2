package edu.fiuba.algo3.modelo.correccion;

import java.util.ArrayList;

public class Respuesta {

    private ArrayList<String> respuestas;
    private int puntosObtenidos = 0;
    private Boolean respuestaCorrecta; //Quizas sirve despues
    private Corrector tipoPuntaje;

    public Respuesta(ArrayList<String> respuestas) {
        this.respuestas = respuestas;
    }

    public ArrayList<String> getRespuesta() {
        return this.respuestas;
    }


    public Resultado compararCon(Respuesta respuestasJugador){
        Resultado resultado = new Resultado(0, 0, this.respuestas.size());
        for(String respuestaJugador: respuestasJugador.getRespuesta()){
            if(this.respuestas.contains(respuestaJugador)){
                resultado.sumarCorrecta();
            }else{
                resultado.sumarIncorrecta();
            }
        }
        return resultado;
    }


    public void asignarPuntaje(int puntosObtenidos){
        this.puntosObtenidos = puntosObtenidos;
    }

    public int getPuntosObtenidos() {
        return this.puntosObtenidos;
    }
}
