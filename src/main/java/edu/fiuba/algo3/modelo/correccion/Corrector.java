package edu.fiuba.algo3.modelo.correccion;

public interface Corrector {

    int corregirPregunta(Resultado resultado);
    boolean tienePenalidad();
}
