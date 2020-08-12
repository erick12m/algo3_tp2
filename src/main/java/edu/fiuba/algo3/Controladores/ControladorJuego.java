package edu.fiuba.algo3.Controladores;

import edu.fiuba.algo3.Vistas.*;
import edu.fiuba.algo3.modelo.Kahoot;
import edu.fiuba.algo3.modelo.correcciones.Respuesta;
import edu.fiuba.algo3.modelo.excepciones.GameOverException;
import edu.fiuba.algo3.modelo.excepciones.RondaFinalizadaException;
import javafx.animation.Timeline;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class ControladorJuego {
    private Stage ventana;
    private Kahoot kahoot;
    private ControladorPregunta controladorPregunta;
    private Respuesta respuestaCorrecta;
    private Timeline timer;
    public ControladorJuego(Stage ventana){
        this.ventana = ventana;
    }

    public void iniciarJuego(String nombreJugador1, String nombreJugador2) {
        if (nombreJugador1.equals("") ||  nombreJugador2.equals("")){
            VentanaMensaje.mostrar("Error", "Ambos jugadores deben tener un nombre");
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

    public void gameOver() {
        String ganador = kahoot.getGanador();
        VentanaMensaje.mostrar("","El ganador es: ".concat(ganador));
        ventana.close();
    }

    public void siguienteTurno(StackPane stackPregunta) {
        timer.stop();
        try {
            kahoot.siguienteTurno();
            this.actualizarTablero();
            timer.play();
        } catch (RondaFinalizadaException e) {
            this.mostrarRespuestaCorrecta();
            this.respuestaCorrecta = kahoot.getPreguntaActual().getRespuesta();
            this.actualizarTablero();
            stackPregunta.getChildren().clear();
            stackPregunta.getChildren().add(new VistaPregunta(controladorPregunta));
        }
        catch (GameOverException gameOverException) {
                this.gameOver();
        }
    }

    public void comenzar(StackPane stackPregunta) {
        ObservableList lista = stackPregunta.getChildren();
        lista.add(new VistaPregunta(controladorPregunta));
        respuestaCorrecta = kahoot.getPreguntaActual().getRespuesta();
        timer.play();
    }

    public void mostrarRespuestaCorrecta(){
        String respuestaCorrecta = this.respuestaCorrecta.getRespuestaCorrecta();
        VentanaRespuestaCorrecta.mostrar("La respuesta correcta es: ".concat(respuestaCorrecta), timer);
    }

    public void actualizarTablero(){
        TextoPregunta.getInstancia().actualizarLabel(kahoot);
        TextoTurno.getInstancia().actualizarLabel(kahoot);
    }

    public void setTimer(Timeline timer){
        this.timer = timer;
    }
}
