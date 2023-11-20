package com.pratica.sistemaDeVendas.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;

public class UsuarioDAO {
    public String cadastrarUsuario(Usuario usuario) throws SQLException{
        String sql = "INSERT INTO cinecap.usuario (cpf, senha, email, nome, data_nascimento)VALUES ( ?, ?, ?, ?, ?)";

        try (Connection conexao = ConexãoBanco.conectar();
        PreparedStatement statement = conexao.prepareStatement(sql)){
            statement.setString(1, usuario.getCPF());
            statement.setString(2, usuario.getSenha());
            statement.setString(3, usuario.getEmail());
            statement.setString(4, usuario.getNome());
            Date dataNascimento = (Date) usuario.getDataDeNascimento();
            statement.setDate(5, dataNascimento);
            return "usuario Cadastrado com sucesso.";
        } catch (SQLException e){
            return("Erro ao cadastrar Usuário");
        }
    }

    public ArrayList<Usuario> buscarUsuarios(Usuario usuario) throws SQLException{
        ArrayList<Usuario> usuarios = new ArrayList<>();
        String sql = "SELECT * FROM cinecap.usuario";
        try(Connection conexao = ConexãoBanco.conectar();
        PreparedStatement statement = conexao.prepareStatement(sql);
        ResultSet resultado = statement.executeQuery()){
            while (resultado.next()){
                usuario.setId(resultado.getLong("id"));
            }
        }
        return null;
    }

    public ArrayList<Usuario> listarUsuario() throws SQLException{
        ArrayList<Usuario> usuarios = new ArrayList<>();
        String sql = "SELECT * FROM cinecap.usuario";
        try(Connection conexao = ConexãoBanco.conectar();
        PreparedStatement statement = conexao.prepareStatement(sql);
        ResultSet resultado = statement.executeQuery()){
            while (resultado.next()){
                Usuario usuario = new Usuario();
                usuario.setId(resultado.getLong("id"));
                usuario.setCPF(resultado.getString("cpf"));
                usuario.setNome(resultado.getString("nome"));
                usuario.setEmail(resultado.getString("email"));
                usuario.setSenha(resultado.getString("senha"));
                usuario.setDataDeNascimento((java.util.Date)resultado.getDate("data_nascimento"));
                usuarios.add(usuario);
            }
        } catch (SQLException e){
            System.out.println("Erro ao listar usuários: " + e.getMessage());
        }
        return usuarios;
    }
}
