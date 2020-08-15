package edu.fiuba.algo3.Vistas;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class VentanaGanador {
    public static void mostrar(String nombreGanador, Stage ventanaJuego){

        Stage ventana = new Stage();

        ventana.initModality(Modality.APPLICATION_MODAL);

        Label label = (nombreGanador.equals("Empate")) ? new Label("Empate !") : new Label("El" +
                "ganador es: ".concat(nombreGanador));

        Button boton = new Button("Finalizar");

        boton.setOnAction(e ->{
            ventana.close();
            ventanaJuego.close();
        });

        VBox layout = new VBox(10, label, boton);
        layout.setAlignment(Pos.CENTER);
        Scene scene = new Scene(layout, 400 ,300);

        ventana.setScene(scene);
        ventana.show();

    }

}
