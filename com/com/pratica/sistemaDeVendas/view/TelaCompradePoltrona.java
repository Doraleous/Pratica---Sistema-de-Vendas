
package com.pratica.sistemaDeVendas.view;

import com.pratica.sistemaDeVendas.model.Poltrona;
import com.pratica.sistemaDeVendas.model.Sala;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

public class TelaCompradePoltrona extends GridPane {
    private Sala sala;
    private Application aplicacao;

    public TelaCompradePoltrona(Sala sala, Aplicacao aplicacao) {
        this.sala = sala;
        this.aplicacao = aplicacao;
        criarGridPane();
    }

    private void criarGridPane() {
        setPadding(new Insets(10));
        setHgap(10);
        setVgap(10);

        for (int i = 0; i < 13; i++) {
            for (int j = 0; j < 19; j++) {
                PoltronaButton poltronaButton = new PoltronaButton(sala.getPoltrona(i, j));
                add(poltronaButton, j, i);
            }
        }

        Button btnConfirmar = new Button("Confirmar");
        btnConfirmar.setOnAction(e -> onConfirmar());
        add(btnConfirmar, 0, 13);

        Button btnCancelar = new Button("Cancelar");
        btnCancelar.setOnAction(e -> onCancelar());
        add(btnCancelar, 1, 13);
    }

    private class PoltronaButton extends Button {
        private Poltrona poltrona;

        PoltronaButton(Poltrona poltrona) {
            this.poltrona = poltrona;
            setText(Integer.toString(poltrona.getNumero()));
            setOnAction(e -> reservarOuLiberarPoltrona());
            atualizarEstilo();
        }

        private void reservarOuLiberarPoltrona() {
            poltrona.setDisponibilidade(!poltrona.isDisponibilidade());
            atualizarEstilo();
        }

        private void atualizarEstilo() {
            if (poltrona.isDisponibilidade()) {
                setStyle("-fx-background-color: lightgreen;");
            } else {
                setStyle("-fx-background-color: lightcoral;");
            }
        }

        private void onConfirmar() {

        }
    }

    private Object onConfirmar() {
        return null;
    }

    private Object onCancelar() {
        return null;
    }

}
