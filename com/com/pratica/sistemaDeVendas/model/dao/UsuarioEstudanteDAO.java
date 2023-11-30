package com.pratica.sistemadevendas.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import com.pratica.sistemadevendas.model.UsuarioComum;
import com.pratica.sistemadevendas.model.UsuarioEstudante;
import com.pratica.sistemadevendas.model.util.ConexãoBanco;

public class UsuarioEstudanteDAO {
    public String cadastrarUsuarioEstudante(UsuarioEstudante usuarioEstudante) throws SQLException {
        UsuarioComumDAO usuarioComumDAO = new UsuarioComumDAO();
        UsuarioComum UsuarioComum = new UsuarioComum(
                usuarioEstudante.getCPF(),
                usuarioEstudante.getSenha(),
                usuarioEstudante.getNome(),
                usuarioEstudante.getEmail(),
                usuarioEstudante.getDataDeNascimento());
        UsuarioComumDAO.cadastrarUsuarioComum(UsuarioComum);
        long idNovoUsuario = usuarioComumDAO.buscarUsuarioComum(usuarioEstudante.getEmail());
        String sql = "INSERT INTO cinecap.usuario_estudante (id) VALUES (?)";

        try (Connection conexao = ConexãoBanco.conectar();
                PreparedStatement statement = conexao.prepareStatement(sql)) {
            statement.setLong(1, idNovoUsuario);
            statement.execute();
            return "Usuario Estudante Cadastrado com Sucesso.";
        } catch (SQLException e) {
            return ("Erro ao Cadastrar Usuário Estudante");
        }
    }

    public ArrayList<UsuarioEstudante> listarUsuariosEstudantes() throws SQLException {
        ArrayList<UsuarioEstudante> usuariosEstudantes = new ArrayList<>();
        String sql = "SELECT cinecap.usuario.id, cinecap.usuario.cpf, cinecap.usuario.senha, cinecap.usuario.nome, " +
                "cinecap.usuario.email, cinecap.usuario.data_nascimento FROM cinecap.usuario_estudante inner join cinecap.usuario on"
                +
                "cinecap.usuario.id = cinecap.usuario_estudante.id";
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
                UsuarioEstudante usuarioEstudante = new UsuarioEstudante(cpf, senha, nome, email, dataDeNascimento);
                usuariosEstudantes.add(usuarioEstudante);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar usuários: " + e.getMessage());
        }
        return usuariosEstudantes;
    }

    public boolean usuarioEstudanteExiste(String email) throws SQLException {
        UsuarioComumDAO usuarioComumDAO = new UsuarioComumDAO();
        boolean existe = usuarioComumDAO.usuarioComumExiste(email);
        if (existe) {
            long idUsuario = usuarioComumDAO.buscarUsuarioComum(email);
            String sql = "SELECT COUNT(*) FROM cinecap.usuario_estudante WHERE id = ?";
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

    public boolean isUsuarioEstudante(Long usuarioId) throws SQLException {
        String sql = "SELECT COUNT(*) FROM cinecap.usuario_estudante WHERE id = ?";
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

    public Long buscarUsuarioEstudante(String email) throws SQLException {
        UsuarioComumDAO usuarioComumDAO = new UsuarioComumDAO();
        long idUsuario = usuarioComumDAO.buscarUsuarioComum(email);
        if (idUsuario != 0l) {
            String sql = "SELECT cinecap.usuario_estudante.id FROM cinecap.usuario_estudante WHERE id = ?";
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
        return 0L;
    }

    public boolean deletarUSuarioEstudante(String email) throws SQLException {
        UsuarioComumDAO usuarioComumDAO = new UsuarioComumDAO();
        boolean encontrado = usuarioComumDAO.usuarioComumExiste(email);
        if (encontrado) {
            Long idAdmin = this.buscarUsuarioEstudante(email);
            if (idAdmin != 01) {
                String sql = "DELETE FROM cinecap.usuario_estudante WHERE id = ?";
                try (Connection conexao = ConexãoBanco.conectar();
                        PreparedStatement statement = conexao.prepareStatement(sql)) {
                    statement.setLong(1, idAdmin);
                    int linhasAfetadas = statement.executeUpdate();
                    if (linhasAfetadas > 0) {
                        usuarioComumDAO.deletarUsuarioComum(email);
                    }
                    return linhasAfetadas > 0;
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return false;
    }
}
