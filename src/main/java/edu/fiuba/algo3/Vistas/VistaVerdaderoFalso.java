package edu.fiuba.algo3.Vistas;

import edu.fiuba.algo3.modelo.Kahoot;
import edu.fiuba.algo3.modelo.correcciones.Respuesta;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.TilePane;

import java.util.ArrayList;

public class VistaVerdaderoFalso extends VistaPregunta {
    private String respuesta = "";
    public VistaVerdaderoFalso(Kahoot kahoot, ArrayList<Button> botonesOpciones) {
        this.setOrientation(Orientation.HORIZONTAL);
        this.setTileAlignment(Pos.CENTER);
        this.setPrefTileWidth(320);
        this.setPrefTileHeight(50);
        this.setAlignment(Pos.CENTER);
        this.setPrefColumns(2);
        this.getChildren().addAll(botonesOpciones);
        botonesOpciones.forEach(boton -> {
            boton.setOnAction(e ->{
                    respuesta = boton.getText();
            });
        });
    }

}
