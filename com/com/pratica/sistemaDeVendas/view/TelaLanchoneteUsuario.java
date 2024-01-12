package com.pratica.sistemaDeVendas.view;

import com.pratica.sistemaDeVendas.controller.LancheController;
import com.pratica.sistemaDeVendas.model.Lanche;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TelaLanchoneteUsuario extends Application {
    private final LancheController lancheController = new LancheController();
    private final ObservableList<Lanche> lanchesObservableList = FXCollections.observableArrayList();
    private Aplicacao aplicacao;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        // public TelaLanchoneteUsuario (Aplicacao aplicacao)
        primaryStage.setTitle("Compra de Lanches");

        // Criar elementos da interface gráfica
        ListView<Lanche> lanchesListView = new ListView<>();
        lanchesListView.setItems(lanchesObservableList);

        TextField quantidadeTextField = new TextField();
        quantidadeTextField.setPromptText("Quantidade");

        Label mensagemLabel = new Label(); // Adicione um Label para mostrar mensagens

        Button comprarButton = new Button("Comprar");
        comprarButton.setOnAction(event -> comprarLanche(
                lanchesListView.getSelectionModel().getSelectedItem(),
                quantidadeTextField.getText(),
                mensagemLabel)); // Passe o Label para a função comprarLanche

        Button voltarButton = new Button("Voltar");
        /*
         * voltarButton.setOnAction(event -> {
         * sair();
         * });
         */

        // Layout
        VBox vbox = new VBox(10);
        vbox.setPadding(new Insets(10, 10, 10, 10));
        vbox.getChildren().addAll(lanchesListView, quantidadeTextField, comprarButton, voltarButton, mensagemLabel);

        // Carregar lanches no início
        carregarLanches();

        // Criar cena e exibir a janela
        Scene scene = new Scene(vbox, 300, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void carregarLanches() {
        // Carregar lanches do banco de dados ou de onde você preferir
        lanchesObservableList.addAll(lancheController.listarLanches());
    }

    private void comprarLanche(Lanche lanche, String quantidadeStr, Label mensagemLabel) {
        try {
            int quantidade = Integer.parseInt(quantidadeStr);
            if (lanche != null && quantidade > 0) {
                // Aqui você pode adicionar a lógica para realizar a compra
                // Por exemplo, atualizar o banco de dados com a compra
                mensagemLabel.setText(
                        "Compra realizada: " + quantidade + "x " + lanche.getNome() + " por R$" + lanche.getPreco());
            } else {
                mensagemLabel.setText("Selecione um lanche e insira uma quantidade válida.");
            }
        } catch (NumberFormatException e) {
            mensagemLabel.setText("Insira uma quantidade válida.");
        }
    }

    /*
     * public void sair() {
     * this.aplicacao.getEstagioAtual().close();
     * }
     */
}
