package edu.fiuba.algo3.modelo.correccion;

public class Resultado {

    int correctas;
    int incorrectas;
    int correctasEsperadas;


    public Resultado(int correctas, int incorrectas, int correctasEsperadas) {
        this.correctas = correctas;
        this.incorrectas = incorrectas;
        this.correctasEsperadas = correctasEsperadas;
    }

    public int getCorrectas() {
        return correctas;
    }

    public void sumarCorrecta() { this.correctas ++;}

    public int diferencia() {
        return (correctasEsperadas - correctas);
    }

    public void sumarIncorrecta() { this.incorrectas ++;}

    public int getIncorrectas() { return incorrectas;}
}
