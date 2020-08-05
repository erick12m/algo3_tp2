package edu.fiuba.algo3.modelo.TestsPreguntas.MultipleChoice;

import edu.fiuba.algo3.modelo.correccion.CorrectorClasico;
import edu.fiuba.algo3.modelo.correccion.CorrectorParcial;
import edu.fiuba.algo3.modelo.correccion.CorrectorPenalidad;
import edu.fiuba.algo3.modelo.correccion.Respuesta;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.preguntas.MultipleChoice;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MultipleChoiceTest {
    private Jugador jugador1;
    private Jugador jugador2;
    private ArrayList<String> opciones;
    private Respuesta respuestasCorrectas;

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
        respuestasCorrectas = new Respuesta(listaCorrectas);

    }
    //Test Puntaje Clasico
    @Test
    public void test01PuntajeClasicoJugadorRespondeCorrectamenteYSumaUnPunto() {
        CorrectorClasico clasico = new CorrectorClasico();
        MultipleChoice pregunta = new MultipleChoice("Elegir los numeros en palabras 1 2 3", respuestasCorrectas, opciones, clasico);

        jugador1.respuestaElegida(respuestasCorrectas);

        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(jugador1.getRespuesta());
        pregunta.evaluarRespuesta(respuestas);
        jugador1.actualizarPuntaje();
        assertEquals(1, jugador1.getPuntaje());
    }
    @Test
    public void test02PuntajeClasicoJugadorRespondeIncorrectamenteYSigueEn0Puntos(){
        CorrectorClasico clasico = new CorrectorClasico();
        MultipleChoice pregunta = new MultipleChoice("Elegir los numeros en palabras 1 2 3", respuestasCorrectas, opciones, clasico);
        var respuestasJugador = new ArrayList<String>();
        respuestasJugador.add("cuatro");

        jugador1.respuestaElegida(new Respuesta(respuestasJugador));


        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(jugador1.getRespuesta());
        pregunta.evaluarRespuesta(respuestas);
        jugador1.actualizarPuntaje();
        assertEquals(0, jugador1.getPuntaje());
    }
    @Test
    public void test03PuntajeClasicoJugadorRespondeIncorrectamenteEligiendoMenosOpcionesCorrectasYSigueTeniendoCeroPuntos() {
        CorrectorClasico clasico = new CorrectorClasico();
        MultipleChoice pregunta = new MultipleChoice("Elegir los numeros en palabras 1 2 3", respuestasCorrectas, opciones, clasico);
        var listaRespuestasJugador = new ArrayList<String>();
        listaRespuestasJugador.add("uno");
        var respuestasJugador = new Respuesta(listaRespuestasJugador);
        jugador1.respuestaElegida(respuestasJugador);


        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(jugador1.getRespuesta());
        pregunta.evaluarRespuesta(respuestas);
        jugador1.actualizarPuntaje();
        assertEquals(0, jugador1.getPuntaje());
    }
    @Test
    public void test04PuntajeClasicoJugadorRespondeIncorrectamenteEligiendoOpcionIncorrectaYSigueTeniendoCeroPuntos() {
        CorrectorClasico clasico = new CorrectorClasico();

        MultipleChoice pregunta = new MultipleChoice("Elegir los numeros en palabras 1 2 3", respuestasCorrectas, opciones, clasico);
        var listaRespuestasJugador = new ArrayList<String>();
        listaRespuestasJugador.add("cuatro");
        var respuestasJugador = new Respuesta(listaRespuestasJugador);
        jugador1.respuestaElegida(respuestasJugador);


        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(jugador1.getRespuesta());
        pregunta.evaluarRespuesta(respuestas);
        jugador1.actualizarPuntaje();
        assertEquals(0, jugador1.getPuntaje());
    }
    @Test
    public void test05PuntajeClasicoRafaelRespondeCorrectamenteYGana1PuntoYPabloIncorrectamenteYSigueEn0() {
        CorrectorClasico clasico = new CorrectorClasico();
        MultipleChoice pregunta = new MultipleChoice("Elegir los numeros en palabras 1 2 3", respuestasCorrectas, opciones, clasico);
        var listaRespuestasJugador = new ArrayList<String>();
        listaRespuestasJugador.add("cuatro");
        var respuestasJugador = new Respuesta(listaRespuestasJugador);
        jugador2.respuestaElegida(respuestasJugador);
        jugador1.respuestaElegida(respuestasCorrectas);

        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(jugador1.getRespuesta());
        respuestas.add(jugador2.getRespuesta());
        pregunta.evaluarRespuesta(respuestas);
        jugador1.actualizarPuntaje();
        jugador2.actualizarPuntaje();
        assertEquals(1, jugador1.getPuntaje());
        assertEquals(0, jugador2.getPuntaje());
    }
    //Test Puntaje Parcial
    @Test
    public void test06PuntajeParcialJugadorRespondeCorrectamenteYSumaTantosPuntosComoRespuestasCorrectas(){
        CorrectorParcial parcial = new CorrectorParcial();

        MultipleChoice pregunta = new MultipleChoice("Elegir los numeros en palabras 1 2 3", respuestasCorrectas, opciones, parcial);
        var listaRespuestasJugador2 = new ArrayList<String>();
        jugador1.respuestaElegida(respuestasCorrectas);
        listaRespuestasJugador2.add("uno");
        jugador2.respuestaElegida(new Respuesta(listaRespuestasJugador2));

        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(jugador1.getRespuesta());
        respuestas.add(jugador2.getRespuesta());
        pregunta.evaluarRespuesta(respuestas);
        jugador1.actualizarPuntaje();
        jugador2.actualizarPuntaje();
        assertEquals(3, jugador1.getPuntaje());
        assertEquals(1,jugador2.getPuntaje());

    }
    @Test
    public void test07PuntajeParcialJugadorRespondeAlgunasCorrectasYUnaIncorrectaYNoSumaPuntos(){
        CorrectorParcial parcial = new CorrectorParcial();

        MultipleChoice pregunta = new MultipleChoice("Elegir los numeros en palabras 1 2 3", respuestasCorrectas, opciones, parcial);
        var respuestasJugador = new ArrayList<String>();
        respuestasJugador.add("uno");
        respuestasJugador.add("dos");
        respuestasJugador.add("cuatro");

        jugador1.respuestaElegida(new Respuesta(respuestasJugador));


        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(jugador1.getRespuesta());
        pregunta.evaluarRespuesta(respuestas);
        jugador1.actualizarPuntaje();
        assertEquals(0, jugador1.getPuntaje());
    }
    @Test
    public void test08PuntajeParcialRafaelRespondeCorrectamenteDosYPabloUnaYObtienenPuntajeCorrecto(){
        CorrectorParcial parcial = new CorrectorParcial();

        MultipleChoice pregunta = new MultipleChoice("Elegir los numeros en palabras 1 2 3", respuestasCorrectas, opciones, parcial);
        var listaRespuestasJugador1 = new ArrayList<String>();
        listaRespuestasJugador1.add("uno");
        listaRespuestasJugador1.add("dos");
        var respuestasJugador1 = new Respuesta(listaRespuestasJugador1);
        jugador1.respuestaElegida(respuestasJugador1);
        var listaRespuestasJugador2 = new ArrayList<String>();
        listaRespuestasJugador2.add("tres");
        var respuestasJugador2 = new Respuesta(listaRespuestasJugador2);
        jugador2.respuestaElegida(respuestasJugador2);

        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(jugador1.getRespuesta());
        respuestas.add(jugador2.getRespuesta());
        pregunta.evaluarRespuesta(respuestas);
        jugador1.actualizarPuntaje();
        jugador2.actualizarPuntaje();
        assertEquals(2, jugador1.getPuntaje());
        assertEquals(1, jugador2.getPuntaje());
    }
    //Test Puntaje Penalidad
    @Test
    public void test09PuntajePenalidadJugadorResponde2CorrectasY1IncorrectaYTiene1Punto(){
        CorrectorPenalidad penalidad = new CorrectorPenalidad();

        MultipleChoice pregunta = new MultipleChoice("Elegir los numeros en palabras 1 2 3", respuestasCorrectas, opciones, penalidad);
        var listaRespuestasJugador = new ArrayList<String>();
        listaRespuestasJugador.add("uno");
        listaRespuestasJugador.add("dos");
        listaRespuestasJugador.add("cuatro");
        jugador1.respuestaElegida(new Respuesta(listaRespuestasJugador));

        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(jugador1.getRespuesta());
        pregunta.evaluarRespuesta(respuestas);
        jugador1.actualizarPuntaje();
        assertEquals(1, jugador1.getPuntaje());

    }
    @Test
    public void test10PuntajePenalidadJugadorQueTeniaUnPuntoRespondeIncorrectamenteYLoPierde(){
        CorrectorPenalidad penalidad = new CorrectorPenalidad();

        MultipleChoice pregunta = new MultipleChoice("Elegir los numeros en palabras 1 2 3", respuestasCorrectas, opciones, penalidad);
        var listaRespuestasJugador = new ArrayList<String>();
        listaRespuestasJugador.add("uno");
        jugador1.respuestaElegida(new Respuesta(listaRespuestasJugador));

        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(jugador1.getRespuesta());
        pregunta.evaluarRespuesta(respuestas);
        jugador1.actualizarPuntaje();
        assertEquals(1, jugador1.getPuntaje());

        listaRespuestasJugador.remove(0);
        listaRespuestasJugador.add("cuatro");
        jugador1.respuestaElegida(new Respuesta(listaRespuestasJugador));
        respuestas.remove(0);
        respuestas.add(jugador1.getRespuesta());
        pregunta.evaluarRespuesta(respuestas);
        jugador1.actualizarPuntaje();
        assertEquals(0, jugador1.getPuntaje());
    }
    @Test
    public void test11PuntajePenalidadJugadorQueTiene0PuntosRespondeMalYSigueTeniendo0Puntos(){
        CorrectorPenalidad penalidad = new CorrectorPenalidad();

        MultipleChoice pregunta = new MultipleChoice("Elegir los numeros en palabras 1 2 3", respuestasCorrectas, opciones, penalidad);
        var listaRespuestasJugador = new ArrayList<String>();
        listaRespuestasJugador.add("cuatro");
        jugador1.respuestaElegida(new Respuesta(listaRespuestasJugador));

        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(jugador1.getRespuesta());
        pregunta.evaluarRespuesta(respuestas);
        jugador1.actualizarPuntaje();
        assertEquals(0, jugador1.getPuntaje());
    }
}
