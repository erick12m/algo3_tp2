package edu.fiuba.algo3.modelo.TestsPreguntas;

import edu.fiuba.algo3.modelo.correcciones.CorrectorClasico;
import edu.fiuba.algo3.modelo.correcciones.Respuesta;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.preguntas.OrderedChoice;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrderedChoiceTest {
    private Jugador jugador1;
    private Jugador jugador2;
    private ArrayList<String> opciones;
    private Respuesta respuestaCorrecta;

    @BeforeEach
    public void setUp(){
        jugador1 = new Jugador("Rafael");
        jugador2 = new Jugador("Pablo");

        opciones = new ArrayList<String>();
        opciones.add("uno");
        opciones.add("dos");
        opciones.add("tres");
        opciones.add("cuatro");

        var listaCorrectas = new ArrayList<String>();
        listaCorrectas.add("uno");
        listaCorrectas.add("dos");
        listaCorrectas.add("tres");
        listaCorrectas.add("cuatro");
        respuestaCorrecta = new Respuesta(listaCorrectas);

    }
    @Test
    public void test01JugadorRespondeOrdenCorrectamenteYSumaUnPunto() {
        CorrectorClasico clasico = new CorrectorClasico();
        OrderedChoice pregunta = new OrderedChoice("Ordene los numeros en forma creciente", respuestaCorrecta, opciones, clasico);

        jugador1.respuestaElegida(respuestaCorrecta);

        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(jugador1.getRespuesta());
        pregunta.evaluarRespuesta(respuestas);
        jugador1.actualizarPuntaje();
        assertEquals(1, jugador1.getPuntaje());
    }
    @Test
    public void test02JugadorRespondeOrdenIncorrectamenteYNoSumaPuntos() {
        CorrectorClasico clasico = new CorrectorClasico();

        OrderedChoice pregunta = new OrderedChoice("Ordene los numeros en forma creciente", respuestaCorrecta, opciones, clasico);
        var listaRespuestaJugador = new ArrayList<String>();
        listaRespuestaJugador.add("uno");
        listaRespuestaJugador.add("dos");
        listaRespuestaJugador.add("cuatro");
        listaRespuestaJugador.add("tres");
        var respuestaJugador = new Respuesta(listaRespuestaJugador);
        jugador1.respuestaElegida(respuestaJugador);


        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(jugador1.getRespuesta());
        pregunta.evaluarRespuesta(respuestas);
        jugador1.actualizarPuntaje();
        assertEquals(0, jugador1.getPuntaje());
    }
    @Test
    public void test03JugadorRespondeIncompletamenteYNoSumaPuntos() {
        CorrectorClasico clasico = new CorrectorClasico();

        OrderedChoice pregunta = new OrderedChoice("Ordene los numeros en forma creciente", respuestaCorrecta, opciones, clasico);
        var listaRespuestaJugador = new ArrayList<String>();
        listaRespuestaJugador.add("uno");
        listaRespuestaJugador.add("dos");
        listaRespuestaJugador.add("tres");
        var respuestaJugador = new Respuesta(listaRespuestaJugador);
        jugador1.respuestaElegida(respuestaJugador);


        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(jugador1.getRespuesta());
        pregunta.evaluarRespuesta(respuestas);
        jugador1.actualizarPuntaje();
        assertEquals(0, jugador1.getPuntaje());
    }
    @Test
    public void test04Jugador1OrdenaCorrectamenteYSumaUnPuntoJugador2OrdenaIncorrectamenteYNoSumaPuntos() {
        CorrectorClasico clasico = new CorrectorClasico();

        OrderedChoice pregunta = new OrderedChoice("Ordene los numeros en forma creciente", respuestaCorrecta, opciones, clasico);

        var listaRespuestaJugador = new ArrayList<String>();
        //Orden inverso
        listaRespuestaJugador.add("cuatro");
        listaRespuestaJugador.add("tres");
        listaRespuestaJugador.add("dos");
        listaRespuestaJugador.add("uno");
        var respuestaJugador = new Respuesta(listaRespuestaJugador);
        jugador2.respuestaElegida(respuestaJugador);
        jugador1.respuestaElegida(respuestaCorrecta);


        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(jugador1.getRespuesta());
        respuestas.add(jugador2.getRespuesta());
        pregunta.evaluarRespuesta(respuestas);
        jugador1.actualizarPuntaje();
        jugador2.actualizarPuntaje();
        assertEquals(1, jugador1.getPuntaje());
        assertEquals(0, jugador2.getPuntaje());
    }
    @Test
    public void test05AmbosJugadoresOrdenanIncorrectamenteYNoSumanPuntos() {
        CorrectorClasico clasico = new CorrectorClasico();

        OrderedChoice pregunta = new OrderedChoice("Ordene los numeros en forma creciente", respuestaCorrecta, opciones, clasico);

        var listaRespuestaJugador = new ArrayList<String>();
        //Orden inverso
        listaRespuestaJugador.add("cuatro");
        listaRespuestaJugador.add("tres");
        listaRespuestaJugador.add("dos");
        listaRespuestaJugador.add("uno");
        var respuestaJugador = new Respuesta(listaRespuestaJugador);
        jugador2.respuestaElegida(respuestaJugador);
        jugador1.respuestaElegida(respuestaJugador);


        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(jugador1.getRespuesta());
        respuestas.add(jugador2.getRespuesta());
        pregunta.evaluarRespuesta(respuestas);
        jugador1.actualizarPuntaje();
        jugador2.actualizarPuntaje();
        assertEquals(0, jugador1.getPuntaje());
        assertEquals(0, jugador2.getPuntaje());
    }
}
