package com.pratica.sistemadevendas.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.pratica.sistemadevendas.model.Sala;
import com.pratica.sistemadevendas.model.util.ConexãoBanco;

public class SalaDAO {

    public void cadastrarSala(Sala sala) throws SQLException {
        String sql = "INSERT INTO cinecap.sala (nome, tipo_sala) VALUES (?, ?)"; //nome dos campos esta certo?
        try (Connection conexao = ConexãoBanco.conectar();
                PreparedStatement statement = conexao.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, sala.getNomeSala());
            statement.setString(2, sala.getTipoSala());
            statement.executeUpdate();

            ResultSet generatedKeys = statement.getGeneratedKeys();
            if (generatedKeys.next()) {
                sala.setId(generatedKeys.getLong(1));
            }
        }
    }

    public List<String> listarSalas() throws SQLException {
        List<String> listaDeSalas = new ArrayList<>();

        String sql = "SELECT id, nome, tipo_sala FROM cinecap.sala";

        try (Connection conexao = ConexãoBanco.conectar();
                PreparedStatement statement = conexao.prepareStatement(sql)) {
            ResultSet resultado = statement.executeQuery();
            while (resultado.next()) {
                Long id = resultado.getLong("id");
                String nomeSala = resultado.getString("nome_sala");
                String tipoSala = resultado.getString("tipo_sala");
                String infoSala = "ID: " + id + ", Nome: " + nomeSala + ", Tipo: " + tipoSala;
                listaDeSalas.add(infoSala);
            }
        }
        return listaDeSalas;
    }

    public void atualizarSala(Sala sala) throws SQLException {
        String sql = "UPDATE cinecap.sala SET nome = ?, tipo_sala = ? WHERE id = ?";
        try (Connection conexao = ConexãoBanco.conectar();
                PreparedStatement statement = conexao.prepareStatement(sql)) {
            statement.setString(1, sala.getNomeSala());
            statement.setString(2, sala.getTipoSala());
            statement.setLong(3, sala.getId());
            statement.executeUpdate();
        }
    }

    public void deletarSala(Long id) throws SQLException {
        String sql = "DELETE FROM cinecap.sala WHERE id = ?";
        try (Connection conexao = ConexãoBanco.conectar();
                PreparedStatement statement = conexao.prepareStatement(sql)) {
            statement.setLong(1, id);
            statement.executeUpdate();
        }
    }

    // Adicione outros métodos conforme necessário
}
