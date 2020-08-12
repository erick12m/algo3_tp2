package edu.fiuba.algo3.Vistas.eventos;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class EventHandlerTeclado implements EventHandler<KeyEvent> {
    private Button botonJugar;
    public EventHandlerTeclado(Button botonJugar) {
        this.botonJugar = botonJugar;
    }



    @Override
    public void handle(KeyEvent keyEvent) {
        if (keyEvent.getCode() == KeyCode.ENTER){
            Event.fireEvent(botonJugar, new ActionEvent());
        }
    }
}
