package edu.fiuba.algo3.Vistas;

import edu.fiuba.algo3.Controladores.controladorTexto;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ContenedorCargaDeNombres extends BorderPane {

    public ContenedorCargaDeNombres(Stage ventana){
        Text instruccionesJugador1 = new Text("Nombre jugador 1:");
        Text instruccionesJugador2 = new Text("Nombre jugador 2:");
        TextField nombreJugador1 = new TextField();
        TextField nombreJugador2 = new TextField();
        // TODO no muestra la etiqueta en el textfield
        //nombreJugador1.setPromptText("Nombre jugador 1");
        //nombreJugador1.setPromptText("Nombre jugador 1");
        nombreJugador1.setMaxWidth(200);
        nombreJugador2.setMaxWidth(200);
        HBox hBoxJugador1 = new HBox(10, instruccionesJugador1,nombreJugador1);
        hBoxJugador1.setAlignment(Pos.CENTER);
        HBox hBoxJugador2 = new HBox(10,instruccionesJugador2,nombreJugador2);
        hBoxJugador2.setAlignment(Pos.CENTER);
        Button botonSalir = new Button("Salir");
        Button botonJugar = new Button("Jugar");

        //Acciones botones
        botonSalir.setOnAction(e -> ventana.close());

        controladorTexto textoEventHandler = new controladorTexto(botonJugar);
        nombreJugador1.setOnKeyPressed(textoEventHandler);
        nombreJugador2.setOnKeyPressed(textoEventHandler);

        VBox botoneraCarga = new VBox(40, hBoxJugador1, hBoxJugador2, botonJugar, botonSalir);
        botoneraCarga.setAlignment(Pos.CENTER);//alinea los botones principales
        this.setCenter(botoneraCarga);


    }

}





