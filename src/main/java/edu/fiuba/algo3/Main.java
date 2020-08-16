package edu.fiuba.algo3;

import edu.fiuba.algo3.Vistas.ContenedorComenzar;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage){

        ContenedorComenzar contenedorComenzar = new ContenedorComenzar(primaryStage);

        primaryStage.setTitle("AlgoHoot");
        Scene escena = new Scene(contenedorComenzar, 640, 359);
        primaryStage.setScene(escena);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}