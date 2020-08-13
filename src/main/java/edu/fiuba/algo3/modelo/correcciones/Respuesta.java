package edu.fiuba.algo3.modelo.correcciones;

import edu.fiuba.algo3.modelo.utilizablesJugador.Exclusividad;

import java.util.ArrayList;
import java.util.Collections;

public class Respuesta {

    private ArrayList<String> respuestas = new ArrayList<>();
    //private ArrayList<String> primerGrupo = new ArrayList<>();
    private ArrayList<String> segundoGrupo = new ArrayList<>();
    private int puntosObtenidos = 0;
    // TODO Si no se crea con dos grupos que guarde en el primero
    public Respuesta(ArrayList<String> respuestas) {
        this.segundoGrupo = new ArrayList<String>();
        this.respuestas = new ArrayList<>(respuestas);
    }

    public Respuesta(ArrayList<String> primerGrupo, ArrayList<String> segundoGrupo) {
        Collections.sort(primerGrupo);
        Collections.sort(segundoGrupo);
        this.respuestas = new ArrayList<>(primerGrupo);
        this.segundoGrupo = new ArrayList<>(segundoGrupo);
    }

    public Resultado compararCon(Respuesta respuestasJugador){
        Resultado resultado = new Resultado(0, 0, this.respuestas.size());
        for(String respuestaJugador: respuestasJugador.getRespuesta()){
            if(this.respuestas.contains(respuestaJugador)){
                resultado.sumarCorrecta();
            }else{
                System.out.println("Entre a incorrecta");
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
        //Collections.sort(primerGrupoJugador);
        //Collections.sort(segundoGrupoJugador);
        System.out.println("Respuesta 1: ".concat(String.valueOf(this.respuestas)));
        System.out.println("Primer grupo: ".concat(String.valueOf(primerGrupoJugador)));
        System.out.println("Segundo grupo: ".concat(String.valueOf(segundoGrupoJugador)));
        System.out.println("Respuesta 2: ".concat(String.valueOf(this.segundoGrupo)));
        if ((this.respuestas.equals(primerGrupoJugador) || this.segundoGrupo.equals(primerGrupoJugador))
                && (this.segundoGrupo.equals(segundoGrupoJugador) || this.respuestas.equals(segundoGrupoJugador))){
            resultado.sumarCorrecta();
        } else {
            System.out.println("Entre a restar en group");
            resultado.sumarIncorrecta();
        }
        return resultado;
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
        String cadena = "";
        cadena = cadena.concat(concatenarRespuestas(this.respuestas));
        if (segundoGrupo == null){
            return cadena;
        }
        cadena = cadena.concat("\n").concat(concatenarRespuestas(this.segundoGrupo));
        return cadena;
    }
    private String concatenarRespuestas(ArrayList<String> respuestas){
        String cadena = "";
        for(String cad: respuestas){
            cadena = cadena.concat(cad).concat(", ");
        }
        return cadena;
    }
}
