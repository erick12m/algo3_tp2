package edu.fiuba.algo3.modelo.correcciones;

public class CorrectorPenalidad implements Corrector {

    @Override
    public int corregirPregunta(Resultado resultado) {
        int puntos = resultado.getCorrectas() - resultado.getIncorrectas();
        return puntos;
    }

    @Override
    public boolean tienePenalidad() {
        return true;
    }
}
