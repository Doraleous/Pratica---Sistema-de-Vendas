/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pratica.sistemaDeVendas.controller;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author emart
 */
public class Usuario implements Serializable {

    private String CPF;
    private String nome;
    private String genero;
    private Date dataDeNascimento;
    private String email;
    private String senha;

    public Usuario(String CPF, String senha) {
        this.CPF = CPF;
        this.senha = senha;
    }

    public String toString() {
        return this.CPF;
    }

}
