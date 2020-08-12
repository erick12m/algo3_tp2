package edu.fiuba.algo3.Controladores;

import edu.fiuba.algo3.Vistas.*;
import edu.fiuba.algo3.modelo.Kahoot;
import edu.fiuba.algo3.modelo.excepciones.GameOverException;
import edu.fiuba.algo3.modelo.excepciones.RondaFinalizadaException;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class ControladorJuego {
    private Stage ventana;
    private Kahoot kahoot;
    private ControladorPregunta controladorPregunta;
    public ControladorJuego(Stage ventana){
        this.ventana = ventana;
    }

    public void iniciarJuego(String nombreJugador1, String nombreJugador2) {
        if (nombreJugador1.equals("") ||  nombreJugador2.equals("")){
            VentanaError.mostrar("Error", "Ambos jugadores deben tener un nombre");
        }else{
            this.kahoot = new Kahoot();
            kahoot.crearJugadores(nombreJugador1, nombreJugador2);
            this.controladorPregunta = new ControladorPregunta(kahoot);
            ContenedorPrincipal contenedorPrincipal = new ContenedorPrincipal(ventana, this);
            Scene juego = new Scene(contenedorPrincipal, 640, 359);
            ventana.setScene(juego);

        }

    }

    public String jugadorActual() {
        return this.kahoot.getJugadorActual().getNombre();
    }

    public boolean gameOver() {
        return kahoot.isOver();
    }

    public void siguienteTurno(StackPane stackPregunta) {
        try {
            kahoot.siguienteJugador();
            TextoTurno.getInstancia().actualizarLabel(kahoot);
        } catch (RondaFinalizadaException rondaFinalizadaException) {
            VentanaRespuestaCorrecta.mostrar("La respuesta correcta esta en tu corazon");
            try {
                kahoot.siguientePregunta();
                TextoPregunta.getInstancia().actualizarLabel(kahoot);
                TextoTurno.getInstancia().actualizarLabel(kahoot);
                stackPregunta.getChildren().removeAll();
                stackPregunta.getChildren().add(new VistaPregunta(controladorPregunta));
            } catch (GameOverException gameOverException) {
                VentanaError.mostrar("", "Finalizó el juego");
                ventana.close();
            }
            VentanaError.mostrar("", "Nueva Pregunta");
        }
    }

    public void comenzar(StackPane stackPregunta) {
        ObservableList lista = stackPregunta.getChildren();
        lista.add(new VistaPregunta(controladorPregunta));
    }
}
