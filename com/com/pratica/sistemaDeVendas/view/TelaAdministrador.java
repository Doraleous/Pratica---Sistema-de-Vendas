/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pratica.sistemadevendas.view;

import com.pratica.sistemadevendas.controller.UsuarioController;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

/**
 *
 * @author emart
 */
public class TelaAdministrador {

    private Label labelTitulo;
    private Region separador;
    private Button botaoFilmes;
    private Button botaoLoja;
    private Button botaoDeslogar;
    private Button botaoUsuarios;
    private Button botaoSair;
    private HBox caixaDeBotoes;
    private HBox caixaSair;
    private VBox paneADM;
    private Scene cenaADM;

    private UsuarioController usuarioController;

    private Aplicacao aplicacao;

    public TelaAdministrador(Aplicacao aplicacao) {

        labelTitulo = new Label("Cinecap - Administrador");
        labelTitulo.setStyle("-fx-text-fill: white; -fx-font-size: 40px;");
        separador = new Region();
        separador.setMinHeight(200);

        this.botaoFilmes = new Button("Bilheteria");
        botaoFilmes.setPrefWidth(200);
        botaoFilmes.setStyle("-fx-border-color: black; -fx-border-width: 1px;");
        this.botaoLoja = new Button("Loja");
        botaoLoja.setPrefWidth(200);
        botaoLoja.setStyle("-fx-border-color: black; -fx-border-width: 1px;");
        this.botaoUsuarios = new Button("Usuarios");
        botaoUsuarios.setPrefWidth(200);
        botaoUsuarios.setStyle("-fx-border-color: black; -fx-border-width: 1px;");
        this.botaoSair = new Button("Sair");
        botaoSair.setStyle("-fx-border-color: black; -fx-border-width: 1px;");
        botaoSair.setPrefWidth(150);
        botaoSair.setStyle("-fx-border-color: black; -fx-border-width: 1px;");
        this.botaoDeslogar = new Button("Deslogar");
        botaoDeslogar.setPrefWidth(150);
        botaoDeslogar.setStyle("-fx-border-color: black; -fx-border-width: 1px;");
        this.aplicacao = aplicacao;

        botaoUsuarios.setOnAction(e -> irParaTelaDeUsuariosCRUD());

        botaoLoja.setOnAction(e -> irParaTelaDeLanchoneteCLUD());

        botaoFilmes.setOnAction(e -> irParaFilmeCLUD());

        botaoSair.setOnAction(e -> sair());

        botaoDeslogar.setOnAction(e -> deslogar());
        caixaDeBotoes = new HBox(40);
        caixaDeBotoes.getChildren().addAll(botaoFilmes, botaoLoja, botaoUsuarios);
        caixaDeBotoes.setSpacing(50);
        caixaDeBotoes.setAlignment(Pos.CENTER);
        caixaSair = new HBox();
        caixaSair.getChildren().addAll(botaoSair, botaoDeslogar);
        caixaSair.setSpacing(90);
        caixaSair.setAlignment(Pos.CENTER);

        paneADM = new VBox(40);
        paneADM.getChildren().addAll(labelTitulo, separador, caixaDeBotoes, caixaSair);
        paneADM.setAlignment(Pos.TOP_CENTER);
        paneADM.setStyle("-fx-background-color: red;");
        cenaADM = new Scene(paneADM, 600, 220);

    }

    public void irParaFilmeCLUD() {
        this.aplicacao.mudaCena(this.aplicacao.getTelaOperacoesFilme().telaOperacoesFilme());
    }

    public void irParaTelaDeUsuariosCRUD() {

        this.aplicacao.mudaCena(this.aplicacao.getTelaOperacoesUsuario().telaOperaCoesUsuario());

    }

    public void irParaTelaDeLanchoneteCLUD() {
        this.aplicacao.mudaCena(this.aplicacao.getTelaOperacoesLanchonete().telaOperacoesLanchonete());
    }

    public void sair() {

        this.aplicacao.getEstagioAtual().close();
    }

    public void deslogar() {
        this.aplicacao.getTelaLogin().loginTextField().setText("");
        this.aplicacao.getTelaLogin().senhaTextField().setText("");
        this.aplicacao.mudaCena(this.aplicacao.getTelaLogin().telaLogin());
        
    }

    public Scene telaMenuAdministrador() {
        return cenaADM;
    }

}
