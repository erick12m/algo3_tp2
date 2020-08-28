package edu.fiuba.algo3.modelo.utilizablesJugador;

import edu.fiuba.algo3.modelo.correcciones.Respuesta;
import edu.fiuba.algo3.modelo.excepciones.NoTieneExclusividadException;
import edu.fiuba.algo3.modelo.jugador.Jugador;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Exclusividad {
    private int usos = 0;

    public void sumarUso(Jugador jugador) throws NoTieneExclusividadException {
        jugador.usarExclusividad();
        this.usos++;
    }

    public void aplicar(ArrayList<Respuesta> respuestas) {
        if (this.usos == 0){return;}
        ArrayList<Respuesta> respuestasCorrectas = respuestas.stream()
                .filter(Respuesta::esCorrecta)
                .collect(Collectors.toCollection(ArrayList::new));
        if (respuestasCorrectas.size() == 1){
            respuestasCorrectas.get(0).usarExclusividad(this);
        }
        this.usos = 0;
    }
    public int calcularExclusividad(int puntos){
        return puntos * usos * 2;
    }
}
