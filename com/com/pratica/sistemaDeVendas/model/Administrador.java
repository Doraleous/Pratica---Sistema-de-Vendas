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
public class Administrador extends Usuario implements Serializable {
    //teste
    
    public Administrador(String CPF, String email, String senha) {
        super(CPF, email, senha);
        
    }
    
}
