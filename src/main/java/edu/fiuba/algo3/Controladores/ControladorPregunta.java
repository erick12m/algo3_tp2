package edu.fiuba.algo3.Controladores;

import edu.fiuba.algo3.modelo.Kahoot;
import edu.fiuba.algo3.modelo.correcciones.Respuesta;
import edu.fiuba.algo3.modelo.excepciones.GameOverException;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import javafx.scene.control.Button;

import java.util.ArrayList;

public class ControladorPregunta {
    //Pregunta pregunta;
    ArrayList<String> opciones;
    Respuesta respuestaCorrecta;
    Kahoot kahoot;

    public ControladorPregunta(Kahoot kahoot){
        this.kahoot = kahoot;
    }

    public void siguientePregunta() throws GameOverException {
        kahoot.siguientePregunta();
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



}
