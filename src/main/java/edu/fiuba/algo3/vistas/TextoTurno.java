package edu.fiuba.algo3.vistas;
import edu.fiuba.algo3.modelo.Kahoot;
import javafx.scene.control.Label;

public class TextoTurno {
    private static TextoTurno instanciaTextoTurno = null;
    Label labelTextoTurno;

    public TextoTurno(){}

    public static TextoTurno getInstancia(){
        if (instanciaTextoTurno == null) instanciaTextoTurno = new TextoTurno();

        return instanciaTextoTurno;
    }

    public void guardarLabel(Label labelAGuardar){
        labelTextoTurno = labelAGuardar;
    }

    public void actualizarLabel(Kahoot kahoot){
        labelTextoTurno.setText("Turno de: ".concat(kahoot.getJugadorActual().getNombre()));
    }

}