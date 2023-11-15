package com.pratica.sistemaDeVendas.controller;

import java.util.ArrayList;
import java.io.*;
import java.util.List;

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
    "usuarios";

    public UsuarioController(){
        System.out.println("entrando no UsuarioController");
        usuarios = this.iniciaCadastro();
    }

    /*private boolean cadastrarUsuario(String cpf, String email, String senha){
        System.out.println("entrando no cadastrarUsuario");
        if(buscarUsuario(email) == null){
            Usuario novoUsuario = new Usuario(cpf, email, senha);
            usuarios.add(novoUsuario);
            salvarUsuario();
            return true;
        }
        return false;
    }*/

    public void salvarUsuario() {
        System.out.println("entrando no salvarUsuario");
        File listaDeUsuarios = new File(CAMINHO_DO_ARQUIVO_USUARIO);
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream
        (listaDeUsuarios, false))) {
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
        Administrador root = new Administrador("01986","admin@cinecap.com", "admin");
        usuarios.add(root);
        this.salvarUsuario();
        for(Usuario usuario : usuarios){
            System.out.println(usuario);
        }
        return usuarios;
    }

    public boolean login(String email, String senha){
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

    public List<Usuario> listarUsuarios() {
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
    }

    public void sair(){
        File listaDeUsuarios = new File(CAMINHO_DO_ARQUIVO_USUARIO);
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream
        (listaDeUsuarios, false))) {
            oos.writeObject(usuarios);
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public ArrayList getUsuarios(){
        System.out.println("entrando no getUsuarios");
        return this.usuarios;
    }

}