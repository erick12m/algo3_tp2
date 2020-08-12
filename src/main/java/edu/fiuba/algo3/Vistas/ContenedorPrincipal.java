package edu.fiuba.algo3.Vistas;

import edu.fiuba.algo3.Controladores.ControladorJuego;
import javafx.animation.*;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class ContenedorPrincipal extends BorderPane {
        public ContenedorPrincipal(Stage ventana, ControladorJuego controlador) {
            Image imagen = new Image("file:Imagenes/fondo_azul.jpg",640,460, true, true);
            final ImageView imagenVista = new ImageView(imagen);
            this.getChildren().addAll(imagenVista);
            Button botonContinuar = new Button("Continuar");
            PauseTransition delay = new PauseTransition(Duration.seconds(10));
            delay.setOnFinished( event -> {
                VentanaMensaje.mostrar("Tiempo Finalizado", "Terminó tu tiempo.");
                botonContinuar.fire();
            });

            Label textoTurno = new Label("Turno de ".concat(controlador.jugadorActual()));
            TextoTurno.getInstancia().guardarLabel(textoTurno);
            //VistaPregunta vistaPregunta = new VistaPregunta(controlador);
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
            StackPane stackPregunta = new StackPane();
            vBox.getChildren().add(stackPregunta);

            ProgressBar tiempoRestante = new ProgressBar();
            IntegerProperty segundos = new SimpleIntegerProperty();
            tiempoRestante.progressProperty().bind(segundos.divide(10.0));
            Timeline timeline = new Timeline(
                    new KeyFrame(Duration.ZERO, new KeyValue(segundos, 0)),
                    new KeyFrame(Duration.seconds(10), e-> {
                        VentanaMensaje.mostrar("Tiempo Finalizado", "Terminó tu tiempo.");
                        botonContinuar.fire();
                    }, new KeyValue(segundos, 10))
            );
            timeline.setCycleCount(Animation.INDEFINITE);
            controlador.setTimer(timeline);
            controlador.comenzar(stackPregunta);




            botonContinuar.setOnAction(e ->{
                //timeline.stop();
                controlador.siguienteTurno(stackPregunta);
                //timeline.play();
            });
            tiempoRestante.setMinWidth(530);
            HBox botonera = new HBox(tiempoRestante,botonContinuar);
            botonera.setSpacing(30);
            this.setBottom(botonera);





            this.setCenter(vBox);
            //timeline.play();

        }

}



