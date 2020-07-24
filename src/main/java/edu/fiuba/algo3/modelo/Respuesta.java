package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class Respuesta {

    private ArrayList<String> respuesta;
    private int puntosObtenidos = 0;
    private Boolean respuestaCorrecta; //Quizas sirve despues

    public Respuesta(ArrayList<String> respuesta) {
        this.respuesta = respuesta;
    }

    public ArrayList<String> getRespuesta() {
        return this.respuesta;
    }


    protected Resultado compararConVarias(Respuesta respuestasJugador){
        Resultado puntos = new Resultado(0, 0, this.respuesta.size());
        for(String respuestaJugador: respuestasJugador.respuesta){
            if(this.respuesta.contains(respuestaJugador)){
                puntos.sumarCorrecta();
            }
        }
        return puntos;
    }

    public boolean compararCon(Respuesta respuestaJugador) {
        String respuestaJug = respuestaJugador.getRespuesta().get(0);
        return respuestaJug.equals(this.respuesta.get(0));
    }



    public void asignarPuntaje(int puntosObtenidos){
        this.puntosObtenidos = puntosObtenidos;
    }

    public int getPuntosObtenidos() {
        return this.puntosObtenidos;
    }
}
