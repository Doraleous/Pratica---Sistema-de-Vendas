package com.pratica.sistemadevendas.view;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TelaComprarFilmes extends Application {

    private GridPane caixaFilmesEBotoesComprar;

    private Button botaoVoltar;
    private HBox caixaBotaoVoltar;

    private VBox caixaConteiner;

    private Scene telaComprarFilmes;

    public Aplicacao aplicacao;

    public TelaComprarFilmes(Aplicacao aplicacao) {
        this.aplicacao = aplicacao;

        int linha, colunaFilme = 0, colunaBotaoComprar = 1;

        caixaFilmesEBotoesComprar = new GridPane();

        for (linha = 0; linha < 5; linha++) {
            Label labelNomeFilme = new Label("Pornôzão do Diegão" + linha);
            Button comprar = new Button("Comprar");

            caixaFilmesEBotoesComprar.add(labelNomeFilme, colunaFilme, linha);
            caixaFilmesEBotoesComprar.add(comprar, colunaBotaoComprar, linha);

        }

        caixaFilmesEBotoesComprar.setAlignment(Pos.CENTER);

        botaoVoltar = new Button("Voltar");
        botaoVoltar.setPrefWidth(200);
        caixaBotaoVoltar = new HBox();
        caixaBotaoVoltar.getChildren().addAll(botaoVoltar);
        caixaBotaoVoltar.setAlignment(Pos.CENTER);

        caixaConteiner = new VBox();
        caixaConteiner.getChildren().addAll(caixaFilmesEBotoesComprar, caixaBotaoVoltar);
        caixaConteiner.setAlignment(Pos.CENTER);

        telaComprarFilmes = new Scene(caixaConteiner);

    }

    public Scene telaComprarFilmes() {
        return this.telaComprarFilmes;
    }

    public void start(Stage estagio) {
        estagio = new Stage();
        estagio.setWidth(800);
        estagio.setHeight(800);

        estagio.setScene(this.telaComprarFilmes);
        estagio.show();
    }

    public static void main(String[] args) {
        Application.launch(args);

    }

}