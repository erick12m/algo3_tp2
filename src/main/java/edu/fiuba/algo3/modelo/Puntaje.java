package edu.fiuba.algo3.modelo;

public class Puntaje {
    private int puntaje = 0;

    public Puntaje(){}

    public int getPuntosObtenidos(){
        return puntaje;
    }

    public void actualizarPuntaje(int puntosAdquiridos){
        puntaje = (puntaje + puntosAdquiridos < 0) ? 0 : (puntaje + puntosAdquiridos);
        //Con esto evitamos que el puntaje sea negativo
    }
}
