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

/**
 *
 * @author emart
 */
public class cadastroDeUsuarios {

    private ArrayList<Pessoa> usuarios;
    private String caminhoDoArquivo = "C:\\PraticaProjeto\\usuarios";

    public cadastroDeUsuarios() {
        usuarios = this.iniciaCadastro();

    }

    public void addUsuario(String CPF) {

        Pessoa novoUsuario = new Pessoa(CPF);
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
                ArrayList<Pessoa> usuarios = (ArrayList<Pessoa>) ois.readObject();
                return usuarios;

            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        ArrayList<Pessoa> usuarios = new ArrayList<>();
        return usuarios;

    }

    public static void main(String args[]) {
        cadastroDeUsuarios cadastro = new cadastroDeUsuarios();

        cadastro.addUsuario("93492848");

        cadastro.salvaUsuarios();
    }
}
