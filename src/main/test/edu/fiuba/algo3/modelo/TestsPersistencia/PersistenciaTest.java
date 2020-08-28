package edu.fiuba.algo3.modelo.TestsPersistencia;

import edu.fiuba.algo3.modelo.preguntas.FabricaPreguntas;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class PersistenciaTest {

    /*@Test
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
        String persistencia = gson.toJson(pregunta);

        // Pasa de JSON a pregunta
        Type tipoPreguntas = new TypeToken<ArrayList<MultipleChoice>>(){}.getType();
        InputStream is = new FileInputStream (new File ("preguntasMultipleChoice.persistencia"));
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is));
        ArrayList<MultipleChoice> preguntaJson = gson.fromJson(bufferedReader, tipoPreguntas);

        assertEquals(pregunta.getEnunciado(), preguntaJson.get(0).getEnunciado());
    }*/

    @Test
    public void test01SeCreanLasPreguntasConLaFabricaYDevuelveUnArregloDeTamanioMayorACero() throws FileNotFoundException {

        ArrayList<Pregunta> preguntas = FabricaPreguntas.crearPreguntas();
        assertNotEquals(0, preguntas.size());
    }
}
