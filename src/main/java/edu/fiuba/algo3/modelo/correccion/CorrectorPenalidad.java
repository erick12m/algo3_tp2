package edu.fiuba.algo3.modelo.correccion;

public class CorrectorPenalidad implements Corrector {

    @Override
    public int corregirPregunta(Resultado resultado) {
        int puntos = resultado.getCorrectas() - resultado.getIncorrectas();
        return puntos;
    }

    @Override
    public boolean tienePenalidad() {
        return true;
    }

    /*public int corregirPregunta (Resultado resultado, Multiplicador multiplicador) {
        int puntos = corregirPregunta (resultado);
        puntos = multiplicador.multiplicarPuntaje(puntos);
        return puntos;
    }*/
}
