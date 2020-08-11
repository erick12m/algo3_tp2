package edu.fiuba.algo3.Vistas;

import javafx.scene.layout.TilePane;

import java.util.ArrayList;

public abstract class VistaPregunta extends TilePane {
    private String respuesta;
    public ArrayList<String> getRespuesta(){
        ArrayList<String> respuestas = new ArrayList<String>();
        respuestas.add(respuesta);
        return respuestas;
    }
}
