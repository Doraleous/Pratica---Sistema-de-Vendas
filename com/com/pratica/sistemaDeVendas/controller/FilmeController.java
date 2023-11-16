/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pratica.sistemaDeVendas.controller;

import com.pratica.sistemaDeVendas.model.Filme;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author emart
 */
public class FilmeController {
    private ArrayList<Filme> filmes;
    private String caminhoDoArquivo = "C:\\PraticaProjeto\\filmes";
    
    public FilmeController() {
        filmes = this.iniciaCadastro();

    }
    
    public void addFilme(String titulo) {

        Filme novoFilme = new Filme(titulo);
        filmes.add(novoFilme);

    }
    
    public void salvaFilmes() {
        File listaDeFilmes = new File(caminhoDoArquivo);

        try ( ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(listaDeFilmes, false))) {
            oos.writeObject(filmes);
            System.out.println("Cadastro saved to " + caminhoDoArquivo);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    
    public ArrayList iniciaCadastro() {
        File listaDeFilmes = new File(caminhoDoArquivo);
        if (listaDeFilmes.exists()) {
            try ( ObjectInputStream ois = new ObjectInputStream(new FileInputStream(listaDeFilmes))) {
                ArrayList<Filme> filmes = (ArrayList<Filme>) ois.readObject();
                return filmes;

            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        ArrayList<Filme> filmes = new ArrayList<>();
        return filmes;

    }
    
    public static void main(String args[]) {
        FilmeController cadastro = new FilmeController();

        cadastro.addFilme("93492848");

        cadastro.salvaFilmes();
    }
    
    
    
}
