/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pratica.sistemadevendas.model;

import java.io.Serializable;
import java.util.Date;

public class UsuarioComum extends Usuario implements Serializable {
    private Date ultimoLogin;
    private int pontos;

    public UsuarioComum(String CPF, String senha, String nome, String email, Date dataDeNascimento) {
        super(CPF, senha, nome, email, dataDeNascimento);
    }

}
