/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pratica.sistemaDeVendas.controller;

import com.pratica.sistemaDeVendas.model.Administrador;
import com.pratica.sistemaDeVendas.model.Usuario;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author emart
 */
public class UsuarioController {

    private ArrayList<Usuario> usuarios;
    private String caminhoDoArquivo = "C:\\PraticaProjeto\\usuarios";

    public UsuarioController() {
        usuarios = this.iniciaCadastro();

    }

    public Usuario getUsuario(Usuario usuarioDesejado) {
        for (Usuario usuario : this.usuarios) {
            if (usuario.getCPF().equals(usuarioDesejado.getCPF())) {
                return usuario;
            }
        }
        return null;
    }

    public void addUsuario(String CPF, String senha, String nome, String email) {

        Usuario novoUsuario = new Usuario(CPF, senha, nome, email);
        usuarios.add(novoUsuario);

    }

    public ArrayList getUsuarios() {
        return this.usuarios;

    }

    public void salvaUsuarios() {
        File listaDeUsuarios = new File(caminhoDoArquivo);

        try ( ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(listaDeUsuarios, false))) {
            oos.writeObject(usuarios);
            System.out.println("Cadastro saved to " + caminhoDoArquivo);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public ArrayList iniciaCadastro() {
        File listaDeUsuarios = new File(caminhoDoArquivo);
        if (listaDeUsuarios.exists()) {
            try ( ObjectInputStream ois = new ObjectInputStream(new FileInputStream(listaDeUsuarios))) {
                ArrayList<Usuario> usuarios = (ArrayList<Usuario>) ois.readObject();
                return usuarios;

            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        ArrayList<Usuario> usuarios = new ArrayList<>();
        Administrador root = new Administrador("01986", "1234", "Jairo", "jairo@gmail");
        usuarios.add(root);
        //this.salvaUsuarios(); // teste
        return usuarios;

    }

    public void imprimeUsuarios() {
        File listaDeUsuarios = new File(caminhoDoArquivo);
        if (listaDeUsuarios.exists()) {
            try ( ObjectInputStream ois = new ObjectInputStream(new FileInputStream(listaDeUsuarios))) {
                ArrayList<Usuario> usuarios = (ArrayList<Usuario>) ois.readObject();
                for (Usuario usuario : usuarios) {
                    System.out.println(usuario);
                }

            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Terminou o imprimeUsuarios");

    }

    public boolean login(String email, String senha) {
        System.out.println("entrando no login");
        Usuario usuario = buscarUsuario(email);
        return usuario != null && senha.equals(usuario.getSenha());
    }
    
    public Usuario buscarUsuario(String email) {
        System.out.println("entrando no buscarUsuario");
        for (Usuario usuario : usuarios) {
            if(usuario.getEmail().equals(email)){
                return usuario;
            }
        }
        return null;
    }

    private Usuario buscarUsuario2(String email) {
        System.out.println("entrando no buscarUsuario");
        File listaUsuarios = new File(caminhoDoArquivo);
        try ( ObjectInputStream ois = new ObjectInputStream(new FileInputStream(listaUsuarios))) {
            System.out.println("entrando no try");
            this.usuarios = (ArrayList<Usuario>) ois.readObject();
            System.out.println("quantidade de usuarios" + usuarios.size());
            for (Usuario usuario : usuarios) {
                if (usuario.getEmail().equals(email)) {
                    return usuario;
                }
            }
            return null;
        } catch (EOFException e) {
            // Alcançou o final do arquivo, nenhum usuário correspondente encontrado
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null; // Usuário não encontrado
    } 
    
    public void sair(){
        File listaDeUsuarios = new File(caminhoDoArquivo);
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream
        (listaDeUsuarios, false))) {
            oos.writeObject(usuarios);
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void main(String args[]) {
        UsuarioController cadastro = new UsuarioController();

        cadastro.addUsuario("93492848", "0987", "Diego", "diego@gmail");

        cadastro.salvaUsuarios();
        cadastro.imprimeUsuarios();

        System.out.println("O usuário buscado é" + cadastro.buscarUsuario("diego@gmail"));
    }
}
