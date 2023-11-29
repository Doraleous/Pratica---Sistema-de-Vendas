package com.pratica.sistemadevendas.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import com.pratica.sistemadevendas.model.util.ConexãoBanco;

public class FilmeDAO {

    public ArrayList<String> filmesDisponiveisCompra() throws SQLException{
        ArrayList<String> listaDeFilmes = new ArrayList<>();

        String sql = "SELECT cinecap.filme.titulo FROM cinecap.filme";

        try(Connection conexao = ConexãoBanco.conectar();
        PreparedStatement statement = conexao.prepareStatement(sql)){
            ResultSet resultado = statement.executeQuery();
            while(resultado.next()){
                listaDeFilmes.add(resultado.getString(1));
            }

        }
        return listaDeFilmes;
    }
    
}
