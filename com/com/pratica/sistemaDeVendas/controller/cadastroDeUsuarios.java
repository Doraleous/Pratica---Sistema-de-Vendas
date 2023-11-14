/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pratica.sistemaDeVendas.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import com.pratica.sistemaDeVendas.model.Administrador;
import com.pratica.sistemaDeVendas.model.Usuario;

/**
 *
 * @author emart
 */
public class cadastroDeUsuarios {

    private ArrayList<Usuario> usuarios;
    private String caminhoDoArquivo = "C:\\PraticaProjeto\\usuarios";

    public cadastroDeUsuarios() {
        usuarios = this.iniciaCadastro();

    }

    public void addUsuario(String CPF, String email, String senha) {

        Usuario novoUsuario = new Usuario(CPF, email, senha);
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
        Administrador root = new Administrador("01986","admin@cinecap.com", "admin");
        usuarios.add(root);
        return usuarios;

    }

    public static void main(String args[]) {
        cadastroDeUsuarios cadastro = new cadastroDeUsuarios();

        cadastro.addUsuario("93492848","email@.com", "0987");

        cadastro.salvaUsuarios();
    }
}
