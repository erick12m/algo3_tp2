package edu.fiuba.algo3.modelo.correcciones;

public class CorrectorParcial implements Corrector {

    @Override
    public int corregirPregunta(Resultado resultado){
        return resultado.getIncorrectas() == 0 ? resultado.getCorrectas() : 0;
    }

    @Override
    public boolean tienePenalidad() {
        return false;
    }
}
