package edu.fiuba.algo3;

import com.google.gson.*;
import edu.fiuba.algo3.modelo.correccion.CorrectorClasico;
import edu.fiuba.algo3.modelo.correccion.Respuesta;
import edu.fiuba.algo3.modelo.preguntas.MultipleChoice;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class JsonPrueba {

    static public void main(String[] args) throws IOException {
        var opciones = new ArrayList<String>();
        opciones.add("1");
        opciones.add("2");
        opciones.add("3");
        opciones.add("4");
        ArrayList<String> respuesta = new ArrayList<String>();
        respuesta.add("2");
        respuesta.add("4");

        CorrectorClasico clasico = new CorrectorClasico();
        Respuesta respuestaCorrecta = new Respuesta(respuesta);

        MultipleChoice pregunta = new MultipleChoice("Seleccione los numeros pares", respuestaCorrecta, opciones, clasico);

        // Creamos el objeto Gson que se encargara de las conversiones
        Gson gson = new Gson();

        // Convertimos un objecto sencillo a JSON
        String json = gson.toJson(pregunta);
        System.out.println(json);
        System.out.println();

        FileWriter writer = new FileWriter("preguntas.json");
        writer.write(json);
        writer.close();

    }

}
