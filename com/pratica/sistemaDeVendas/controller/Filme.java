/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pratica.sistemaDeVendas.controller;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author emart
 */
public class Filme implements Serializable {
    private String titulo;
    double notaMedia;
    ArrayList<Double> notas;
    
    public Filme (String titulo){
        this.titulo = titulo;
    }
    
}
