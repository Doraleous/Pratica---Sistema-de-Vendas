package com.pratica.sistemadevendas.view;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TelaDeCriticoDarNota extends VBox {

    private ObservableList<Filme> listaFilmes = FXCollections.observableArrayList();
    private Application aplicacao;

    public TelaDeCriticoDarNota(Aplicacao aplicacao) {
        this.aplicacao = aplicacao;

        // Adicionar filmes à lista Buscar filmes*
        listaFilmes.add(new Filme("Filme 1"));
        listaFilmes.add(new Filme("Filme 2"));
        listaFilmes.add(new Filme("Filme 3"));

        ListView<Filme> listViewFilmes = new ListView<>(listaFilmes);
        listViewFilmes.setCellFactory(param -> new ListCell<>() {
            @Override
            protected void updateItem(Filme filme, boolean empty) {
                super.updateItem(filme, empty);
                if (empty || filme == null) {
                    setText(null);
                } else {
                    setText(filme.getTitulo());
                }
            }
        });

        Slider sliderNota = new Slider(0, 10, 5);
        sliderNota.setShowTickMarks(true);
        sliderNota.setShowTickLabels(true);

        Button btnDarNota = new Button("Dar Nota");
        btnDarNota.setOnAction(e -> {
            Filme selectedFilme = listViewFilmes.getSelectionModel().getSelectedItem();
            if (selectedFilme != null) {
                double nota = sliderNota.getValue();
                selectedFilme.adicionarNota(nota);
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Nota Adicionada");
                alert.setHeaderText(null);
                alert.setContentText("Nota " + nota + " adicionada para " + selectedFilme.getTitulo());
                alert.showAndWait();
            } else {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Selecione um Filme");
                alert.setHeaderText(null);
                alert.setContentText("Por favor, selecione um filme antes de dar uma nota.");
                alert.showAndWait();
            }
        });

        Button btnVoltar = new Button("Voltar");
        btnVoltar.setOnAction(e -> voltarParaOutraTela());

        // Layout da tela
        setSpacing(10);
        setPadding(new Insets(10));
        getChildren().addAll(listViewFilmes, sliderNota, btnDarNota, btnVoltar);
    }

}
