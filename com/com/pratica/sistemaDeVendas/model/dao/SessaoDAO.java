package com.pratica.sistemadevendas.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import com.pratica.sistemadevendas.model.Filme;
import com.pratica.sistemadevendas.model.Sala;
import com.pratica.sistemadevendas.model.Sessao;
import com.pratica.sistemadevendas.model.util.ConexãoBanco;

public class SessaoDAO {

    public String cadastrarSessao(Sessao sessao) throws SQLException {
        String sql = "INSERT INTO cinecap.sessao (sala_id, filme_id, data_inicio) VALUES (?, ?, ?)";
        try (Connection conexao = ConexãoBanco.conectar();
                PreparedStatement statement = conexao.prepareStatement(sql)) {
            statement.setLong(1, sessao.getSala().getId());
            statement.setLong(2, sessao.getFilme().getId());
            statement.setDate(3, new java.sql.Date(sessao.getDataInicio().getTime()));
            statement.execute();
            return "Sessão cadastrada com Sucesso";
        } catch (SQLException e) {
            e.printStackTrace();
            return "Erro ao cadastrar a sessão";
        }
    }

    public ArrayList<Sessao> listarSessoesDisponiveis() throws SQLException {
        ArrayList<Sessao> listaDeSessoes = new ArrayList<>();

        String sql = "select cinecap.sessao.id, cinecap.sessao.sala_id, cinecap.sessao.filme_id from cinecap.sessao inner join cinecap.filme on cinecap.filme.id = cinecap.sessao.filme_id where cinecap.filme.em_cartaz = true AND cinecap.sessao.data_inicio >= now()";

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

    public static void main(String[] args) throws SQLException {
        SessaoDAO sessaoDAO = new SessaoDAO();
        ArrayList<Sessao> sessoes = sessaoDAO.listarSessoesDisponiveis();
        for (Sessao sessao : sessoes) {
            System.out.println(sessao);
        }
    }

}
