/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pratica.sistemaDeVendas.controller;

import java.io.Serializable;

/**
 *
 * @author emart
 */
public class UsuarioCritico extends UsuarioComum implements Serializable {
    
    public UsuarioCritico(String CPF, String senha) {
        super(CPF, senha);
    }
    
}
