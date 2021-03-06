package edu.fiuba.algo3.controladores;

import edu.fiuba.algo3.modelo.Kahoot;
import edu.fiuba.algo3.modelo.correcciones.Respuesta;
import javafx.scene.control.Button;

import java.util.ArrayList;

public class ControladorGroupChoice extends ControladorPregunta {
    private final String GRUPO_1 = "Grupo 1";
    private final String GRUPO_2 = "Grupo 2";
    private ArrayList<String> grupo1 = new ArrayList<>();
    private ArrayList<String> grupo2 = new ArrayList<>();

    public ControladorGroupChoice(Kahoot kahoot) {
        this.kahoot = kahoot;
    }

    @Override
    public void setGrupo(Button botonGrupo){
        if (this.botonesActivos.contains(botonGrupo)){
            botonGrupo.setStyle("");
            this.botonesActivos.remove(botonGrupo);
        }else{
            this.activarBoton(botonGrupo);
        }
        this.establecerGrupo(botonGrupo.getText());
        this.refrescarOpciones();
    }

    private void establecerGrupo(String textGrupo){
        switch (textGrupo){
            case GRUPO_1:
                this.grupo1 = new ArrayList<>(this.respuestaJugador);
                this.respuestaJugador.clear();
                break;
            case GRUPO_2:
                this.grupo2 = new ArrayList<>(this.respuestaJugador);
                this.respuestaJugador.clear();
                break;
        }
    }

    @Override
    public Respuesta getRespuestaJugador(){
        Respuesta respuestaJugador = new Respuesta(grupo1, grupo2);
        this.grupo1.clear();
        this.grupo2.clear();
        return respuestaJugador;
    }
}
