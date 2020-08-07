package edu.fiuba.algo3.modelo.json;

import com.google.gson.*;
import edu.fiuba.algo3.json.AdaptadorCorrector;
import edu.fiuba.algo3.modelo.correccion.Corrector;
import edu.fiuba.algo3.modelo.correccion.CorrectorClasico;
import edu.fiuba.algo3.modelo.correccion.Respuesta;
import edu.fiuba.algo3.modelo.preguntas.MultipleChoice;
import org.junit.jupiter.api.Test;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JsonTest {

    @Test
    public void test01() throws IOException {
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

        GsonBuilder builder = new GsonBuilder();
        builder.registerTypeAdapter(Corrector.class, new AdaptadorCorrector());
        //builder.registerTypeAdapter(Pregunta.class, new AbstractElementAdapter());
        Gson gson = builder.setPrettyPrinting().create();

        // Convertimos una pregunta a JSON
        String json = gson.toJson(pregunta);
        System.out.println(json);
        System.out.println();

        FileWriter writer = new FileWriter("preguntas.json");
        writer.write(json);
        writer.close();

        // Pasa de JSON a pregunta
        MultipleChoice preguntaJson = gson.fromJson(json, MultipleChoice.class);
        System.out.println(preguntaJson);

        assertEquals(pregunta.getEnunciado(), preguntaJson.getEnunciado());

    }

}
