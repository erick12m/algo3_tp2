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

        primaryStage.setTitle("AlgoChess");
        Scene escena = new Scene(contenedorComenzar, 640, 359);
        primaryStage.setScene(escena);
        primaryStage.getIcons().add(new Image("file:Imagenes/logo_kahoot.jpeg"));
        primaryStage.show();
        primaryStage.setResizable(false);

    }

    public static void main(String[] args) {
        launch(args);
    }


}


/*package Vistas;

        import Vistas.Contenedores.ContenedorComenzar;
        import javafx.application.Application;
        import javafx.scene.ImageCursor;
        import javafx.scene.Scene;
        import javafx.scene.image.Image;
        import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage){

        ContenedorComenzar contenedorComenzar = new ContenedorComenzar(primaryStage);

        primaryStage.setTitle("AlgoChess");
        Scene escena = new Scene(contenedorComenzar, 550, 400);
        escena.getStylesheets().add("file:src/Vistas/Contenedores/Carga.css");
        ImageCursor imageCursor = new ImageCursor(new Image("file:///home/agustin/Desktop/git-TP2/TP2-Algochess/Recursos/cursores/cursorManito.png"));
        escena.setCursor(imageCursor);
        primaryStage.setScene(escena);
        primaryStage.getIcons().add(new Image("file:Recursos/Logo/AutoChessLogo.png"));
        primaryStage.show();
        primaryStage.setResizable(false);

    }


    public static void main(String[] args) {
        launch(args);
    }
}*/