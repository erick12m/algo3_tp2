package edu.fiuba.algo3.modelo.TestsPreguntas;

import edu.fiuba.algo3.modelo.correccion.CorrectorClasico;
import edu.fiuba.algo3.modelo.correccion.Respuesta;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.preguntas.GroupChoice;
import edu.fiuba.algo3.modelo.preguntas.MultipleChoice;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GroupChoiceTest {
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

        var grupoCorrectas1 = new ArrayList<String>();
        var grupoCorrectas2 = new ArrayList<String>();
        grupoCorrectas1.add("uno");
        grupoCorrectas2.add("dos");
        grupoCorrectas1.add("tres");
        grupoCorrectas2.add("cuatro");
        respuestaCorrecta = new Respuesta(grupoCorrectas1,grupoCorrectas2);

    }
    @Test
    public void test01JugadorAgrupaCorrectamenteYSumaUnPunto() {
        CorrectorClasico clasico = new CorrectorClasico();
        GroupChoice pregunta = new GroupChoice("Separe los pares de los impares", respuestaCorrecta, opciones, clasico);

        jugador1.respuestaElegida(respuestaCorrecta);

        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(jugador1.getRespuesta());
        pregunta.evaluarRespuesta(respuestas);
        jugador1.actualizarPuntaje();
        assertEquals(1, jugador1.getPuntaje());
    }
    @Test
    public void test02JugadorAgrupaIncorrectamenteYNoSumaPuntos() {
        CorrectorClasico clasico = new CorrectorClasico();
        GroupChoice pregunta = new GroupChoice("Separe pares de impares", respuestaCorrecta, opciones, clasico);

        var grupoJugador1 = new ArrayList<String>();
        var grupoJugador2 = new ArrayList<String>();
        grupoJugador1.add("uno");
        grupoJugador1.add("dos");
        grupoJugador2.add("cuatro");
        grupoJugador2.add("tres");
        var respuestaJugador = new Respuesta(grupoJugador1,grupoJugador2);
        jugador1.respuestaElegida(respuestaJugador);

        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(jugador1.getRespuesta());
        pregunta.evaluarRespuesta(respuestas);
        jugador1.actualizarPuntaje();
        assertEquals(0, jugador1.getPuntaje());
    }
    @Test
    public void test03JugadorAgrupaIncompletamenteYNoSumaPuntos() {
        CorrectorClasico clasico = new CorrectorClasico();
        GroupChoice pregunta = new GroupChoice("Separe pares de impares", respuestaCorrecta, opciones, clasico);

        var grupoJugador1 = new ArrayList<String>();
        var grupoJugador2 = new ArrayList<String>();
        grupoJugador1.add("uno");
        grupoJugador2.add("cuatro");
        grupoJugador2.add("tres");
        var respuestaJugador = new Respuesta(grupoJugador1,grupoJugador2);
        jugador1.respuestaElegida(respuestaJugador);
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(jugador1.getRespuesta());
        pregunta.evaluarRespuesta(respuestas);
        jugador1.actualizarPuntaje();
        assertEquals(0, jugador1.getPuntaje());
    }
    @Test
    public void test04Jugador1AgrupaCorrectamenteYSumaUnPuntoJugador2AgrupaIncorrectamenteYNoSumaPuntos() {
        CorrectorClasico clasico = new CorrectorClasico();
        GroupChoice pregunta = new GroupChoice("Separe pares de impares", respuestaCorrecta, opciones, clasico);

        var grupo1Jugador1 = new ArrayList<String>();
        var grupo2Jugador1 = new ArrayList<String>();
        var grupo1Jugador2 = new ArrayList<String>();
        var grupo2Jugador2 = new ArrayList<String>();
        //Las respuestas de cada uno están desordenadas para este test
        grupo1Jugador1.add("tres");
        grupo1Jugador1.add("uno");
        grupo2Jugador1.add("cuatro");
        grupo2Jugador1.add("dos");

        grupo1Jugador2.add("uno");
        grupo1Jugador2.add("cuatro");
        grupo2Jugador2.add("dos");
        grupo2Jugador2.add("tres");
        var respuestaJugador1 = new Respuesta(grupo1Jugador1,grupo2Jugador1);
        var respuestaJugador2 = new Respuesta(grupo1Jugador2,grupo2Jugador2);
        jugador1.respuestaElegida(respuestaJugador1);
        jugador2.respuestaElegida(respuestaJugador2);


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
    public void test05AmbosJugadoresAgrupanIncorrectamenteYNingunoSumaPuntos() {
        CorrectorClasico clasico = new CorrectorClasico();
        GroupChoice pregunta = new GroupChoice("Separe pares de impares", respuestaCorrecta, opciones, clasico);

        var grupo1Jugador1 = new ArrayList<String>();
        var grupo2Jugador1 = new ArrayList<String>();
        var grupo1Jugador2 = new ArrayList<String>();
        var grupo2Jugador2 = new ArrayList<String>();
        //Las respuestas de cada uno están desordenadas para este test
        grupo1Jugador1.add("dos");
        grupo1Jugador1.add("uno");
        grupo2Jugador1.add("cuatro");
        grupo2Jugador1.add("tres");

        grupo1Jugador2.add("uno");
        grupo1Jugador2.add("cuatro");
        grupo2Jugador2.add("dos");
        grupo2Jugador2.add("tres");
        var respuestaJugador1 = new Respuesta(grupo1Jugador1,grupo2Jugador1);
        var respuestaJugador2 = new Respuesta(grupo1Jugador2,grupo2Jugador2);
        jugador1.respuestaElegida(respuestaJugador1);
        jugador2.respuestaElegida(respuestaJugador2);


        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(jugador1.getRespuesta());
        respuestas.add(jugador2.getRespuesta());
        pregunta.evaluarRespuesta(respuestas);
        jugador1.actualizarPuntaje();
        jugador2.actualizarPuntaje();
        assertEquals(0, jugador1.getPuntaje());
        assertEquals(0, jugador2.getPuntaje());
    }

    @Test
    public void test06AmbosJugadoresAgrupanIncompletamenteYNingunoSumaPuntos() {
        CorrectorClasico clasico = new CorrectorClasico();
        GroupChoice pregunta = new GroupChoice("Separe pares de impares", respuestaCorrecta, opciones, clasico);

        var grupo1Jugador1 = new ArrayList<String>();
        var grupo2Jugador1 = new ArrayList<String>();
        var grupo1Jugador2 = new ArrayList<String>();
        var grupo2Jugador2 = new ArrayList<String>();
        //Las respuestas de cada uno están desordenadas para este test
        grupo1Jugador1.add("dos");
        grupo2Jugador1.add("cuatro");

        grupo1Jugador2.add("uno");
        grupo2Jugador2.add("tres");
        var respuestaJugador1 = new Respuesta(grupo1Jugador1,grupo2Jugador1);
        var respuestaJugador2 = new Respuesta(grupo1Jugador2,grupo2Jugador2);
        jugador1.respuestaElegida(respuestaJugador1);
        jugador2.respuestaElegida(respuestaJugador2);


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
