package edu.fiuba.algo3.modelo.preguntas;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import edu.fiuba.algo3.json.AdaptadorCorrector;
import edu.fiuba.algo3.modelo.correcciones.Corrector;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;

public class FabricaPreguntas {

    public static ArrayList<Pregunta> crearPreguntas () throws FileNotFoundException {
        ArrayList<Pregunta> preguntas = new ArrayList<>();
        preguntas.addAll(crearVerdaderoFalso());
        preguntas.addAll(crearMultipleChoice());
        preguntas.addAll(crearOrderedChoice());
        preguntas.addAll(crearGroupChoice());

        Collections.shuffle(preguntas);
        return preguntas;
    }

    private static ArrayList<Pregunta> crearVerdaderoFalso() throws FileNotFoundException {
        return recuperarObjetosJson(new TypeToken<ArrayList<VerdaderoFalso>>(){}.getType()
                ,"preguntasVerdaderoFalso.json");
    }

    private static ArrayList<Pregunta> crearMultipleChoice() throws FileNotFoundException {

        return recuperarObjetosJson(new TypeToken<ArrayList<MultipleChoice>>(){}.getType()
                ,"preguntasMultipleChoice.json");
    }

    private static ArrayList<Pregunta> crearOrderedChoice() throws FileNotFoundException{
        return recuperarObjetosJson(new TypeToken<ArrayList<OrderedChoice>>(){}.getType()
                ,"preguntasOrderedChoice.json");
    }

    private static ArrayList<Pregunta> crearGroupChoice() throws FileNotFoundException {
        return recuperarObjetosJson(new TypeToken<ArrayList<GroupChoice>>(){}.getType()
                ,"preguntasGroupChoice.json");
    }

    private static ArrayList<Pregunta> recuperarObjetosJson(Type tipoPreguntas
            ,String rutaObjetosJson) throws FileNotFoundException {

        GsonBuilder builder = new GsonBuilder();
        builder.registerTypeAdapter(Corrector.class, new AdaptadorCorrector());
        Gson gson = builder.create();
        InputStream is = new FileInputStream(new File(rutaObjetosJson));
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is));
        ArrayList<Pregunta> preguntasJson = gson.fromJson(bufferedReader, tipoPreguntas);

        return preguntasJson;
    }
}
