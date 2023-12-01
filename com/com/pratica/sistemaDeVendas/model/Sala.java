package com.pratica.sistemadevendas.model;

import java.io.Serializable;

public class Sala implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private Poltrona[][] poltronas;
    private Sessao[] sessoes;
    private String nomeSala;
    private Enum tipoSala;

    public Sala(String nomeSala, Enum tipoSala) {
        this.nomeSala = nomeSala;
        this.tipoSala = tipoSala;
        this.poltronas = new Poltrona[13][19];
        this.sessoes = new Sessao[10]; // Por exemplo, você pode ajustar o tamanho conforme necessário

        for (int i = 0; i < 13; i++) {
            for (int j = 0; j < 19; j++) {
                this.poltronas[i][j] = new Poltrona((i * 19) + j + 1, true);
            }
        }
    }

    public Sessao[] getSessoes() {
        return sessoes;
    }

    public void adicionarSessao(Sessao sessao, int indice) {
        if (indice >= 0 && indice < sessoes.length) {
            this.sessoes[indice] = sessao;
        } else {
            System.out.println("Índice inválido para adicionar sessão.");
        }
    }

    public String getNomeSala() {
        return nomeSala;
    }

    public void setNomeSala(String nomeSala) {
        this.nomeSala = nomeSala;
    }

    public Enum getTipoSala() {
        return tipoSala;
    }

    public void setTipoSala(Enum tipoSala) {
        this.tipoSala = tipoSala;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Poltrona getPoltrona(int linha, int coluna) {
        return poltronas[linha][coluna];
    }

    // Método para exibir informações da sala
    /*
     * public void exibirInformacoesDaSala() {
     * System.out.println("Estado Atual da Sala:");
     * for (int i = 0; i < 13; i++) {
     * for (int j = 0; j < 19; j++) {
     * poltronas[i][j].exibirInformacoes();
     * System.out.println("------------------------");
     * }
     * }
     * }
     */
}
