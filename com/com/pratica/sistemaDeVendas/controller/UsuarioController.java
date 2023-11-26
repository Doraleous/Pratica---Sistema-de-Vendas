package com.pratica.sistemaDeVendas.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import com.pratica.sistemaDeVendas.model.Administrador;
import com.pratica.sistemaDeVendas.model.Usuario;

public class UsuarioController {
    private ArrayList<Usuario> usuarios;
    private final String CAMINHO_DO_ARQUIVO_USUARIO = System.getProperty("user.dir") +
    File.separator +
    "com" +
    File.separator +
    "com" +
    File.separator +
    "pratica" +
    File.separator +
    "sistemaDeVendas" +
    File.separator +
    "data"+
    File.separator +
    "usuarios.txt";

    public UsuarioController(){
        System.out.println("entrando no UsuarioController");
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
        File listaDeUsuarios = new File(CAMINHO_DO_ARQUIVO_USUARIO);

        try ( ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(listaDeUsuarios, false))) {
            oos.writeObject(usuarios);
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    private ArrayList<Usuario> iniciaCadastro() {
        System.out.println("entrando no iniciaCadastro");
        File listaUsuarios = new File(CAMINHO_DO_ARQUIVO_USUARIO);
        if(listaUsuarios.exists()){
            try ( ObjectInputStream ois = new ObjectInputStream(new FileInputStream(listaUsuarios))) {
                this.usuarios = (ArrayList<Usuario>) ois.readObject();
                return usuarios;
            } catch (IOException | ClassNotFoundException e){
                e.printStackTrace();
            }
        }
        ArrayList<Usuario> usuarios = new ArrayList<>();
        Administrador root = new Administrador("01986", "1234", "Jairo", "jairo@gmail");
        usuarios.add(root);
        //this.salvaUsuarios(); // teste
        return usuarios;
    }

    public boolean login(String email, String senha){
        System.out.println("entrando no login");
        Usuario usuario = buscarUsuario(email);
        return usuario != null && senha.equals(usuario.getSenha());
    }
    public Usuario buscarUsuario(String email) {
        System.out.println("entrando no buscarUsuario");
        System.out.println(usuarios.size());
        for (Usuario usuario : usuarios) {
            System.out.println("user:" + usuario);
            if(usuario.getEmail().equals(email)){
                return usuario;
            }
        }
        return null;
    }

    /*public List<Usuario> listarUsuarios() {
        System.out.println("entrando no listarUsuarios");
        List<Usuario> usuarios = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(CAMINHO_DO_ARQUIVO_USUARIO))) {
            Object obj;
            while ((obj = ois.readObject()) != null) {
                if (obj instanceof Usuario) {
                    usuarios.add((Usuario) obj);
                }
            }
        } catch (EOFException e) {
            // Alcançou o final do arquivo
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return usuarios;
    }*/

    public void sair(){
        File listaDeUsuarios = new File(CAMINHO_DO_ARQUIVO_USUARIO);
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream
        (listaDeUsuarios, false))) {
            oos.writeObject(usuarios);
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    

}
