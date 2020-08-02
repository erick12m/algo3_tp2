package edu.fiuba.algo3.modelo.jugador;
import edu.fiuba.algo3.modelo.Kahoot;
import edu.fiuba.algo3.modelo.correccion.Respuesta;
import edu.fiuba.algo3.modelo.excepciones.NoTieneExclusividadException;
import edu.fiuba.algo3.modelo.excepciones.NoTieneMultiplicadorException;

import java.util.ArrayList;
import java.util.Iterator;

public class Jugador {

    private String nombre;
    private Respuesta respuesta;
    private Puntaje puntaje;
    private int usosExclusividad = 2;
    private int multiplicador = 1;
    private int usosMultiplicadorx2 = 2;
    private int usosMultiplicadorx3 = 2;

    //TODO REVISAR BIEN ESTA PARTE QUE SOLO RESTA LOS USOS DE EXCLUSIVIDAD
    public void usarExclusividad() throws NoTieneExclusividadException {
        if (!Kahoot.esPreguntaConPenalidad() && usosExclusividad > 0) {
            usosExclusividad--;
        } else {
            throw new NoTieneExclusividadException();
        }
    }

    public void activarMultiplicadorx2() throws NoTieneMultiplicadorException {
        if (Kahoot.esPreguntaConPenalidad() && usosMultiplicadorx2 > 0){
            usosMultiplicadorx2--;
            multiplicador = 2;
        } else {
            throw new NoTieneMultiplicadorException();
        }
    }

    public void activarMultiplicadorx3() throws NoTieneMultiplicadorException {
        if (Kahoot.esPreguntaConPenalidad() && usosMultiplicadorx3 > 0){
            usosMultiplicadorx3--;
            multiplicador = 3;
        } else {
            throw new NoTieneMultiplicadorException();
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
        puntaje.actualizarPuntaje(puntosObtenidos * multiplicador);
        multiplicador = 1;
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