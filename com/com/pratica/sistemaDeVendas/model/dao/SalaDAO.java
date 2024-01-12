package com.pratica.sistemaDeVendas.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.pratica.sistemaDeVendas.model.Sala;
import com.pratica.sistemaDeVendas.model.TipoSala;
import com.pratica.sistemaDeVendas.model.util.ConexãoBanco;
import com.pratica.sistemaDeVendas.view.Aplicacao;

public class SalaDAO {

    private Aplicacao aplicacao;

    public SalaDAO(Aplicacao aplicacao) {
        this.aplicacao = aplicacao;
    }

    public String cadastrarSala(Sala sala) throws SQLException {

        String sql = "INSERT INTO cinecap.sala (nome, tipo_sala_id) VALUES (?, ?)"; // nome dos campos esta certo?
        try (Connection conexao = ConexãoBanco.conectar();
                PreparedStatement statement = conexao.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, sala.getNome());
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

        String sql = "SELECT cinecap.sala.id, cinecap.sala.nome, cinecap.sala.tipo_sala_id FROM cinecap.sala";

        try (Connection conexao = ConexãoBanco.conectar();
                PreparedStatement statement = conexao.prepareStatement(sql);
                ResultSet resultado = statement.executeQuery();) {

            while (resultado.next()) {
                Long id = resultado.getLong(1);
                String nomeSala = resultado.getString(2);
                Long tipoSalaId = resultado.getLong(3);
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
                sala.setId(id);
                listaDeSalas.add(sala);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaDeSalas;
    }

    public Boolean atualizarSala(Sala sala) throws SQLException {
        String sql = "UPDATE cinecap.sala SET nome_sala = ?, tipo_sala = ? WHERE id = ?";
        try (Connection conexao = ConexãoBanco.conectar();
                PreparedStatement statement = conexao.prepareStatement(sql)) {
            statement.setString(1, sala.getNome());
            statement.setLong(2, sala.getTipoSala().getId());
            statement.setLong(3, sala.getId());
            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Boolean deletarSala(Sala sala) throws SQLException {
        String sql = "DELETE FROM cinecap.sala WHERE nome = ?";
        try (Connection conexao = ConexãoBanco.conectar();
                PreparedStatement statement = conexao.prepareStatement(sql)) {
            statement.setString(1, sala.getNome());
            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Long buscarSala(String nome) throws SQLException {
        String sql = "SELECT cinecap.sala.id FROM cinecap.sala WHERE cinecap.sala.nome = ?";
        try (Connection conexao = ConexãoBanco.conectar();
                PreparedStatement statement = conexao.prepareStatement(sql)) {
            statement.setString(1, nome);
            try (ResultSet resultado = statement.executeQuery()) {
                if (resultado.next()) {
                    Long idSala = resultado.getLong(1);
                    return idSala;
                } else {
                    System.out.println("Nenhum resultado encontrado para id");
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0L;
    }

    // Adicione outros métodos conforme necessário
}
