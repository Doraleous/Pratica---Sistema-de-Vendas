package com.pratica.sistemadevendas.view;

import java.sql.SQLException;

import com.pratica.sistemadevendas.controller.UsuarioController;
import com.pratica.sistemadevendas.model.Administrador;
import com.pratica.sistemadevendas.model.UsuarioComum;
import com.pratica.sistemadevendas.model.UsuarioCritico;
import com.pratica.sistemadevendas.model.UsuarioEstudante;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.Stage;

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

    private Scene telaOperacoesUsuario;


    private Aplicacao aplicacao;

    public TelaOperacoesUsuario(Aplicacao aplicacao){
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
        statusOperacaoLabel = new Label("Status");
        caixaDataDeNascimentoEStatus = new HBox();
        caixaDataDeNascimentoEStatus.setAlignment(Pos.CENTER);
        caixaDataDeNascimentoEStatus.getChildren().addAll(dataDeNascimentoLabel, dataDeNascimentoTextField,
        statusOperacaoLabel);

        cadastrarAdministrador = new Button("Cadastrar Administrador");
        cadastrarAdministrador.setPrefWidth(200);
        cadastrarCritico = new Button("Cadastrar Crítico");
        cadastrarCritico.setPrefWidth(200);
        caixaCadastraAdministradorECritico = new HBox();
        caixaCadastraAdministradorECritico.setSpacing(30);
        caixaCadastraAdministradorECritico.setAlignment(Pos.CENTER);
        caixaCadastraAdministradorECritico.getChildren().addAll(cadastrarAdministrador, cadastrarCritico);

        cadastrarCliente = new Button("Cadastrar Sala XD");
        cadastrarCliente.setPrefWidth(200);
        cadastrarEstudante = new Button("Cadastrar Sala XD3D");
        cadastrarEstudante.setPrefWidth(200);
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

        telaOperacoesUsuario = new Scene(caixaConteiner);


    }

    public Scene telaOperaCoesUsuario(){     
        
        

        return telaOperacoesUsuario;
        
    }

    public Label getLabelStatusOperacao(){
        return this.statusOperacaoLabel;
    }

    /*public void cadastraADMController() throws SQLException{
        String CPF = this.textFieldCPF.getText();
        String senha = this.textFieldSenha.getText();
        String nome = this.textFieldNome.getText();
        String email = this.textFieldEmail.getText();

        this.aplicacao.getUsuarioController().cadastraAdministradorController(CPF, senha, nome, email);

    }*/

    


    public void voltar(){
        this.aplicacao.mudaCena(this.aplicacao.getTelaAdministrador().telaMenuAdministrador());

    }
    
}
