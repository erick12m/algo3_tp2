package edu.fiuba.algo3.Vistas;

import edu.fiuba.algo3.modelo.Kahoot;
import javafx.scene.control.Label;
import javafx.scene.text.Text;

public class TextoPregunta {
    private static TextoPregunta instanciaTextoPregunta = null;
    Text labelTextoPregunta;

    public TextoPregunta(){

    }

    public static TextoPregunta getInstancia(){
        if (instanciaTextoPregunta == null) instanciaTextoPregunta = new TextoPregunta();

        return instanciaTextoPregunta;
    }

    public void guardarLabel(Text labelAGuardar){
        labelTextoPregunta = labelAGuardar;
    }

    public void actualizarLabel(Kahoot kahoot){
        labelTextoPregunta.setText(kahoot.getPreguntaActual().getNombre() +":\n\n"
                + kahoot.getPreguntaActual().getEnunciado());
    }
}
