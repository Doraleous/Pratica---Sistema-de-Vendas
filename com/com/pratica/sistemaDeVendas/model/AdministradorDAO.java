package com.pratica.sistemaDeVendas.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AdministradorDAO {
    public String cadastrarAdministrador(Administrador administrador) throws SQLException{
        String sql = "INSERT INTO cinecap.usuario (cpf)VALUES (?)";

        try (Connection conexao = ConexãoBanco.conectar();
        PreparedStatement statement = conexao.prepareStatement(sql)){
            statement.setString(1, administrador.getCPF());
            
            return "Usuario Administrador Cadastrado com sucesso.";
        } catch (SQLException e){
            return("Erro ao cadastrar Usuário Administrador");
        }
    }
}
