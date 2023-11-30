package com.pratica.sistemadevendas.model;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoDeCompras {
    private List<Lanche> itens;

    public CarrinhoDeCompras() {
        this.itens = new ArrayList<>();
    }

    public void adicionarItem(Lanche lanche) {
        itens.add(lanche);
    }

    public List<Lanche> getItens() {
        return new ArrayList<>(itens);
    }

    public double calcularTotal() {
        double total = 0;
        for (Lanche lanche : itens) {
            total += lanche.getPreco();
        }
        return total;
    }
}