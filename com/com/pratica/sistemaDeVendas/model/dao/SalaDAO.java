package com.pratica.sistemadevendas.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.pratica.sistemadevendas.model.Sala;
import com.pratica.sistemadevendas.model.TipoSala;
import com.pratica.sistemadevendas.model.util.ConexãoBanco;

public class SalaDAO {

    public String cadastrarSala(Sala sala) throws SQLException {
        String sql = "INSERT INTO cinecap.sala (nome, tipo_sala_id) VALUES (?, ?)"; // nome dos campos esta certo?
        try (Connection conexao = ConexãoBanco.conectar();
                PreparedStatement statement = conexao.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, sala.getNomeSala());
            statement.setLong(2, sala.getTipoSala().getId());
            statement.execute();
           
            return "Sala Cadastrada Com Sucesso.";
        } catch (SQLException e) {
            e.printStackTrace();
            return "Erro ao cadastrar a  Sala";
        }
    }

    public ArrayList<Sala> listarSalas() throws SQLException {
        ArrayList<Sala> listaDeSalas = new ArrayList<>();

        String sql = "SELECT id, nome, tipo_sala FROM cinecap.sala";

        try (Connection conexao = ConexãoBanco.conectar();
                PreparedStatement statement = conexao.prepareStatement(sql);
                ResultSet resultado = statement.executeQuery();) {

            while (resultado.next()) {
                Long id = resultado.getLong("id");
                String nomeSala = resultado.getString("nome");
                Long tipoSalaId = resultado.getLong("tipo_sala_id");
                int tipoSalaIdCastado = tipoSalaId.intValue();
                TipoSala tipoSala;
                switch (tipoSalaIdCastado) {
                    case 1:
                        tipoSala = TipoSala._3D;
                        break;

                    case 2:
                        tipoSala = TipoSala.XD;
                        break;

                    case 3:
                        tipoSala = TipoSala.XD3D;
                        break;
                        
                    default:
                        tipoSala = TipoSala.COMUM;
                        break;
                }

                Sala sala = new Sala(nomeSala, tipoSala);
                listaDeSalas.add(sala);
            }
        }
        return listaDeSalas;
    }

    public void atualizarSala(Sala sala) throws SQLException {
        String sql = "UPDATE cinecap.sala SET nome = ?, tipo_sala = ? WHERE id = ?";
        try (Connection conexao = ConexãoBanco.conectar();
                PreparedStatement statement = conexao.prepareStatement(sql)) {
            statement.setString(1, sala.getNomeSala());
            statement.setLong(2, sala.getTipoSala().getId());
            statement.setLong(3, sala.getId());
            statement.executeUpdate();
        }
    }

    public void deletarSala(Sala sala) throws SQLException {
        String sql = "DELETE FROM cinecap.sala WHERE nome = ?";
        try (Connection conexao = ConexãoBanco.conectar();
            PreparedStatement statement = conexao.prepareStatement(sql)) {
            statement.setString(1, sala.getNomeSala());
            statement.executeUpdate();
        }
    }

    // Adicione outros métodos conforme necessário
}
