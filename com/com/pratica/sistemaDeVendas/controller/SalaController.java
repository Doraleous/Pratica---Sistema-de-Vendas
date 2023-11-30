package com.pratica.sistemadevendas.controller;

import com.pratica.sistemadevendas.model.Sala;
import com.pratica.sistemadevendas.model.dao.SalaDAO;

import java.sql.SQLException;
import java.util.List;

public class SalaController {

    private SalaDAO salaDAO;

    public SalaController() {
        salaDAO = new SalaDAO();
    }

    public void cadastrarSala(Sala sala) throws SQLException {
        salaDAO.cadastrarSala(sala);
    }

    public List<String> listarSalas() throws SQLException {
        return salaDAO.listarSalas();
    }

    public void atualizarSala(Sala sala) throws SQLException {
        salaDAO.atualizarSala(sala);
    }

    public void deletarSala(Long id) throws SQLException {
        salaDAO.deletarSala(id);
    }

}
