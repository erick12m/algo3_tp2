package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.MusicPlayer;
import edu.fiuba.algo3.controladores.eventos.EventHandlerComenzar;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

public class ContenedorComenzar extends StackPane {

    public ContenedorComenzar(Stage primaryStage){

        //MediaPlayer media = this.iniciarMusica();
        MediaPlayer media = MusicPlayer.reproducirCancion("Africa_toto.mp3");

        //Creo los botones
        Button botonComenzar = new Button("Comenzar");
        Button botonSalir = new Button("Salir");
        Button botonSonido = new Button("Sonido");

        //Seteo las acciones
        EventHandlerComenzar eventoComenzar = new EventHandlerComenzar(primaryStage, media);
        botonComenzar.setOnAction(eventoComenzar);
        botonSalir.setOnAction(e -> primaryStage.close());
        botonSonido.setOnAction(e ->{
            if (media.getStatus().equals(MediaPlayer.Status.PLAYING)) media.pause();
            else media.play();
        });

        HBox botoneraPrincipal = new HBox(40, botonComenzar, botonSalir);
        HBox botoneraSecundaria = new HBox(300, botonSonido);
        BorderPane border = new BorderPane();
        border.setTop(botoneraSecundaria);
        border.setCenter(botoneraPrincipal);

        //Alineaciones
        botoneraPrincipal.setAlignment(Pos.BOTTOM_CENTER); //alinea los botones principales
        botoneraSecundaria.setPadding(new Insets(10)); //separa los botones secundarios de la ventana
        botoneraSecundaria.setAlignment(Pos.TOP_LEFT); //alinea los botones secundarios
        this.getChildren().add(border);
        this.getStylesheets().add("file:CSS/escenaComenzar.css");
    }
}