package edu.fiuba.algo3.modelo;

public class CorrectorClasico implements Corrector {

    @Override
    public int corregirPregunta(Resultado resultado) {

        if (resultado.diferencia() == 0) {
            return 1;
        }
        return 0;
    }
}
