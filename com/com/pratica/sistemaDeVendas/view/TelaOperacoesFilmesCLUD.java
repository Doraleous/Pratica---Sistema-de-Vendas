package com.pratica.sistemadevendas.view;

import java.sql.SQLException;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

public class TelaOperacoesFilmesCLUD {

    private Label tituloLabel;
    private TextField tituloTextField;
    private Region entreTituloLabelETxtfld;
    private HBox digitaTitulo;

    private Button cadastraFilmeBotao;
    private Button deletarFilmeBotao;
    private HBox cadastraDeletaFilme;

    private Button listarFilmeBotao;
    private Button atualizarFilmeBotao;
    private HBox listaAtualizaFilme;

    private Button retirarFilmeDeCartazBotao;
    private HBox caixaRetiraFilmeDeCartaz;

    private Label statusOperacaoLabel;
    private HBox caixaStatusOperacao;

    private Button botaoVoltar;
    private HBox caixaBotaoVoltar;

    private VBox caixaConteiner;

    private Scene telaOperacoesFilmesCLUD;

    private Aplicacao aplicacao;

    public TelaOperacoesFilmesCLUD(Aplicacao aplicacao) {
        this.aplicacao = aplicacao;

        tituloLabel = new Label("Título:");
        tituloTextField = new TextField();
        tituloTextField.setPrefWidth(400);
        entreTituloLabelETxtfld = new Region();
        entreTituloLabelETxtfld.setMaxWidth(20);
        entreTituloLabelETxtfld.setMinWidth(20);
        digitaTitulo = new HBox();
        digitaTitulo.setAlignment(Pos.CENTER);
        digitaTitulo.getChildren().addAll(tituloLabel, entreTituloLabelETxtfld, tituloTextField);

        cadastraFilmeBotao = new Button("Cadastrar Filme");
        cadastraFilmeBotao.setPrefWidth(300);
        cadastraFilmeBotao.setOnAction(e -> {
            try {
                cadastraFilme();
            } catch (SQLException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        });
        deletarFilmeBotao = new Button("Deletar Filme");
        deletarFilmeBotao.setPrefWidth(300);
        cadastraDeletaFilme = new HBox();
        cadastraDeletaFilme.setSpacing(50);
        cadastraDeletaFilme.setAlignment(Pos.CENTER);
        cadastraDeletaFilme.getChildren().addAll(cadastraFilmeBotao, deletarFilmeBotao);

        listarFilmeBotao = new Button("Listar Filme");
        listarFilmeBotao.setPrefWidth(300);
        atualizarFilmeBotao = new Button("Atualizar Filme");
        atualizarFilmeBotao.setPrefWidth(300);
        listaAtualizaFilme = new HBox();
        listaAtualizaFilme.setSpacing(50);
        listaAtualizaFilme.setAlignment(Pos.CENTER);
        listaAtualizaFilme.getChildren().addAll(listarFilmeBotao, atualizarFilmeBotao);

        retirarFilmeDeCartazBotao = new Button("Retirar filme de cartaz");
        retirarFilmeDeCartazBotao.setPrefWidth(300);
        retirarFilmeDeCartazBotao.setOnAction(e -> retiraFilmeDeCartaz());
        caixaRetiraFilmeDeCartaz = new HBox();
        caixaRetiraFilmeDeCartaz.setAlignment(Pos.CENTER);
        caixaRetiraFilmeDeCartaz.getChildren().addAll(retirarFilmeDeCartazBotao);

        statusOperacaoLabel = new Label("Status");
        statusOperacaoLabel.setStyle("-fx-text-fill: yellow; -fx-font-size: 40px;");
        caixaStatusOperacao = new HBox();
        caixaStatusOperacao.getChildren().addAll(statusOperacaoLabel);

        botaoVoltar = new Button("Voltar");
        botaoVoltar.setOnAction(e -> voltar());
        botaoVoltar.setPrefWidth(100);
        caixaBotaoVoltar = new HBox();
        caixaBotaoVoltar.setAlignment(Pos.CENTER);
        caixaBotaoVoltar.getChildren().addAll(botaoVoltar);

        caixaConteiner = new VBox();
        caixaConteiner.setStyle("-fx-background-color: red;");
        caixaConteiner.setSpacing(100);
        caixaConteiner.setAlignment(Pos.CENTER);
        caixaConteiner.getChildren().addAll(digitaTitulo, cadastraDeletaFilme, listaAtualizaFilme,
                caixaRetiraFilmeDeCartaz,
                caixaStatusOperacao,
                caixaBotaoVoltar);

        telaOperacoesFilmesCLUD = new Scene(caixaConteiner);

    }

    public String cadastrarFilme() {
        return this.tituloTextField.getText();
    }

    public Scene telaOperacoesFilmesCLUD() {
        return this.telaOperacoesFilmesCLUD;
    }

    public String retiraFilmeDeCartaz() {
        return this.tituloTextField.getText();
    }

    public void cadastraFilme() throws SQLException {
        this.aplicacao.getAdministradorController().cadastrarFilme(cadastrarFilme());
    }

    public Label statusOperacao() {
        return this.statusOperacaoLabel;
    }

    public void voltar() {
        this.aplicacao.mudaCena(this.aplicacao.getTelaOperacoesFilme().telaOperacoesFilme());

    }

}
