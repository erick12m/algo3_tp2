package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.controladores.ControladorJuego;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class ContenedorPrincipal extends BorderPane {

        public ContenedorPrincipal(ControladorJuego controlador) {
            
            MediaPlayer media = controlador.getMedia();
            Button botonSonido = new Button("Sonido");
            botonSonido.setOnAction(e ->{
                if (media.getStatus().equals(MediaPlayer.Status.PLAYING)) media.pause();
                else media.play();
            });

            Button botonContinuar = new Button("Continuar");

            VBox vBox = crearPanelJugador(controlador);
            StackPane stackPregunta = new StackPane();
            vBox.getChildren().add(stackPregunta);

            ProgressBar tiempoRestante = crearProgressBar(controlador, botonContinuar, stackPregunta);

            botonContinuar.setOnAction(e ->{
                controlador.siguienteTurno(stackPregunta);
            });
            tiempoRestante.setMinWidth(430);

            crearBotonera(botonSonido, botonContinuar, vBox, tiempoRestante);
        }

    private ProgressBar crearProgressBar(ControladorJuego controlador, Button botonContinuar, StackPane stackPregunta) {
        ProgressBar tiempoRestante = new ProgressBar();

        IntegerProperty segundos = new SimpleIntegerProperty();
        tiempoRestante.progressProperty().bind(segundos.divide(25.0));
        Timeline timeline = new Timeline (
                new KeyFrame(Duration.ZERO, new KeyValue(segundos, 0)),
                new KeyFrame(Duration.seconds(25), e-> {
                    Ventana.mostrarMensajeError("Tiempo Finalizado", "Terminó tu tiempo.");
                    botonContinuar.fire();
                }, new KeyValue(segundos, 25))
        );
        timeline.setCycleCount(Animation.INDEFINITE);
        controlador.setTimer(timeline);
        controlador.comenzar(stackPregunta);
        return tiempoRestante;
    }

    private void crearBotonera(Button botonSonido, Button botonContinuar, VBox vBox, ProgressBar tiempoRestante) {
        HBox botonera = new HBox(tiempoRestante, botonContinuar);
        botonera.setPadding(new Insets(30));
        VBox botonOpciones = new VBox (botonSonido);
        botonera.setSpacing(40);
        botonOpciones.setAlignment(Pos.TOP_LEFT);
        this.setBottom(botonera);
        this.setCenter(vBox);
        this.setTop(botonOpciones);
    }

    private VBox crearPanelJugador(ControladorJuego controlador) {
        Label textoTurno = new Label("Turno de ".concat(controlador.jugadorActual()));
        TextoTurno.getInstancia().guardarLabel(textoTurno);
        Rectangle panelJugador = new Rectangle();
        panelJugador.setHeight(50);
        panelJugador.setWidth(640);
        panelJugador.setArcHeight(10);
        panelJugador.setArcWidth(10);
        panelJugador.setFill(Color.TRANSPARENT);
        StackPane stackJugador = new StackPane();
        stackJugador.getChildren().addAll(panelJugador, textoTurno);
        VBox vBox = new VBox();
        vBox.setSpacing(0);
        vBox.setAlignment(Pos.CENTER);
        vBox.getChildren().add(stackJugador);
        return vBox;
    }

}



