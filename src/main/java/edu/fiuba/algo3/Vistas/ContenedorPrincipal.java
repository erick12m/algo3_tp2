package edu.fiuba.algo3.Vistas;

import edu.fiuba.algo3.Controladores.ControladorPregunta;
import edu.fiuba.algo3.Vistas.VentanaError;
import edu.fiuba.algo3.modelo.excepciones.NoTieneMultiplicadorException;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.animation.PauseTransition;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

import edu.fiuba.algo3.modelo.Kahoot;
import edu.fiuba.algo3.modelo.excepciones.GameOverException;
import edu.fiuba.algo3.modelo.excepciones.RondaFinalizadaException;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.ArrayList;

public class ContenedorPrincipal extends BorderPane {
        private final String VERDADEROFALSO = "Verdadero o Falso";
        private final String ORDEREDCHOICE = "Ordered Choice";
        private final String MULTIPLECHOICE = "Multiple Choice";
        private final String GROUPCHOICE = "Group Choice";
        public ContenedorPrincipal(Stage ventana, Kahoot kahoot) {
            ControladorPregunta controladorPregunta = new ControladorPregunta(kahoot);

            Image imagen = new Image("file:Imagenes/fondo_azul.jpg",640,460, true, true);
            final ImageView imagenVista = new ImageView(imagen);
            this.getChildren().addAll(imagenVista);

            Button botonMultiplicadorx2 = new Button("x2");
            Button botonMultiplicadorx3 = new Button("x3");
            Button botonExclusividad = new Button("Exclusividad");
            Button botonContinuar = new Button("Continuar");
            Button botonGrupo1 = new Button("Grupo 1");
            Button botonGrupo2 = new Button("Grupo 2");
            Button botonPrueba = new Button("Probando");

            botonPrueba.setOnAction(e ->{
                System.out.println(botonPrueba.getText());
            });
            PauseTransition delay = new PauseTransition(Duration.seconds(5));
            delay.setOnFinished( event -> {
                VentanaError.mostrar("Tiempo Finalizado", "Terminó tu tiempo.");
                botonContinuar.fire();
            });
            VistaPregunta vistaPregunta = new VistaPregunta(controladorPregunta);
            switch (kahoot.getPreguntaActual().getNombre()){
                case VERDADEROFALSO:
                    //vistaPregunta = new VistaVerdaderoFalso(kahoot, controladorPregunta.getBotonesOpciones());
                    break;
                case MULTIPLECHOICE:
                    break;
                case ORDEREDCHOICE:
                    break;
                case GROUPCHOICE:
                    break;
            }

            //Acciones botones
            botonMultiplicadorx2.setOnAction(e ->{
                try{
                   kahoot.getJugadorActual().activarMultiplicadorx2();
                } catch (NoTieneMultiplicadorException noTieneMultiplicadorException) {
                    VentanaError.mostrar("", "El jugador no posee multiplicadores x2");
                }
            });

            botonMultiplicadorx2.setOnAction(e ->{
                try{
                    kahoot.getJugadorActual().activarMultiplicadorx3();
                } catch (NoTieneMultiplicadorException noTieneMultiplicadorException) {
                    VentanaError.mostrar("", "El jugador no posee multiplicadores x3");
                }
            });

            Label textoTurno = new Label("Turno de ".concat(kahoot.getJugadorActual().getNombre()));
            TextoTurno.getInstancia().guardarLabel(textoTurno);



            //botonExclusividad.setVisible(false);
            //botonMultiplicadorx2.setVisible(false);
            //botonMultiplicadorx3.setVisible(false);
            //try {
            //    kahoot.siguientePregunta();
            //} catch (GameOverException e) {

            //}
            //kahoot.crearJugadores("Pablo", "Rafael");
            var pregunta = kahoot.getPreguntaActual();

            //Seteando visibilidad de los utilizables del jugador
            if (pregunta.tienePenalidad()){
                botonMultiplicadorx2.setVisible(true);
                botonMultiplicadorx3.setVisible(true);
                botonExclusividad.setVisible(false);
            }

            else{
                botonMultiplicadorx2.setVisible(false);
                botonMultiplicadorx3.setVisible(false);
                botonExclusividad.setVisible(true);
            }

            /*try{
                kahoot.siguienteJugador();
            } catch (RondaFinalizadaException e){

            }*/
            var jugador = kahoot.getJugadorActual();
            TilePane tilePane = new TilePane();
            Rectangle rectangulo = new Rectangle();
            rectangulo.setHeight(150);
            rectangulo.setWidth(640);
            rectangulo.setArcHeight(10);
            rectangulo.setArcWidth(10);
            //rectangulo.setFill(Color.web("#0231B3"));
            rectangulo.setFill(Color.TRANSPARENT);
            ArrayList<Button> botones = new ArrayList<Button>();
            for (String opcion : pregunta.getOpciones()){
                var boton = new Button(opcion);
                boton.setMinWidth(320);
                boton.setMinHeight(50);
                botones.add(boton);
            }
            Rectangle panelJugador = new Rectangle();
            panelJugador.setHeight(50);
            panelJugador.setWidth(640);
            panelJugador.setArcHeight(10);
            panelJugador.setArcWidth(10);
            //panelJugador.setFill(Color.web("#0F50FF"));
            panelJugador.setFill(Color.TRANSPARENT);
            VBox vBox = new VBox();

            //Setting the space between the nodes of a VBox pane
            vBox.setSpacing(0);
            vBox.setAlignment(Pos.CENTER);

            Text texto = new Text();

            DropShadow ds = new DropShadow();
            ds.setOffsetY(3.0f);
            ds.setColor(Color.color(0.4f, 0.4f, 0.4f));

            texto.setEffect(ds);
            texto.setCache(true);
            texto.setText(pregunta.getNombre() +":\n\n" + pregunta.getEnunciado());
            texto.setTextAlignment(TextAlignment.CENTER);
            texto.setFont(Font.font("Tahoma", FontWeight.BOLD, 18));
            texto.setWrappingWidth(600);
            StackPane stack = new StackPane();
            stack.getChildren().addAll(rectangulo,texto);


            StackPane stackJugador = new StackPane();
            stackJugador.getChildren().addAll(panelJugador, textoTurno);

            //Setting the orientation for the Tile Pane
            tilePane.setOrientation(Orientation.HORIZONTAL);
            //Setting the alignment for the Tile Pane
            tilePane.setTileAlignment(Pos.CENTER);
            tilePane.setPrefTileWidth(320);
            tilePane.setPrefTileHeight(50);
            tilePane.setAlignment(Pos.CENTER);
            tilePane.setPrefColumns(2);

            vBox.getChildren().addAll(stackJugador, stack, vistaPregunta);
            botonContinuar.setOnAction(e ->{
                try {
                    kahoot.siguienteJugador();
                    TextoTurno.getInstancia().actualizarLabel(kahoot);
                } catch (RondaFinalizadaException rondaFinalizadaException) {
                    //ControladorPreguntas
                    //Respuesta Correcta
                    VentanaRespuestaCorrecta.mostrar("La respuesta correcta esta en tu corazon");
                    try {
                        kahoot.siguientePregunta();
                        TextoTurno.getInstancia().actualizarLabel(kahoot);
                    } catch (GameOverException gameOverException) {
                        VentanaError.mostrar("", "Finalizó el juego");
                        ventana.close();
                    }
                    VentanaError.mostrar("", "Nueva Pregunta");
                }
            });


            HBox botonera = new HBox(botonExclusividad, botonMultiplicadorx2, botonMultiplicadorx3, botonContinuar, botonPrueba);
            botonera.setSpacing(10);
            this.setBottom(botonera);





            this.setCenter(vBox);
            delay.play();

        }

}



