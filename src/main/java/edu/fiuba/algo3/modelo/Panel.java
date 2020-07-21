package edu.fiuba.algo3.modelo;

public class Panel {

    public void agregarJugador(Jugador jugador) {
    }

    public void agregarPregunta(Pregunta pregunta) {
    }

    public void obtenerRespuestas(Pregunta pregunta) {
    }


    public void presentarPregunta (Jugador jugador, Pregunta pregunta) {

        System.out.println (pregunta);
        Respuesta respuesta = jugador.responderPregunta();
        int puntos = pregunta.evaluarRespuesta(respuesta);
        jugador.actualizarPuntaje(puntos);
    }

}
