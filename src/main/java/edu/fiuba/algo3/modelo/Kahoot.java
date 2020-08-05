package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.correccion.Respuesta;
import edu.fiuba.algo3.modelo.excepciones.NoTieneExclusividadException;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Kahoot {
    /*TODO cambiar esta clase a que sea kahoot y que se encargue de crear jugadores y preguntas, que tenga estado para
    hacer lo de puntaje exclusivo */
    private Exclusividad exclusividad = new Exclusividad();
    private ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
    private static Pregunta preguntaActual;
    public static Jugador jugadorActual;

    public void setPreguntaActual(Pregunta preguntaActual){
        Kahoot.preguntaActual = preguntaActual;
    }

    public void setJugadorActual(Jugador jugadorActual){
        Kahoot.jugadorActual = jugadorActual;
    }

    public void agregarJugador(Jugador jugador) {
        this.jugadores.add(jugador);
    }

    public ArrayList<Respuesta> obtenerRespuestas() {
        ArrayList<Respuesta> respuestas = jugadores.stream()
                .map(Jugador::getRespuesta)
                .collect(Collectors.toCollection(ArrayList::new));
        return respuestas;
    }

    public void usarExclusividad(Jugador jugador){
        try {
            this.exclusividad.sumarUso(jugador);
        } catch (NoTieneExclusividadException e) {
        }
    }
    // TODO ACORDARSE DE DEFINIR QUE HACER CON LA PREGUNTA ACTUAL Y EL PARAMETRO PREGUNTA
    public void puntuarPregunta(){
        var respuestas = this.obtenerRespuestas();
        preguntaActual.evaluarRespuesta(respuestas);
        exclusividad.aplicar(respuestas);
        this.jugadores.forEach(Jugador::actualizarPuntaje);
    }

    public static boolean esPreguntaConPenalidad() {
        return preguntaActual.tienePenalidad();
    }

    public Pregunta getPreguntaActual() {
        return Kahoot.preguntaActual;
    }

    public Jugador getJugadorActual() {
        return Kahoot.jugadorActual;
    }
}
