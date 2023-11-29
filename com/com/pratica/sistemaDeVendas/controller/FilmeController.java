/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pratica.sistemadevendas.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.SQLException;
import java.util.ArrayList;

import com.pratica.sistemadevendas.model.Filme;
import com.pratica.sistemadevendas.model.dao.FilmeDAO;
import com.pratica.sistemadevendas.view.Aplicacao;

/**
 *
 * @author emart
 */
public class FilmeController {

    private FilmeDAO filmeDAO;
    private Aplicacao aplicacao;
    
    public FilmeController(Aplicacao aplicacao){
        filmeDAO = new FilmeDAO();
        this.aplicacao = aplicacao;
    }

    public ArrayList<String> verificaListaDeFilmes() throws SQLException{
        ArrayList<String> ListaVerificada = filmeDAO.filmesDisponiveisCompra();
        if(!ListaVerificada.isEmpty()){
            return ListaVerificada;
        }else{
            return null;
        }
    }
   
    
    
    
}
