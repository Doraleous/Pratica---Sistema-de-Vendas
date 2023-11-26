package com.pratica.sistemaDeVendas.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import com.pratica.sistemaDeVendas.model.Usuario;
import com.pratica.sistemaDeVendas.model.util.ConexãoBanco;

public class UsuarioDAO {
    public String cadastrarUsuario(Usuario usuario) throws SQLException {
        String sql = "INSERT INTO cinecap.usuario (cpf, senha, email, nome, data_nascimento)VALUES ( ?, ?, ?, ?, ?)";

        try (Connection conexao = ConexãoBanco.conectar();
                PreparedStatement statement = conexao.prepareStatement(sql)) {
            statement.setString(1, usuario.getCPF());
            statement.setString(2, usuario.getSenha());
            statement.setString(3, usuario.getEmail());
            statement.setString(4, usuario.getNome());
            java.sql.Date dataNascimento = (java.sql.Date) usuario.getDataDeNascimento();
            statement.setDate(5, dataNascimento);
            return "usuario Cadastrado com sucesso.";
        } catch (SQLException e) {
            // Lidar com exceções, logar ou tratar de alguma forma
            e.printStackTrace();
            return "Erro ao cadastrar o usuário.";
        }
    }

    public ArrayList<Usuario> listarUsuario() throws SQLException {
        ArrayList<Usuario> usuarios = new ArrayList<>();
        String sql = "SELECT * FROM cinecap.usuario";
        try (Connection conexao = ConexãoBanco.conectar();
                PreparedStatement statement = conexao.prepareStatement(sql);
                ResultSet resultado = statement.executeQuery()) {
            while (resultado.next()) {
                Usuario usuario = new Usuario();
                usuario.setId(resultado.getLong("id"));
                usuario.setCPF(resultado.getString("cpf"));
                usuario.setNome(resultado.getString("nome"));
                usuario.setEmail(resultado.getString("email"));
                usuario.setSenha(resultado.getString("senha"));
                usuario.setDataDeNascimento((java.util.Date) resultado.getDate("data_nascimento"));
                usuarios.add(usuario);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar usuários: " + e.getMessage());
        }
        return usuarios;
    }

    public boolean atualizarUsuario(String cpf,
            String nome,
            Date dataDeNascimento,
            String email,
            String senha) throws SQLException {
        long encontrado = this.buscarUsuario(email);
        if (encontrado != 0l) {
            String sql = "update cinecap.usuario set " +
                    "cinecap.usuario.cpf = ?, " +
                    "cinecap.usuario.senha = ?, " +
                    "cinecap.usuario.nome = ?, " +
                    "cinecap.usuario.email = ?, " +
                    "cinecap.usuario.data_nascimento = ? " +
                    "where id = ?";

            try (Connection conexao = ConexãoBanco.conectar();
                    PreparedStatement statement = conexao.prepareStatement(sql)) {
                statement.setString(1, cpf);
                statement.setString(2, senha);
                statement.setString(3, nome);
                statement.setString(4, email);

                if (dataDeNascimento != null) {
                    java.sql.Date dataNascimento = (java.sql.Date) dataDeNascimento;
                    statement.setDate(5, dataNascimento);
                } else {
                    statement.setNull(5, java.sql.Types.DATE);
                }

                statement.setLong(6, encontrado);

                int linhasAfetadas = statement.executeUpdate();

                return linhasAfetadas > 0;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public boolean usuarioExiste(String email) {
        String sql = "SELECT COUNT(*) FROM cinecap.usuario WHERE email = ?";
        try (Connection conexao = ConexãoBanco.conectar();
                PreparedStatement statement = conexao.prepareStatement(sql)) {
            statement.setString(1, email);

            try (ResultSet resultado = statement.executeQuery()) {
                if (resultado.next()) {
                    int count = resultado.getInt(1);
                    return count > 0;
                }
            }
        } catch (SQLException e) {
            // Lidar com exceções, se necessário
            e.printStackTrace();
        }
        return false;
    }

    public long buscarUsuario(String email) throws SQLException {
        String sql = "SELECT cinecap.usuario.id FROM cinecap.usuario where email = ?";
        try (Connection conexao = ConexãoBanco.conectar();
                PreparedStatement statement = conexao.prepareStatement(sql);) {
            statement.setString(1, email);
            try (ResultSet resultado = statement.executeQuery()) {
                if (resultado.next()) {
                    long id = resultado.getLong(1);
                    return id;
                }
            }
        }
        return 0l;
    }

    public boolean deletarUsuario(String email) {
        boolean encontrado = this.usuarioExiste(email);
        if (encontrado) {
            String sql = "DELETE FROM cinecap.usuario WHERE email = ?";
            try (Connection conexao = ConexãoBanco.conectar();
                    PreparedStatement statement = conexao.prepareStatement(sql)) {
                statement.setString(1, email);
                int linhasAfetadas = statement.executeUpdate();
                return linhasAfetadas > 0;
            } catch (SQLException e) {
                // Lidar com exceções, logar ou tratar de alguma forma
                e.printStackTrace();
            }
        }
        return false;
    }

}
