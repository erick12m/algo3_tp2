package edu.fiuba.algo3.modelo;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Opciones {

    HashMap <Integer, String> opciones;

    public Opciones () {
        this.opciones = new HashMap <Integer, String> ();
    }

    public void agregarOpcion (int numeroOpcion, String enunciado) {
        opciones.put(numeroOpcion, enunciado);
    }

    public void presentarOpciones () {
        Iterator iterador = opciones.entrySet().iterator();

        while (iterador.hasNext()) {
            Map.Entry entrada = (Map.Entry) iterador.next();

            Integer iNumeroOpcion = (Integer) entrada.getKey();
            String enunciado = (String) entrada.getValue();
            System.out.println(iNumeroOpcion + ". " + enunciado);
        }
    }
}
