package com.pratica.sistemadevendas.view;

import java.util.List;
import java.util.Scanner;

import com.pratica.sistemadevendas.controller.CompraLancheController;
import com.pratica.sistemadevendas.model.Lanche;

public class CompraLancheView {
    public void exibirMenu(List<Lanche> lanches) {
        System.out.println("Menu de Lanches:");
        for (int i = 0; i < lanches.size(); i++) {
            Lanche lanche = lanches.get(i);
            System.out.println(i + 1 + ". " + lanche.getNome() + " - R$" + lanche.getPreco());
        }
    }

    public int solicitarLanche() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Escolha o nÃºmero do lanche desejado: ");
            return scanner.nextInt();
        }
    }

    public void exibirTotal(double total) {
        System.out.println("Total da compra: R$" + total);
    }
}
class LancheApp {
    private CompraLancheView view;
    private CompraLancheController controller;

    public LancheApp() {
        this.view = new CompraLancheView();
        this.controller = new CompraLancheController(view);

        // Adicionando lanches ao menu
        controller.adicionarLanche("Pipoca Grande", 10.0);
        controller.adicionarLanche("Refrigerante", 5.0);
        controller.adicionarLanche("Chocolate", 7.5);
    }

    public void executarLancheApp() {
        // Realizando uma compra
        controller.realizarCompra();

        // Adicionando mais um item ao carrinho
        controller.realizarCompra();
    }
}