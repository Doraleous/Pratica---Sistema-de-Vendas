package com.pratica.sistemadevendas.model;

import java.io.Serializable;
import java.util.Date;

public class Sessao implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
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
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFilmeEmCartaz(Filme filmeEmCartaz) {
        this.filmeEmCartaz = filmeEmCartaz;
    }
}
