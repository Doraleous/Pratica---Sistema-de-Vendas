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
    
    public void start(Stage estagioPrimario) throws IOException {
        this.estagioAtual = estagioPrimario;
        estagioAtual.initStyle(StageStyle.UNDECORATED);
        estagioAtual.setTitle("Cinecap - Logar Usuário");
        TelaLogin cenaLogin = new TelaLogin(this);
        
        
        estagioAtual.setScene(cenaLogin.telaLogin());
        estagioAtual.show();
        
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
