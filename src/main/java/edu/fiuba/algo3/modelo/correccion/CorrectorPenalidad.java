package edu.fiuba.algo3.modelo.correccion;

public class CorrectorPenalidad implements Corrector {
    @Override
    public int corregirPregunta(Resultado resultado){
        return (resultado.getCorrectas() - resultado.getIncorrectas());
    }
}
