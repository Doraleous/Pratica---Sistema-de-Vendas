package com.pratica.sistemadevendas.model;

import java.util.Date;

public class Sessao {
    private Date dataInicio;
    private Filme filmeEmCartaz;

    public Sessao(Date dataInicio, Filme filmeEmCartaz) {
        this.dataInicio = dataInicio;
        this.filmeEmCartaz = filmeEmCartaz;
    }

    public Sessao(String string, Filme filme) {
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Filme getFilmeEmCartaz() {
        return filmeEmCartaz;
    }

    public void setFilmeEmCartaz(Filme filmeEmCartaz) {
        this.filmeEmCartaz = filmeEmCartaz;
    }
}
