package com.pratica.sistemadevendas.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.pratica.sistemadevendas.model.CarrinhoDeCompras;
import com.pratica.sistemadevendas.model.Lanche;
import com.pratica.sistemadevendas.view.CompraLancheView;

public class CompraLancheController {
    private List<Lanche> menu;
    private CarrinhoDeCompras carrinho;
    private CompraLancheView view;

    public CompraLancheController(CompraLancheView view) {
        this.menu = new ArrayList<>();
        this.carrinho = new CarrinhoDeCompras();
        this.view = view;
    }

    public void adicionarLanche(String nome, double preco) {
        Lanche lanche = new Lanche(nome, preco);
        menu.add(lanche);
    }

    public void exibirMenu() {
        view.exibirMenu(menu);
    }

    public void realizarCompra() {
        view.exibirMenu(menu);
        int escolha = view.solicitarLanche();

        if (escolha >= 1 && escolha <= menu.size()) {
            Lanche lancheEscolhido = menu.get(escolha - 1);
            carrinho.adicionarItem(lancheEscolhido);
            view.exibirTotal(carrinho.calcularTotal());
        } else {
            System.out.println("Opção inválida.");
        }
    }
    public void modificarLanche() {
        view.exibirMenu(menu);
        int escolha = view.solicitarLanche();

        if (escolha >= 1 && escolha <= menu.size()) {
            Lanche lancheEscolhido = menu.get(escolha - 1);

            try (Scanner scanner = new Scanner(System.in)) {
                System.out.print("Novo nome para o lanche: ");
                String novoNome = scanner.nextLine();
                lancheEscolhido.setNome(novoNome);

                System.out.print("Novo preço para o lanche: ");
                double novoPreco = scanner.nextDouble();
                lancheEscolhido.setPreco(novoPreco);
            }

            view.exibirMenu(menu);
            System.out.println("Lanche modificado com sucesso!");
        } else {
            System.out.println("Opção inválida.");
        }
    }

    public void removerLanche() {
        view.exibirMenu(menu);
        int escolha = view.solicitarLanche();

        if (escolha >= 1 && escolha <= menu.size()) {
            Lanche lancheRemovido = menu.remove(escolha - 1);
            view.exibirMenu(menu);
            System.out.println("Lanche removido: " + lancheRemovido.getNome());
        } else {
            System.out.println("Opção inválida.");
        }
    }
}

