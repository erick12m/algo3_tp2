package edu.fiuba.algo3.modelo.TestsPreguntas.VerdaderoFalso;

import edu.fiuba.algo3.modelo.correcciones.CorrectorClasico;
import edu.fiuba.algo3.modelo.correcciones.CorrectorPenalidad;
import edu.fiuba.algo3.modelo.correcciones.Respuesta;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import edu.fiuba.algo3.modelo.preguntas.VerdaderoFalso;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VerdaderoFalsoTest {
    private Jugador jugador1;
    private Jugador jugador2;
    private Pregunta pregunta;
    private ArrayList<String> opciones;

    @BeforeEach
    public void setUp(){
        jugador1 = new Jugador("Rafael");
        jugador2 = new Jugador("Pablo");
        opciones = new ArrayList<String>();
        opciones.add("Verdadero");
        opciones.add("Falso");
    }
    @Test
    public void test01JugadorRespondeCorrectamenteClasicoYSumaUnPunto() {


        ArrayList<String> respuesta = new ArrayList<String>();
        respuesta.add("Verdadero");

        CorrectorClasico clasico = new CorrectorClasico();
        Respuesta respuestaCorrecta = new Respuesta(respuesta);

        jugador1.respuestaElegida(respuestaCorrecta); //El jugador eligio la respuesta Verdadero

        VerdaderoFalso verdaderoFalso = new VerdaderoFalso("1 + 1 = 2?", respuestaCorrecta, opciones, clasico);

        ArrayList<Respuesta> respuestaJugador = new ArrayList<Respuesta>();
        respuestaJugador.add(jugador1.getRespuesta());

        verdaderoFalso.evaluarRespuesta(respuestaJugador);
        jugador1.actualizarPuntaje();

        assertEquals(1, jugador1.getPuntaje());
    }

    @Test
    public void test02JugadorRespondeMalClasicoYNoSumaPuntos() {

        ArrayList<String> respuesta = new ArrayList<String>();
        respuesta.add("Verdadero");
        CorrectorClasico clasico = new CorrectorClasico();
        Respuesta respuestaCorrecta = new Respuesta(respuesta);

        ArrayList<String> respuestaJug = new ArrayList<String>();
        respuestaJug.add("Falso");

        jugador1.respuestaElegida(new Respuesta(respuestaJug)); //El jugador eligio la respuesta Verdadero



        VerdaderoFalso verdaderoFalso = new VerdaderoFalso("1 + 1 = 2?", respuestaCorrecta, opciones, clasico);

        ArrayList<Respuesta> respuestaJugador = new ArrayList<Respuesta>();
        respuestaJugador.add(jugador1.getRespuesta());

        verdaderoFalso.evaluarRespuesta(respuestaJugador);
        jugador1.actualizarPuntaje();

        assertEquals(0, jugador1.getPuntaje());
    }

    @Test
    public void test03JugadorRespondeCorrectamenteAUnaPreguntaQueEsFalsaYSumaPuntos() {
        ArrayList<String> respuesta = new ArrayList<String>();
        respuesta.add("Falso");

        CorrectorClasico clasico = new CorrectorClasico();
        Respuesta respuestaCorrecta = new Respuesta(respuesta);

        jugador1.respuestaElegida(respuestaCorrecta); //El jugador eligio la respuesta Verdadero



        VerdaderoFalso verdaderoFalso = new VerdaderoFalso("1 + 1 = 2?", respuestaCorrecta, opciones, clasico);

        ArrayList<Respuesta> respuestaJugador = new ArrayList<Respuesta>();
        respuestaJugador.add(jugador1.getRespuesta());

        verdaderoFalso.evaluarRespuesta(respuestaJugador);
        jugador1.actualizarPuntaje();

        assertEquals(1, jugador1.getPuntaje());
    }

    @Test
    public void test04JugadorRespondeIncorrectamenteAUnaPreguntaQueEsFalsaYNoSumaPuntos() {
        ArrayList<String> respuesta = new ArrayList<String>();
        respuesta.add("Falso");

        CorrectorClasico clasico = new CorrectorClasico();
        Respuesta respuestaCorrecta = new Respuesta(respuesta);

        ArrayList<String> respuestaJug = new ArrayList<String>();
        respuestaJug.add("Verdadero");

        jugador1.respuestaElegida(new Respuesta(respuestaJug)); //El jugador eligio la respuesta Verdadero

        VerdaderoFalso verdaderoFalso = new VerdaderoFalso("1 + 1 = 2?", respuestaCorrecta, opciones, clasico);

        ArrayList<Respuesta> respuestaJugador = new ArrayList<Respuesta>();
        respuestaJugador.add(jugador1.getRespuesta());

        verdaderoFalso.evaluarRespuesta(respuestaJugador);
        jugador1.actualizarPuntaje();

        assertEquals(0, jugador1.getPuntaje());
    }

    @Test
    public void test05JugadorRespondeCorrectamenteConPenalidadYSumaUnPunto() {

        ArrayList<String> respuesta = new ArrayList<String>();
        respuesta.add("Verdadero");

        CorrectorPenalidad penalidad = new CorrectorPenalidad();
        Respuesta respuestaCorrecta = new Respuesta(respuesta);

        jugador1.respuestaElegida(respuestaCorrecta); //El jugador eligio la respuesta Verdadero

        VerdaderoFalso verdaderoFalso = new VerdaderoFalso("1 + 1 = 2?", respuestaCorrecta, opciones, penalidad);

        ArrayList<Respuesta> respuestaJugador = new ArrayList<Respuesta>();
        respuestaJugador.add(jugador1.getRespuesta());

        verdaderoFalso.evaluarRespuesta(respuestaJugador);
        jugador1.actualizarPuntaje();

        assertEquals(1, jugador1.getPuntaje());
    }

    @Test
    public void test06JugadorConUnPuntoRespondeIncorrectamenteConPenalidadYAhoraTiene0Puntos() {

        ArrayList<String> respuesta = new ArrayList<String>();
        respuesta.add("Verdadero");

        CorrectorPenalidad penalidad =  new CorrectorPenalidad();
        Respuesta respuestaCorrecta = new Respuesta(respuesta);

        ArrayList<String> respuestaJug = new ArrayList<String>();
        respuestaJug.add("Verdadero");

        jugador1.respuestaElegida(new Respuesta(respuestaJug)); //El jugador eligio la respuesta Verdadero

        VerdaderoFalso verdaderoFalso = new VerdaderoFalso("1 + 1 = 2?", respuestaCorrecta, opciones, penalidad);

        ArrayList<Respuesta> respuestaJugador = new ArrayList<Respuesta>();
        respuestaJugador.add(jugador1.getRespuesta());

        verdaderoFalso.evaluarRespuesta(respuestaJugador);
        jugador1.actualizarPuntaje();

        assertEquals(1, jugador1.getPuntaje()); //Jugador Suma un punto

        ArrayList<String> respuesta2Jug = new ArrayList<String>();
        respuesta2Jug.add("Falso");

        jugador1.respuestaElegida(new Respuesta(respuesta2Jug)); //El jugador eligio la respuesta Falso

        VerdaderoFalso verdaderoFalso2 = new VerdaderoFalso("3 - 1 = 2?", respuestaCorrecta, opciones, penalidad);

        ArrayList<Respuesta> respuestaJugador2 = new ArrayList<Respuesta>();
        respuestaJugador2.add(jugador1.getRespuesta());

        verdaderoFalso.evaluarRespuesta(respuestaJugador2);
        jugador1.actualizarPuntaje();

        assertEquals(0, jugador1.getPuntaje());
    }

    @Test
    public void test07JugadorCon0PuntosRespondeIncorrectamenteConPenalidadYSigueCon0Puntos() {

        ArrayList<String> respuesta = new ArrayList<String>();
        respuesta.add("Verdadero");

        CorrectorPenalidad penalidad = new CorrectorPenalidad();
        Respuesta respuestaCorrecta = new Respuesta(respuesta);

        ArrayList<String> respuestaJug = new ArrayList<String>();
        respuestaJug.add("Falso");

        jugador1.respuestaElegida(new Respuesta(respuestaJug)); //El jugador eligio la respuesta Falso

        VerdaderoFalso verdaderoFalso = new VerdaderoFalso("1 + 1 = 2?", respuestaCorrecta, opciones, penalidad);

        ArrayList<Respuesta> respuestaJugador = new ArrayList<Respuesta>();
        respuestaJugador.add(jugador1.getRespuesta());

        verdaderoFalso.evaluarRespuesta(respuestaJugador);
        jugador1.actualizarPuntaje();

        assertEquals(0, jugador1.getPuntaje());
    }
}
