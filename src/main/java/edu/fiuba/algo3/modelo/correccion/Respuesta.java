package edu.fiuba.algo3.modelo.correccion;

import edu.fiuba.algo3.modelo.Exclusividad;

import java.util.ArrayList;

public class Respuesta {

    private ArrayList<String> respuestas;
    private ArrayList<String> primerGrupo;
    private ArrayList<String> segundoGrupo;
    private int puntosObtenidos = 0;

    public Respuesta(ArrayList<String> respuestas) {
        this.respuestas = respuestas;
    }

    public Respuesta(ArrayList<String> primerGrupo, ArrayList<String> segundoGrupo) {
        this.primerGrupo = primerGrupo;
        this.segundoGrupo = segundoGrupo;
    }

    public Resultado compararCon(Respuesta respuestasJugador){
        Resultado resultado = new Resultado(0, 0, this.respuestas.size());
        for(String respuestaJugador: respuestasJugador.getRespuesta()){
            if(this.respuestas.contains(respuestaJugador)){
                resultado.sumarCorrecta();
            }else{
                resultado.sumarIncorrecta();
            }
        }
        return resultado;
    }
    public Resultado compararOrden(Respuesta respuestasJugador){
        Resultado resultado = new Resultado(0, 0, 1);
        if (this.respuestas.equals(respuestasJugador.getRespuesta())){
            resultado.sumarCorrecta();
        }
        return resultado;
    }
    public Resultado compararGrupos(Respuesta respuestasJugador){
        Resultado resultado = new Resultado(0, 0, 1);

        if (this.primerGrupo.containsAll(respuestasJugador.getPrimerGrupo())
                && this.segundoGrupo.containsAll(respuestasJugador.getSegundoGrupo())){
            resultado.sumarCorrecta();
        } else {
            resultado.sumarIncorrecta();
        }
        return resultado;
    }

    public boolean esCorrecta(){
        return this.puntosObtenidos > 0;
    }

    public void usarExclusividad(Exclusividad exclusividad) {
        this.puntosObtenidos = exclusividad.calcularExclusividad(this.puntosObtenidos);
    }

    public void asignarPuntaje(int puntosObtenidos){
        this.puntosObtenidos = puntosObtenidos;
    }

    public int getPuntosObtenidos() {
        return puntosObtenidos;
    }

    public ArrayList<String> getRespuesta() {
        return respuestas;
    }

    public ArrayList<String> getPrimerGrupo() {
        return primerGrupo;
    }

    public ArrayList<String> getSegundoGrupo() {
        return segundoGrupo;
    }
}
