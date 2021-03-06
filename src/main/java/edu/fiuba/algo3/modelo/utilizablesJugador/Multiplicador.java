package edu.fiuba.algo3.modelo.utilizablesJugador;

import edu.fiuba.algo3.modelo.excepciones.NoTieneMultiplicadorException;

import java.util.HashMap;
import java.util.Map;

public class Multiplicador {
    private final int CANT_USOS = 1;
    private Map<Integer,Integer> usos = new HashMap<Integer, Integer>();
    private int multiplicador = 1;

    public void activarMultiplicador(int multiplicador) throws NoTieneMultiplicadorException {
        if (!usos.containsKey(multiplicador)){
            usos.put(multiplicador,CANT_USOS);
        }
        if (usos.get(multiplicador) <= 0){
            throw new NoTieneMultiplicadorException();
        }
        usos.put(multiplicador,usos.get(multiplicador)-1);
        this.multiplicador = multiplicador;

    }

    public int usarMultiplicador(int puntos){
        return puntos * multiplicador;
    }

    public void resetear() {
        this.multiplicador = 1;
    }
}
