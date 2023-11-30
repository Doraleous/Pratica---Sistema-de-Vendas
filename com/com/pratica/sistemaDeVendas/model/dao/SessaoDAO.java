package com.pratica.sistemadevendas.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import com.pratica.sistemadevendas.model.Filme;
import com.pratica.sistemadevendas.model.Sessao;
import com.pratica.sistemadevendas.model.util.ConexaoBanco;

public class SessaoDAO {

    public String cadastrarSessao(Sessao sessao) throws SQLException {
        String sql = "INSERT INTO cinecap.sessao (data_inicio, id_filme) VALUES (?, ?)";
        try (Connection conexao = ConexaoBanco.conectar();
                PreparedStatement statement = conexao.prepareStatement(sql)) {
            statement.setTimestamp(1, new java.sql.Timestamp(sessao.getDataInicio().getTime()));
            statement.setLong(2, sessao.getFilmeEmCartaz().getId());
            statement.executeUpdate();
            return "Sessão cadastrada com Sucesso";
        } catch (SQLException e) {
            e.printStackTrace();
            return "Erro ao cadastrar a sessão";
        }
    }

    public ArrayList<String> listarSessoesDisponiveis() throws SQLException {
        ArrayList<String> listaDeSessoes = new ArrayList<>();

        String sql = "SELECT cinecap.sessao.data_inicio, cinecap.filme.titulo " +
                     "FROM cinecap.sessao INNER JOIN cinecap.filme " +
                     "ON cinecap.sessao.id_filme = cinecap.filme.id";

        try (Connection conexao = ConexaoBanco.conectar();
                PreparedStatement statement = conexao.prepareStatement(sql)) {
            ResultSet resultado = statement.executeQuery();
            while (resultado.next()) {
                Date dataInicio = resultado.getTimestamp("data_inicio");
                String tituloFilme = resultado.getString("titulo");
                String infoSessao = "Data: " + dataInicio + ", Filme: " + tituloFilme;
                listaDeSessoes.add(infoSessao);
            }
        }
        return listaDeSessoes;
    }

}

