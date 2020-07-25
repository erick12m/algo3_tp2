package edu.fiuba.algo3.modelo.TestsPreguntas;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VerdaderoFalsoTest {
    @Test
    public void test01JugadorRespondeCorrectamenteClasicoYSumaUnPunto() {

        //Panel panel = new Panel();

        Jugador jugador = new Jugador("Rafael"); //No anda con moc

        ArrayList<String> respuesta = new ArrayList<String>();
        respuesta.add("Verdadero");

        ArrayList<String> opciones = new ArrayList<String>();
        opciones.add("Verdadero");
        opciones.add("Falso");

        CorrectorClasico clasico = new CorrectorClasico();
        Respuesta respuestaCorrecta = new Respuesta(respuesta, clasico);

        jugador.respuestaElegida(respuestaCorrecta); //El jugador eligio la respuesta Verdadero


        VerdaderoFalso verdaderoFalso = new VerdaderoFalso("1 + 1 = 2?", respuestaCorrecta, opciones);

        ArrayList<Respuesta> respuestaJugador = new ArrayList<Respuesta>();
        respuestaJugador.add(jugador.getRespuesta());

        verdaderoFalso.evaluarRespuesta(respuestaJugador);
        jugador.actualizarPuntaje();

        assertEquals(1, jugador.getPuntaje());
    }

    @Test
    public void test02JugadorRespondeMalClasicoYNoSumaPuntos() {

        Jugador jugador = new Jugador("Rafael"); //No anda con moc

        ArrayList<String> respuesta = new ArrayList<String>();
        respuesta.add("Verdadero");

        ArrayList<String> opciones = new ArrayList<String>();
        opciones.add("Verdadero");
        opciones.add("Falso");
        CorrectorClasico clasico = new CorrectorClasico();
        Respuesta respuestaCorrecta = new Respuesta(respuesta);

        ArrayList<String> respuestaJug = new ArrayList<String>();
        respuestaJug.add("Falso");

        jugador.respuestaElegida(new Respuesta(respuestaJug,clasico)); //El jugador eligio la respuesta Verdadero



        VerdaderoFalso verdaderoFalso = new VerdaderoFalso("1 + 1 = 2?", respuestaCorrecta, opciones);

        ArrayList<Respuesta> respuestaJugador = new ArrayList<Respuesta>();
        respuestaJugador.add(jugador.getRespuesta());

        verdaderoFalso.evaluarRespuesta(respuestaJugador);
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
        CorrectorClasico clasico = new CorrectorClasico();
        Respuesta respuestaCorrecta = new Respuesta(respuesta, clasico);

        jugador.respuestaElegida(respuestaCorrecta); //El jugador eligio la respuesta Verdadero



        VerdaderoFalso verdaderoFalso = new VerdaderoFalso("1 + 1 = 2?", respuestaCorrecta, opciones);

        ArrayList<Respuesta> respuestaJugador = new ArrayList<Respuesta>();
        respuestaJugador.add(jugador.getRespuesta());

        verdaderoFalso.evaluarRespuesta(respuestaJugador);
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
        CorrectorClasico clasico = new CorrectorClasico();
        Respuesta respuestaCorrecta = new Respuesta(respuesta);

        ArrayList<String> respuestaJug = new ArrayList<String>();
        respuestaJug.add("Verdadero");

        jugador.respuestaElegida(new Respuesta(respuestaJug, clasico)); //El jugador eligio la respuesta Verdadero



        VerdaderoFalso verdaderoFalso = new VerdaderoFalso("1 + 1 = 2?", respuestaCorrecta, opciones);

        ArrayList<Respuesta> respuestaJugador = new ArrayList<Respuesta>();
        respuestaJugador.add(jugador.getRespuesta());

        verdaderoFalso.evaluarRespuesta(respuestaJugador);
        jugador.actualizarPuntaje();

        assertEquals(0, jugador.getPuntaje());
    }

    @Test
    public void test01JugadorRespondeCorrectamenteConPenalidadYSumaUnPunto() {

        //Panel panel = new Panel();

        Jugador jugador = new Jugador("Rafael"); //No anda con moc

        ArrayList<String> respuesta = new ArrayList<String>();
        respuesta.add("Verdadero");

        ArrayList<String> opciones = new ArrayList<String>();
        opciones.add("Verdadero");
        opciones.add("Falso");

        CorrectorPenalidad penalidad = new CorrectorPenalidad();
        Respuesta respuestaCorrecta = new Respuesta(respuesta, penalidad);

        jugador.respuestaElegida(respuestaCorrecta); //El jugador eligio la respuesta Verdadero



        VerdaderoFalso verdaderoFalso = new VerdaderoFalso("1 + 1 = 2?", respuestaCorrecta, opciones);

        ArrayList<Respuesta> respuestaJugador = new ArrayList<Respuesta>();
        respuestaJugador.add(jugador.getRespuesta());

        verdaderoFalso.evaluarRespuesta(respuestaJugador);
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

        CorrectorPenalidad penalidad =  new CorrectorPenalidad();
        Respuesta respuestaCorrecta = new Respuesta(respuesta, penalidad);

        ArrayList<String> respuestaJug = new ArrayList<String>();
        respuestaJug.add("Verdadero");

        jugador.respuestaElegida(new Respuesta(respuestaJug, penalidad)); //El jugador eligio la respuesta Verdadero

        VerdaderoFalso verdaderoFalso = new VerdaderoFalso("1 + 1 = 2?", respuestaCorrecta, opciones);

        ArrayList<Respuesta> respuestaJugador = new ArrayList<Respuesta>();
        respuestaJugador.add(jugador.getRespuesta());

        verdaderoFalso.evaluarRespuesta(respuestaJugador);
        jugador.actualizarPuntaje();

        assertEquals(1, jugador.getPuntaje()); //Jugador Suma un punto

        ArrayList<String> respuesta2Jug = new ArrayList<String>();
        respuesta2Jug.add("Falso");

        jugador.respuestaElegida(new Respuesta(respuesta2Jug, penalidad)); //El jugador eligio la respuesta Falso

        VerdaderoFalso verdaderoFalso2 = new VerdaderoFalso("3 - 1 = 2?", respuestaCorrecta, opciones);

        ArrayList<Respuesta> respuestaJugador2 = new ArrayList<Respuesta>();
        respuestaJugador2.add(jugador.getRespuesta());

        verdaderoFalso.evaluarRespuesta(respuestaJugador2);
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

        CorrectorPenalidad penalidad = new CorrectorPenalidad();
        Respuesta respuestaCorrecta = new Respuesta(respuesta, penalidad);

        ArrayList<String> respuestaJug = new ArrayList<String>();
        respuestaJug.add("Falso");

        jugador.respuestaElegida(new Respuesta(respuestaJug,penalidad)); //El jugador eligio la respuesta Falso

        VerdaderoFalso verdaderoFalso = new VerdaderoFalso("1 + 1 = 2?", respuestaCorrecta, opciones);

        ArrayList<Respuesta> respuestaJugador = new ArrayList<Respuesta>();
        respuestaJugador.add(jugador.getRespuesta());

        verdaderoFalso.evaluarRespuesta(respuestaJugador);
        jugador.actualizarPuntaje();

        assertEquals(0, jugador.getPuntaje());
    }
}
