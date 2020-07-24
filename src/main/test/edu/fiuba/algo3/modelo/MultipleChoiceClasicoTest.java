package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MultipleChoiceClasicoTest {
    @Test
    public void test01JugadorRespondeCorrectamenteYSumaUnPunto() {

        Jugador jugador = new Jugador("Rafael"); //No anda con moc

        var listaCorrectas = new ArrayList<String>();
        listaCorrectas.add("uno");
        listaCorrectas.add("dos");
        listaCorrectas.add("tres");
        var respuestasCorrectas = new Respuesta(listaCorrectas);

        ArrayList<String> opciones = new ArrayList<String>();
        opciones.add("uno");
        opciones.add("dos");
        opciones.add("tres");
        opciones.add("cuatro");

        MultipleChoiceClasico pregunta = new MultipleChoiceClasico("Elegir los numeros en palabras 1 2 3", respuestasCorrectas, opciones);
        var respuestasJugador = new ArrayList<String>();

        respuestasJugador.add("uno");
        respuestasJugador.add("dos");
        respuestasJugador.add("tres");
        jugador.respuestaElegida(respuestasJugador);


        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(jugador.getRespuesta());
        pregunta.evaluarRespuesta(respuestas);
        jugador.actualizarPuntaje();
        assertEquals(1, jugador.getPuntaje());
    }
}
