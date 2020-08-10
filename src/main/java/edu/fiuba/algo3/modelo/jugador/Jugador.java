package edu.fiuba.algo3.modelo.jugador;
import edu.fiuba.algo3.modelo.Kahoot;
import edu.fiuba.algo3.modelo.Multiplicador;
import edu.fiuba.algo3.modelo.correccion.Respuesta;
import edu.fiuba.algo3.modelo.excepciones.NoTieneExclusividadException;
import edu.fiuba.algo3.modelo.excepciones.NoTieneMultiplicadorException;

import java.util.ArrayList;
import java.util.Iterator;

public class Jugador {


    private String nombre;
    private Respuesta respuesta;
    private Puntaje puntaje;
    private int usosExclusividad = 1;
    private Multiplicador multiplicador = new Multiplicador();

    public void usarExclusividad() throws NoTieneExclusividadException {
        if (!Kahoot.esPreguntaConPenalidad() && usosExclusividad > 0) {
            this.usosExclusividad--;
        } else {
            throw new NoTieneExclusividadException();
        }
    }

    public void activarMultiplicadorx2() throws NoTieneMultiplicadorException {
        if (Kahoot.esPreguntaConPenalidad()) {
            this.multiplicador.activarMultiplicador(2);
        }
    }

    public void activarMultiplicadorx3() throws NoTieneMultiplicadorException {
        if (Kahoot.esPreguntaConPenalidad()) {
            this.multiplicador.activarMultiplicador(3);
        }
    }

    public Jugador (String nombre) {
        this.nombre = nombre;
        this.puntaje = new Puntaje();

    }

    public void respuestaElegida(Respuesta respuesta) {
        this.respuesta = respuesta;
    }

    public void actualizarPuntaje() {
        int puntosObtenidos = respuesta.getPuntosObtenidos();
        puntaje.actualizarPuntaje(this.multiplicador.usarMultiplicador(puntosObtenidos));
        this.multiplicador.resetear();
    }

    public String getNombre(){
        return nombre;
    }

    public int getPuntaje() {
        return puntaje.getPuntosObtenidos();
    }

    public Respuesta getRespuesta(){
        return respuesta;
    }
}