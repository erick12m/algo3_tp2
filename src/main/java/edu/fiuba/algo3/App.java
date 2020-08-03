package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.Kahoot;
import edu.fiuba.algo3.modelo.correccion.CorrectorClasico;
import edu.fiuba.algo3.modelo.correccion.Respuesta;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.preguntas.MultipleChoice;
import edu.fiuba.algo3.modelo.preguntas.VerdaderoFalso;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        //var javaVersion = SystemInfo.javaVersion();
        //var javafxVersion = SystemInfo.javafxVersion();

        //var label = new Label("Hello World, JavaFX " + javafxVersion + ", running on Java " + javaVersion + ".");
        //var scene = new Scene(new StackPane(label), 640, 480);
        //stage.setScene(scene);
        //stage.show();
        //Creating an array of Buttons
        var jugador1 = new Jugador("Rafael");
        var opciones = new ArrayList<String>();
        opciones.add("1");
        opciones.add("2");
        opciones.add("3");
        opciones.add("4");
        ArrayList<String> respuesta = new ArrayList<String>();
        respuesta.add("Verdadero");

        CorrectorClasico clasico = new CorrectorClasico();
        Respuesta respuestaCorrecta = new Respuesta(respuesta);

        jugador1.respuestaElegida(respuestaCorrecta); //El jugador eligio la respuesta Verdadero

        MultipleChoice verdaderoFalso = new MultipleChoice("Seleccione los numeros pares", respuestaCorrecta, opciones, clasico);
        ArrayList<Button> botones = new ArrayList<Button>();
        for (String opcion : verdaderoFalso.getOpciones()){
            var boton = new Button(opcion);
            boton.setMinWidth(100);
            boton.setMinHeight(50);
            botones.add(boton);
        }
        //Creating a Tile Pane
        TilePane tilePane = new TilePane();
        Rectangle rectangulo = new Rectangle();
        rectangulo.setHeight(150);
        rectangulo.setWidth(200);
        rectangulo.setArcHeight(10);
        rectangulo.setArcWidth(10);
        rectangulo.setFill(Color.LIGHTGRAY);

        //Instantiating the VBox class
        VBox vBox = new VBox();

        //Setting the space between the nodes of a VBox pane
        vBox.setSpacing(10);
        vBox.setAlignment(Pos.CENTER);
        Text texto = new Text();
        texto.setText(verdaderoFalso.getEnunciado());
        StackPane stack = new StackPane();
        stack.getChildren().addAll(rectangulo,texto);
        //Setting the orientation for the Tile Pane
        tilePane.setOrientation(Orientation.HORIZONTAL);
        //Setting the alignment for the Tile Pane
        tilePane.setTileAlignment(Pos.CENTER);
        tilePane.setPrefTileWidth(100);
        tilePane.setPrefTileHeight(50);
        tilePane.setAlignment(Pos.CENTER);

        //Setting the preferred columns for the Tile Pane
        tilePane.setPrefColumns(2);

        //Retrieving the observable list of the Tile Pane
        ObservableList list = tilePane.getChildren();

        //Adding the array of buttons to the pane
        list.addAll(botones);

        ObservableList lista2 = vBox.getChildren();
        lista2.addAll(stack,tilePane);

        //Creating a scene object
        Scene scene = new Scene(vBox);

        //Setting title to the Stage
        stage.setTitle("Tile Pane Example");

        //Adding scene to the stage
        stage.setScene(scene);

        //Displaying the contents of the stage
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}