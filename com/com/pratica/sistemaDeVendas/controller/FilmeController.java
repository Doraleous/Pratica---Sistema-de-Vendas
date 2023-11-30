/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pratica.sistemadevendas.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.SQLException;
import java.util.ArrayList;

import com.pratica.sistemadevendas.model.Filme;
import com.pratica.sistemadevendas.model.dao.FilmeDAO;
import com.pratica.sistemadevendas.view.Aplicacao;

/**
 *
 * @author emart
 */
public class FilmeController {

    private FilmeDAO filmeDAO;
    private Aplicacao aplicacao;
    private AdministradorController admController;

    public FilmeController(Aplicacao aplicacao) {
        filmeDAO = new FilmeDAO();
        
        this.aplicacao = aplicacao;
        this.admController = this.aplicacao.getAdministradorController();
    }

    public ArrayList<String> verificaListaDeFilmes() throws SQLException {
        ArrayList<String> ListaVerificada = filmeDAO.filmesDisponiveisCompra();
        if (!ListaVerificada.isEmpty()) {
            return ListaVerificada;
        } else {
            return null;
        }
    }
    public void retiraFilmeDeCartaz(String tituloDoFilme) throws SQLException{
        System.out.println("passei no filme controller");
        String tituloFilme = tituloDoFilme;
        this.filmeDAO.retiraFilmeDeCartaz(tituloFilme);
        this.aplicacao.getTelaOperacoesFilmesCLUD().statusOperacao().setText("Filme retirado de cartaz");
    }

    public void deletaFilme(String titulo) throws SQLException{
        this.filmeDAO.deletarFilme(titulo);
    }

    public void cadastraFilme() throws SQLException {

        if ((this.aplicacao.getTelaOperacoesFilmesCLUD().cadastrarFilme().equals("")) ||
                (this.aplicacao.getTelaOperacoesFilmesCLUD().cadastrarFilme() == null)) {
            this.aplicacao.getTelaOperacoesFilmesCLUD().statusOperacao().setText("Título deve ser preenchido");

        } else if (this.filmeDAO.filmeExiste(this.aplicacao.getTelaOperacoesFilmesCLUD().cadastrarFilme())) {
            this.aplicacao.getTelaOperacoesFilmesCLUD().statusOperacao().setText("Filme já existe");

        } else {
            Filme novoFilme = new Filme(this.aplicacao.getTelaOperacoesFilmesCLUD().cadastrarFilme());
            this.filmeDAO.cadastrarFilme(novoFilme);
            this.aplicacao.getTelaOperacoesFilmesCLUD().statusOperacao().setText("Filme cadastrado com suceso");

        }
    }

}
