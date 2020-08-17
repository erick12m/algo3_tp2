package edu.fiuba.algo3.modelo.preguntas;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import edu.fiuba.algo3.modelo.persistencia.GestorObjetosJson;

import java.io.FileNotFoundException;
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
        Gson gson = GestorObjetosJson.crearGJson();
        return GestorObjetosJson.recuperarObjetosJson(gson,new TypeToken<ArrayList<VerdaderoFalso>>(){}.getType()
                ,"preguntasVerdaderoFalso.json");
    }

    private static ArrayList<Pregunta> crearMultipleChoice() throws FileNotFoundException {
        Gson gson = GestorObjetosJson.crearGJson();
        return GestorObjetosJson.recuperarObjetosJson(gson, new TypeToken<ArrayList<MultipleChoice>>(){}.getType()
                ,"preguntasMultipleChoice.json");
    }

    private static ArrayList<Pregunta> crearOrderedChoice() throws FileNotFoundException{
        Gson gson = GestorObjetosJson.crearGJson();
        return GestorObjetosJson.recuperarObjetosJson(gson, new TypeToken<ArrayList<OrderedChoice>>(){}.getType()
                ,"preguntasOrderedChoice.json");
    }

    private static ArrayList<Pregunta> crearGroupChoice() throws FileNotFoundException {
        Gson gson = GestorObjetosJson.crearGJson();
        return GestorObjetosJson.recuperarObjetosJson(gson, new TypeToken<ArrayList<GroupChoice>>(){}.getType()
                ,"preguntasGroupChoice.json");

        //SE ELIMINARIA EL gson Y EL LLAMADO A LA CLASE ESTATICA GESTOROBJETOSJSON E IGUAL ANDANDARIA
        //SI SE DECIDE ELIMINAR LA CLASE GestorObjetosJson
    }

    //TODO SI LA CLASE GESTOR DE OBJETOS ES MUY EXAGERADA SE ELIMINA Y QUEDA ESTO
    /*private static ArrayList<Pregunta> recuperarObjetosJson(Type tipoPreguntas
            ,String rutaObjetosJson) throws FileNotFoundException {

        GsonBuilder builder = new GsonBuilder();
        builder.registerTypeAdapter(Corrector.class, new AdaptadorCorrector());
        Gson gson = builder.create();
        InputStream is = new FileInputStream(new File(rutaObjetosJson));
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is));
        ArrayList<Pregunta> preguntasJson = gson.fromJson(bufferedReader, tipoPreguntas);

        return preguntasJson;
    }*/
}
