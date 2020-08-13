package edu.fiuba.algo3.Controladores;

import edu.fiuba.algo3.modelo.Kahoot;
import edu.fiuba.algo3.modelo.correcciones.Respuesta;
import edu.fiuba.algo3.modelo.excepciones.NoTieneExclusividadException;
import edu.fiuba.algo3.modelo.excepciones.NoTieneMultiplicadorException;
import javafx.scene.control.Button;

import java.util.ArrayList;

public abstract class ControladorPregunta {
    protected ArrayList<String> opciones;
    protected Respuesta respuestaCorrecta;
    protected Kahoot kahoot;
    protected ArrayList<String> respuestaJugador = new ArrayList<>();

    /*public ControladorPregunta(Kahoot kahoot){
        this.kahoot = kahoot;
    }*/

    public void guardarRespuesta(Button botonOpcion){
        String textoOpcion = botonOpcion.getText();
        if (respuestaJugador.contains(textoOpcion)) {
            respuestaJugador.remove(textoOpcion);
        }
        else {
            respuestaJugador.add(textoOpcion);
        }
    }

    public ArrayList<Button> getBotonesOpciones(){
        ArrayList<Button> botones = new ArrayList<Button>();
        for (String opcion : kahoot.getPreguntaActual().getOpciones()){
            var boton = new Button(opcion);
            boton.setOnAction(e ->{
                boton.getText();
            });
            boton.setMinWidth(320);
            boton.setMinHeight(50);
            botones.add(boton);
        }
        return botones;
    }


    public String getNombre() {
        return kahoot.getPreguntaActual().getNombre();
    }

    public String getEnunciado() {
        return kahoot.getPreguntaActual().getEnunciado();
    }

    public Respuesta getRespuestaJugador(){
        System.out.println(kahoot.getJugadorActual().getNombre().concat(" resp: ").concat(String.valueOf(respuestaJugador)));
        Respuesta respuesta = new Respuesta(respuestaJugador);
        respuestaJugador.clear();
        return respuesta;
    }

    public void activarMultiplicadorx2() {
        try {
            kahoot.getJugadorActual().activarMultiplicadorx2();
        } catch (NoTieneMultiplicadorException e) {
            e.printStackTrace();
        }
    }

    public void activarMultiplicadorx3() {
        try {
            kahoot.getJugadorActual().activarMultiplicadorx3();
        } catch (NoTieneMultiplicadorException e) {
            e.printStackTrace();
        }
    }

    public void activarExclusividad(){
        try {
            kahoot.usarExclusividad(kahoot.getJugadorActual());
        } catch (NoTieneExclusividadException e) {
            e.printStackTrace();
        }
    }

    public boolean esPreguntaConPenalidad(){
        return kahoot.esPreguntaConPenalidad();
    }

    public void setGrupo(String text){
        System.out.println("Setee grupo"); //TODO borrar esto despues, es para debuguear
    }
}
