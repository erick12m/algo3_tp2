package edu.fiuba.algo3.modelo.TestsJugador;

import edu.fiuba.algo3.modelo.Jugador;
import org.junit.jupiter.api.Test;

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
}