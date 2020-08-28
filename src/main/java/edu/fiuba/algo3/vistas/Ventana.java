package edu.fiuba.algo3.vistas;

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

public class Ventana {

    public static void mostrarGanador(String nombreGanador, Stage ventanaJuego){

        Stage ventana = new Stage();

        ventana.initModality(Modality.APPLICATION_MODAL);

        Label label = (nombreGanador.equals("Empate")) ? new Label("Empate !") : new Label("El " +
                "ganador es: ".concat(nombreGanador));

        Button boton = new Button("Finalizar");

        boton.setOnAction(e ->{
            ventana.close();
            ventanaJuego.close();
        });

        VBox layout = new VBox(10, label, boton);
        layout.setAlignment(Pos.CENTER);
        Scene scene = new Scene(layout, 400 ,300);
        scene.getStylesheets().add("file:CSS/ventanaGanador.css");

        ventana.setScene(scene);
        ventana.show();

    }

    public static void mostrarMensajeError(String titulo, String mensaje){
        PauseTransition delay = new PauseTransition(Duration.seconds(5));
        Stage ventana = new Stage();

        ventana.initModality(Modality.APPLICATION_MODAL);
        ventana.setTitle(titulo);

        Label label = new Label("Mensaje");
        label.setText(mensaje);

        Button botonOK = new Button("Ok");
        botonOK.setOnAction(e -> ventana.close());
        delay.setOnFinished( event -> botonOK.fire());

        VBox layout = new VBox(10, label, botonOK);
        layout.setAlignment(Pos.CENTER);
        Scene scene = new Scene(layout, 400 ,300);
        scene.getStylesheets().add("file:CSS/ventanaAlerta.css");
        ventana.setScene(scene);
        delay.play();
        ventana.show();

    }

    public static void mostrarRespuestaCorrecta(String mensaje,String puntajes, Timeline timer){
        timer.stop();
        Stage ventana = new Stage();
        Button botonCerrar = new Button("Cerrar");
        ventana.setWidth(500);

        botonCerrar.setOnAction(e ->{
            ventana.close();
            timer.play();
        });

        ventana.initModality(Modality.APPLICATION_MODAL);
        ventana.setTitle("Respuesta Correcta");

        Label label = new Label(mensaje);
        Label label2= new Label(puntajes);

        VBox layout = new VBox(10, label, label2, botonCerrar);
        layout.setAlignment(Pos.CENTER);
        Scene scene = new Scene(layout, 400 ,300);
        scene.getStylesheets().add("file:CSS/ventanaAlerta.css");
        ventana.setScene(scene);
        ventana.show();
    }
}
