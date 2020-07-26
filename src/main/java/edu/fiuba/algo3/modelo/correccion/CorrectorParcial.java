package edu.fiuba.algo3.modelo.correccion;

public class CorrectorParcial implements Corrector {

    @Override
    public int corregirPregunta(Resultado resultado){
        return resultado.getCorrectas();
    }
}
