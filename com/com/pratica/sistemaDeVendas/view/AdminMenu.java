package com.pratica.sistemaDeVendas.view;

import java.io.File;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class AdminMenu extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Criar um layout StackPane
        StackPane root = new StackPane();
        root.setBackground(new Background(new BackgroundFill(Color.web("#FF0000"), null, null)));
        root.setPrefSize(300, 400);  // Aumentei a altura para acomodar a Label

        // Adicionar a Label acima dos botões
        Label labelTitulo = new Label("CineCap");
        labelTitulo.setStyle("-fx-text-fill: white; -fx-font-size: 24px;");
        root.getChildren().add(labelTitulo);

        // Criar botões
        Button btn1 = criarBotaoComImagem("img" + File.separator + "bilhete.png");
        Button btn2 = criarBotaoComImagem("img" + File.separator + "pipoca.png");
        Button btn3 = criarBotaoComImagem("img" + File.separator + "engrenagem.png");

        // Adicionar os botões ao layout
        root.getChildren().addAll(btn1, btn2, btn3);

        // Configurar a posição dos botões
        StackPane.setAlignment(labelTitulo, Pos.TOP_CENTER);  // Posicionar a Label no topo central
        StackPane.setAlignment(btn1, Pos.CENTER_LEFT);
        StackPane.setAlignment(btn2, Pos.CENTER);
        StackPane.setAlignment(btn3, Pos.CENTER_RIGHT);

        // Criar a cena
        Scene scene = new Scene(root);

        // Configurar a cena no palco (Stage)
        primaryStage.setTitle("Menu de Administrador");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private Button criarBotaoComImagem(String imagePath) {
        // Criar um botão
        Button button = new Button();

        // Carregar a imagem
        Image image = new Image(getClass().getResourceAsStream(imagePath));

        // Criar um ImageView com a imagem
        ImageView imageView = new ImageView(image);

        // Configurar o tamanho da imagem
        imageView.setFitWidth(50);
        imageView.setFitHeight(50);

        // Configurar a imagem no botão
        button.setGraphic(imageView);

        // Configurar o fundo do botão
        button.setBackground(new Background(new BackgroundFill(Color.WHITE, null, null)));

        // Configurar o tamanho do botão
        button.setPrefSize(100, 100);

        return button;
    }

    public static void main(String[] args) {
        launch(args);
    }
}