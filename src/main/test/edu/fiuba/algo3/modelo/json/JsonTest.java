package edu.fiuba.algo3.modelo.json;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import edu.fiuba.algo3.json.AdaptadorCorrector;
import edu.fiuba.algo3.modelo.TestsPreguntas.GroupChoiceTest;
import edu.fiuba.algo3.modelo.correcciones.Corrector;
import edu.fiuba.algo3.modelo.correcciones.CorrectorClasico;
import edu.fiuba.algo3.modelo.correcciones.Respuesta;
import edu.fiuba.algo3.modelo.preguntas.*;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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

        GsonBuilder builder = new GsonBuilder();
        builder.registerTypeAdapter(Corrector.class, new AdaptadorCorrector());
        Gson gson = builder.setPrettyPrinting().create();

        // Convertimos una pregunta a JSON
        String json = gson.toJson(pregunta);

        // Pasa de JSON a pregunta
        Type tipoPreguntas = new TypeToken<ArrayList<MultipleChoice>>(){}.getType();
        InputStream is = new FileInputStream (new File ("preguntasMultipleChoice.json"));
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is));
        ArrayList<MultipleChoice> preguntaJson = gson.fromJson(bufferedReader, tipoPreguntas);

        assertEquals(pregunta.getEnunciado(), preguntaJson.get(0).getEnunciado());
    }

    @Test // LA PRUEBA NO SE SI NECESITAN IR, ESTAN PARA CHEQUEAR SI FUNCIONABA
    public void test02SeCreanLasPreguntasConLaFabricaYDevuelveUnArregloDeTamanio10() throws FileNotFoundException {

        ArrayList<Pregunta> preguntas = FabricaPreguntas.crearPreguntas();
        assertEquals(10, preguntas.size());
    }
}
