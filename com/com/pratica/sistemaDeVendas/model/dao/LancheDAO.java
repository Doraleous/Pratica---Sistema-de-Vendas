package com.pratica.sistemadevendas.model.dao;

import java.sql.*;
import java.util.ArrayList;

import com.pratica.sistemadevendas.model.Lanche;

import com.pratica.sistemadevendas.model.util.ConexãoBanco;

public class LancheDAO {
    private final String URL = "jdbc:mysql://seu_servidor:porta/seu_banco";
    private final String USUARIO = "seu_usuario";
    private final String SENHA = "sua_senha";

    public String cadastrarLanche(Lanche lanche) {
        try (Connection conexao = ConexãoBanco.conectar()) {
            String sql = "INSERT INTO lanche (nome, preco) VALUES (?, ?)";
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
        try (Connection connection = DriverManager.getConnection(URL, USUARIO, SENHA)) {
            String query = "SELECT * FROM lanche";
            try (Statement statement = connection.createStatement();
                    ResultSet resultSet = statement.executeQuery(query)) {
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
        try (Connection connection = DriverManager.getConnection(URL, USUARIO, SENHA)) {
            String query = "UPDATE lanche SET preco = ? WHERE nome = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
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
        try (Connection connection = DriverManager.getConnection(URL, USUARIO, SENHA)) {
            String query = "SELECT * FROM lanche WHERE nome = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
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
        try (Connection connection = DriverManager.getConnection(URL, USUARIO, SENHA)) {
            String query = "SELECT id FROM lanche WHERE nome = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
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
        try (Connection connection = DriverManager.getConnection(URL, USUARIO, SENHA)) {
            String query = "DELETE FROM lanche WHERE nome = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
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
