package edu.fiuba.algo3.modelo;

public class PuntajeClasico implements EstadoPuntaje {

    @Override
    public int puntuarPregunta(Resultado resultado) {

        return resultado.getCorrectas();
    }
}
