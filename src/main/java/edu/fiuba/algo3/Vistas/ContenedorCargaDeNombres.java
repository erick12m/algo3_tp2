package edu.fiuba.algo3.Vistas;

import edu.fiuba.algo3.Controladores.ControladorJuego;
import edu.fiuba.algo3.Vistas.eventos.EventHandlerTeclado;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ContenedorCargaDeNombres extends BorderPane {
    private MediaPlayer media;

    public ContenedorCargaDeNombres(Stage ventana, MediaPlayer media){
        ControladorJuego controladorJuego = new ControladorJuego(ventana);
        controladorJuego.setAudio(media);
        //Imagen de Fondo de la escena
        Image imagen = new Image("file:Imagenes/fondo_abstracto.jpg",640,460, true, true);
        final ImageView imagenVista = new ImageView(imagen);
        this.getChildren().addAll(imagenVista);




        //Solicitud de nombres a los jugadores
        Text instruccionesJugador1 = new Text("Nombre jugador 1:");
        Text instruccionesJugador2 = new Text("Nombre jugador 2:");
        TextField nombreJugador1 = new TextField();
        TextField nombreJugador2 = new TextField();
        nombreJugador1.setMaxWidth(200);
        nombreJugador2.setMaxWidth(200);
        HBox hBoxJugador1 = new HBox(10, instruccionesJugador1,nombreJugador1);
        hBoxJugador1.setAlignment(Pos.CENTER);
        HBox hBoxJugador2 = new HBox(10,instruccionesJugador2,nombreJugador2);
        hBoxJugador2.setAlignment(Pos.CENTER);
        Button botonSalir = new Button("Salir");
        Button botonJugar = new Button("Jugar");
        Button botonSonido = new Button("Sonido");

        //Acciones botones y teclado
        botonSalir.setOnAction(e -> ventana.close());
        botonJugar.setOnAction(e -> { controladorJuego.iniciarJuego(nombreJugador1.getText()
                ,nombreJugador2.getText()); });

        botonSonido.setOnAction(e ->{
            if (media.getStatus().equals(MediaPlayer.Status.PLAYING)) media.pause();
            else media.play();
        });

        EventHandlerTeclado eventoTeclado = new EventHandlerTeclado(botonJugar);
        nombreJugador1.setOnKeyPressed(eventoTeclado);
        nombreJugador2.setOnKeyPressed(eventoTeclado);

        VBox botoneraCarga = new VBox(40, hBoxJugador1, hBoxJugador2, botonJugar, botonSalir, botonSonido);
        botoneraCarga.setAlignment(Pos.CENTER);//alinea los botones principales

        this.setCenter(botoneraCarga);

    }
}





