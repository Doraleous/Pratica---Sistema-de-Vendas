package com.pratica.sistemadevendas.view;

import com.pratica.sistemadevendas.controller.LancheController;
import com.pratica.sistemadevendas.model.Lanche;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TelaLanchoneteUsuario extends Application {
    private final LancheController lancheController = new LancheController();
    private final ObservableList<Lanche> lanchesObservableList = FXCollections.observableArrayList();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Compra de Lanches");

        // Criar elementos da interface gráfica
        ListView<Lanche> lanchesListView = new ListView<>();
        lanchesListView.setItems(lanchesObservableList);

        TextField quantidadeTextField = new TextField();
        quantidadeTextField.setPromptText("Quantidade");

        Button comprarButton = new Button("Comprar");
        comprarButton.setOnAction(event -> comprarLanche(lanchesListView.getSelectionModel().getSelectedItem(),
                quantidadeTextField.getText()));

        // Layout
        VBox vbox = new VBox(10);
        vbox.setPadding(new Insets(10, 10, 10, 10));
        vbox.getChildren().addAll(lanchesListView, quantidadeTextField, comprarButton);

        // Carregar lanches no início
        carregarLanches();

        // Criar cena e exibir a janela
        Scene scene = new Scene(vbox, 300, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void carregarLanches() {
        // Carregar lanches do banco de dados ou de onde você preferir
        Lanche lanche;
        for (llllllanchesObservableList : lanche){

        }
        lanchesObservableList.addAll(lancheController.listarLanches());
    }

    private void comprarLanche(Lanche lanche, String quantidadeStr) {
        try {
            int quantidade = Integer.parseInt(quantidadeStr);
            if (lanche != null && quantidade > 0) {
                // Aqui você pode adicionar a lógica para realizar a compra
                // Por exemplo, atualizar o banco de dados com a compra
                System.out.println(
                        "Compra realizada: " + quantidade + "x " + lanche.getNome() + " por R$" + lanche.getPreco());
            } else {
                System.out.println("Selecione um lanche e insira uma quantidade válida.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Insira uma quantidade válida.");
        }
    }
}
