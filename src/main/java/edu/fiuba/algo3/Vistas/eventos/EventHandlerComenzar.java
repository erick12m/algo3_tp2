package edu.fiuba.algo3.Vistas.eventos;

import edu.fiuba.algo3.Vistas.ContenedorCargaDeNombres;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class EventHandlerComenzar implements EventHandler<ActionEvent> {

    private Stage ventana;



    public EventHandlerComenzar(Stage ventana){
        this.ventana = ventana;
    }

    @Override
    public void handle(ActionEvent actionEvent){
        ContenedorCargaDeNombres contenedorCargaDeNombres = new ContenedorCargaDeNombres(ventana);
        Scene escenaCarga = new Scene(contenedorCargaDeNombres, 640, 359);
        ventana.setScene(escenaCarga);
    }
}
