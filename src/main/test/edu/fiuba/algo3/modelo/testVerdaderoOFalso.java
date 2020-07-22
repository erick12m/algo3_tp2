package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class testVerdaderoOFalso {
    @Test
    public void test01JugadorRespondeTrueCorrectamenteYSumaUnPunto() {

        Panel panel = new Panel();

        Jugador jugadorMock1 = mock(Jugador.class);

        Respuesta respuestaCorrecta = new Respuesta("true");
        var respuestasCorrectas = new ArrayList<Respuesta>();
        respuestasCorrectas.add(respuestaCorrecta);

        VerdaderoOFalso pregunta = new VerdaderoOFalso("enunciado", respuestasCorrectas);

        Respuesta respuestaTrue = new Respuesta("true");

        when(jugadorMock1.responderPregunta()).thenReturn(respuestaTrue);
        when(jugadorMock1.actualizarPuntaje(1)).thenCallRealMethod();
        when(jugadorMock1.obtenerPuntos()).thenCallRealMethod();

        panel.presentarPregunta(jugadorMock1, pregunta);

        assertEquals(1, jugadorMock1.obtenerPuntos());
    }

    @Test
    public void test02JugadorRespondeTrueIncorrectamenteYNoSumaPuntos() {

        Panel panel = new Panel();

        Jugador jugadorMock1 = mock(Jugador.class);

        panel.agregarJugador(jugadorMock1);
        Respuesta respuestaCorrecta = new Respuesta("false");
        var respuestasCorrectas = new ArrayList<Respuesta>();
        respuestasCorrectas.add(respuestaCorrecta);

        VerdaderoOFalso pregunta = new VerdaderoOFalso("enunciado", respuestasCorrectas);

        Respuesta respuestaTrue = new Respuesta("true");

        when(jugadorMock1.responderPregunta()).thenReturn(respuestaTrue);
        when(jugadorMock1.actualizarPuntaje(0)).thenCallRealMethod();
        when(jugadorMock1.obtenerPuntos()).thenCallRealMethod();

        panel.presentarPregunta(jugadorMock1, pregunta);

        assertEquals(0, jugadorMock1.obtenerPuntos());
    }

    @Test
    public void test03JugadorRespondeFalseCorrectamenteSumaUnPunto() {

        Panel panel = new Panel();

        Jugador jugadorMock1 = mock(Jugador.class);

        panel.agregarJugador(jugadorMock1);
        Respuesta respuestaCorrecta = new Respuesta("false");
        var respuestasCorrectas = new ArrayList<Respuesta>();
        respuestasCorrectas.add(respuestaCorrecta);

        VerdaderoOFalso pregunta = new VerdaderoOFalso("enunciado", respuestasCorrectas);

        Respuesta respuestaFalse = new Respuesta("false");

        when(jugadorMock1.responderPregunta()).thenReturn(respuestaFalse);
        when(jugadorMock1.actualizarPuntaje(1)).thenCallRealMethod();
        when(jugadorMock1.obtenerPuntos()).thenCallRealMethod();

        panel.presentarPregunta(jugadorMock1, pregunta);

        assertEquals(1, jugadorMock1.obtenerPuntos());
    }


    @Test
    public void test04JugadorRespondeFalseIncorrectamenteYNoSumaPuntos() {

        Panel panel = new Panel();

        Jugador jugadorMock1 = mock(Jugador.class);

        panel.agregarJugador(jugadorMock1);
        Respuesta respuestaCorrecta = new Respuesta("true");
        var respuestasCorrectas = new ArrayList<Respuesta>();
        respuestasCorrectas.add(respuestaCorrecta);

        VerdaderoOFalso pregunta = new VerdaderoOFalso("enunciado", respuestasCorrectas);

        Respuesta respuestaFalse = new Respuesta("false");

        when(jugadorMock1.responderPregunta()).thenReturn(respuestaFalse);
        when(jugadorMock1.actualizarPuntaje(0)).thenCallRealMethod();
        when(jugadorMock1.obtenerPuntos()).thenCallRealMethod();

        panel.presentarPregunta(jugadorMock1, pregunta);

        assertEquals(0, jugadorMock1.obtenerPuntos());
    }
}