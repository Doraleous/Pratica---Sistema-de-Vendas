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
import javafx.stage.StageStyle;

public class TelaLanchoneteUsuario {
    private final LancheController lancheController = new LancheController();
    private final ObservableList<Lanche> lanchesObservableList = FXCollections.observableArrayList();
    private Aplicacao aplicacao;
    private Scene scene;

    public TelaLanchoneteUsuario(Aplicacao aplicacao) {
        this.aplicacao = aplicacao;
        // this.aplicacao.getEstagioAtual().initStyle(StageStyle.UNDECORATED);

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
        voltarButton.setOnAction(event -> this.aplicacao.getEstagioAtual().close());
        /*
         * voltarButton.setOnAction(event -> {
         * sair();
         * });
         */

        // Layout
        VBox vbox = new VBox(10);
        vbox.setPadding(new Insets(10, 10, 10, 10));
        vbox.setStyle("-fx-background-color: red;");
        vbox.getChildren().addAll(lanchesListView, quantidadeTextField, comprarButton, voltarButton, mensagemLabel);

        // Carregar lanches no início
        carregarLanches();

        // Criar cena e exibir a janela
        scene = new Scene(vbox, 300, 300);
        this.aplicacao.getEstagioAtual().setScene(scene);
        this.aplicacao.getEstagioAtual().show();
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

    /**
     * @param aplicacao the aplicacao to set
     */
    public void setAplicacao(Aplicacao aplicacao) {
        this.aplicacao = aplicacao;
    }

    /**
     * @return Scene return the scene
     */
    public Scene getScene() {
        return scene;
    }

}
