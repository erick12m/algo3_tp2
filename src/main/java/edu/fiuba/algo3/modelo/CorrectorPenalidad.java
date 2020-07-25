package edu.fiuba.algo3.modelo;

public class CorrectorPenalidad extends Corrector {
    @Override
    public int corregirPregunta(Resultado resultado){
        return (resultado.getCorrectas() - resultado.getIncorrectas());
    }
}
