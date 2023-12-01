package com.pratica.sistemadevendas.controller;

import com.pratica.sistemadevendas.model.Sala;
import com.pratica.sistemadevendas.model.dao.SalaDAO;
import com.pratica.sistemadevendas.view.Aplicacao;

import java.lang.reflect.Array;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SalaController {

    private SalaDAO salaDAO;
    private Aplicacao aplicacao;

    public SalaController(Aplicacao aplicacao) {
        this.aplicacao = aplicacao;
        salaDAO = new SalaDAO();
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
