package com.pratica.sistemadevendas.view;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class TelaOperacoesLanchonete {
    private Label labelNomeLanche = new Label ("Nome");
    private TextField textFieldNomeLanche = new TextField("");
    private Button botaoCadastraLanche = new Button("Cadastrar Produto");
    private Button botaoDeletaLanche = new Button("Deletar Produto");
    private Button botaoListarLanche = new Button("Listar Produto");
    private Button botaoAtualizarLanche = new Button("Atualizar Produto");
    private Button botaoVoltar = new Button("Voltar");

    private Label labelPrecoLanche = new Label ("Preço");
    private TextField textFieldPrecoLanche = new TextField();

    private Label labelStatusOperacao = new Label("Status");

    private HBox caixaConteiner = new HBox();
    private VBox caixaLabelsBotoes = new VBox();
    private VBox caixaTextFields = new VBox();

    private Scene telaOperacoesLanchonete;

    private Aplicacao aplicacao;

    public TelaOperacoesLanchonete(Aplicacao aplicacao){
        this.aplicacao = aplicacao;

        labelNomeLanche.setPrefHeight(50);
        labelNomeLanche.setPrefWidth(100);

        labelPrecoLanche.setPrefHeight(50);
        labelPrecoLanche.setPrefWidth(100);

        labelStatusOperacao.setPrefHeight(50);
        labelStatusOperacao.setPrefWidth(100);

        botaoVoltar.setPrefWidth(100);
        botaoVoltar.setOnAction(e -> voltar());

        caixaLabelsBotoes.getChildren().addAll(labelNomeLanche, labelPrecoLanche, botaoVoltar, labelStatusOperacao);

        textFieldNomeLanche.setPrefWidth(300);
        textFieldNomeLanche.setPrefHeight(50);

        textFieldPrecoLanche.setPrefWidth(300);
        textFieldPrecoLanche.setPrefHeight(50);

        botaoCadastraLanche.setPrefWidth(200);
        botaoListarLanche.setPrefWidth(200);        
        botaoDeletaLanche.setPrefWidth(200);
        botaoListarLanche.setPrefWidth(200);
        
        caixaTextFields.setPadding(new Insets(10.5, 2, 10.5, 2));
        caixaTextFields.getChildren().addAll(textFieldNomeLanche, textFieldPrecoLanche, botaoCadastraLanche,
        botaoListarLanche, botaoDeletaLanche, botaoAtualizarLanche);


        caixaConteiner.setStyle("-fx-background-color: red;");
        caixaConteiner.setSpacing(10);
        caixaConteiner.getChildren().addAll(caixaLabelsBotoes, caixaTextFields);

        telaOperacoesLanchonete = new Scene(caixaConteiner);
    }

    public Scene telaOperacoesLanchonete(){           

        return telaOperacoesLanchonete;        
    }

    public void voltar(){
        this.aplicacao.mudaCena(this.aplicacao.getTelaAdministrador().telaMenuAdministrador());

    }

    
}
