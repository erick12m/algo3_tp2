package edu.fiuba.algo3.modelo.TestsPreguntas;

import edu.fiuba.algo3.modelo.correccion.CorrectorClasico;
import edu.fiuba.algo3.modelo.correccion.Respuesta;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.preguntas.GroupChoice;
import edu.fiuba.algo3.modelo.preguntas.MultipleChoice;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GroupChoiceTest {
    @Test
    public void test01JugadorAgrupaCorrectamenteYSumaUnPunto() {

        Jugador jugador = new Jugador("Rafael"); //No anda con moc

        var grupoCorrectas1 = new ArrayList<String>();
        var grupoCorrectas2 = new ArrayList<String>();
        grupoCorrectas1.add("uno");
        grupoCorrectas2.add("dos");
        grupoCorrectas1.add("tres");
        grupoCorrectas2.add("cuatro");
        CorrectorClasico clasico = new CorrectorClasico();
        var respuestaCorrecta = new Respuesta(grupoCorrectas1,grupoCorrectas2);

        ArrayList<String> opciones = new ArrayList<String>();
        opciones.add("uno");
        opciones.add("dos");
        opciones.add("tres");
        opciones.add("cuatro");

        GroupChoice pregunta = new GroupChoice("Separe los pares de los impares", respuestaCorrecta, opciones, clasico);

        jugador.respuestaElegida(respuestaCorrecta);


        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(jugador.getRespuesta());
        pregunta.evaluarRespuesta(respuestas);
        jugador.actualizarPuntaje();
        assertEquals(1, jugador.getPuntaje());
    }
    @Test
    public void test02JugadorRespondeOrdenInorrectamenteYNoSumaPuntos() {

        Jugador jugador = new Jugador("Rafael"); //No anda con moc

        var grupoCorrectas1 = new ArrayList<String>();
        var grupoCorrectas2 = new ArrayList<String>();
        grupoCorrectas1.add("uno");
        grupoCorrectas2.add("dos");
        grupoCorrectas1.add("tres");
        grupoCorrectas2.add("cuatro");
        CorrectorClasico clasico = new CorrectorClasico();
        var respuestaCorrecta = new Respuesta(grupoCorrectas1,grupoCorrectas2);

        ArrayList<String> opciones = new ArrayList<String>();
        opciones.add("uno");
        opciones.add("dos");
        opciones.add("tres");
        opciones.add("cuatro");

        GroupChoice pregunta = new GroupChoice("Ordene los numeros en forma creciente", respuestaCorrecta, opciones, clasico);
        var grupoJugador1 = new ArrayList<String>();
        var grupoJugador2 = new ArrayList<String>();
        grupoJugador1.add("uno");
        grupoJugador1.add("dos");
        grupoJugador2.add("cuatro");
        grupoJugador2.add("tres");
        var respuestaJugador = new Respuesta(grupoJugador1,grupoJugador2);
        jugador.respuestaElegida(respuestaJugador);


        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(jugador.getRespuesta());
        pregunta.evaluarRespuesta(respuestas);
        jugador.actualizarPuntaje();
        assertEquals(0, jugador.getPuntaje());
    }
}
