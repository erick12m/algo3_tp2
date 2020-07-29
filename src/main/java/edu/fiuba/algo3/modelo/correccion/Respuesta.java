package edu.fiuba.algo3.modelo.correccion;

import java.util.ArrayList;

public class Respuesta {

    private ArrayList<String> respuestas;
    private ArrayList<String> primerGrupo;
    private ArrayList<String> segundoGrupo;
    private int puntosObtenidos = 0;
    private Boolean respuestaCorrecta; //Quizas sirve despues

    public Respuesta(ArrayList<String> respuestas) {
        this.respuestas = respuestas;
    }

    public Respuesta(ArrayList<String> primerGrupo, ArrayList<String> segundoGrupo) {
        this.primerGrupo = primerGrupo;
        this.segundoGrupo = segundoGrupo;
    }

    public ArrayList<String> getRespuesta() {
        return this.respuestas;
    }
    public ArrayList<String> getPrimerGrupo() {
        return this.primerGrupo;
    }
    public ArrayList<String> getSegundoGrupo() {
        return this.segundoGrupo;
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
    public Resultado compararOrden(Respuesta respuestasJugador){
        Resultado resultado = new Resultado(0, 0, this.respuestas.size());
        var respuestas = respuestasJugador.getRespuesta();
        for (int i = 0; i < respuestas.size(); i++){
            if (this.respuestas.get(i).equals(respuestas.get(i))){
                resultado.sumarCorrecta();
            }else{
                resultado.sumarIncorrecta();
            }
        }
        return resultado;
    }
    public Resultado compararGrupos(Respuesta respuestasJugador){
        Resultado resultado = new Resultado(0, 0, 1);
        if (this.primerGrupo.containsAll(respuestasJugador.getPrimerGrupo())
                && this.segundoGrupo.containsAll(respuestasJugador.getSegundoGrupo())){
            resultado.sumarCorrecta();
        }else{
            resultado.sumarIncorrecta();
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
