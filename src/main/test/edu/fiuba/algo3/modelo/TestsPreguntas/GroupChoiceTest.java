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
    public void test02JugadorRespondeOrdenInorrectamenteYNoSumaPuntos() {
        CorrectorClasico clasico = new CorrectorClasico();
        GroupChoice pregunta = new GroupChoice("Ordene los numeros en forma creciente", respuestaCorrecta, opciones, clasico);

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
}
