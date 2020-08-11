package edu.fiuba.algo3.Vistas;

import edu.fiuba.algo3.Vistas.ContenedorPrincipal;
import edu.fiuba.algo3.Controladores.controladorTexto;
import edu.fiuba.algo3.modelo.Kahoot;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ContenedorCargaDeNombres extends BorderPane {

    public ContenedorCargaDeNombres(Stage ventana){

        Image imagen = new Image("file:Imagenes/fondo_abstracto.jpg",640,460, true, true);
        final ImageView imagenVista = new ImageView(imagen);
        this.getChildren().addAll(imagenVista);

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
        botonJugar.setOnAction(e -> {
            if (nombreJugador1.getText().equals("") ||  nombreJugador2.getText().equals("")){
                VentanaError.mostrar("Error", "Ambos jugadores deben tener un nombre");
            }
            else{
                Kahoot kahoot = new Kahoot();
                kahoot.crearJugadores(nombreJugador1.getText(), nombreJugador2.getText());
                ContenedorPrincipal contenedorPrincipal = new ContenedorPrincipal(ventana, kahoot);
                Scene juego = new Scene(contenedorPrincipal, 640, 359);
                ventana.setScene(juego);

            }
        }); //Cuanto tocamos esto tenemos que chequear que los nombres esten bien

        controladorTexto textoEventHandler = new controladorTexto(botonJugar);
        nombreJugador1.setOnKeyPressed(textoEventHandler);
        nombreJugador2.setOnKeyPressed(textoEventHandler);

        VBox botoneraCarga = new VBox(40, hBoxJugador1, hBoxJugador2, botonJugar, botonSalir);
        botoneraCarga.setAlignment(Pos.CENTER);//alinea los botones principales
        this.setCenter(botoneraCarga);

    }

}





