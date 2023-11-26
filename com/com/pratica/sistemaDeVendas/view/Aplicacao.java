/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pratica.sistemaDeVendas.view;

import java.io.IOException;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author emart
 */
public class Aplicacao extends Application {
    private Stage estagioAtual;
    private TelaAdministrador telaAdministrador;
    

    private TelaLogin telaLogin; 

    private TelaOperacoesUsuario telaOperacoesUsuario2;
    
    private TelaOperacoesLanchonete telaOperacoesLanchonete;

    private TelaOperacoesFilme telaOperacoesFilme;
    
    
    public void start(Stage estagioPrimario) throws IOException {
        //this.estagioAtual = estagioPrimario;
        estagioAtual = new Stage();
        estagioAtual.initStyle(StageStyle.UNDECORATED);
        estagioAtual.setTitle("Cinecap - Logar Usuário");
        estagioAtual.setWidth(700);
        estagioAtual.setHeight(700);

        telaAdministrador = new TelaAdministrador(this);
        telaLogin = new TelaLogin(this);
        telaOperacoesUsuario2 = new TelaOperacoesUsuario(this);
        telaOperacoesLanchonete = new TelaOperacoesLanchonete(this);
        telaOperacoesFilme = new TelaOperacoesFilme(this);
        
        
        estagioAtual.setScene(this.telaLogin.telaLogin());
        estagioAtual.show();
        
    }

    public TelaAdministrador getTelaAdministrador(){
        return this.telaAdministrador;
    }

    public TelaLogin getTelaLogin(){
        return this.telaLogin;
    }

    public TelaOperacoesUsuario getTelaOperacoesUsuario(){
        return this.telaOperacoesUsuario2;

    }

    public TelaOperacoesLanchonete getTelaOperacoesLanchonete(){
        return this.telaOperacoesLanchonete;
    }

    public TelaOperacoesFilme getTelaOperacoesFilme(){
        return this.telaOperacoesFilme;
    }
    
    public void mudaCena(Scene novaCena){
        this.estagioAtual.setScene(novaCena);
        this.estagioAtual.show();
        
    }
    
    public Stage estagioAtual(){
        return this.estagioAtual;
    }

    
    
    public static void main(String[] args) {
        Application.launch(args);

    }
    
}
