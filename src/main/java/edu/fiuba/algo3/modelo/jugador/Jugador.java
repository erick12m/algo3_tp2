package edu.fiuba.algo3.modelo.jugador;
import edu.fiuba.algo3.modelo.Kahoot;
import edu.fiuba.algo3.modelo.correcciones.Corrector;
import edu.fiuba.algo3.modelo.utilizablesJugador.Multiplicador;
import edu.fiuba.algo3.modelo.correcciones.Respuesta;
import edu.fiuba.algo3.modelo.excepciones.NoTieneExclusividadException;
import edu.fiuba.algo3.modelo.excepciones.NoTieneMultiplicadorException;

public class Jugador {


    private String nombre;
    private Respuesta respuesta;
    private Puntaje puntaje;
    private int usosExclusividad = 1;
    private Multiplicador multiplicador = new Multiplicador();

    //TODO REVISAR BIEN ESTA PARTE QUE SOLO RESTA LOS USOS DE EXCLUSIVIDAD
    public void usarExclusividad() throws NoTieneExclusividadException {
        if (usosExclusividad > 0) {
            this.usosExclusividad--;
        } else {
            throw new NoTieneExclusividadException();
        }
    }
    //TODO recordar filtrar lo de si es con penalidad
    public void activarMultiplicadorx2() throws NoTieneMultiplicadorException {
        if (Kahoot.esPreguntaConPenalidad()){
            this.multiplicador.activarMultiplicador(2);
        }
    }

    public void activarMultiplicadorx3() throws NoTieneMultiplicadorException {
        if (Kahoot.esPreguntaConPenalidad()){
            this.multiplicador.activarMultiplicador(3);
        }
    }

    public Jugador (String nombre) {
        this.nombre = nombre;
        this.puntaje = new Puntaje();

    }

    public void respuestaElegida(Respuesta respuesta) {
        this.respuesta = respuesta;
    }

    public void actualizarPuntaje() {
        int puntosObtenidos = respuesta.getPuntosObtenidos();
        puntaje.actualizarPuntaje(this.multiplicador.usarMultiplicador(puntosObtenidos));
        this.multiplicador.resetear();
    }

    public String getNombre(){
        return nombre;
    }

    public int getPuntaje() {
        return puntaje.getPuntosObtenidos();
    }

    public Respuesta getRespuesta(){
        return respuesta;
    }

    public void setearPuntaje(int puntos){ //Para testear
        puntaje.actualizarPuntaje(puntos);
    }
}