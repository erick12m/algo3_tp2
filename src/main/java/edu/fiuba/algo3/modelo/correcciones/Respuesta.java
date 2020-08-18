package edu.fiuba.algo3.modelo.correcciones;

import edu.fiuba.algo3.modelo.utilizablesJugador.Exclusividad;

import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;

public class Respuesta {
    private ArrayList<String> respuestas = new ArrayList<>();
    private ArrayList<String> segundoGrupo = new ArrayList<>();
    private int puntosObtenidos = 0;

    public Respuesta(ArrayList<String> respuestas) {
        this.respuestas = new ArrayList<>(respuestas);
        this.segundoGrupo = new ArrayList<String>();
    }

    public Respuesta(ArrayList<String> primerGrupo, ArrayList<String> segundoGrupo) {
        this.respuestas = new ArrayList<>(primerGrupo);
        this.segundoGrupo = new ArrayList<>(segundoGrupo);
        Collections.sort(this.respuestas);
        Collections.sort(this.segundoGrupo);
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
        Resultado resultado = new Resultado(0, 0, 1);
        if (this.respuestas.equals(respuestasJugador.getRespuesta())){
            resultado.sumarCorrecta();
        }
        return resultado;
    }
    public Resultado compararGrupos(Respuesta respuestasJugador){
        Resultado resultado = new Resultado(0, 0, 1);
        var primerGrupoJugador = respuestasJugador.getPrimerGrupo();
        var segundoGrupoJugador = respuestasJugador.getSegundoGrupo();
        if (esGrupoValido(primerGrupoJugador)
                && esGrupoValido(segundoGrupoJugador)){
            resultado.sumarCorrecta();
        }
        return resultado;
    }

    private boolean esGrupoValido(ArrayList<String> grupo){
        return this.respuestas.equals(grupo) || this.segundoGrupo.equals(grupo);
    }

    public boolean esCorrecta(){
        return this.puntosObtenidos > 0;
    }

    public void usarExclusividad(Exclusividad exclusividad) {
        this.puntosObtenidos = exclusividad.calcularExclusividad(this.puntosObtenidos);
    }

    public void asignarPuntaje(int puntosObtenidos){
        this.puntosObtenidos = puntosObtenidos;
    }

    public int getPuntosObtenidos() {
        return puntosObtenidos;
    }

    public ArrayList<String> getRespuesta() {
        return respuestas;
    }

    public ArrayList<String> getPrimerGrupo() {
        return respuestas;
    }

    public ArrayList<String> getSegundoGrupo() {
        return segundoGrupo;
    }

    public String getRespuestaCorrecta(){
        String cadena = this.respuestas.stream().collect(Collectors.joining(", "));
        if (segundoGrupo != null){
            cadena = cadena.concat(" // ")
                    .concat(this.segundoGrupo.stream().collect(Collectors.joining(", ")));
        }
        return cadena;
    }
}
