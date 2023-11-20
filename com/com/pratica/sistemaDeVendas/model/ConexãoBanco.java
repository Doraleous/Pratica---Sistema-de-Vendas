package com.pratica.sistemaDeVendas.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexãoBanco {
    private static final String URL = "jdbc:postgresql://localhost:5432/cinecap";
    private static final String USUARIO= "postgres";
    private static final String SENHA= "@Diego123";

    public static Connection conectar () throws SQLException{
        return DriverManager.getConnection(URL, USUARIO, SENHA);
    }
}