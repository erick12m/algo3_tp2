package edu.fiuba.algo3.Controladores;

import edu.fiuba.algo3.modelo.Kahoot;
import javafx.scene.control.Button;

public class ControlardorVerdaderoFalso extends ControladorPregunta{

    public ControlardorVerdaderoFalso(Kahoot kahoot){
        this.kahoot = kahoot;
    }

    @Override
    public void guardarRespuesta(Button botonOpcion){
        String textoBoton = botonOpcion.getText();
        this.respuestaJugador.clear();
        this.respuestaJugador.add(textoBoton);
    }

}
