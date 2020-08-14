package edu.fiuba.algo3.Controladores;

import edu.fiuba.algo3.modelo.Kahoot;
import edu.fiuba.algo3.modelo.correcciones.Respuesta;

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
    public void setGrupo(String textGrupo){
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
        this.refrescarBotones();
    }

    @Override
    public Respuesta getRespuestaJugador(){
        System.out.println(this.kahoot.getJugadorActual().getNombre().concat(" Grupo 1:").concat(String.valueOf(grupo1)));
        System.out.println(this.kahoot.getJugadorActual().getNombre().concat(" Grupo 2:").concat(String.valueOf(grupo2)));
        return new Respuesta(grupo1, grupo2);
    }
}
