package edu.fiuba.algo3.modelo.TestsPreguntas;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MultipleChoiceTest {
    //Test Puntaje Clasico
    @Test
    public void test01JugadorRespondeCorrectamenteYSumaUnPunto() {

        Jugador jugador = new Jugador("Rafael"); //No anda con moc

        var listaCorrectas = new ArrayList<String>();
        listaCorrectas.add("uno");
        listaCorrectas.add("dos");
        listaCorrectas.add("tres");
        CorrectorClasico clasico = new CorrectorClasico();
        var respuestasCorrectas = new Respuesta(listaCorrectas, clasico);

        ArrayList<String> opciones = new ArrayList<String>();
        opciones.add("uno");
        opciones.add("dos");
        opciones.add("tres");
        opciones.add("cuatro");

        MultipleChoice pregunta = new MultipleChoice("Elegir los numeros en palabras 1 2 3", respuestasCorrectas, opciones);
        var respuestasJugador = new ArrayList<String>();


        jugador.respuestaElegida(respuestasCorrectas);


        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(jugador.getRespuesta());
        pregunta.evaluarRespuesta(respuestas);
        jugador.actualizarPuntaje();
        assertEquals(1, jugador.getPuntaje());
    }
    //Test Puntaje Parcial
    @Test
    public void JugadorRespondeCorrectamenteYSumaTantosPuntosComoRespuestasCorrectas(){
        Jugador rafael = new Jugador("Rafael");
        Jugador pablo = new Jugador("Pablo");

        var listaCorrectas = new ArrayList<String>();
        listaCorrectas.add("uno");
        listaCorrectas.add("dos");
        listaCorrectas.add("tres");
        CorrectorParcial parcial = new CorrectorParcial();
        var respuestasCorrectas = new Respuesta(listaCorrectas, parcial);

        ArrayList<String> opciones = new ArrayList<String>();
        opciones.add("uno");
        opciones.add("dos");
        opciones.add("tres");
        opciones.add("cuatro");

        MultipleChoice pregunta = new MultipleChoice("Elegir los numeros en palabras 1 2 3", respuestasCorrectas, opciones);
        var listaRespuestasJugador2 = new ArrayList<String>();
        rafael.respuestaElegida(respuestasCorrectas);
        listaRespuestasJugador2.add("uno");
        pablo.respuestaElegida(new Respuesta(listaRespuestasJugador2,parcial));

        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(rafael.getRespuesta());
        respuestas.add(pablo.getRespuesta());
        pregunta.evaluarRespuesta(respuestas);
        rafael.actualizarPuntaje();
        pablo.actualizarPuntaje();
        assertEquals(3, rafael.getPuntaje());
        assertEquals(1,pablo.getPuntaje());

    }
    //Test Puntaje Penalidad
    @Test
    public void JugadorResponde2CorrectasY1InorrectaYTiene1Punto(){
        Jugador rafael = new Jugador("Rafael");

        var listaCorrectas = new ArrayList<String>();
        listaCorrectas.add("uno");
        listaCorrectas.add("dos");
        listaCorrectas.add("tres");
        CorrectorPenalidad penalidad = new CorrectorPenalidad();
        var respuestasCorrectas = new Respuesta(listaCorrectas, penalidad);

        ArrayList<String> opciones = new ArrayList<String>();
        opciones.add("uno");
        opciones.add("dos");
        opciones.add("tres");
        opciones.add("cuatro");

        MultipleChoice pregunta = new MultipleChoice("Elegir los numeros en palabras 1 2 3", respuestasCorrectas, opciones);
        var listaRespuestasJugador = new ArrayList<String>();
        listaRespuestasJugador.add("uno");
        listaRespuestasJugador.add("dos");
        listaRespuestasJugador.add("cuatro");
        rafael.respuestaElegida(new Respuesta(listaRespuestasJugador, penalidad));

        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(rafael.getRespuesta());
        pregunta.evaluarRespuesta(respuestas);
        rafael.actualizarPuntaje();
        assertEquals(1, rafael.getPuntaje());

    }
}
