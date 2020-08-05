package edu.fiuba.algo3.Controladores;

import edu.fiuba.algo3.Vistas.ContenedorCargaDeNombres;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class controladorComenzar implements EventHandler<ActionEvent> {

    private Stage ventana;

    public controladorComenzar(Stage ventana){
        this.ventana = ventana;
    }

    @Override
    public void handle(ActionEvent actionEvent){
        ContenedorCargaDeNombres contenedorCargaDeNombres = new ContenedorCargaDeNombres(ventana);
        Scene escenaCarga = new Scene(contenedorCargaDeNombres, 550, 400);
        ventana.setScene(escenaCarga);
    }
}


/*package Controladores;

        import Vistas.Contenedores.ContenedorCargaDeNombres;
        import javafx.event.ActionEvent;
        import javafx.event.EventHandler;
        import javafx.scene.ImageCursor;
        import javafx.scene.Scene;
        import javafx.scene.image.Image;
        import javafx.stage.Stage;

public class CargaHandler implements EventHandler<ActionEvent> {

    private Stage ventana;

    public CargaHandler(Stage ventana){
        this.ventana = ventana;
    }

    @Override
    public void handle(ActionEvent actionEvent){
        ContenedorCargaDeNombres contenedorCargaDeNombres = new ContenedorCargaDeNombres(ventana);
        Scene escenaCarga = new Scene(contenedorCargaDeNombres, 550, 400);
        escenaCarga.getStylesheets().add("file:src/Vistas/Contenedores/Carga.css");
        ImageCursor imageCursor = new ImageCursor(new Image("file:///home/agustin/Desktop/git-TP2/TP2-Algochess/Recursos/cursores/cursorManito.png"));
        escenaCarga.setCursor(imageCursor);
        ventana.setScene(escenaCarga);
    }*/