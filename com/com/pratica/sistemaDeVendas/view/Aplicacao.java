/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pratica.sistemaDeVendas.view;

import java.io.IOException;

import com.pratica.sistemaDeVendas.controller.UsuarioController;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Aplicacao extends Application {
    private Stage estagioAtual;
    private TelaAdministrador telaAdministrador; 
    private TelaLogin telaLogin; 
    private TelaOperacoesUsuario telaOperacoesUsuario2; 
    private UsuarioController usuarioController;

    public static void main(String[] args) {
        Application.launch(args);

    }
    
    
    public void start(Stage estagioPrimario) throws IOException {
        //this.estagioAtual = estagioPrimario;
        estagioAtual = new Stage();
        estagioAtual.initStyle(StageStyle.UNDECORATED);
        estagioAtual.setTitle("Cinecap - Logar Usuário");
        estagioAtual.setWidth(700);
        estagioAtual.setHeight(700);
        usuarioController = new UsuarioController();
        telaAdministrador = new TelaAdministrador(this, usuarioController);
        telaLogin = new TelaLogin(this, usuarioController);
        telaOperacoesUsuario2 = new TelaOperacoesUsuario(this);
        
        
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
    
    public void mudaCena(Scene novaCena){
        this.estagioAtual.setScene(novaCena);
        this.estagioAtual.show();
        
    }
    
    public Stage estagioAtual(){
        return this.estagioAtual;
    }
    
    
    
    

    /**
     * @return Stage return the estagioAtual
     */
    public Stage getEstagioAtual() {
        return estagioAtual;
    }

    /**
     * @param estagioAtual the estagioAtual to set
     */
    public void setEstagioAtual(Stage estagioAtual) {
        this.estagioAtual = estagioAtual;
    }

    /**
     * @param telaAdministrador the telaAdministrador to set
     */
    public void setTelaAdministrador(TelaAdministrador telaAdministrador) {
        this.telaAdministrador = telaAdministrador;
    }

    /**
     * @param telaLogin the telaLogin to set
     */
    public void setTelaLogin(TelaLogin telaLogin) {
        this.telaLogin = telaLogin;
    }

    /**
     * @return TelaOperacoesUsuario return the telaOperacoesUsuario2
     */
    public TelaOperacoesUsuario getTelaOperacoesUsuario2() {
        return telaOperacoesUsuario2;
    }

    /**
     * @param telaOperacoesUsuario2 the telaOperacoesUsuario2 to set
     */
    public void setTelaOperacoesUsuario2(TelaOperacoesUsuario telaOperacoesUsuario2) {
        this.telaOperacoesUsuario2 = telaOperacoesUsuario2;
    }

    /**
     * @return UsuarioController return the usuarioController
     */
    public UsuarioController getUsuarioController() {
        return usuarioController;
    }

}
