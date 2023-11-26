package com.pratica.sistemaDeVendas.controller;

import java.util.ArrayList;

import com.pratica.sistemaDeVendas.model.Filme;
import com.pratica.sistemaDeVendas.model.Usuario;
import com.pratica.sistemaDeVendas.model.UsuarioComum;

public class UsuarioComumController {
    private ArrayList<Usuario> listaUsuarios;
    private ArrayList<Filme> listaFilmes;
    private UsuarioController usuarioController;

    public UsuarioComumController(
    ArrayList<Usuario> listaUsuarios,
    ArrayList<Filme> listaFilmes,
    UsuarioController usuarioController){
        this.listaUsuarios = listaUsuarios;
        this.usuarioController = usuarioController;
        this.listaFilmes = listaFilmes;
    }
    
    public boolean cadastrarUsuarioComun(UsuarioComum usuarioComum){
        
        return false;
    }
}
