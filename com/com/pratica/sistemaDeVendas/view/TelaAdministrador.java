/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pratica.sistemaDeVendas.view;

import com.pratica.sistemaDeVendas.controller.UsuarioController;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

/**
 *
 * @author emart
 */
public class TelaAdministrador {

    private Button botaoFilmes;
    private Button botaoLoja;
    private Button botaoUsuarios;
    private Button botaoSair;



    private UsuarioController usuarioController;

    private Aplicacao aplicacao;

    public TelaAdministrador(Aplicacao aplicacao) {
        /*String bilheteria = "C:\\PraticaProjeto\\bilheteria.png";
        String engrenagem = "C:\\PraticaProjeto\\engrenagem.png";
        String pipoca = "C:\\PraticaProjeto\\pipoca.png";*/
        this.botaoFilmes = new Button("Bilheteria");
        this.botaoLoja = new Button("Loja");
        this.botaoUsuarios = new Button("Usuarios");
        this.botaoSair = new Button("Sair");
        this.usuarioController = new UsuarioController();
        this.aplicacao = aplicacao;

        botaoUsuarios.setOnAction(e -> {
            System.out.println("clicado");
            irParaTelaDeUsuariosCRUD();
        });
        
        botaoSair.setOnAction(e -> sair());
        

    }

    public void irParaTelaDeUsuariosCRUD(){
        System.out.println("meu corpo");
        //TelaAdministrador telaADM = new TelaAdministrador(this.aplicacao);
        //Scene cenaUsuarioCRUD = this.telaOperaCoesUsuario();
        this.aplicacao.mudaCena(this.aplicacao.getTelaOperacoesUsuario().telaOperaCoesUsuario());

    }
    
    public void sair() {
        this.usuarioController.sair();
        this.aplicacao.estagioAtual().close();
    }

    public Scene telaMenuAdministrador() {

        HBox caixaDeBotoes = new HBox(40);
        
        caixaDeBotoes.getChildren().addAll(botaoFilmes, botaoLoja, botaoUsuarios);
        //caixaDeBotoes.setAlignment(Pos.CENTER);

        HBox caixaSair = new HBox();
        caixaSair.getChildren().addAll(botaoSair);
        //caixaSair.setAlignment(Pos.BOTTOM_LEFT);

        VBox paneADM = new VBox();
        paneADM.getChildren().addAll(caixaDeBotoes, caixaSair);
        paneADM.setStyle("-fx-background-color: red;");

        Scene cenaADM = new Scene(paneADM, 600, 220);
        return cenaADM;
    }
    
    public Button criarBotaoComImagem(String caminhoDaImagem){
        
        Button botao = new Button();
        
        Image imagem = new Image(getClass().getResourceAsStream(caminhoDaImagem));
        
        ImageView imageView = new ImageView(imagem);
        
        imageView.setFitWidth(50);
        imageView.setFitHeight(50);
        
        botao.setGraphic(imageView);
        
        botao.setBackground(new Background(new BackgroundFill(Color.WHITE, null, null)));
        
        return botao;
        
    }

    
    

    

}
