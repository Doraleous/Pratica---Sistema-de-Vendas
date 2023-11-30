package com.pratica.sistemadevendas.model;

import java.util.Date;

public class Sessao {
    private Date dataInicio;
    private Date dataFim;
    private Filme filmeEmCartaz;

    public Sessao(Date dataInicio, Date dataFim, Filme filmeEmCartaz) {
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.filmeEmCartaz = filmeEmCartaz;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

    public Filme getFilmeEmCartaz() {
        return filmeEmCartaz;
    }

    public void setFilmeEmCartaz(Filme filmeEmCartaz) {
        this.filmeEmCartaz = filmeEmCartaz;
    }
}
