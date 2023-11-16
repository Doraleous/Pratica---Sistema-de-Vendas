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

    private String CPF;
    private String nome;    
    private Date dataDeNascimento;
    private String email;
    private String senha;

    public Usuario(String CPF, String senha, String nome, String email) {
        this.CPF = CPF;
        this.senha = senha;
        this.nome = nome;
        this.email = email;
        
    }

    public String getCPF() {
        return this.CPF;
    }

    public String getSenha() {
        return this.senha;
    }

    public String getEmail() {
        return this.email;
    }

    public String toString() {
        return this.CPF;
    }

}
