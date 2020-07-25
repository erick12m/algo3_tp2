package edu.fiuba.algo3.modelo;

public class PuntajeParcial implements EstadoPuntaje{

    @Override
    public int puntuarPregunta(Resultado resultado){
        return resultado.getCorrectas();
    }
}
