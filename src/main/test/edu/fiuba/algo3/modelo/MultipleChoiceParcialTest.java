package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MultipleChoiceParcialTest {
    @Test
    public void JugadorRespondeCorrectamenteYSumaTantosPuntosComoRespuestasCorrectas(){
        Jugador rafael = new Jugador("Rafael");
        Jugador pablo = new Jugador("Pablo");

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

        MultipleChoiceParcial pregunta = new MultipleChoiceParcial("Elegir los numeros en palabras 1 2 3", respuestasCorrectas, opciones);
        var respuestasJugador1 = new ArrayList<String>();
        var respuestasJugador2 = new ArrayList<String>();
        respuestasJugador1.add("uno");
        respuestasJugador1.add("dos");
        respuestasJugador1.add("tres");
        rafael.respuestaElegida(respuestasJugador1);
        respuestasJugador2.add("uno");
        pablo.respuestaElegida(respuestasJugador2);

        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(rafael.getRespuesta());
        respuestas.add(pablo.getRespuesta());
        pregunta.evaluarRespuesta(respuestas);
        rafael.actualizarPuntaje();
        pablo.actualizarPuntaje();
        assertEquals(3, rafael.getPuntaje());
        assertEquals(1,pablo.getPuntaje());

    }
}
