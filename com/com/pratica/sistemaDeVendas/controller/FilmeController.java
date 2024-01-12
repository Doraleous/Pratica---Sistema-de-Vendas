/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pratica.sistemaDeVendas.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import com.pratica.sistemaDeVendas.model.Filme;
import com.pratica.sistemaDeVendas.model.dao.FilmeDAO;
import com.pratica.sistemaDeVendas.view.Aplicacao;

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

    public ArrayList<Filme> verificaListaDeFilmes() throws SQLException {
        ArrayList<Filme> ListaVerificada = filmeDAO.filmesParaComprar();
        if (!ListaVerificada.isEmpty()) {
            return ListaVerificada;
        } else {
            return null;
        }
    }

    public void retiraFilmeDeCartaz(String tituloDoFilme) throws SQLException {
        System.out.println("passei no filme controller");
        String tituloFilme = tituloDoFilme;
        this.filmeDAO.retiraFilmeDeCartaz(tituloFilme);
        this.aplicacao.getTelaOperacoesFilmesCLUD().statusOperacao().setText("Filme retirado de cartaz");
    }

    public void deletaFilme(String titulo) throws SQLException {
        this.filmeDAO.deletarFilme(titulo);
    }

    public void cadastraFilme() throws SQLException {

        if ((this.aplicacao.getTelaOperacoesFilmesCLUD().cadastrarFilme().equals("")) ||
                (this.aplicacao.getTelaOperacoesFilmesCLUD().cadastrarFilme() == null)) {
            this.aplicacao.getTelaOperacoesFilmesCLUD().statusOperacao().setText("Título deve ser preenchido");

        } else if (this.filmeDAO.filmeExiste(this.aplicacao.getTelaOperacoesFilmesCLUD().cadastrarFilme())) {
            this.aplicacao.getTelaOperacoesFilmesCLUD().statusOperacao().setText("Filme já existe");

        } else {
            Filme novoFilme = new Filme(0l, this.aplicacao.getTelaOperacoesFilmesCLUD().cadastrarFilme());
            this.filmeDAO.cadastrarFilme(novoFilme);
            this.aplicacao.getTelaOperacoesFilmesCLUD().statusOperacao().setText("Filme cadastrado com suceso");

        }
    }

}
