package com.pratica.sistemadevendas.model;

import java.io.Serializable;
import java.util.Date;

public class Sessao implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private Sala sala;
    private Filme filme;
    private Date dataInicio;

    public Sessao(Date dataInicio, Filme filmeEmCartaz) {
        this.dataInicio = dataInicio;
        this.filme = filmeEmCartaz;
    }

    public Sessao() {
    }

    /**
     * @return Long return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return Sala return the sala
     */
    public Sala getSala() {
        return sala;
    }

    /**
     * @param sala the sala to set
     */
    public void setSala(Sala sala) {
        this.sala = sala;
    }

    /**
     * @return Filme return the filme
     */
    public Filme getFilme() {
        return filme;
    }

    /**
     * @param filme the filme to set
     */
    public void setFilme(Filme filme) {
        this.filme = filme;
    }

    /**
     * @return Date return the dataInicio
     */
    public Date getDataInicio() {
        return dataInicio;
    }

    /**
     * @param dataInicio the dataInicio to set
     */
    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", sala='" + getSala().getId() + "'" +
                ", filme='" + getFilme().getId() + "'" +
                "}";
    }

}
