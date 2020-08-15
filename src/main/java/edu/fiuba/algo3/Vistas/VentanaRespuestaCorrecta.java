package edu.fiuba.algo3.Vistas;

import javafx.animation.PauseTransition;
import javafx.animation.Timeline;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;

public class VentanaRespuestaCorrecta {
    public static void mostrar(String mensaje,String puntajes, Timeline timer){
        timer.stop();
        Stage ventana = new Stage();
        PauseTransition delay = new PauseTransition(Duration.seconds(5));
        Button botonCerrar = new Button("Cerrar");
        botonCerrar.setOnAction(e ->{
            ventana.close();
            timer.play();
        });
        delay.setOnFinished( event -> botonCerrar.fire());

        ventana.initModality(Modality.APPLICATION_MODAL);
        ventana.setTitle("Respuesta Correcta");

        Label label = new Label(mensaje);
        Label label2= new Label(puntajes);

        VBox layout = new VBox(10, label, label2, botonCerrar);
        layout.setAlignment(Pos.CENTER);
        Scene scene = new Scene(layout, 400 ,300);

        ventana.setScene(scene);
        delay.play();
        ventana.show();

    }
}
