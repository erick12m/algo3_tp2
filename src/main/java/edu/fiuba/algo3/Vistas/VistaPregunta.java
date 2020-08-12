package edu.fiuba.algo3.Vistas;

import edu.fiuba.algo3.Controladores.ControladorPregunta;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

import java.util.ArrayList;

public class VistaPregunta extends VBox {
    private String respuesta;

    public VistaPregunta(ControladorPregunta controladorPregunta) {
        //Visualizacion pregunta
        Rectangle rectangulo = new Rectangle();
        rectangulo.setHeight(150);
        rectangulo.setWidth(640);
        rectangulo.setArcHeight(10);
        rectangulo.setArcWidth(10);
        rectangulo.setFill(Color.TRANSPARENT);
        Text texto = new Text();
        DropShadow ds = new DropShadow();
        ds.setOffsetY(3.0f);
        ds.setColor(Color.color(0.4f, 0.4f, 0.4f));
        texto.setEffect(ds);
        texto.setCache(true);
        texto.setText(controladorPregunta.getNombre() +":\n\n"
                + controladorPregunta.getEnunciado());
        texto.setTextAlignment(TextAlignment.CENTER);
        texto.setFont(Font.font("Tahoma", FontWeight.BOLD, 18));
        texto.setWrappingWidth(600);
        TextoPregunta.getInstancia().guardarLabel(texto);
        StackPane stack = new StackPane();
        //stack.getChildren().addAll(rectangulo,texto);

        //Visualizacion Opciones
        TilePane opciones = new TilePane();
        opciones.setOrientation(Orientation.HORIZONTAL);
        opciones.setTileAlignment(Pos.CENTER);
        opciones.setPrefTileWidth(320);
        opciones.setPrefTileHeight(50);
        opciones.setAlignment(Pos.CENTER);
        opciones.setPrefColumns(2);
        var botonesOpciones = controladorPregunta.getBotonesOpciones();
        opciones.getChildren().addAll(botonesOpciones);
        botonesOpciones.forEach(boton -> {
            boton.setOnAction(e ->{
                respuesta = boton.getText();
            });
        });

        //Visualizacion utilizables
        Button botonMultiplicadorx2 = new Button("x2");
        Button botonMultiplicadorx3 = new Button("x3");
        Button botonExclusividad = new Button("Exclusividad");
        HBox botonera = new HBox(botonExclusividad,botonMultiplicadorx2,botonMultiplicadorx3);

        this.getChildren().addAll(stack,opciones,botonera);
    }

    public ArrayList<String> getRespuesta(){
        ArrayList<String> respuestas = new ArrayList<String>();
        respuestas.add(respuesta);
        return respuestas;
    }
}
