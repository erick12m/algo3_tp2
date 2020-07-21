package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static edu.fiuba.algo3.modelo.Pregunta.crearPreguntaVerdaderoYFalso;
import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class test01VerdaderoYFalso {
    @Test
    public void verdaderoYFalso() {

        Panel panel = new Panel();

        Jugador jugadorMock1 = mock(Jugador.class);
        Jugador jugadorMock2 = mock(Jugador.class);

        panel.agregarJugador (jugadorMock1);
        panel.agregarJugador (jugadorMock2);

        Pregunta pregunta = crearPreguntaVerdaderoYFalso ("enunciado", true);

        panel.agregarPregunta (pregunta);

        when(jugadorMock1.obtenerRespuesta(pregunta)).thenReturn(true);
        when(jugadorMock2.obtenerRespuesta(pregunta)).thenReturn(false);

        panel.obtenerRespuestas(pregunta);

        assertEquals(1, jugadorMock1.obtenerPuntos());
        assertEquals(0, jugadorMock2.obtenerPuntos());
    }
}
