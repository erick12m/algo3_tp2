package edu.fiuba.algo3.modelo.TestsJugador;

import edu.fiuba.algo3.modelo.Kahoot;
import edu.fiuba.algo3.modelo.correccion.CorrectorPenalidad;
import edu.fiuba.algo3.modelo.correccion.Respuesta;
import edu.fiuba.algo3.modelo.excepciones.NoTieneMultiplicadorException;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.preguntas.VerdaderoFalso;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JugadorTest {
    @Test
    public void test01ElJugadorSeCreaCorrectamente() {
        Jugador jugador = new Jugador("Rafael");
        assertEquals("Rafael", jugador.getNombre());
    }

    @Test
    public void test02ElJugadorSeCreaYTienePuntajeCero() {
        Jugador jugador = new Jugador("Rafael");
        assertEquals(0, jugador.getPuntaje());
    }

    @Test
    public void test03ElJugadorActivaMultiplicadorx2YDevuelveDoblePuntos() throws NoTieneMultiplicadorException {
        Kahoot kahoot = new Kahoot();
        Jugador jugador = new Jugador("Rafael");
        ArrayList<String> opciones = new ArrayList<String>();
        opciones.add("Verdadero");
        opciones.add("Falso");

        ArrayList<String> respuesta = new ArrayList<String>();
        respuesta.add("Verdadero");

        CorrectorPenalidad penalidad = new CorrectorPenalidad();
        Respuesta respuestaCorrecta = new Respuesta(respuesta);

        VerdaderoFalso verdaderoFalso = new VerdaderoFalso("1 + 1 = 2?", respuestaCorrecta, opciones, penalidad);
        kahoot.setPreguntaActual(verdaderoFalso);
        ArrayList<Respuesta> respuestaJugador = new ArrayList<Respuesta>();
        jugador.respuestaElegida(respuestaCorrecta); //El jugador eligio la respuesta Verdadero
        respuestaJugador.add(jugador.getRespuesta());

        jugador.activarMultiplicadorx2();

        verdaderoFalso.evaluarRespuesta(respuestaJugador);
        jugador.actualizarPuntaje();
        assertEquals(2, jugador.getPuntaje());
    }

    @Test
    public void test04ElJugadorActivaMultiplicadorx3YDevuelveDoblePuntos() throws NoTieneMultiplicadorException {
        Kahoot kahoot = new Kahoot();
        Jugador jugador = new Jugador("Rafael");
        ArrayList<String> opciones = new ArrayList<String>();
        opciones.add("Verdadero");
        opciones.add("Falso");

        ArrayList<String> respuesta = new ArrayList<String>();
        respuesta.add("Verdadero");

        CorrectorPenalidad penalidad = new CorrectorPenalidad();
        Respuesta respuestaCorrecta = new Respuesta(respuesta);

        VerdaderoFalso verdaderoFalso = new VerdaderoFalso("1 + 1 = 2?", respuestaCorrecta, opciones, penalidad);
        kahoot.setPreguntaActual(verdaderoFalso);
        ArrayList<Respuesta> respuestaJugador = new ArrayList<Respuesta>();
        jugador.respuestaElegida(respuestaCorrecta); //El jugador eligio la respuesta Verdadero
        respuestaJugador.add(jugador.getRespuesta());

        jugador.activarMultiplicadorx3();

        verdaderoFalso.evaluarRespuesta(respuestaJugador);
        jugador.actualizarPuntaje();
        assertEquals(3, jugador.getPuntaje());
    }
    @Test
    public void test04ElJugadorActivaMultiplicadorx2YEnLaSiguientePreguntaNoHaceEfecto() throws NoTieneMultiplicadorException {
        Kahoot kahoot = new Kahoot();
        Jugador jugador = new Jugador("Rafael");
        ArrayList<String> opciones = new ArrayList<String>();
        opciones.add("Verdadero");
        opciones.add("Falso");

        ArrayList<String> respuesta = new ArrayList<String>();
        respuesta.add("Verdadero");

        CorrectorPenalidad penalidad = new CorrectorPenalidad();
        Respuesta respuestaCorrecta = new Respuesta(respuesta);

        VerdaderoFalso verdaderoFalso = new VerdaderoFalso("1 + 1 = 2?", respuestaCorrecta, opciones, penalidad);
        kahoot.setPreguntaActual(verdaderoFalso);

        jugador.respuestaElegida(respuestaCorrecta); //El jugador eligio la respuesta Verdadero
        ArrayList<Respuesta> respuestaJugador = new ArrayList<Respuesta>();
        respuestaJugador.add(jugador.getRespuesta());

        jugador.activarMultiplicadorx2();

        verdaderoFalso.evaluarRespuesta(respuestaJugador);
        jugador.actualizarPuntaje();
        assertEquals(2, jugador.getPuntaje());

        //siguiente pregunta

        VerdaderoFalso verdaderoFalso2 = new VerdaderoFalso("1 - 1 = 0?", respuestaCorrecta, opciones, penalidad);
        kahoot.setPreguntaActual(verdaderoFalso2);

        jugador.respuestaElegida(respuestaCorrecta);
        ArrayList<Respuesta> respuestaJugador2 = new ArrayList<Respuesta>();
        respuestaJugador2.add(jugador.getRespuesta());

        verdaderoFalso.evaluarRespuesta(respuestaJugador);
        jugador.actualizarPuntaje();
        assertEquals(3, jugador.getPuntaje());

    }

    @Test
    public void test05ElJugadorActivaMultiplicadorx3YEnLaSiguientePreguntaNoHaceEfecto() throws NoTieneMultiplicadorException {
        Kahoot kahoot = new Kahoot();
        Jugador jugador = new Jugador("Rafael");
        ArrayList<String> opciones = new ArrayList<String>();
        opciones.add("Verdadero");
        opciones.add("Falso");

        ArrayList<String> respuesta = new ArrayList<String>();
        respuesta.add("Verdadero");

        CorrectorPenalidad penalidad = new CorrectorPenalidad();
        Respuesta respuestaCorrecta = new Respuesta(respuesta);

        VerdaderoFalso verdaderoFalso = new VerdaderoFalso("1 + 1 = 2?", respuestaCorrecta, opciones, penalidad);
        kahoot.setPreguntaActual(verdaderoFalso);

        jugador.respuestaElegida(respuestaCorrecta); //El jugador eligio la respuesta Verdadero
        ArrayList<Respuesta> respuestaJugador = new ArrayList<Respuesta>();
        respuestaJugador.add(jugador.getRespuesta());

        jugador.activarMultiplicadorx3();

        verdaderoFalso.evaluarRespuesta(respuestaJugador);
        jugador.actualizarPuntaje();
        assertEquals(3, jugador.getPuntaje());

        //siguiente pregunta

        VerdaderoFalso verdaderoFalso2 = new VerdaderoFalso("1 - 1 = 0?", respuestaCorrecta, opciones, penalidad);
        kahoot.setPreguntaActual(verdaderoFalso2);

        jugador.respuestaElegida(respuestaCorrecta);
        ArrayList<Respuesta> respuestaJugador2 = new ArrayList<Respuesta>();
        respuestaJugador2.add(jugador.getRespuesta());

        verdaderoFalso.evaluarRespuesta(respuestaJugador);
        jugador.actualizarPuntaje();
        assertEquals(4, jugador.getPuntaje());

    }
}

 /*   @Test
    public void testChevere(){
        Kahoot kahoot = new Kahoot();
        Jugador jugador = new Jugador("Rafael");

        ArrayList<String> opciones = new ArrayList<String>();
        opciones.add("Verdadero");
        opciones.add("Falso");

        ArrayList<String> respuesta = new ArrayList<String>();
        respuesta.add("Verdadero");

        CorrectorClasico penalidad = new CorrectorClasico();

        VerdaderoFalso verdaderoFalso = new VerdaderoFalso("1 + 1 = 2?", new Respuesta(opciones), opciones, penalidad);
        kahoot.setPreguntaActual(verdaderoFalso);
        jugador.activarMultiplicador();
    }
*/