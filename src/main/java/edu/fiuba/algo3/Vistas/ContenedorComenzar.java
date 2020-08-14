package edu.fiuba.algo3.Vistas;

import edu.fiuba.algo3.Vistas.eventos.EventHandlerComenzar;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.io.File;

import static javafx.scene.media.MediaPlayer.INDEFINITE;


public class ContenedorComenzar extends StackPane {

    public ContenedorComenzar(Stage primaryStage){

        MediaPlayer media = this.iniciarMusica();


        //Creo los botones
        Button botonComenzar = new Button("Comenzar");
        Button botonSalir = new Button("Salir");
        Button botonSonido = new Button("Sonido");

        //Seteo las acciones
        EventHandlerComenzar eventoComenzar = new EventHandlerComenzar(primaryStage);
        botonComenzar.setOnAction(eventoComenzar);
        botonSalir.setOnAction(e -> primaryStage.close());
        botonSonido.setOnAction(e ->{
            if (media.getStatus().equals(MediaPlayer.Status.PLAYING)) media.pause();
            else media.play();
        });



        Image imagen = new Image("file:Imagenes/logo_kahoot.jpeg",640,360,true,true);
        final ImageView imagenVista = new ImageView(imagen);
        VBox botoneraPrincipal = new VBox(40, botonComenzar, botonSalir);
        HBox botoneraSecundaria = new HBox(300, botonSonido);
        BorderPane border = new BorderPane();
        border.setTop(botoneraSecundaria);
        border.setBottom(botoneraPrincipal);
        //Alineaciones
        botoneraPrincipal.setAlignment(Pos.CENTER); //alinea los botones principales
        botoneraSecundaria.setPadding(new Insets(10)); //separa los botones secundarios de la ventana
        botoneraSecundaria.setAlignment(Pos.TOP_CENTER); //alinea los botones secundarios


        this.getChildren().addAll(imagenVista,border);

    }

    public MediaPlayer iniciarMusica(){
        String musicFile = "Musica/Pibe_cantina.mp3";
        Media sound = new Media(new File(musicFile).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.play();
        mediaPlayer.setVolume(0.7);
        mediaPlayer.setCycleCount(INDEFINITE);
        return mediaPlayer;
    }

}