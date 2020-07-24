package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class VerdaderoOFalsoClasicoTest {
    @Test
    public void test01JugadorRespondeCorrectamenteYSumaUnPunto() {

        //Panel panel = new Panel();

        Jugador jugador = new Jugador("Rafael"); //No anda con moc

        ArrayList<String> respuesta = new ArrayList<String>();
        respuesta.add("Verdadero");

        ArrayList<String> opciones = new ArrayList<String>();
        opciones.add("Verdadero");
        opciones.add("Falso");

        ArrayList<String> respuestaJug = new ArrayList<String>();
        respuestaJug.add("Verdadero");

        jugador.respuestaElegida(respuestaJug); //El jugador eligio la respuesta Verdadero

        Respuesta respuestaCorrecta = new Respuesta(respuesta);

        VerdaderoOFalsoClasico verdaderoOFalso = new VerdaderoOFalsoClasico("1 + 1 = 2?", respuestaCorrecta, opciones);

        ArrayList<Respuesta> respuestaJugador = new ArrayList<Respuesta>();
        respuestaJugador.add(jugador.getRespuesta());

        verdaderoOFalso.evaluarRespuesta(respuestaJugador);
        jugador.actualizarPuntaje();

        assertEquals(1, jugador.getPuntaje());
    }

    @Test
    public void test02JugadorRespondeMalYNoSumaPuntos() {

        Jugador jugador = new Jugador("Rafael"); //No anda con moc

        ArrayList<String> respuesta = new ArrayList<String>();
        respuesta.add("Verdadero");

        ArrayList<String> opciones = new ArrayList<String>();
        opciones.add("Verdadero");
        opciones.add("Falso");

        ArrayList<String> respuestaJug = new ArrayList<String>();
        respuestaJug.add("Falso");

        jugador.respuestaElegida(respuestaJug); //El jugador eligio la respuesta Verdadero

        Respuesta respuestaCorrecta = new Respuesta(respuesta);

        VerdaderoOFalsoClasico verdaderoOFalso = new VerdaderoOFalsoClasico("1 + 1 = 2?", respuestaCorrecta, opciones);

        ArrayList<Respuesta> respuestaJugador = new ArrayList<Respuesta>();
        respuestaJugador.add(jugador.getRespuesta());

        verdaderoOFalso.evaluarRespuesta(respuestaJugador);
        jugador.actualizarPuntaje();

        assertEquals(0, jugador.getPuntaje());
    }

    @Test
    public void test03JugadorRespondeCorrectamenteAUnaPreguntaQueEsFalsaYSumaPuntos() {

        Jugador jugador = new Jugador("Rafael"); //No anda con moc

        ArrayList<String> respuesta = new ArrayList<String>();
        respuesta.add("Falso");

        ArrayList<String> opciones = new ArrayList<String>();
        opciones.add("Verdadero");
        opciones.add("Falso");

        ArrayList<String> respuestaJug = new ArrayList<String>();
        respuestaJug.add("Falso");

        jugador.respuestaElegida(respuestaJug); //El jugador eligio la respuesta Verdadero

        Respuesta respuestaCorrecta = new Respuesta(respuesta);

        VerdaderoOFalsoClasico verdaderoOFalso = new VerdaderoOFalsoClasico("1 + 1 = 2?", respuestaCorrecta, opciones);

        ArrayList<Respuesta> respuestaJugador = new ArrayList<Respuesta>();
        respuestaJugador.add(jugador.getRespuesta());

        verdaderoOFalso.evaluarRespuesta(respuestaJugador);
        jugador.actualizarPuntaje();

        assertEquals(1, jugador.getPuntaje());
    }


    @Test
    public void test04JugadorRespondeIncorrectamenteAUnaPreguntaQueEsFalsaYNoSumaPuntos() {

        Jugador jugador = new Jugador("Rafael"); //No anda con moc

        ArrayList<String> respuesta = new ArrayList<String>();
        respuesta.add("Falso");

        ArrayList<String> opciones = new ArrayList<String>();
        opciones.add("Verdadero");
        opciones.add("Falso");

        ArrayList<String> respuestaJug = new ArrayList<String>();
        respuestaJug.add("Verdadero");

        jugador.respuestaElegida(respuestaJug); //El jugador eligio la respuesta Verdadero

        Respuesta respuestaCorrecta = new Respuesta(respuesta);

        VerdaderoOFalsoClasico verdaderoOFalso = new VerdaderoOFalsoClasico("1 + 1 = 2?", respuestaCorrecta, opciones);

        ArrayList<Respuesta> respuestaJugador = new ArrayList<Respuesta>();
        respuestaJugador.add(jugador.getRespuesta());

        verdaderoOFalso.evaluarRespuesta(respuestaJugador);
        jugador.actualizarPuntaje();

        assertEquals(0, jugador.getPuntaje());
    }
}