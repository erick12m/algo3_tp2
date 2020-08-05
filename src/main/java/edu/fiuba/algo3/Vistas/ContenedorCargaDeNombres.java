package edu.fiuba.algo3.Vistas;

import edu.fiuba.algo3.Controladores.controladorTexto;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ContenedorCargaDeNombres extends BorderPane {

    public ContenedorCargaDeNombres(Stage ventana){
        TextField nombreJugador1 = new TextField();
        TextField nombreJugador2 = new TextField();
        nombreJugador1.setPromptText("Nombre jugador 1");
        nombreJugador1.setPromptText("Nombre jugador 1");
        nombreJugador1.setMaxWidth(200);
        nombreJugador2.setMaxWidth(200);
        Button botonSalir = new Button("Salir");
        Button botonJugar = new Button("Jugar");

        //Acciones botones
        botonSalir.setOnAction(e -> ventana.close());

        controladorTexto textoEventHandler = new controladorTexto(botonJugar);
        nombreJugador1.setOnKeyPressed(textoEventHandler);
        nombreJugador2.setOnKeyPressed(textoEventHandler);

        VBox botoneraCarga = new VBox(40, nombreJugador1, nombreJugador2, botonJugar, botonSalir);
        botoneraCarga.setAlignment(Pos.CENTER);//alinea los botones principales
        this.setCenter(botoneraCarga);


    }

}





