package com.pratica.sistemaDeVendas.controller;

import java.util.ArrayList;
import java.io.*;
import java.util.List;

import com.pratica.sistemaDeVendas.model.Usuario;

public class UsuarioController {
    private ArrayList<Usuario> usuarios;
    private static final String CAMINHO_DO_ARQUIVO_USUARIO = System.getProperty("user.dir") +
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

    /*private boolean CadastrarUsuario(String cpf, String email, String senha){
        if(buscarUsuario(email) == null){
            Usuario usuario = new Usuario(cpf, email, senha);
            salvarUsuario(usuario);
            return true;
        }
        return false;
    }*/

    public boolean login(String email, String senha){
        Usuario usuario = buscarUsuario(email);
        return usuario != null && usuario.getSenha().equals(senha);
    }

    public void salvarUsuario(Usuario usuario) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream
        (CAMINHO_DO_ARQUIVO_USUARIO, true))) {
            oos.writeObject(usuario);
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    private Usuario buscarUsuario(String email) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(CAMINHO_DO_ARQUIVO_USUARIO))) {
            Object obj;
            while ((obj = ois.readObject()) != null) {
                if (obj instanceof Usuario) {
                    Usuario usuario = (Usuario) obj;
                    if (usuario.getEmail().equals(email)) {
                        return usuario;
                    }
                }
            }
        } catch (EOFException e) {
            // Alcançou o final do arquivo, nenhum usuário correspondente encontrado
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null; // Usuário não encontrado
    }

    public List<Usuario> listarUsuarios() {
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

}