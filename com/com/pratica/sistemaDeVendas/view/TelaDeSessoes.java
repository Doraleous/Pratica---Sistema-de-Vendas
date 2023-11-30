package com.pratica.sistemadevendas.view;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.application.Application;
import com.pratica.sistemadevendas.model.Filme;

public class ListaSessoesTela {
    Aplicacao aplicacao;

    public static Scene criarScene(Aplicacao aplicacao, Filme filme) {

        this.aplicacao = aplicacao;

        Sessao[] sessoes = {
                new Sessao("2023-12-01 15:00", filme),
                new Sessao("2023-12-01 18:00", filme),
                new Sessao("2023-12-01 21:00", filme)
        };

        VBox layout = new VBox(10);

        for (Sessao sessao : sessoes) {
            Button horarioButton = new Button(sessao.getHorario());
            horarioButton.setOnAction(e -> abrirProximaTela(aplicacao, sessao)); // Definir ação do botão
            layout.getChildren().add(horarioButton);
        }

        return new Scene(layout, 300, 200);
    }

    private static void abrirProximaTela(Application aplicacao, Sessao sessao) {
        System.out.println("Abrir próxima tela para a sessão: " + sessao.getHorario());
    }

    private static class Sessao {
        private String horario;
        private Filme filmeEmCartaz;

        public Sessao(String horario, Filme filmeEmCartaz) {
            this.horario = horario;
            this.filmeEmCartaz = filmeEmCartaz;
        }

        public String getHorario() {
            return horario;
        }

        public Filme getFilmeEmCartaz() {
            return filmeEmCartaz;
        }
    }
}
