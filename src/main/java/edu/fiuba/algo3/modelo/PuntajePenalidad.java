package edu.fiuba.algo3.modelo;

public class PuntajePenalidad implements EstadoPuntaje{
    @Override
    public int puntuarPregunta(Resultado resultado){
        return (resultado.getCorrectas() - resultado.getIncorrectas());
    }
}
