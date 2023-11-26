package com.pratica.sistemaDeVendas.controller;

import java.util.ArrayList;
import java.util.Date;

import com.pratica.sistemaDeVendas.model.Administrador;
import com.pratica.sistemaDeVendas.model.Filme;
import com.pratica.sistemaDeVendas.model.Usuario;
import com.pratica.sistemaDeVendas.model.UsuarioComum;
import com.pratica.sistemaDeVendas.model.UsuarioCritico;
import com.pratica.sistemaDeVendas.model.UsuarioEstudante;

public class AdministradorController {
    private ArrayList<Usuario> listaUsuarios;
    private ArrayList<Filme> listaFilmes;
    private UsuarioController usuarioController;

    public AdministradorController(
        ArrayList<Usuario> listaUsuarios,
        ArrayList<Filme> listaFilmes,
        UsuarioController usuarioController
        ){
        this.listaUsuarios = listaUsuarios;
        this.usuarioController = usuarioController;
        this.listaFilmes = listaFilmes;
    }

    public boolean cadastrarUsuario(
    String cpf,
    String email,
    String senha,
    String nome,
    String tipo
    ){
        Usuario novoUsuario = this.usuarioController.buscarUsuario(email);

        if(novoUsuario != null){
            return false;
        }

        switch (tipo) {
            case "Normal":
                UsuarioComum novoUsuarioComum = new UsuarioComum(cpf,senha, nome, email);
                this.listaUsuarios.add(novoUsuarioComum);

                break;

            case "Administrador":
                Administrador novoAdministrador = new Administrador(cpf,senha, nome, email);
                this.listaUsuarios.add(novoAdministrador);

                break;

            case "Estudante":
                UsuarioEstudante novUsuarioEstudante = new UsuarioEstudante(cpf,senha, nome, email);
                this.listaUsuarios.add(novUsuarioEstudante);

                break;

            case "Critico":
                UsuarioCritico novoUsuarioCritico = new UsuarioCritico(cpf,senha, nome, email);
                this.listaUsuarios.add(novoUsuarioCritico);
                
            break;
        
            default:
                break;
        }

        return true;
    }

    public boolean deletarUsuario(String cpf){
        Usuario adeus = this.buscarUsuario(cpf);
        if(adeus == null){
            return false;
        }
        this.listaUsuarios.remove(adeus);
        return true;
    }

    public Usuario buscarUsuario(String cpf){
        for (Usuario usuario : this.listaUsuarios) {
            if(usuario.getCPF().equals(cpf)){
                return usuario;
            }
        }
        return null;
    }

    public boolean cadastrarFilme(String nome){
        Filme filme = this.buscarFilme(nome);

        if(filme != null){
            return false;
        }

        Filme novoFilme = new Filme(nome);
        this.listaFilmes.add(novoFilme);

        return true;
    }

    public boolean deletarFilme(String nome){
        Filme adeus = this.buscarFilme(nome);
        if(adeus == null){
            return false;
        }
        this.listaFilmes.remove(adeus);
        return true;
    }

    public Filme buscarFilme(String nome){
        for (Filme filme : this.listaFilmes) {
            if(filme.getTitulo().equals(nome)){
                return filme;
            }
        }
        return null;
    }

    public boolean atualizarDados(
        String CPF,
        String nome,
        Date dataDeNascimento,
        String email,
        String senha
    ){
        Usuario localiza = this.buscarUsuario(email);
        
        if(localiza == null){
            return false;
        }

        localiza.setCPF(CPF);
        localiza.setDataDeNascimento(dataDeNascimento);
        localiza.setEmail(email);
        localiza.setNome(nome);
        localiza.setSenha(senha);
        return true;
    }

    /**
     * @return ArrayList<Usuario> return the listaUsuarios
     */
    public ArrayList<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    /**
     * @param listaUsuarios the listaUsuarios to set
     */
    public void setListaUsuarios(ArrayList<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

}
