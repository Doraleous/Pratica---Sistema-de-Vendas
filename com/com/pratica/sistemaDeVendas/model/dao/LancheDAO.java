package com.pratica.sistemadevendas.model.dao;

import java.sql.*;
import java.util.ArrayList;

import com.pratica.sistemadevendas.model.Lanche;

import com.pratica.sistemadevendas.model.util.ConexãoBanco;

public class LancheDAO {

    public String cadastrarLanche(Lanche lanche) {
        try (Connection conexao = ConexãoBanco.conectar()) {
            String sql = "INSERT INTO cinecap.lanche (nome, preco) VALUES (?, ?)";
            try (PreparedStatement preparedStatement = conexao.prepareStatement(sql)) {
                preparedStatement.setString(1, lanche.getNome());
                preparedStatement.setDouble(2, lanche.getPreco());
                preparedStatement.executeUpdate();
                return "Lanche cadastrado com sucesso!";
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return "Erro ao cadastrar o lanche.";
        }
    }

    public ArrayList<Lanche> listarLanches() {
        ArrayList<Lanche> lanches = new ArrayList<>();
        try (Connection conexao = ConexãoBanco.conectar()) {
            String sql = "SELECT * FROM cinecap.lanche";
            try (Statement statement = conexao.createStatement();
                    ResultSet resultSet = statement.executeQuery(sql)) {
                while (resultSet.next()) {
                    String nome = resultSet.getString("nome");
                    double preco = resultSet.getDouble("preco");
                    Lanche lanche = new Lanche(nome, preco);
                    lanches.add(lanche);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lanches;
    }

    public boolean atualizarLanche(String nome, double preco) {
        try (Connection conexao = ConexãoBanco.conectar()) {
            String sql = "UPDATE cinecap.lanche SET preco = ? WHERE nome = ?";
            try (PreparedStatement preparedStatement = conexao.prepareStatement(sql)) {
                preparedStatement.setDouble(1, preco);
                preparedStatement.setString(2, nome);
                int rowsAffected = preparedStatement.executeUpdate();
                return rowsAffected > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean lancheExiste(String nome) {
        try (Connection conexao = ConexãoBanco.conectar()) {
            String sql = "SELECT * FROM cinecap.lanche WHERE nome = ?";
            try (PreparedStatement preparedStatement = conexao.prepareStatement(sql)) {
                preparedStatement.setString(1, nome);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    return resultSet.next();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public long buscarLanche(String nome) {
        try (Connection conexao = ConexãoBanco.conectar()) {
            String sql = "SELECT id FROM cinecap.lanche WHERE nome = ?";
            try (PreparedStatement preparedStatement = conexao.prepareStatement(sql)) {
                preparedStatement.setString(1, nome);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    return resultSet.next() ? resultSet.getLong("id") : -1;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public boolean deletarLanche(String nome) {
        try (Connection conexao = ConexãoBanco.conectar()) {
            String sql = "DELETE FROM cinecap.lanche WHERE nome = ?";
            try (PreparedStatement preparedStatement = conexao.prepareStatement(sql)) {
                preparedStatement.setString(1, nome);
                int rowsAffected = preparedStatement.executeUpdate();
                return rowsAffected > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

}
