package com.pratica.sistemadevendas.view;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import com.pratica.sistemadevendas.model.Filme;
import com.pratica.sistemadevendas.model.Poltrona;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class TelaCriticoDaNota {

    private GridPane caixaFilmesEBotoesAvaliar;

    private Button botaoVoltar;
    private HBox caixaBotaoVoltar;

    private TextField campoNota;

    private VBox caixaConteiner;

    private Scene telaCriticoDaNota;
    private Aplicacao aplicacao;

    public TelaCriticoDaNota(Aplicacao aplicacao) {
        this.aplicacao = aplicacao;

        int linha = 0, colunaFilme = 0, colunaBotaoAvaliar = 1;

        caixaFilmesEBotoesAvaliar = new GridPane();
        caixaFilmesEBotoesAvaliar.setHgap(60);
        caixaFilmesEBotoesAvaliar.setVgap(20);

        String[] listaDeFilmes = { "Filme 1", "Filme 2", "Filme 3" };

        for (String tituloFilme : listaDeFilmes) {
            Label labelNomeFilme = new Label(tituloFilme);
            campoNota = new TextField();
            Button avaliar = new Button("Avaliar");

            caixaFilmesEBotoesAvaliar.add(labelNomeFilme, colunaFilme, linha);
            caixaFilmesEBotoesAvaliar.add(campoNota, colunaBotaoAvaliar, linha);
            caixaFilmesEBotoesAvaliar.add(avaliar, colunaBotaoAvaliar + 1, linha);
            avaliar.setOnAction(e -> avaliarFilme(tituloFilme)); // Definir ação do botão
            linha++;
        }

        caixaFilmesEBotoesAvaliar.setAlignment(Pos.CENTER);

        botaoVoltar = new Button("Voltar");
        botaoVoltar.setPrefWidth(200);
        botaoVoltar.setOnAction(e -> voltar());
        caixaBotaoVoltar = new HBox();
        caixaBotaoVoltar.getChildren().addAll(botaoVoltar);
        caixaBotaoVoltar.setAlignment(Pos.CENTER);

        caixaConteiner = new VBox();
        caixaConteiner.getChildren().addAll(caixaFilmesEBotoesAvaliar, caixaBotaoVoltar);
        caixaConteiner.setAlignment(Pos.CENTER);
        caixaConteiner.setStyle("-fx-background-color: lightblue;"); // Cor de fundo diferente

        telaCriticoDaNota = new Scene(caixaConteiner);
    }

    private void avaliarFilme(String tituloFilme) {
        double nota = Double.parseDouble(campoNota.getText());
        System.out.println("Filme: " + tituloFilme + ", Nota: " + nota);
    }

    private void voltar() {

    }

    public Scene telaCriticoDaNota() {
        return this.telaCriticoDaNota;
    }
}
