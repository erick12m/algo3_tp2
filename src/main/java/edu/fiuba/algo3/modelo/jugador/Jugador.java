package edu.fiuba.algo3.modelo.jugador;
import edu.fiuba.algo3.modelo.correccion.Respuesta;


public class Jugador {

    public String nombre;
    private Respuesta respuesta;
    Puntaje puntaje = new Puntaje();


    public Jugador (String nombre){
        this.nombre = nombre;
    }

    public void respuestaElegida(Respuesta respuesta) {
        this.respuesta = respuesta;
    }

    public void actualizarPuntaje() {
        int puntosObtenidos = this.respuesta.getPuntosObtenidos();
        this.puntaje.actualizarPuntaje(puntosObtenidos);
    }
    public int getPuntaje() {
        return this.puntaje.getPuntosObtenidos();
    }

    public String getNombre(){
        return nombre;
    }

    public Respuesta getRespuesta(){
        return this.respuesta;
    }
}