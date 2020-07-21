package edu.fiuba.algo3.modelo;

public class Panel {

    public void presentarPregunta (Jugador jugador, Pregunta pregunta) {

        System.out.println (pregunta);
        Respuesta respuesta = jugador.responderPregunta();
        int puntos = pregunta.evaluarRespuesta(respuesta);
        jugador.actualizarPuntaje(puntos);
    }

}
