package edu.fiuba.algo3.modelo;
import java.util.Scanner;


public class Jugador {

    String nombre;
    int puntos;

    public Respuesta responderPregunta () {

        Scanner scanner = new Scanner(System.in);
        String texto = scanner.next();
        Respuesta respuesta = new Respuesta(texto);

        return respuesta;
    }

    public void actualizarPuntaje (int puntos) {
        this.puntos += puntos;
    }
    public int obtenerPuntos() {
        return puntos;
    }
}
