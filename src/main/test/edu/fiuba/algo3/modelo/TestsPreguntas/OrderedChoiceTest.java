package edu.fiuba.algo3.modelo.TestsPreguntas;

import edu.fiuba.algo3.modelo.correccion.CorrectorClasico;
import edu.fiuba.algo3.modelo.correccion.Respuesta;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.preguntas.GroupChoice;
import edu.fiuba.algo3.modelo.preguntas.MultipleChoice;
import edu.fiuba.algo3.modelo.preguntas.OrderedChoice;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrderedChoiceTest {
    @Test
    public void test01JugadorRespondeOrdenCorrectamenteYSumaUnPunto() {

        Jugador jugador = new Jugador("Rafael"); //No anda con moc

        var listaCorrectas = new ArrayList<String>();
        listaCorrectas.add("uno");
        listaCorrectas.add("dos");
        listaCorrectas.add("tres");
        listaCorrectas.add("cuatro");
        CorrectorClasico clasico = new CorrectorClasico();
        var respuestaCorrecta = new Respuesta(listaCorrectas);

        ArrayList<String> opciones = new ArrayList<String>();
        opciones.add("uno");
        opciones.add("dos");
        opciones.add("tres");
        opciones.add("cuatro");

        OrderedChoice pregunta = new OrderedChoice("Ordene los numeros en forma creciente", respuestaCorrecta, opciones, clasico);

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

        var listaCorrectas = new ArrayList<String>();
        listaCorrectas.add("uno");
        listaCorrectas.add("dos");
        listaCorrectas.add("tres");
        listaCorrectas.add("cuatro");
        CorrectorClasico clasico = new CorrectorClasico();
        var respuestaCorrecta = new Respuesta(listaCorrectas);

        ArrayList<String> opciones = new ArrayList<String>();
        opciones.add("uno");
        opciones.add("dos");
        opciones.add("tres");
        opciones.add("cuatro");

        OrderedChoice pregunta = new OrderedChoice("Ordene los numeros en forma creciente", respuestaCorrecta, opciones, clasico);
        var listaRespuestaJugador = new ArrayList<String>();
        listaRespuestaJugador.add("uno");
        listaRespuestaJugador.add("dos");
        listaRespuestaJugador.add("cuatro");
        listaRespuestaJugador.add("tres");
        var respuestaJugador = new Respuesta(listaRespuestaJugador);
        jugador.respuestaElegida(respuestaJugador);


        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(jugador.getRespuesta());
        pregunta.evaluarRespuesta(respuestas);
        jugador.actualizarPuntaje();
        assertEquals(0, jugador.getPuntaje());
    }
}
