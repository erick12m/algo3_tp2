package edu.fiuba.algo3.modelo;

public class CorrectorParcial extends Corrector {

    @Override
    public int corregirPregunta(Resultado resultado){
        return resultado.getCorrectas();
    }
}
