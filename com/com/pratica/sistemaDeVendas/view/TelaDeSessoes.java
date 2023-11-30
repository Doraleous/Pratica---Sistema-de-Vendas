package com.pratica.sistemadevendas.view;

import java.sql.SQLException;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Date;
import java.util.List;

import com.pratica.sistemadevendas.model.Filme;
import com.pratica.sistemadevendas.model.Sessao;

public class TelaDeSessoes {

    private GridPane caixaSessoesEBotoes;
    private Button botaoVoltar;
    private HBox caixaBotaoVoltar;
    private Label semSessao;
    private VBox caixaConteiner;
    private Scene telaDeSessoes;
    public Aplicacao aplicacao;
    private String horarioSessao;

    public TelaDeSessoes(Aplicacao aplicacao) throws SQLException {
        this.aplicacao = aplicacao;
        ///////////////////// test/////////////////////////
        List<Sessao> listaDeSessoes = new ArrayList<>();

        // Criando alguns filmes para teste
        Filme filme1 = new Filme("Filme 1");
        Filme filme2 = new Filme("Filme 2");

        // Adicionando sessões fictícias
        listaDeSessoes.add(new Sessao(new Date(), filme1));
        listaDeSessoes.add(new Sessao(new Date(), filme2));
        listaDeSessoes.add(new Sessao(new Date(), filme1));

        if (listaDeSessoes != null) {
            int linha = 0, colunaSessao = 0, colunaBotaoDetalhes = 1;

            caixaSessoesEBotoes = new GridPane();
            caixaSessoesEBotoes.setHgap(60);
            caixaSessoesEBotoes.setVgap(20);

            for (Sessao sessao : listaDeSessoes) {
                /////////////// teste///////////////////
                String horaMinuto = String.format("%02d:%02d",
                        sessao.getDataInicio().getHours(),
                        sessao.getDataInicio().getMinutes());
                Label labelHorarioSessao = new Label(horaMinuto);
                /////////////////////////////////////
                Button detalhes = new Button("Detalhes");

                caixaSessoesEBotoes.add(labelHorarioSessao, colunaSessao, linha);
                caixaSessoesEBotoes.add(detalhes, colunaBotaoDetalhes, linha);
                detalhes.setOnAction(e -> mostrarDetalhesSessao(horarioSessao)); // Definir ação do botão
                linha++;
            }

            caixaSessoesEBotoes.setAlignment(Pos.CENTER);

            botaoVoltar = new Button("Voltar");
            botaoVoltar.setPrefWidth(200);
            botaoVoltar.setOnAction(e -> voltar());
            caixaBotaoVoltar = new HBox();
            caixaBotaoVoltar.getChildren().addAll(botaoVoltar);
            caixaBotaoVoltar.setAlignment(Pos.CENTER);

            caixaConteiner = new VBox();
            caixaConteiner.getChildren().addAll(caixaSessoesEBotoes, caixaBotaoVoltar);
            caixaConteiner.setAlignment(Pos.CENTER);
            caixaConteiner.setStyle("-fx-background-color: lightgreen;");

        } else {
            semSessao = new Label("Não há sessões disponíveis no momento.");
            caixaConteiner = new VBox();
            caixaConteiner.getChildren().add(semSessao);
            caixaConteiner.setAlignment(Pos.CENTER);
        }

        telaDeSessoes = new Scene(caixaConteiner);
    }

    private void mostrarDetalhesSessao(String horarioSessao) {
        System.out.println("Detalhes da sessão: " + horarioSessao);
    }

    private void voltar() {

    }

    public Scene telaDeSessoes() {
        return this.telaDeSessoes;
    }

    /*
     * @Override
     * public void start(Stage stage) {
     * stage.setScene(telaDeSessoes);
     * stage.setTitle("Tela de Sessões");
     * stage.show();
     * }
     * 
     * public static void main(String[] args) {
     * launch(args);
     * }
     */
}
