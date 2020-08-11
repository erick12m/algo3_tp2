package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.correcciones.Respuesta;
import edu.fiuba.algo3.modelo.excepciones.GameOverException;
import edu.fiuba.algo3.modelo.excepciones.NoTieneExclusividadException;
import edu.fiuba.algo3.modelo.excepciones.RondaFinalizadaException;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.preguntas.FabricaPreguntas;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import edu.fiuba.algo3.modelo.utilizablesJugador.Exclusividad;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.stream.Collectors;

public class Kahoot {
    private Exclusividad exclusividad = new Exclusividad();
    private Queue<Jugador> jugadores = new LinkedList<>();
    private static Pregunta preguntaActual;
    public static Jugador jugadorActual;
    private Queue<Pregunta> listaDePreguntas;
    private int contador = 1;
    int CANTIDAD_JUGADORES = 2;

    public Kahoot() {
        try{
            listaDePreguntas = new LinkedList<>(FabricaPreguntas.crearPreguntas());
            preguntaActual = listaDePreguntas.remove();
        } catch (FileNotFoundException e){
        }
    }

    public void siguientePregunta() throws GameOverException {
        try{
            preguntaActual = listaDePreguntas.remove();
            contador = 0;
        } catch(NoSuchElementException e){
            throw new GameOverException();
        }
    }

    public void siguienteJugador() throws RondaFinalizadaException {
        if (contador == CANTIDAD_JUGADORES){
            throw new RondaFinalizadaException();
        }
        jugadorActual = jugadores.remove();
        jugadores.offer(jugadorActual);
        contador++;
    }

    public String getGanador(){
        Jugador jugador1 = jugadores.poll();
        Jugador jugador2 = jugadores.poll();
        int puntosJugador1 = jugador1.getPuntaje();
        int puntosJugador2 = jugador2.getPuntaje();

        if (puntosJugador1 == puntosJugador2) return "Empate";

        else if (puntosJugador1 > puntosJugador2) return jugador1.getNombre();

        return jugador2.getNombre();
    }


    public void crearJugadores(String nombreJugador1, String nombreJugador2){
        Jugador jugador1  = new Jugador(nombreJugador1);
        Jugador jugador2 = new Jugador(nombreJugador2);

        jugadores.offer(jugador1);
        jugadores.offer(jugador2);
        jugadorActual = jugadores.remove();
        jugadores.offer(jugadorActual);
    }

    public void setPreguntaActual(Pregunta preguntaActual){
        Kahoot.preguntaActual = preguntaActual;
        contador = 0;
    }

    public ArrayList<Respuesta> obtenerRespuestas() {
        ArrayList<Respuesta> respuestas = jugadores.stream()
                .map(Jugador::getRespuesta)
                .collect(Collectors.toCollection(ArrayList::new));
        return respuestas;
    }

    public void usarExclusividad(Jugador jugador) throws NoTieneExclusividadException {
        if (this.preguntaActual.tienePenalidad()){ return; }
        this.exclusividad.sumarUso(jugador);
    }

    public void puntuarPregunta(){
        var respuestas   = this.obtenerRespuestas();
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

    public Queue<Jugador> getJugadores(){return jugadores;} //Para testear
}
