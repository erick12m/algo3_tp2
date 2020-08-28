package edu.fiuba.algo3.modelo.TestsKahoot;

import edu.fiuba.algo3.modelo.Kahoot;
import edu.fiuba.algo3.modelo.correcciones.Respuesta;
import edu.fiuba.algo3.modelo.excepciones.GameOverException;
import edu.fiuba.algo3.modelo.excepciones.RondaFinalizadaException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class KahootTest {
    private Kahoot kahoot;
    @BeforeEach
    public void setUp(){
        kahoot = new Kahoot();
        kahoot.crearJugadores("Rafael", "Roger");
    }

    @Test
    public void test00KahootCreaCorrectamenteALosJugadores(){
        var jugadores = kahoot.getJugadores();
        var jugador1 = jugadores.remove();
        var jugador2 = jugadores.remove();

        assertEquals("Roger", jugador1.getNombre());
        assertEquals("Rafael", jugador2.getNombre());
    }

    @Test
    public void test01HayEmpateSiAmbosJugadoresTienenElMismoPuntaje(){
        var nombreGanador = kahoot.getGanador();
        assertEquals("Empate", nombreGanador);
    }

    @Test
    public void test02ElGanadorEsElJugadorConMasPuntos(){
        var jugador1 = kahoot.getJugadorActual();
        jugador1.setearPuntaje(100);

        var nombreGanador = kahoot.getGanador();

        assertEquals("Rafael", nombreGanador);
    }

    @Test
    public void test03SiguienteJugadorCambiaCorrectamenteAlOtroJugador() throws RondaFinalizadaException {
        var jugadorActual = kahoot.getJugadorActual();
        kahoot.siguienteJugador();
        var jugadorNuevo = kahoot.getJugadorActual();

        assertNotEquals(jugadorActual.getNombre(), jugadorNuevo.getNombre());

    }

    @Test
    public void test04SiguientePreguntaCambiaCorrectamenteDePregunta() throws GameOverException {
        var preguntaActual = kahoot.getPreguntaActual();
        kahoot.siguientePregunta();
        var preguntaNueva = kahoot.getPreguntaActual();

        assertNotEquals(preguntaActual, preguntaNueva);
    }

    @Test
    public void test05AlRecorrerTodasLasPreguntasSeLanzaExcepcionDeQueElJuegoFinalizo(){
        int contadorAux = 0;
        boolean flag = false;
        while (true){
            try{
                kahoot.siguientePregunta();
                contadorAux ++;
                if (contadorAux > 30){ //Por si algo falla para salir del while
                    break;
                }
            } catch (GameOverException e) {
                flag = true;
                break;
            }
        }
        assertTrue(flag);
    }


}
