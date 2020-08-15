package edu.fiuba.algo3.Vistas;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class VentanaMensaje {
    public static void mostrar(String titulo, String mensaje){

        Stage ventana = new Stage();

        ventana.initModality(Modality.APPLICATION_MODAL);
        ventana.setTitle(titulo);

        Label label = new Label("Mensaje");
        label.setText(mensaje);

        Button boton = new Button("Ok");
        boton.setOnAction(e -> ventana.close());

        VBox layout = new VBox(10, label, boton);
        layout.setAlignment(Pos.CENTER);
        Scene scene = new Scene(layout, 400 ,300);

        ventana.setScene(scene);
        ventana.show();

    }
}
