/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pratica.sistemaDeVendas.model;

import java.io.Serializable;

/**
 *
 * @author emart
 */
public class UsuarioCritico extends UsuarioComum implements Serializable {
    
    public UsuarioCritico(String CPF, String senha, String nome, String email) {
        super(CPF, senha, nome, email);
    }
    
}
