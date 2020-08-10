package edu.fiuba.algo3.modelo.TestsPreguntas;

import edu.fiuba.algo3.modelo.Kahoot;
import edu.fiuba.algo3.modelo.correcciones.CorrectorClasico;
import edu.fiuba.algo3.modelo.correcciones.CorrectorPenalidad;
import edu.fiuba.algo3.modelo.correcciones.Respuesta;
import edu.fiuba.algo3.modelo.excepciones.NoTieneExclusividadException;
import edu.fiuba.algo3.modelo.excepciones.RondaFinalizadaException;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.preguntas.MultipleChoice;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExclusividadTest {
    private Kahoot kahoot;
    private Respuesta respuestasCorrectas;
    private ArrayList<String> opciones;
    @BeforeEach
    public void setUp(){
        kahoot = new Kahoot();
        kahoot.crearJugadores("Rafael", "Pablo");
        opciones = new ArrayList<String>();
        opciones.add("uno");
        opciones.add("dos");
        opciones.add("tres");
        opciones.add("cuatro");
        var listaCorrectas = new ArrayList<String>();
        listaCorrectas.add("uno");
        listaCorrectas.add("dos");
        listaCorrectas.add("tres");
        respuestasCorrectas = new Respuesta(listaCorrectas);
    }
    @Test
    public void test01RafaelRespondeCorrectamenteConExclusividadYGana2PuntosYPabloIncorrectamenteYSigueEn0() throws RondaFinalizadaException, NoTieneExclusividadException {
        CorrectorClasico clasico = new CorrectorClasico();
        MultipleChoice pregunta = new MultipleChoice("Elegir los numeros en palabras 1 2 3", respuestasCorrectas, opciones, clasico);
        kahoot.setPreguntaActual(pregunta);
        kahoot.siguienteJugador();
        var jugador1 = kahoot.getJugadorActual();
        kahoot.usarExclusividad(jugador1);
        var listaRespuestasJugador = new ArrayList<String>();
        listaRespuestasJugador.add("cuatro");
        var respuestasJugador = new Respuesta(listaRespuestasJugador);
        kahoot.siguienteJugador();
        var jugador2 = kahoot.getJugadorActual();
        jugador2.respuestaElegida(respuestasJugador);
        jugador1.respuestaElegida(respuestasCorrectas);

        kahoot.puntuarPregunta();
        assertEquals(2, jugador1.getPuntaje());
        assertEquals(0, jugador2.getPuntaje());
    }

    @Test
    public void test02UnJugadorUsaExclusividadPeroAmbosRespondenCorrectamenteYNoHaceEfecto() throws RondaFinalizadaException, NoTieneExclusividadException {
        CorrectorClasico clasico = new CorrectorClasico();
        MultipleChoice pregunta = new MultipleChoice("Elegir los numeros en palabras 1 2 3", respuestasCorrectas, opciones, clasico);
        kahoot.setPreguntaActual(pregunta);
        kahoot.siguienteJugador();
        var jugador1 = kahoot.getJugadorActual();
        kahoot.usarExclusividad(jugador1);
        kahoot.siguienteJugador();
        var jugador2 = kahoot.getJugadorActual();
        jugador2.respuestaElegida(respuestasCorrectas);
        jugador1.respuestaElegida(respuestasCorrectas);

        kahoot.puntuarPregunta();
        assertEquals(1, jugador1.getPuntaje());
        assertEquals(1, jugador2.getPuntaje());
    }

    @Test
    public void test03AmbosJugadoresUsanExclusividadYElUnicoQueRespondeCorrectamenteGana4Puntos() throws RondaFinalizadaException, NoTieneExclusividadException {
        CorrectorClasico clasico = new CorrectorClasico();
        MultipleChoice pregunta = new MultipleChoice("Elegir los numeros en palabras 1 2 3", respuestasCorrectas, opciones, clasico);
        kahoot.setPreguntaActual(pregunta);
        kahoot.siguienteJugador();
        var jugador1 = kahoot.getJugadorActual();
        kahoot.siguienteJugador();
        var jugador2 = kahoot.getJugadorActual();
        kahoot.usarExclusividad(jugador1);
        kahoot.usarExclusividad(jugador2);
        var listaRespuestasJugador = new ArrayList<String>();
        listaRespuestasJugador.add("cuatro");
        var respuestasJugador = new Respuesta(listaRespuestasJugador);
        jugador2.respuestaElegida(respuestasJugador);
        jugador1.respuestaElegida(respuestasCorrectas);

        kahoot.puntuarPregunta();
        assertEquals(4, jugador1.getPuntaje());
        assertEquals(0, jugador2.getPuntaje());
    }

    @Test
    public void test04JugadorIntentaUsarExclusividadPorSegundaVezYRecibeError() throws RondaFinalizadaException, NoTieneExclusividadException {
        CorrectorClasico clasico = new CorrectorClasico();
        MultipleChoice pregunta = new MultipleChoice("Elegir los numeros en palabras 1 2 3", respuestasCorrectas, opciones, clasico);
        kahoot.setPreguntaActual(pregunta);
        kahoot.siguienteJugador();
        var jugador1 = kahoot.getJugadorActual();
        kahoot.siguienteJugador();
        var jugador2 = kahoot.getJugadorActual();
        kahoot.usarExclusividad(jugador1);
        var listaRespuestasJugador = new ArrayList<String>();
        listaRespuestasJugador.add("cuatro");
        var respuestasJugador = new Respuesta(listaRespuestasJugador);
        jugador2.respuestaElegida(respuestasJugador);
        jugador1.respuestaElegida(respuestasCorrectas);

        kahoot.puntuarPregunta();
        assertEquals(2, jugador1.getPuntaje());
        assertEquals(0, jugador2.getPuntaje());

        //Siguiente pregunta, intenta usar exclusividad de nuevo



        pregunta = new MultipleChoice("Elegir los numeros en palabras 1 2", respuestasCorrectas, opciones, clasico);
        kahoot.setPreguntaActual(pregunta);
        kahoot.siguienteJugador();
        jugador1 = kahoot.getJugadorActual();
        boolean excepcion = false;
        try{
            kahoot.usarExclusividad(jugador1);
        } catch (NoTieneExclusividadException e){
            excepcion = true;
        }

        assertEquals(true, excepcion);
    }

    @Test
    public void test05JugadorUsaExclusividadUnTurnoYAlSiguienteTurnoNoAplicaElEfecto() throws RondaFinalizadaException, NoTieneExclusividadException {
        CorrectorClasico clasico = new CorrectorClasico();
        MultipleChoice pregunta = new MultipleChoice("Elegir los numeros en palabras 1 2 3", respuestasCorrectas, opciones, clasico);
        kahoot.setPreguntaActual(pregunta);
        kahoot.siguienteJugador();
        var jugador1 = kahoot.getJugadorActual();
        kahoot.siguienteJugador();
        var jugador2 = kahoot.getJugadorActual();

        kahoot.usarExclusividad(jugador1);
        var listaRespuestasJugador = new ArrayList<String>();
        listaRespuestasJugador.add("cuatro");
        var respuestasJugador = new Respuesta(listaRespuestasJugador);
        jugador2.respuestaElegida(respuestasJugador);
        jugador1.respuestaElegida(respuestasCorrectas);

        kahoot.puntuarPregunta();
        assertEquals(2, jugador1.getPuntaje());
        assertEquals(0, jugador2.getPuntaje());

        //Siguiente pregunta

        var listaCorrectas2 = new ArrayList<String>();
        listaCorrectas2.add("uno");
        listaCorrectas2.add("dos");
        Respuesta respuestasCorrectas2 = respuestasCorrectas;
        CorrectorClasico clasico2 = new CorrectorClasico();
        MultipleChoice pregunta2 = new MultipleChoice("Elegir los numeros en palabras 1 2", respuestasCorrectas2, opciones, clasico);
        kahoot.setPreguntaActual(pregunta2);
        jugador1.respuestaElegida(respuestasCorrectas2);
        jugador2.respuestaElegida(respuestasCorrectas2);

        kahoot.puntuarPregunta();
        assertEquals(3, jugador1.getPuntaje());
        assertEquals(1, jugador2.getPuntaje());
    }
    @Test
    public void test06JugadorIntentaActivarPreguntaConExclusividadPeroNoHaceEfectoEnPreguntaConPenalidad() throws RondaFinalizadaException, NoTieneExclusividadException {
        CorrectorPenalidad penalidad = new CorrectorPenalidad();
        MultipleChoice pregunta = new MultipleChoice("Elegir los numeros en palabras 1 2 3", respuestasCorrectas, opciones, penalidad);
        kahoot.setPreguntaActual(pregunta);
        kahoot.siguienteJugador();
        var jugador1 = kahoot.getJugadorActual();
        kahoot.siguienteJugador();
        var jugador2 = kahoot.getJugadorActual();
        kahoot.usarExclusividad(jugador1);
        var listaRespuestasJugador = new ArrayList<String>();
        listaRespuestasJugador.add("cuatro");
        var respuestasJugador = new Respuesta(listaRespuestasJugador);
        jugador2.respuestaElegida(respuestasJugador);
        jugador1.respuestaElegida(respuestasCorrectas);

        kahoot.puntuarPregunta();
        assertEquals(3, jugador1.getPuntaje());
        assertEquals(0, jugador2.getPuntaje());
    }

}