package com.pratica.sistemadevendas.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.pratica.sistemadevendas.model.Filme;
import com.pratica.sistemadevendas.model.util.ConexãoBanco;

public class FilmeDAO {

    public String cadastrarFilme(Filme filme) throws SQLException {
        String sql = "INSERT INTO cinecap.filme (titulo) VALUES (?)";
        try (Connection conexao = ConexãoBanco.conectar();
                PreparedStatement statement = conexao.prepareStatement(sql)) {
            statement.setString(1, filme.getTitulo());
            statement.executeUpdate();
            return "Filme cadastrado com Sucesso";
        } catch (SQLException e) {
            e.printStackTrace();
            return "Erro ao cadastrar o filme";
        }
    }

    public ArrayList<String> filmesDisponiveisCompra() throws SQLException {
        ArrayList<String> listaDeFilmes = new ArrayList<>();

        String sql = "SELECT cinecap.filme.titulo FROM cinecap.filme WHERE cinecap.filme.em_cartaz = true";

        try (Connection conexao = ConexãoBanco.conectar();
                PreparedStatement statement = conexao.prepareStatement(sql)) {
            ResultSet resultado = statement.executeQuery();
            while (resultado.next()) {
                listaDeFilmes.add(resultado.getString(1));
            }

        }
        return listaDeFilmes;
    }

    

    public String retiraFilmeDeCartaz(String titulo) throws SQLException{
        String sql = "UPDATE cinecap.filme SET em_cartaz = false WHERE cinecap.filme.titulo = (?)";
        System.out.println("filmedao 1");
        try(Connection conexao = ConexãoBanco.conectar();
            PreparedStatement statement = conexao.prepareStatement(sql);){
            statement.setString(1, titulo);
            statement.executeUpdate();
            System.out.println("filmedao 2");
            return "Filme retirado de cartaz";
            
        }catch (SQLException E){
            E.printStackTrace();

        }
        return null;
            
    }

    public boolean atualizarFilme(String titulo) throws SQLException {
        long encontrado = this.buscarFilme(titulo);
        if (encontrado != 0l) {
            String sql = "update cinepa.filme set  cinecap.filme.titulo = ?";
            try (Connection conexao = ConexãoBanco.conectar();
                    PreparedStatement statement = conexao.prepareStatement(sql)) {
                statement.setString(1, titulo);
                int linhasAfetadas = statement.executeUpdate();

                return linhasAfetadas > 0;
            }
        }
        return false;
    }

    public boolean filmeExiste(String titulo) throws SQLException {
        String sql = "SELECT COUNT(*) FROM cinecap.filme WHERE titulo =?";
        try (Connection conexao = ConexãoBanco.conectar();
                PreparedStatement statement = conexao.prepareStatement(sql)) {
            statement.setString(1, titulo);

            try (ResultSet resultado = statement.executeQuery()) {
                if (resultado.next()) {
                    int count = resultado.getInt(1);
                    return count > 0;
                }
            }
        }
        return false;
    }

    private long buscarFilme(String titulo) throws SQLException {
        String sql = "SELECT cinecap.filme.id from cinecap.filme where ?";
        try (Connection conexao = ConexãoBanco.conectar();
                PreparedStatement statement = conexao.prepareStatement(sql)) {
            statement.setString(1, titulo);
            try (ResultSet resultado = statement.executeQuery()) {
                if (resultado.next()) {
                    long id = resultado.getLong(1);
                    return id;
                } else {
                    System.out.println("Nenhum resultado encontrado para o titulo: " + titulo);
                }
            }
        }
        return 0;
    }

    public boolean deletarFilme(String titulo) throws SQLException {
        boolean encontrado = this.filmeExiste(titulo);
        if (encontrado) {
            String sql = "DELETE FROM cinecap.filme where titulo = ?";
            try (Connection conexao = ConexãoBanco.conectar();
                    PreparedStatement statement = conexao.prepareStatement(sql)) {
                statement.setString(1, titulo);
                int linhasAfetadas = statement.executeUpdate();
                return linhasAfetadas > 0;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

}
