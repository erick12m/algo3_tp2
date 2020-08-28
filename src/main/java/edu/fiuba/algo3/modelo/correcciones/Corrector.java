package edu.fiuba.algo3.modelo.correcciones;

public interface Corrector {

    int corregirPregunta(Resultado resultado);
    boolean tienePenalidad();
}
