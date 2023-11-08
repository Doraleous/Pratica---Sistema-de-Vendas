/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pratica.sistemaDeVendas.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author emart
 */
public class cadastroDeUsuarios {

    //public Pessoa[] cadastro;
    private ArrayList<Pessoa> usuarios = new ArrayList<>();
    private String caminhoDoArquivo = "C:\\PraticaProjeto\\usuarios";

    public cadastroDeUsuarios(ArrayList usuarios) {
        this.usuarios = usuarios;
    }

    public void addUsuario(String CPF) {
        Pessoa novoUsuario = new Pessoa(CPF);
        usuarios.add(novoUsuario);

    }

    public void salvaUsuarios() {
        File listaDeUsuarios = new File(caminhoDoArquivo);
        if (listaDeUsuarios.exists()) {
            System.out.println("Arquivo já existe");

        } else {
            try ( ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(listaDeUsuarios))) {
                oos.writeObject(usuarios);
            } catch (IOException e) {
                e.printStackTrace();

            }
        }

    }

    public static void main(String args[]) {
        cadastroDeUsuarios cadastro = new cadastroDeUsuarios(new ArrayList<>());

        cadastro.addUsuario("93492834");

        cadastro.salvaUsuarios();
    }
}
