package com.pratica.sistemadevendas.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class TelaOperacoesLanchonete {
    
    private Label nomeProdutoLabel;
    private TextField nomeProdutoTextField;
    private Label valorProdutoLabel;
    private TextField valorProdutoTextField;
    private HBox caixaNomeEValorProdutos;

    private Button cadastrarProdutos;
    private Button deletarProdutos;
    private HBox caixaCadastrarDeletar;

    private Button listarProdutos;
    private Button atualizarProdutos;
    private HBox caixaListarAtualizar;

    private Label statusOperacaoLabel;
    private HBox caixaStatusOperacao;

    private Button botaoVoltar;
    private HBox caixaBotaoVoltar;

    private VBox caixaConteiner;

    private Scene telaOperacoesLanchonete;

    private Aplicacao aplicacao;

    public TelaOperacoesLanchonete(Aplicacao aplicacao){
        this.aplicacao = aplicacao;

        nomeProdutoLabel = new Label("Produto:");
        nomeProdutoTextField = new TextField();
        nomeProdutoTextField.setPrefWidth(200);
        valorProdutoLabel = new Label("Preço:");
        valorProdutoTextField = new TextField();
        valorProdutoTextField.setPrefWidth(200);
        caixaNomeEValorProdutos = new HBox();
        caixaNomeEValorProdutos.setSpacing(6);
        caixaNomeEValorProdutos.setAlignment(Pos.CENTER);
        caixaNomeEValorProdutos.getChildren().addAll(nomeProdutoLabel, nomeProdutoTextField, valorProdutoLabel,
        valorProdutoTextField);

        cadastrarProdutos = new Button("Cadastrar Produto");
        cadastrarProdutos.setPrefWidth(200);
        deletarProdutos = new Button("Deletar Produto");
        deletarProdutos.setPrefWidth(200);
        caixaCadastrarDeletar = new HBox();
        caixaCadastrarDeletar.setSpacing(6);
        caixaCadastrarDeletar.setAlignment(Pos.CENTER);
        caixaCadastrarDeletar.getChildren().addAll(cadastrarProdutos, deletarProdutos);

        listarProdutos = new Button("Listar Produto");
        listarProdutos.setPrefWidth(200);
        atualizarProdutos = new Button("Atualizar Produto");
        atualizarProdutos.setPrefWidth(200);
        caixaListarAtualizar = new HBox();
        caixaListarAtualizar.setSpacing(6);
        caixaListarAtualizar.setAlignment(Pos.CENTER);
        caixaListarAtualizar.getChildren().addAll(listarProdutos, atualizarProdutos);

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
        caixaConteiner.getChildren().addAll(caixaNomeEValorProdutos, caixaCadastrarDeletar, caixaListarAtualizar,
        caixaStatusOperacao, caixaBotaoVoltar);
                
        telaOperacoesLanchonete = new Scene(caixaConteiner);
    }

    public Scene telaOperacoesLanchonete(){           

        return telaOperacoesLanchonete;        
    }

    public void voltar(){
        this.aplicacao.mudaCena(this.aplicacao.getTelaAdministrador().telaMenuAdministrador());

    }

    
}
