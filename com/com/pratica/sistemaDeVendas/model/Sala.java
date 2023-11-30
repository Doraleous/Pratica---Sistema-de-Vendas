package com.pratica.sistemadevendas.model;

public class Sala {
    private Poltrona[][] poltronas;
    private Sessao[] sessoes;
    private String nomeSala;
    private String tipoSala;

    public Sala(String nomeSala, String tipoSala) {
        this.nomeSala = nomeSala;
        this.tipoSala = tipoSala;
        this.poltronas = new Poltrona[13][19];
        this.sessoes = new Sessao[10]; // Por exemplo, você pode ajustar o tamanho conforme necessário

        for (int i = 0; i < 13; i++) {
            for (int j = 0; j < 19; j++) {
                this.poltronas[i][j] = new Poltrona((i * 19) + j + 1, "Padrão", true);
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

    public String getTipoSala() {
        return tipoSala;
    }

    public void setTipoSala(String tipoSala) {
        this.tipoSala = tipoSala;
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
