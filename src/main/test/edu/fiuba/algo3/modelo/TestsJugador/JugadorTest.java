package edu.fiuba.algo3.modelo.TestsJugador;

import edu.fiuba.algo3.modelo.Kahoot;
import edu.fiuba.algo3.modelo.Opcion;
import edu.fiuba.algo3.modelo.correccion.CorrectorClasico;
import edu.fiuba.algo3.modelo.correccion.CorrectorPenalidad;
import edu.fiuba.algo3.modelo.correccion.Respuesta;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import edu.fiuba.algo3.modelo.preguntas.VerdaderoFalso;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JugadorTest{
    @Test
    public void test01ElJugadorSeCreaCorrectamente(){
        Jugador jugador = new Jugador("Rafael");
        assertEquals("Rafael", jugador.getNombre());
    }

    @Test
    public void test02ElJugadorSeCreaYTienePuntajeCero(){
        Jugador jugador = new Jugador("Rafael");
        assertEquals(0, jugador.getPuntaje());
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
}