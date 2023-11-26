package com.pratica.sistemadevendas.controller;

import java.util.ArrayList;

import com.pratica.sistemadevendas.model.Filme;
import com.pratica.sistemadevendas.model.Usuario;
import com.pratica.sistemadevendas.model.UsuarioComum;

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
