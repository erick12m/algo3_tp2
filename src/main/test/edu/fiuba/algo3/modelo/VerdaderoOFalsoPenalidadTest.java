package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class VerdaderoOFalsoPenalidadTest {

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

        VerdaderoOFalsoPenalidad verdaderoOFalso = new VerdaderoOFalsoPenalidad("1 + 1 = 2?", respuestaCorrecta, opciones);

        ArrayList<Respuesta> respuestaJugador = new ArrayList<Respuesta>();
        respuestaJugador.add(jugador.getRespuesta());

        verdaderoOFalso.evaluarRespuesta(respuestaJugador);
        jugador.actualizarPuntaje();

        assertEquals(1, jugador.getPuntaje());
    }

    @Test
    public void test02JugadorConUnPuntoRespondeIncorrectamenteYAhoraTiene0Puntos() {

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

        VerdaderoOFalsoPenalidad verdaderoOFalso = new VerdaderoOFalsoPenalidad("1 + 1 = 2?", respuestaCorrecta, opciones);

        ArrayList<Respuesta> respuestaJugador = new ArrayList<Respuesta>();
        respuestaJugador.add(jugador.getRespuesta());

        verdaderoOFalso.evaluarRespuesta(respuestaJugador);
        jugador.actualizarPuntaje();

        assertEquals(1, jugador.getPuntaje()); //Jugador Suma un punto

        ArrayList<String> respuesta2Jug = new ArrayList<String>();
        respuesta2Jug.add("Falso");

        jugador.respuestaElegida(respuesta2Jug); //El jugador eligio la respuesta Falso

        VerdaderoOFalsoPenalidad verdaderoOFalso2 = new VerdaderoOFalsoPenalidad("3 - 1 = 2?", respuestaCorrecta, opciones);

        ArrayList<Respuesta> respuestaJugador2 = new ArrayList<Respuesta>();
        respuestaJugador.add(jugador.getRespuesta());

        verdaderoOFalso.evaluarRespuesta(respuestaJugador);
        jugador.actualizarPuntaje();

        assertEquals(0, jugador.getPuntaje());
    }

    @Test
    public void test03JugadorCon0PuntosRespondeIncorrectamenteYSigueCon0Puntos() {

        //Panel panel = new Panel();

        Jugador jugador = new Jugador("Rafael"); //No anda con moc

        ArrayList<String> respuesta = new ArrayList<String>();
        respuesta.add("Verdadero");

        ArrayList<String> opciones = new ArrayList<String>();
        opciones.add("Verdadero");
        opciones.add("Falso");

        ArrayList<String> respuestaJug = new ArrayList<String>();
        respuestaJug.add("Falso");

        jugador.respuestaElegida(respuestaJug); //El jugador eligio la respuesta Falso

        Respuesta respuestaCorrecta = new Respuesta(respuesta);

        VerdaderoOFalsoPenalidad verdaderoOFalso = new VerdaderoOFalsoPenalidad("1 + 1 = 2?", respuestaCorrecta, opciones);

        ArrayList<Respuesta> respuestaJugador = new ArrayList<Respuesta>();
        respuestaJugador.add(jugador.getRespuesta());

        verdaderoOFalso.evaluarRespuesta(respuestaJugador);
        jugador.actualizarPuntaje();

        assertEquals(0, jugador.getPuntaje());
    }

}