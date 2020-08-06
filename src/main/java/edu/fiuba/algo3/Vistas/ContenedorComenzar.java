package edu.fiuba.algo3.Vistas;

import edu.fiuba.algo3.Controladores.controladorComenzar;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ContenedorComenzar extends StackPane {

    public ContenedorComenzar(Stage primaryStage){

        //Creo los botones
        Button botonComenzar = new Button("Comenzar");
        Button botonSalir = new Button("Salir");
        Button botonSonido = new Button("Sonido");
        //botonSonido.setSelected(true);

        //Seteo las acciones
        controladorComenzar controladorCarga = new controladorComenzar(primaryStage);
        botonComenzar.setOnAction(controladorCarga);
        botonSalir.setOnAction(e -> primaryStage.close());
        //botonSonido.setOnAction(e -> mediaPlayer.pause());

        Image imagen = new Image("file:Imagenes/logo_kahoot.jpeg",640,359,true,true);
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

}