package edu.fiuba.algo3.Controladores;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class controladorTexto implements EventHandler<KeyEvent> {
    private Button botonJugar;

    public controladorTexto(Button botonJugar){
        this.botonJugar = botonJugar;
    }

    @Override
    public void handle(KeyEvent event){
        if (event.getCode() == KeyCode.ENTER){
            Event.fireEvent(botonJugar, new ActionEvent());
        }
    }
}
