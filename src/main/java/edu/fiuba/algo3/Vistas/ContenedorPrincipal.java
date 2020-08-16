package edu.fiuba.algo3.Vistas;

import edu.fiuba.algo3.Controladores.ControladorJuego;
import javafx.animation.*;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class ContenedorPrincipal extends BorderPane {

        public ContenedorPrincipal(Stage ventana, ControladorJuego controlador) {

            //ventana.setFullScreen(true);

            //Image imagen = new Image("file:Imagenes/fondo_azul.jpg",700,460, true, true);
            //final ImageView imagenVista = new ImageView(imagen);
            //this.getChildren().addAll(imagenVista);

            MediaPlayer media = controlador.getMedia();
            Button botonSonido = new Button("Sonido");
            botonSonido.setOnAction(e ->{
                if (media.getStatus().equals(MediaPlayer.Status.PLAYING)) media.pause();
                else media.play();
            });

            Button botonContinuar = new Button("Continuar");
            PauseTransition delay = new PauseTransition(Duration.seconds(10));
            delay.setOnFinished( event -> {
                Ventana.mostrarMensajeError("Tiempo Finalizado", "Terminó tu tiempo.");
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
            tiempoRestante.progressProperty().bind(segundos.divide(60.0));
            Timeline timeline = new Timeline (
                    new KeyFrame(Duration.ZERO, new KeyValue(segundos, 0)),
                    new KeyFrame(Duration.seconds(60), e-> {
                        // TODO DETENER RELOJ LUEGO DE MENSAJE ERROR
                        Ventana.mostrarMensajeError("Tiempo Finalizado", "Terminó tu tiempo.");
                        botonContinuar.fire();
                    }, new KeyValue(segundos, 60))
            );
            timeline.setCycleCount(Animation.INDEFINITE);
            controlador.setTimer(timeline);
            controlador.comenzar(stackPregunta);

            botonContinuar.setOnAction(e ->{
                controlador.siguienteTurno(stackPregunta);
            });
            tiempoRestante.setMinWidth(430);

            //Region region = new Region();
            //HBox.setHgrow(region, Priority.ALWAYS);

            HBox botonera = new HBox(tiempoRestante, botonContinuar);
            botonera.setPadding(new Insets(30));
            VBox botonOpciones = new VBox (botonSonido);
            botonera.setSpacing(40);
            botonOpciones.setAlignment(Pos.TOP_LEFT);
            this.setBottom(botonera);
            this.setCenter(vBox);
            this.setTop(botonOpciones);
            //timeline.play();
        }

}



