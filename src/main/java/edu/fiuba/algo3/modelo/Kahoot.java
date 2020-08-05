package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.correccion.Respuesta;
import edu.fiuba.algo3.modelo.excepciones.NoTieneExclusividadException;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Kahoot {
    private Exclusividad exclusividad = new Exclusividad();
    private ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
    private static Pregunta preguntaActual;
    public static Jugador jugadorActual;
    private ArrayList<Pregunta> listaDePreguntas;

    /*private Kahoot(String nombreJugador1, String nombreJugador2){
        this.crearJugadores(nombreJugador1, nombreJugador2);
        //listaDePreguntas = FabricaDePreguntas.crearPreguntas(); TODO implementar despues la fabrica de preguntas
    }*/

    public String getGanador(){
        Jugador jugador1 = jugadores.get(0);
        Jugador jugador2 = jugadores.get(1);
        int puntosJugador1 = jugador1.getPuntaje();
        int puntosJugador2 = jugador2.getPuntaje();

        if (puntosJugador1 == puntosJugador2) return "Empate";

        else if (puntosJugador1 > puntosJugador2) return jugador1.getNombre();

        return jugador2.getNombre();
    }


    private void crearJugadores(String nombreJugador1, String nombreJugador2){
        Jugador jugador1  = new Jugador(nombreJugador1);
        Jugador jugador2 = new Jugador(nombreJugador2);

        jugadores.add(jugador1);
        jugadores.add(jugador2);

        //El que comienza respondiendo se elige de manera random
        double numRandom = Math.random();
        jugadorActual = (numRandom > 0.5) ? jugador1 : jugador2;
    }

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
