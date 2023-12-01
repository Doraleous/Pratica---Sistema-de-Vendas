package com.pratica.sistemadevendas.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import com.pratica.sistemadevendas.controller.SessaoController;
import com.pratica.sistemadevendas.model.Filme;
import com.pratica.sistemadevendas.model.Sala;
import com.pratica.sistemadevendas.model.Sessao;
import com.pratica.sistemadevendas.model.util.ConexãoBanco;
import com.pratica.sistemadevendas.view.Aplicacao;

public class SessaoDAO {
    private Aplicacao aplicacao;

    public SessaoController sessaoController;

    public SessaoDAO(Aplicacao aplicacao) {
        this.aplicacao = aplicacao;
    }

    public void cadastrarSessao() throws SQLException {
        SalaDAO salaDAO = new SalaDAO(this.aplicacao);
        FilmeDAO filmeDAO = new FilmeDAO();
        Long idSala = salaDAO.buscarSala(this.aplicacao.getTelaOperacoesSessao().getTextFieldSala().getText());
        Long idFilme = filmeDAO.buscarFilme(this.aplicacao.getTelaOperacoesSessao().getFilmeTextField().getText());

        String sql = "INSERT INTO cinecap.sessao (sala_id, filme_id) VALUES (?, ?)";
        try (Connection conexao = ConexãoBanco.conectar();
                PreparedStatement statement = conexao.prepareStatement(sql);) {
            statement.setLong(1, idSala);
            statement.setLong(2, idFilme);
            statement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public ArrayList<Sessao> listarSessoesDisponiveis() throws SQLException {
        ArrayList<Sessao> listaDeSessoes = new ArrayList<>();

        String sql = "select cinecap.sessao.id, cinecap.sessao.sala_id, cinecap.sessao.filme_id from cinecap.sessao inner join cinecap.filme on cinecap.filme.id = cinecap.sessao.filme_id where cinecap.filme.em_cartaz = true AND (cinecap.sessao.data_inicio >= now() OR cinecap.sessao.data_inicio is null)";

        try (Connection conexao = ConexãoBanco.conectar();
                PreparedStatement statement = conexao.prepareStatement(sql);
                ResultSet resultado = statement.executeQuery()) {

            while (resultado.next()) {
                Sessao sessao = new Sessao();
                Sala sala = new Sala();
                Filme filme = new Filme();
                sala.setId(resultado.getLong(2));
                filme.setId(resultado.getLong(3));
                sessao.setId(resultado.getLong(1));
                sessao.setSala(sala);
                sessao.setFilme(filme);
                listaDeSessoes.add(sessao);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaDeSessoes;
    }

    public Boolean atualizarSessao(Sessao sessao) {
        return false;
    }

    public boolean deletarSessao(Sessao sessao) {
        return false;
    }

}
