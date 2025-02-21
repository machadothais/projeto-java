package service;

import models.Pedido;
import exceptions.PedidoVazioException;
import java.util.ArrayList;
import java.util.List;

public class GerenciadorPedidos {
    private List<Pedido> pedidos;

    public GerenciadorPedidos() {
        this.pedidos = new ArrayList<>();
    }

    public void adicionarPedido(Pedido pedido) {
        if (pedido.getProdutos().isEmpty()) {
            throw new PedidoVazioException("O pedido não pode estar vazio!");
        }
        pedidos.add(pedido);
    }

    public void listarPedidos() {
        if (pedidos.isEmpty()) {
            System.out.println("Nenhum pedido registrado.");
            return;
        }

        System.out.println("\n=== Lista de Pedidos ===");
        for (Pedido pedido : pedidos) {
            System.out.println("Cliente: " + pedido.getClass().getName());
            System.out.println("Total: R$" + pedido.getTotal());
            System.out.println("--------------------------");
        }
    }
}
