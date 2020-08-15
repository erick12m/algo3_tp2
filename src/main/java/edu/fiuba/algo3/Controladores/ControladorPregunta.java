package edu.fiuba.algo3.Controladores;

import edu.fiuba.algo3.Vistas.Ventana;
import edu.fiuba.algo3.modelo.Kahoot;
import edu.fiuba.algo3.modelo.correcciones.Respuesta;
import edu.fiuba.algo3.modelo.excepciones.NoTieneExclusividadException;
import edu.fiuba.algo3.modelo.excepciones.NoTieneMultiplicadorException;
import javafx.scene.control.Button;
import javafx.scene.text.TextAlignment;
import org.w3c.dom.Text;

import java.util.ArrayList;

public abstract class ControladorPregunta {
    protected ArrayList<String> opciones;
    protected Respuesta respuestaCorrecta;
    protected ArrayList<Button> botonesOpciones;
    protected Kahoot kahoot;
    protected ArrayList<String> respuestaJugador = new ArrayList<>();

    /*public ControladorPregunta(Kahoot kahoot){
        this.kahoot = kahoot;
    }*/

    public void guardarRespuesta(Button botonOpcion){
        String textoOpcion = botonOpcion.getText();
        if (respuestaJugador.contains(textoOpcion)) {
            respuestaJugador.remove(textoOpcion);
            botonOpcion.setStyle("");
        }
        else {
            respuestaJugador.add(textoOpcion);
            botonOpcion.setStyle("-fx-border-color: #5eba46; -fx-border-width: 5px;");
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
            boton.setWrapText(true);
            boton.setTextAlignment(TextAlignment.CENTER);
            botones.add(boton);
        }
        this.botonesOpciones = botones;
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
            Ventana.mostrarMensajeError("Error", "La cagaste y no tienes multiplicador");
        }
    }

    public void activarMultiplicadorx3() {
        try {
            kahoot.getJugadorActual().activarMultiplicadorx3();
        } catch (NoTieneMultiplicadorException e) {
            Ventana.mostrarMensajeError("Error", "La cagaste y no tienes multiplicador");

            //e.printStackTrace();
        }
    }

    public void activarExclusividad(){
        try {
            kahoot.usarExclusividad(kahoot.getJugadorActual());
        } catch (NoTieneExclusividadException e) {
            Ventana.mostrarMensajeError("Error", "La cagaste y no tienes exclusividad");
            //e.printStackTrace();
        }
    }

    public boolean esPreguntaConPenalidad(){
        return kahoot.esPreguntaConPenalidad();
    }

    public void setGrupo(String text){
        System.out.println("Setee grupo"); //TODO borrar esto despues, es para debuguear
    }

    public void refrescarBotones(){
        this.botonesOpciones.forEach(b -> b.setStyle(""));
    }
}
