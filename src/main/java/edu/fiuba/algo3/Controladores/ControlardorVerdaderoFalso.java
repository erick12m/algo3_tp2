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
        if (respuestaJugador.contains(textoBoton)){
            botonOpcion.setStyle("");
            this.respuestaJugador.clear();
        }else {
            this.respuestaJugador.add(textoBoton);
            botonOpcion.setStyle("-fx-border-color: #5eba46; -fx-border-width: 5px;");
        }

    }

}
