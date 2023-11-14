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
public class UsuarioComum extends Usuario implements Serializable {
    
    public UsuarioComum(String CPF, String senha) {
        super(CPF, senha);
    }
    
}
