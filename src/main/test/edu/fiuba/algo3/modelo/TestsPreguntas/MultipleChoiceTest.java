package edu.fiuba.algo3.modelo.TestsPreguntas;

import edu.fiuba.algo3.modelo.correccion.CorrectorClasico;
import edu.fiuba.algo3.modelo.correccion.CorrectorParcial;
import edu.fiuba.algo3.modelo.correccion.CorrectorPenalidad;
import edu.fiuba.algo3.modelo.correccion.Respuesta;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.preguntas.MultipleChoice;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MultipleChoiceTest {
    //Test Puntaje Clasico
    @Test
    public void test01PuntajeClasicoJugadorRespondeCorrectamenteYSumaUnPunto() {

        Jugador jugador = new Jugador("Rafael"); //No anda con moc

        var listaCorrectas = new ArrayList<String>();
        listaCorrectas.add("uno");
        listaCorrectas.add("dos");
        listaCorrectas.add("tres");
        CorrectorClasico clasico = new CorrectorClasico();
        var respuestasCorrectas = new Respuesta(listaCorrectas);

        ArrayList<String> opciones = new ArrayList<String>();
        opciones.add("uno");
        opciones.add("dos");
        opciones.add("tres");
        opciones.add("cuatro");

        MultipleChoice pregunta = new MultipleChoice("Elegir los numeros en palabras 1 2 3", respuestasCorrectas, opciones, clasico);
        var respuestasJugador = new ArrayList<String>();


        jugador.respuestaElegida(respuestasCorrectas);


        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(jugador.getRespuesta());
        pregunta.evaluarRespuesta(respuestas);
        jugador.actualizarPuntaje();
        assertEquals(1, jugador.getPuntaje());
    }
    @Test
    public void test02PuntajeClasicoJugadorRespondeIncorrectamenteYSigueEn0Puntos(){
        Jugador jugador = new Jugador("Rafael"); //No anda con moc

        var listaCorrectas = new ArrayList<String>();
        listaCorrectas.add("uno");
        listaCorrectas.add("dos");
        listaCorrectas.add("tres");
        CorrectorClasico clasico = new CorrectorClasico();
        var respuestasCorrectas = new Respuesta(listaCorrectas);

        ArrayList<String> opciones = new ArrayList<String>();
        opciones.add("uno");
        opciones.add("dos");
        opciones.add("tres");
        opciones.add("cuatro");

        MultipleChoice pregunta = new MultipleChoice("Elegir los numeros en palabras 1 2 3", respuestasCorrectas, opciones, clasico);
        var respuestasJugador = new ArrayList<String>();
        respuestasJugador.add("cuatro");

        jugador.respuestaElegida(new Respuesta(respuestasJugador));


        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(jugador.getRespuesta());
        pregunta.evaluarRespuesta(respuestas);
        jugador.actualizarPuntaje();
        assertEquals(0, jugador.getPuntaje());
    }
    @Test
    public void test03PuntajeClasicoJugadorRespondeIncorrectamenteEligiendoMenosOpcionesCorrectasYSigueTeniendoCeroPuntos() {

        Jugador jugador = new Jugador("Rafael");

        var listaCorrectas = new ArrayList<String>();
        listaCorrectas.add("uno");
        listaCorrectas.add("dos");
        listaCorrectas.add("tres");
        CorrectorClasico clasico = new CorrectorClasico();
        var respuestasCorrectas = new Respuesta(listaCorrectas);

        ArrayList<String> opciones = new ArrayList<String>();
        opciones.add("uno");
        opciones.add("dos");
        opciones.add("tres");
        opciones.add("cuatro");

        MultipleChoice pregunta = new MultipleChoice("Elegir los numeros en palabras 1 2 3", respuestasCorrectas, opciones, clasico);
        var listaRespuestasJugador = new ArrayList<String>();
        listaRespuestasJugador.add("uno");
        var respuestasJugador = new Respuesta(listaRespuestasJugador);
        jugador.respuestaElegida(respuestasJugador);


        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(jugador.getRespuesta());
        pregunta.evaluarRespuesta(respuestas);
        jugador.actualizarPuntaje();
        assertEquals(0, jugador.getPuntaje());
    }
    @Test
    public void test04PuntajeClasicoJugadorRespondeIncorrectamenteEligiendoOpcionIncorrectaYSigueTeniendoCeroPuntos() {

        Jugador jugador = new Jugador("Rafael");

        var listaCorrectas = new ArrayList<String>();
        listaCorrectas.add("uno");
        listaCorrectas.add("dos");
        listaCorrectas.add("tres");
        CorrectorClasico clasico = new CorrectorClasico();
        var respuestasCorrectas = new Respuesta(listaCorrectas);

        ArrayList<String> opciones = new ArrayList<String>();
        opciones.add("uno");
        opciones.add("dos");
        opciones.add("tres");
        opciones.add("cuatro");

        MultipleChoice pregunta = new MultipleChoice("Elegir los numeros en palabras 1 2 3", respuestasCorrectas, opciones, clasico);
        var listaRespuestasJugador = new ArrayList<String>();
        listaRespuestasJugador.add("cuatro");
        var respuestasJugador = new Respuesta(listaRespuestasJugador);
        jugador.respuestaElegida(respuestasJugador);


        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(jugador.getRespuesta());
        pregunta.evaluarRespuesta(respuestas);
        jugador.actualizarPuntaje();
        assertEquals(0, jugador.getPuntaje());
    }
    @Test
    public void test05PuntajeClasicoRafaelRespondeCorrectamenteYGana1PuntoYPabloIncorrectamenteYSigueEn0() {

        Jugador jugador1 = new Jugador("Rafael");
        Jugador jugador2 = new Jugador("Pablo");
        var listaCorrectas = new ArrayList<String>();
        listaCorrectas.add("uno");
        listaCorrectas.add("dos");
        listaCorrectas.add("tres");
        CorrectorClasico clasico = new CorrectorClasico();
        var respuestasCorrectas = new Respuesta(listaCorrectas);

        ArrayList<String> opciones = new ArrayList<String>();
        opciones.add("uno");
        opciones.add("dos");
        opciones.add("tres");
        opciones.add("cuatro");

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
        Jugador rafael = new Jugador("Rafael");
        Jugador pablo = new Jugador("Pablo");

        var listaCorrectas = new ArrayList<String>();
        listaCorrectas.add("uno");
        listaCorrectas.add("dos");
        listaCorrectas.add("tres");
        CorrectorParcial parcial = new CorrectorParcial();
        var respuestasCorrectas = new Respuesta(listaCorrectas);

        ArrayList<String> opciones = new ArrayList<String>();
        opciones.add("uno");
        opciones.add("dos");
        opciones.add("tres");
        opciones.add("cuatro");

        MultipleChoice pregunta = new MultipleChoice("Elegir los numeros en palabras 1 2 3", respuestasCorrectas, opciones, parcial);
        var listaRespuestasJugador2 = new ArrayList<String>();
        rafael.respuestaElegida(respuestasCorrectas);
        listaRespuestasJugador2.add("uno");
        pablo.respuestaElegida(new Respuesta(listaRespuestasJugador2));

        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(rafael.getRespuesta());
        respuestas.add(pablo.getRespuesta());
        pregunta.evaluarRespuesta(respuestas);
        rafael.actualizarPuntaje();
        pablo.actualizarPuntaje();
        assertEquals(3, rafael.getPuntaje());
        assertEquals(1,pablo.getPuntaje());

    }
    @Test
    public void test07PuntajeParcialJugadorRespondeAlgunasCorrectasYUnaIncorrectaYNoSumaPuntos(){
        Jugador jugador = new Jugador("Rafael"); //No anda con moc

        var listaCorrectas = new ArrayList<String>();
        listaCorrectas.add("uno");
        listaCorrectas.add("dos");
        listaCorrectas.add("tres");
        CorrectorParcial parcial = new CorrectorParcial();
        var respuestasCorrectas = new Respuesta(listaCorrectas);

        ArrayList<String> opciones = new ArrayList<String>();
        opciones.add("uno");
        opciones.add("dos");
        opciones.add("tres");
        opciones.add("cuatro");

        MultipleChoice pregunta = new MultipleChoice("Elegir los numeros en palabras 1 2 3", respuestasCorrectas, opciones, parcial);
        var respuestasJugador = new ArrayList<String>();
        respuestasJugador.add("uno");
        respuestasJugador.add("dos");
        respuestasJugador.add("cuatro");

        jugador.respuestaElegida(new Respuesta(respuestasJugador));


        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(jugador.getRespuesta());
        pregunta.evaluarRespuesta(respuestas);
        jugador.actualizarPuntaje();
        assertEquals(0, jugador.getPuntaje());
    }
    @Test
    public void test08PuntajeParcialRafaelRespondeCorrectamenteDosYPabloUnaYObtienenPuntajeCorrecto(){
        Jugador jugador1 = new Jugador("Rafael");
        Jugador jugador2 = new Jugador("Pablo");
        var listaCorrectas = new ArrayList<String>();
        listaCorrectas.add("uno");
        listaCorrectas.add("dos");
        listaCorrectas.add("tres");
        CorrectorParcial parcial = new CorrectorParcial();
        var respuestasCorrectas = new Respuesta(listaCorrectas);

        ArrayList<String> opciones = new ArrayList<String>();
        opciones.add("uno");
        opciones.add("dos");
        opciones.add("tres");
        opciones.add("cuatro");

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
        Jugador rafael = new Jugador("Rafael");

        var listaCorrectas = new ArrayList<String>();
        listaCorrectas.add("uno");
        listaCorrectas.add("dos");
        listaCorrectas.add("tres");
        CorrectorPenalidad penalidad = new CorrectorPenalidad();
        var respuestasCorrectas = new Respuesta(listaCorrectas);

        ArrayList<String> opciones = new ArrayList<String>();
        opciones.add("uno");
        opciones.add("dos");
        opciones.add("tres");
        opciones.add("cuatro");

        MultipleChoice pregunta = new MultipleChoice("Elegir los numeros en palabras 1 2 3", respuestasCorrectas, opciones, penalidad);
        var listaRespuestasJugador = new ArrayList<String>();
        listaRespuestasJugador.add("uno");
        listaRespuestasJugador.add("dos");
        listaRespuestasJugador.add("cuatro");
        rafael.respuestaElegida(new Respuesta(listaRespuestasJugador));

        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(rafael.getRespuesta());
        pregunta.evaluarRespuesta(respuestas);
        rafael.actualizarPuntaje();
        assertEquals(1, rafael.getPuntaje());

    }
    @Test
    public void test10PuntajePenalidadJugadorQueTeniaUnPuntoRespondeIncorrectamenteYLoPierde(){
        Jugador rafael = new Jugador("Rafael");

        var listaCorrectas = new ArrayList<String>();
        listaCorrectas.add("uno");
        listaCorrectas.add("dos");
        listaCorrectas.add("tres");
        CorrectorPenalidad penalidad = new CorrectorPenalidad();
        var respuestasCorrectas = new Respuesta(listaCorrectas);

        ArrayList<String> opciones = new ArrayList<String>();
        opciones.add("uno");
        opciones.add("dos");
        opciones.add("tres");
        opciones.add("cuatro");

        MultipleChoice pregunta = new MultipleChoice("Elegir los numeros en palabras 1 2 3", respuestasCorrectas, opciones, penalidad);
        var listaRespuestasJugador = new ArrayList<String>();
        listaRespuestasJugador.add("uno");
        rafael.respuestaElegida(new Respuesta(listaRespuestasJugador));

        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(rafael.getRespuesta());
        pregunta.evaluarRespuesta(respuestas);
        rafael.actualizarPuntaje();
        assertEquals(1, rafael.getPuntaje());

        listaRespuestasJugador.remove(0);
        listaRespuestasJugador.add("cuatro");
        rafael.respuestaElegida(new Respuesta(listaRespuestasJugador));
        respuestas.remove(0);
        respuestas.add(rafael.getRespuesta());
        pregunta.evaluarRespuesta(respuestas);
        rafael.actualizarPuntaje();
        assertEquals(0, rafael.getPuntaje());
    }
    @Test
    public void test11PuntajePenalidadJugadorQueTiene0PuntosRespondeMalYSigueTeniendo0Puntos(){
        Jugador rafael = new Jugador("Rafael");

        var listaCorrectas = new ArrayList<String>();
        listaCorrectas.add("uno");
        listaCorrectas.add("dos");
        listaCorrectas.add("tres");
        CorrectorPenalidad penalidad = new CorrectorPenalidad();
        var respuestasCorrectas = new Respuesta(listaCorrectas);

        ArrayList<String> opciones = new ArrayList<String>();
        opciones.add("uno");
        opciones.add("dos");
        opciones.add("tres");
        opciones.add("cuatro");

        MultipleChoice pregunta = new MultipleChoice("Elegir los numeros en palabras 1 2 3", respuestasCorrectas, opciones, penalidad);
        var listaRespuestasJugador = new ArrayList<String>();
        listaRespuestasJugador.add("cuatro");
        rafael.respuestaElegida(new Respuesta(listaRespuestasJugador));

        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(rafael.getRespuesta());
        pregunta.evaluarRespuesta(respuestas);
        rafael.actualizarPuntaje();
        assertEquals(0, rafael.getPuntaje());
    }
}
