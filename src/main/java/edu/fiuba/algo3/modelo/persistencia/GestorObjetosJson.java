package edu.fiuba.algo3.modelo.persistencia;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import edu.fiuba.algo3.modelo.correcciones.Corrector;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class GestorObjetosJson {

    private GestorObjetosJson () { }

    public static Gson crearGJson (){
        GsonBuilder builder = new GsonBuilder();
        builder.registerTypeAdapter(Corrector.class, new AdaptadorCorrector());
        Gson gson = builder.create();
        return gson;
    }

    public static ArrayList<Pregunta> recuperarObjetosJson(Gson gson, Type tipoPreguntas
            , String rutaObjetosJson) throws FileNotFoundException {

        InputStream is = new FileInputStream(new File(rutaObjetosJson));
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is));
        ArrayList<Pregunta> preguntasJson = gson.fromJson(bufferedReader, tipoPreguntas);
        return preguntasJson;
    }
}
