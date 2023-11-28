package com.pratica.sistemadevendas.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import com.pratica.sistemadevendas.model.Administrador;
import com.pratica.sistemadevendas.model.Usuario;
import com.pratica.sistemadevendas.model.UsuarioComum;
import com.pratica.sistemadevendas.model.util.ConexãoBanco;

public class UsuarioComumDAO {
    public String cadastrarUsuarioComum(UsuarioComum usuarioComum) throws SQLException {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        Usuario usuario = new Usuario();
        usuario.setCPF(usuarioComum.getCPF());
        usuario.setSenha(usuarioComum.getSenha());
        usuario.setEmail(usuarioComum.getEmail());
        usuario.setNome(usuarioComum.getNome());
        usuario.setDataDeNascimento(usuarioComum.getDataDeNascimento());
        usuarioDAO.cadastrarUsuario(usuario);
        long idNovoUsuario = usuarioDAO.buscarUsuario(usuarioComum.getEmail());
        String sql = "INSERT INTO cinecap.usuario_comum (id) VALUES (?)";

        try (Connection conexao = ConexãoBanco.conectar();
                PreparedStatement statement = conexao.prepareStatement(sql)) {
            statement.setLong(1, idNovoUsuario);
            return "Usuario Comum Cadastrado com Sucesso.";
        } catch (SQLException e) {
            return ("Erro ao  cadastrar Usuário Comum.");
        }
    }

    public ArrayList<UsuarioComum> listarUsuariosComuns() throws SQLException {
        ArrayList<UsuarioComum> usuariosComuns = new ArrayList<>();
        String sql = "SELECT cinecap.usuario.id, cinecap.usuario.cpf, cinecap.usuario.senha, cinecap.usuario.nome, " +
                "cinecap.usuario.email, cinecap.usuario.data_nascimento FROM cinecap.administrador inner join cinecap.usuario on"
                +
                "cinecap.usuario.id = cinecap.cinecap.usuario_comum.id";
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
                UsuarioComum usuarioComum = new UsuarioComum(cpf, senha, nome, email, dataDeNascimento);
                usuariosComuns.add(usuarioComum);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar usuários: " + e.getMessage());
        }
        return usuariosComuns;
    }

    public boolean usuarioComumExiste(String email) throws SQLException {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        boolean existe = usuarioDAO.usuarioExiste(email);
        if (existe) {
            long idUsuario = usuarioDAO.buscarUsuario(email);
            String sql = "SELECT COUNT(*) FROM cinecap.cinecap.usuario_comum WHERE id = ?";
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

    public boolean isUsuarioComum(long usuarioId) throws SQLException {
        String sql = "SELECT COUNT(*) FROM cinecap.cinecap.usuario_comum WHERE id = ?";
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

    public long buscarUsuarioComum(String email) throws SQLException {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        long idUsuario = usuarioDAO.buscarUsuario(email);
        if (idUsuario != 0l) {
            String sql = "SELECT cinecap.cinecap.usuario_comum.id FROM cinecap.cinecap.usuario_comum where id = ?";
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

    public boolean deletarUsuarioComum(String email) throws SQLException {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        boolean encontrado = usuarioDAO.usuarioExiste(email);
        if (encontrado) {
            long idAdmin = this.buscarUsuarioComum(email);
            if (idAdmin != 0l) {
                String sql = "DELETE FROM cinecap.cinecap.usuario_comum WHERE id = ?";
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
