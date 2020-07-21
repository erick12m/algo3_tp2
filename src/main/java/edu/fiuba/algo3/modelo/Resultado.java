package edu.fiuba.algo3.modelo;

public class Resultado {

    int correctas;
    int incorrectas;
    int correctasEsperadas;

    public Resultado () {
        this(0,0,0);
    }

    public Resultado(int correctas, int incorrectas, int correctasEsperadas) {
        this.correctas = correctas;
        this.incorrectas = incorrectas;
        this.correctasEsperadas = correctasEsperadas;
    }

    public void setCorrectas(int correctas) {
        this.correctas = correctas;
    }

    public void setIncorrectas(int incorrectas) {
        this.incorrectas = incorrectas;
    }

    public int getCorrectas() {
        return correctas;
    }
}
