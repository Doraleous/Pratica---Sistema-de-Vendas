package com.pratica.sistemadevendas.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import com.pratica.sistemadevendas.model.Administrador;
import com.pratica.sistemadevendas.model.Usuario;
import com.pratica.sistemadevendas.model.util.ConexãoBanco;

public class AdministradorDAO {
    public String cadastrarAdministrador(Administrador administrador) throws SQLException {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        Usuario usuario = new Usuario();
        usuario.setCPF(administrador.getCPF());
        usuario.setSenha(administrador.getSenha());
        usuario.setEmail(administrador.getEmail());
        usuario.setNome(administrador.getNome());
        usuario.setDataDeNascimento(administrador.getDataDeNascimento());
        usuarioDAO.cadastrarUsuario(usuario);
        long idNovoUsuario = usuarioDAO.buscarUsuario(administrador.getEmail());
        String sql = "INSERT INTO cinecap.administrador (id) VALUES (?)";

        try (Connection conexao = ConexãoBanco.conectar();
                PreparedStatement statement = conexao.prepareStatement(sql)) {
            statement.setLong(1, idNovoUsuario);
            statement.execute();
            return "Usuario Administrador Cadastrado com sucesso.";
        } catch (SQLException e) {
            return ("Erro ao cadastrar Usuário Administrador");
        }
    }

    public ArrayList<Administrador> listarAdministradores() throws SQLException {
        ArrayList<Administrador> administradores = new ArrayList<>();

        String sql = "SELECT cinecap.usuario.id, cinecap.usuario.cpf, cinecap.usuario.senha, cinecap.usuario.nome, " +
                "cinecap.usuario.email, cinecap.usuario.data_nascimento FROM cinecap.administrador inner join cinecap.usuario on"
                +
                "cinecap.usuario.id = cinecap.administrador.id";
        try (Connection conexao = ConexãoBanco.conectar();
                PreparedStatement statement = conexao.prepareStatement(sql);
                ResultSet resultado = statement.executeQuery()) {
            while (resultado.next()) {
                long id = resultado.getLong("id");
                String cpf = resultado.getString("cpf");
                String nome = resultado.getString("nome");
                String email = resultado.getString("email");
                String senha = resultado.getString("senha");
                Date dataDeNascimento = (java.util.Date) resultado.getDate("data_nascimento");
                Administrador administrador = new Administrador(cpf, senha, nome, email, dataDeNascimento);
                administradores.add(administrador);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar usuários: " + e.getMessage());
        }
        return administradores;
    }

    public boolean atualizarAdministrador(String cpf,
            String nome,
            Date dataDeNascimento,
            String email,
            String senha) throws SQLException {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        long encontrado = usuarioDAO.buscarUsuario(email);
        if (encontrado != 0l) {
            usuarioDAO.atualizarUsuario(cpf, nome, dataDeNascimento, email, senha);
            return true;
        }
        return false;
    }

    public boolean administradorExiste(String email) throws SQLException {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        boolean existe = usuarioDAO.usuarioExiste(email);
        if (existe) {
            long idUsuario = usuarioDAO.buscarUsuario(email);
            String sql = "SELECT COUNT(*) FROM cinecap.administrador WHERE id = ?";
            try (Connection conexao = ConexãoBanco.conectar();
                    PreparedStatement statement = conexao.prepareStatement(sql)) {
                statement.setLong(1, idUsuario);

                try (ResultSet resultado = statement.executeQuery()) {
                    if (resultado.next()) {
                        int count = resultado.getInt(1);
                        return count > 0;
                    }
                }
            } catch (SQLException e) {
                // Lidar com exceções, logar ou tratar de alguma forma
                e.printStackTrace();
            }
        }
        return false;
    }

    public boolean isAdministrador(long usuarioId) throws SQLException {
        String sql = "SELECT COUNT(*) FROM cinecap.administrador WHERE id = ?";
        try (Connection conexao = ConexãoBanco.conectar();
                PreparedStatement statement = conexao.prepareStatement(sql)) {
            statement.setLong(1, usuarioId);
            try (ResultSet resultado = statement.executeQuery()) {
                if (resultado.next()) {
                    int count = resultado.getInt(1);
                    return count > 0;
                }
            } catch (SQLException e) {
                // Lidar com exceções, logar ou tratar de alguma forma
                e.printStackTrace();
            }
        }
        return false;
    }

    public long buscarAdministrador(String email) throws SQLException {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        long idUsuario = usuarioDAO.buscarUsuario(email);
        if (idUsuario != 0l) {
            String sql = "SELECT cinecap.administrador.id FROM cinecap.administrador where id = ?";
            try (Connection conexao = ConexãoBanco.conectar();
                    PreparedStatement statement = conexao.prepareStatement(sql)) {
                statement.setLong(1, idUsuario);
                try (ResultSet resultado = statement.executeQuery()) {
                    if (resultado.next()) {
                        long id = resultado.getLong(1);
                        return id;
                    }
                }
            }
        }
        return 0l;
    }

    public boolean deletarAdministrador(String email) throws SQLException {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        boolean encontrado = usuarioDAO.usuarioExiste(email);
        if (encontrado) {
            long idAdmin = this.buscarAdministrador(email);
            if (idAdmin != 0l) {
                String sql = "DELETE FROM cinecap.administrador WHERE id = ?";
                try (Connection conexao = ConexãoBanco.conectar();
                        PreparedStatement statement = conexao.prepareStatement(sql)) {
                    statement.setLong(1, idAdmin);
                    int linhasAfetadas = statement.executeUpdate();
                    if (linhasAfetadas > 1) {
                        usuarioDAO.deletarUsuario(email);
                    }
                    return linhasAfetadas > 0;
                } catch (SQLException e) {
                    // Lidar com exceções, logar ou tratar de alguma forma
                    e.printStackTrace();
                }
            }
        }
        return false;
    }
}
