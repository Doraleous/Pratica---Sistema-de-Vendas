package com.pratica.sistemaDeVendas.view;

import java.sql.SQLException;

import com.pratica.sistemaDeVendas.controller.AdministradorController;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class TelaOperacoesUsuario {

    private Label emailLabel;
    private TextField emailTextField;
    private Label nomeLabel;
    private TextField nomeTextField;
    private HBox caixaEmailENome;

    private Label senhaLabel;
    private TextField senhaTextField;
    private Label cpfLabel;
    private TextField cpTextField;
    private HBox caixaSenhaECPF;

    private Label dataDeNascimentoLabel;
    private TextField dataDeNascimentoTextField;
    private Label statusOperacaoLabel;
    private HBox caixaDataDeNascimentoEStatus;

    private Button cadastrarAdministrador;
    private Button cadastrarCritico;
    private HBox caixaCadastraAdministradorECritico;

    private Button cadastrarCliente;
    private Button cadastrarEstudante;
    private HBox caixaCadastraClienteEstudante;

    private Button deletarBotao;
    private Button buscarBotao;
    private Button atualizarBotao;
    private Button voltaBotao;
    private HBox caixaCLUDEVoltar;

    private VBox caixaConteiner;

    private AdministradorController administradorController;

    private Scene telaOperacoesUsuario;

    private Aplicacao aplicacao;

    public TelaOperacoesUsuario(Aplicacao aplicacao) {
        this.aplicacao = aplicacao;

        emailLabel = new Label("Email:");
        emailTextField = new TextField();
        emailTextField.setPrefWidth(200);
        nomeLabel = new Label("Nome:");
        nomeTextField = new TextField();
        nomeTextField.setPrefWidth(200);
        caixaEmailENome = new HBox();
        caixaEmailENome.setAlignment(Pos.CENTER);
        caixaEmailENome.getChildren().addAll(emailLabel, emailTextField, nomeLabel, nomeTextField);

        senhaLabel = new Label("Senha:");
        senhaTextField = new TextField();
        senhaTextField.setPrefWidth(200);
        cpfLabel = new Label("CPF:");
        cpTextField = new TextField();
        cpTextField.setPrefWidth(200);
        caixaSenhaECPF = new HBox();
        caixaSenhaECPF.setAlignment(Pos.CENTER);
        caixaSenhaECPF.getChildren().addAll(senhaLabel, senhaTextField, cpfLabel, cpTextField);

        dataDeNascimentoLabel = new Label("Data de nascimento:");
        dataDeNascimentoTextField = new TextField();
        dataDeNascimentoTextField.setPrefWidth(200);
        statusOperacaoLabel = new Label("");
        statusOperacaoLabel.setFont(new Font(30));
        caixaDataDeNascimentoEStatus = new HBox();
        caixaDataDeNascimentoEStatus.setAlignment(Pos.CENTER);
        caixaDataDeNascimentoEStatus.getChildren().addAll(dataDeNascimentoLabel, dataDeNascimentoTextField,
                statusOperacaoLabel);

        cadastrarAdministrador = new Button("Cadastrar Administrador");
        cadastrarAdministrador.setPrefWidth(200);
        cadastrarAdministrador.setOnAction(e -> {
            try {
                this.administradorController.cadastrarUsuario("Administrador");
            } catch (SQLException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        });
        cadastrarCritico = new Button("Cadastrar Crítico");
        cadastrarCritico.setPrefWidth(200);
        cadastrarCritico.setOnAction(e -> {
            try {
                this.administradorController.cadastrarUsuario("Crítico");
            } catch (SQLException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        });
        caixaCadastraAdministradorECritico = new HBox();
        caixaCadastraAdministradorECritico.setSpacing(30);
        caixaCadastraAdministradorECritico.setAlignment(Pos.CENTER);
        caixaCadastraAdministradorECritico.getChildren().addAll(cadastrarAdministrador, cadastrarCritico);

        cadastrarCliente = new Button("Cadastrar Usuário");
        cadastrarCliente.setPrefWidth(200);
        cadastrarCliente.setOnAction(e -> {
            try {
                this.administradorController.cadastrarUsuario("Comum");
            } catch (SQLException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        });
        cadastrarEstudante = new Button("Cadastrar Estudante");
        cadastrarEstudante.setPrefWidth(200);
        cadastrarEstudante.setOnAction(e -> {
            try {
                this.administradorController.cadastrarUsuario("Estudante");
            } catch (SQLException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        });
        caixaCadastraClienteEstudante = new HBox();
        caixaCadastraClienteEstudante.setSpacing(30);
        caixaCadastraClienteEstudante.setAlignment(Pos.CENTER);
        caixaCadastraClienteEstudante.getChildren().addAll(cadastrarCliente, cadastrarEstudante);

        deletarBotao = new Button("Deletar");
        deletarBotao.setPrefWidth(100);
        buscarBotao = new Button("Buscar");
        buscarBotao.setPrefWidth(100);
        atualizarBotao = new Button("Atualizar");
        atualizarBotao.setPrefWidth(100);
        voltaBotao = new Button("Voltar");
        voltaBotao.setPrefWidth(100);
        voltaBotao.setOnAction(e -> voltar());
        caixaCLUDEVoltar = new HBox();
        caixaCLUDEVoltar.setAlignment(Pos.CENTER);
        caixaCLUDEVoltar.setSpacing(20);
        caixaCLUDEVoltar.getChildren().addAll(deletarBotao, buscarBotao, atualizarBotao, voltaBotao);

        caixaConteiner = new VBox();
        caixaConteiner.setStyle("-fx-background-color: red;");
        caixaConteiner.setSpacing(100);
        caixaConteiner.setAlignment(Pos.CENTER);
        caixaConteiner.getChildren().addAll(caixaEmailENome, caixaSenhaECPF, caixaDataDeNascimentoEStatus,
                caixaCadastraAdministradorECritico, caixaCadastraClienteEstudante, caixaCLUDEVoltar);

        administradorController = new AdministradorController(this.aplicacao);

        telaOperacoesUsuario = new Scene(caixaConteiner);

    }

    public Scene telaOperaCoesUsuario() {

        return telaOperacoesUsuario;

    }

    public Label getLabelStatusOperacao() {
        return this.statusOperacaoLabel;
    }

    public TextField getEmailTextField() {
        return this.emailTextField;
    }

    public TextField getnomeTextField() {
        return this.nomeTextField;
    }

    public TextField getsenhaTextField() {
        return this.senhaTextField;
    }

    public TextField getcpTextField() {
        return this.cpTextField;
    }

    public Label statusOperacaoLabel() {
        return this.statusOperacaoLabel();
    }

    public void voltar() {
        this.aplicacao.mudaCena(this.aplicacao.getTelaAdministrador().telaMenuAdministrador());

    }

}
