package edu.fiuba.algo3.modelo;

public class PuntajeClasico implements EstadoPuntaje {

    @Override
    public int puntuarPregunta(Resultado resultado) {
        if (resultado.diferencia() == 0){return 1;}
        return 0;
    }
}
