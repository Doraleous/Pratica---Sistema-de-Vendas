package com.pratica.sistemaDeVendas.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import com.pratica.sistemaDeVendas.model.Sala;
import com.pratica.sistemaDeVendas.model.dao.SalaDAO;
import com.pratica.sistemaDeVendas.view.Aplicacao;

public class SalaController {

    private SalaDAO salaDAO;
    private Aplicacao aplicacao;

    public SalaController(Aplicacao aplicacao) {
        this.aplicacao = aplicacao;
        salaDAO = new SalaDAO(this.aplicacao);
    }

    public void cadastrarSala(Sala sala) throws SQLException {
        salaDAO.cadastrarSala(sala);
    }

    public ArrayList<Sala> listarSalas() throws SQLException {
        return salaDAO.listarSalas();
    }

    public void atualizarSala(Sala sala) throws SQLException {
        salaDAO.atualizarSala(sala);
    }

    public void cadastraSala3D(Sala sala) throws SQLException{
       
        this.salaDAO.cadastrarSala(sala);
    }

    public void cadastraSalaXD(Sala sala) throws SQLException{
        this.salaDAO.cadastrarSala(sala);
    }

    public void cadastraSalaXD3D(Sala sala) throws SQLException{
        this.salaDAO.cadastrarSala(sala);
    }

    public void cadastraSalaComum(Sala sala) throws SQLException{
        this.salaDAO.cadastrarSala(sala);
    }

    public void deletarSala(Sala sala) throws SQLException {
        salaDAO.deletarSala(sala);
    }

}
