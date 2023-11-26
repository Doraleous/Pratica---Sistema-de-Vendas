/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pratica.sistemaDeVendas.model;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author emart
 */
public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String CPF;
    private String nome;
    private Date dataDeNascimento;
    private String email;
    private String senha;

    public Usuario(String CPF, String senha, String nome, String email) {
        this.CPF = CPF;
        this.senha = senha;
        this.nome = nome;
        this.email= email;
    }

    public Usuario (){
        
    }

    public String toString() {
        return "CPF: " + this.CPF + " Nome: " + this.nome +  " E-mail: " + this.email + /*this.dataNascimentoToString() +*/ " Senha: " + this.senha;
    }
    /**
     * @return String return the CPF
     */
    public String getCPF() {
        return CPF;
    }

    /**
     * @param CPF the CPF to set
     */
    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    /**
     * @return String return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return Date return the dataDeNascimento
     */
    public Date getDataDeNascimento() {
        return dataDeNascimento;
    }

    /**
     * @param dataDeNascimento the dataDeNascimento to set
     */
    public void setDataDeNascimento(Date dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

    /**
     * @return String return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return String return the senha
     */
    public String getSenha() {
        return senha;
    }

    /**
     * @param senha the senha to set
     */
    public void setSenha(String senha) {
        this.senha = senha;
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

    /*public String dataNascimentoToString(){
        int dia = this.getDataDeNascimento().getDay();
        int mes = this.getDataDeNascimento().getMonth()+1; // somo mais 1 por que o Date salva os meses de 0 a 11
        int ano = this.getDataDeNascimento().getYear()+1900; // somo mais 1900 por que o Date salva os anos subtraindo 1900
        return " Data= "+ dia + "/" + mes + "/" + ano;
    }*/

}
