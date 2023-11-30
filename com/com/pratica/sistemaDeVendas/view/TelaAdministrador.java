/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pratica.sistemadevendas.view;

import com.pratica.sistemadevendas.controller.UsuarioController;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

/**
 *
 * @author emart
 */
public class TelaAdministrador {

    private Button botaoFilmes;
    private Button botaoLoja;
    private Button botaoDeslogar;
    private Button botaoUsuarios;
    private Button botaoSair;
    private HBox caixaDeBotoes = new HBox(40);
    private HBox caixaSair = new HBox();
    private VBox paneADM = new VBox();
    private Scene cenaADM;

    private UsuarioController usuarioController;

    private Aplicacao aplicacao;

    public TelaAdministrador(Aplicacao aplicacao) {

        this.botaoFilmes = new Button("Bilheteria");
        botaoFilmes.setPrefWidth(200);
        this.botaoLoja = new Button("Loja");
        botaoLoja.setPrefWidth(200);
        this.botaoUsuarios = new Button("Usuarios");
        botaoUsuarios.setPrefWidth(200);
        this.botaoSair = new Button("Sair");
        this.botaoDeslogar = new Button("Deslogar");
        this.aplicacao = aplicacao;

        botaoUsuarios.setOnAction(e -> irParaTelaDeUsuariosCRUD());

        botaoLoja.setOnAction(e -> irParaTelaDeLanchoneteCLUD());

        botaoFilmes.setOnAction(e -> irParaFilmeCLUD());

        botaoSair.setOnAction(e -> sair());

        botaoDeslogar.setOnAction(e -> deslogar());

        caixaDeBotoes.getChildren().addAll(botaoFilmes, botaoLoja, botaoUsuarios);
        caixaDeBotoes.setSpacing(50);
        caixaSair.getChildren().addAll(botaoSair, botaoDeslogar);
        caixaSair.setSpacing(90);

        paneADM.getChildren().addAll(caixaDeBotoes, caixaSair);
        paneADM.setAlignment(Pos.CENTER);
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

        this.aplicacao.estagioAtual().close();
    }

    public void deslogar() {
        this.aplicacao.mudaCena(this.aplicacao.getTelaLogin().telaLogin());
    }

    public Scene telaMenuAdministrador() {
        return cenaADM;
    }

}
