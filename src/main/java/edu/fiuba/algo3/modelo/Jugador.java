package edu.fiuba.algo3.modelo;
import java.util.Scanner;


public class Jugador {

    String nombre;
    int puntos;

    public Jugador (String nombre){
        this.puntos = 0;
        this.nombre = nombre;
    }

    public Respuesta responderPregunta () {

        Scanner scanner = new Scanner(System.in);
        String texto = scanner.next();
        Respuesta respuesta = new Respuesta(texto);

        return respuesta;
    }

    public int actualizarPuntaje (int puntos) {
        this.puntos += puntos;
        return 0;
    }
    public int obtenerPuntos() {
        return puntos;
    }
}
