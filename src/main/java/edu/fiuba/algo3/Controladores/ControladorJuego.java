package edu.fiuba.algo3.Controladores;

import edu.fiuba.algo3.Vistas.*;
import edu.fiuba.algo3.modelo.Kahoot;
import edu.fiuba.algo3.modelo.correcciones.Respuesta;
import edu.fiuba.algo3.modelo.excepciones.GameOverException;
import edu.fiuba.algo3.modelo.excepciones.RondaFinalizadaException;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import javafx.animation.Timeline;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.io.File;

import static javafx.scene.media.MediaPlayer.INDEFINITE;

public class ControladorJuego {
    private Stage ventana;
    private Kahoot kahoot;
    private ControladorPregunta controladorPregunta;
    private Respuesta respuestaCorrecta;
    private Timeline timer;
    private final String VERDADER_O_FALSO =  "Verdadero o Falso";
    private final String GROUP_CHOICE = "Group Choice";
    private Pregunta preguntaActual;
    private MediaPlayer media;

    public ControladorJuego(Stage ventana){
        this.ventana = ventana;
    }

    public void iniciarJuego(String nombreJugador1, String nombreJugador2) {
        if (nombreJugador1.equals("") ||  nombreJugador2.equals("")){
            VentanaMensaje.mostrar("Error", "Ambos jugadores deben tener un nombre");
        }else{
            this.kahoot = new Kahoot();
            kahoot.crearJugadores(nombreJugador1, nombreJugador2);
            preguntaActual = kahoot.getPreguntaActual();
            this.controladorPregunta = this.getControladorCorrecto();
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
        media.stop();
        media = this.iniciarMusica();
        VentanaGanador.mostrar(ganador, this.ventana);
    }

    public void siguienteTurno(StackPane stackPregunta) {
        timer.stop();
        try {
            Respuesta respuestaJugador = controladorPregunta.getRespuestaJugador();
            kahoot.getJugadorActual().respuestaElegida(respuestaJugador);
            kahoot.siguienteTurno();
            this.actualizarTablero();
            timer.play();
        } catch (RondaFinalizadaException e) {
            this.corregirRespuestas();
            this.preguntaActual = kahoot.getPreguntaActual();
            this.controladorPregunta = this.getControladorCorrecto();
            this.mostrarRespuestaCorrecta();
            this.respuestaCorrecta = kahoot.getPreguntaActual().getRespuesta();

            stackPregunta.getChildren().clear();
            stackPregunta.getChildren().add(new VistaPregunta(controladorPregunta));
            this.actualizarTablero();
        }
        catch (GameOverException gameOverException) {
                this.corregirRespuestas();
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
        VentanaRespuestaCorrecta.mostrar("La respuesta correcta es: ".concat("\n").concat(respuestaCorrecta), timer);
    }

    public void actualizarTablero(){
        TextoPregunta.getInstancia().actualizarLabel(kahoot);
        TextoTurno.getInstancia().actualizarLabel(kahoot);
        this.controladorPregunta.refrescarBotones();
    }

    public void setTimer(Timeline timer){
        this.timer = timer;
    }

    public ControladorPregunta getControladorCorrecto(){
        switch (kahoot.getPreguntaActual().getNombre()){
            case VERDADER_O_FALSO:
                return new ControladorVerdaderoFalso(kahoot);

            case GROUP_CHOICE:
                return new ControladorGroupChoice(kahoot);

            default:
                return new ControladorMultipleOrderedChoice(kahoot);
        }
    }

    public void corregirRespuestas(){
        kahoot.puntuarPregunta(preguntaActual);
        kahoot.imprimirPuntajes();
    }

    public void setAudio(MediaPlayer media) { this.media = media;}

    public MediaPlayer getMedia() {
        return this.media;
    }

    public MediaPlayer iniciarMusica(){
        String musicFile = "Musica/we-are-the-champions.mp3";
        Media sound = new Media(new File(musicFile).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.play();
        mediaPlayer.setVolume(0.7);
        mediaPlayer.setCycleCount(INDEFINITE);
        return mediaPlayer;
    }
}
