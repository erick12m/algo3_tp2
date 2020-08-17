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
    protected ArrayList<Button> botonesActivos = new ArrayList<>();
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
            this.activarBoton(botonOpcion);
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

    public void activarMultiplicadorx2(Button boton) {
        if (this.tieneUtilizableActivo()){
            Ventana.mostrarMensajeError("Error", "Ya tiene un multiplicador activo");
            return;
        }
        try {
            kahoot.getJugadorActual().activarMultiplicadorx2();
            this.activarBoton(boton);
        } catch (NoTieneMultiplicadorException e) {
            Ventana.mostrarMensajeError("Error", "La cagaste y no tienes multiplicador");
        }
    }

    private boolean tieneUtilizableActivo() {
        return !this.botonesActivos.isEmpty();
    }

    public void activarBoton(Button boton) {
        this.botonesActivos.add(boton);
        boton.setStyle("-fx-border-color: #5eba46; -fx-border-width: 2px;");
    }

    public void activarMultiplicadorx3(Button boton) {
        if (this.tieneUtilizableActivo()){
            Ventana.mostrarMensajeError("Error", "Ya tiene un multiplicador activo");
            return;
        }
        try {
            kahoot.getJugadorActual().activarMultiplicadorx3();
            this.activarBoton(boton);
        } catch (NoTieneMultiplicadorException e) {
            Ventana.mostrarMensajeError("Error", "La cagaste y no tienes multiplicador");

            //e.printStackTrace();
        }
    }


    public void activarExclusividad(Button boton){
        if (this.tieneUtilizableActivo()){
            Ventana.mostrarMensajeError("Error", "Ya tiene exclusividad activo");
            return;
        }
        try {
            kahoot.usarExclusividad(kahoot.getJugadorActual());
            this.activarBoton(boton);
        } catch (NoTieneExclusividadException e) {
            Ventana.mostrarMensajeError("Error", "La cagaste y no tienes exclusividad");
            //e.printStackTrace();
        }
    }

    public boolean esPreguntaConPenalidad(){
        return kahoot.esPreguntaConPenalidad();
    }

    public void setGrupo(Button botonGrupo){
        System.out.println("Setee grupo"); //TODO borrar esto despues, es para debuguear
    }
    public void refrescarOpciones(){
        this.botonesOpciones.forEach(b -> b.setStyle(""));
    }

    public void refrescarUtilizables(){
        this.botonesActivos.forEach(b -> b.setStyle(""));
    }

    public void refrescarBotones(){
        this.refrescarOpciones();
        this.refrescarUtilizables();
    }
}
