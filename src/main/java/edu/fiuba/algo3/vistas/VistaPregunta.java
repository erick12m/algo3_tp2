package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.controladores.ControladorPregunta;
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

import java.util.Collections;

public class VistaPregunta extends VBox {

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
        texto.setFont(Font.font("Montserrat", FontWeight.BOLD, 18));
        texto.setWrappingWidth(600);
        TextoPregunta.getInstancia().guardarLabel(texto);
        StackPane stack = new StackPane();
        stack.getChildren().addAll(rectangulo,texto);

        //Visualizacion Opciones
        TilePane opciones = new TilePane();
        opciones.setOrientation(Orientation.HORIZONTAL);
        opciones.setTileAlignment(Pos.CENTER);
        opciones.setPrefTileWidth(320);
        opciones.setPrefTileHeight(60);
        opciones.setAlignment(Pos.CENTER);
        opciones.setPrefColumns(2);
        var botonesOpciones = controladorPregunta.getBotonesOpciones();
        Collections.shuffle(botonesOpciones);
        botonesOpciones.forEach(b -> b.setStyle(""));
        opciones.getChildren().addAll(botonesOpciones);
        botonesOpciones.forEach(boton -> {
            boton.setOnAction(e ->{
                controladorPregunta.guardarRespuesta(boton);
            });
        });

        //Botones utilizables
        Button botonGrupo1 = new Button("Grupo 1");
        Button botonGrupo2 = new Button("Grupo 2");
        Button botonMultiplicadorx2 = new Button("x2");
        Button botonMultiplicadorx3 = new Button("x3");
        Button botonExclusividad = new Button("Exclusividad");

        //Seteo acciones de los botones especiales
        botonGrupo1.setOnAction(e ->{
            controladorPregunta.setGrupo(botonGrupo1);
        });

        botonGrupo2.setOnAction(e ->{
            controladorPregunta.setGrupo(botonGrupo2);
        });

        botonMultiplicadorx2.setOnAction(e ->{
            controladorPregunta.activarMultiplicadorx2(botonMultiplicadorx2);
        });
        botonMultiplicadorx3.setOnAction(e ->{
            controladorPregunta.activarMultiplicadorx3(botonMultiplicadorx3);
        });

        botonExclusividad.setOnAction(e ->{
            controladorPregunta.activarExclusividad(botonExclusividad);
        });

        HBox botonera = new HBox(botonExclusividad,botonMultiplicadorx2,botonMultiplicadorx3, botonGrupo1, botonGrupo2);
        //Seteamos las visibilidades en false siempre, asi solo se muestran los botones permitidos
        botonera.getChildren().forEach(b -> b.setVisible(false));

        //Seteo las visibilidades
        botonGrupo1.setVisible(controladorPregunta.getNombre().equals("Group Choice"));
        botonGrupo2.setVisible(controladorPregunta.getNombre().equals("Group Choice"));

        botonMultiplicadorx2.setVisible(controladorPregunta.esPreguntaConPenalidad());
        botonMultiplicadorx3.setVisible(controladorPregunta.esPreguntaConPenalidad());
        botonExclusividad.setVisible(!controladorPregunta.esPreguntaConPenalidad());

        this.getChildren().addAll(stack,opciones,botonera);
    }
}
