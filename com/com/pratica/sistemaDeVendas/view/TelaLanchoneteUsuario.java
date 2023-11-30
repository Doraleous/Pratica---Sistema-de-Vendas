package com.pratica.sistemaDeVendas.view;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    private int count = 0;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Cinecap");

        Button btnComprar = new Button("Comprar");
        Button btnVoltar = new Button("Voltar");
        Button btnSair = new Button("Sair");

        Button btnAumentar = new Button("+");
        Button btnDiminuir = new Button("-");

        Label lblCount = new Label("Quantidade: " + count);

        btnAumentar.setOnAction(e -> {
            count++;
            lblCount.setText("Quantidade: " + count);
        });

        btnDiminuir.setOnAction(e -> {
            if (count > 0) {
                count--;
                lblCount.setText("Quantidade: " + count);
            }
        });

        VBox vbox = new VBox(btnComprar, btnVoltar, btnSair, btnAumentar, btnDiminuir, lblCount);
        Scene scene = new Scene(vbox, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
