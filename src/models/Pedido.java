package models;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private Cliente cliente;
    private List<Produto> produtos;
    private double total;

    public Pedido(Cliente cliente) {
        this.cliente = cliente;
        this.produtos = new ArrayList<>();
        this.total = 0.0;
    }

    public void adicionarProduto(Produto produto, int quantidade) {
        if (quantidade > 0) {
            produto.reduzirEstoque(quantidade);
            produtos.add(produto);
            total += produto.getPreco() * quantidade;
        } else {
            System.out.println("Quantidade inválida.");
        }
    }
    
    public void finalizarPedido() {
        System.out.println("\nPedido finalizado para " + cliente.getNome());
        System.out.println("Endereço de entrega: " + cliente.getEndereco());
        
        if (produtos.isEmpty()) {
            System.out.println("Nenhum produto foi adicionado ao pedido.");
        } else {
            System.out.println("Produtos:");
            for (Produto produto : produtos) {
                
                System.out.println("- " + produto.getNome() + " (R$" + produto.getPreco() + ")");
            }
        }
        
        System.out.println("\nTotal do pedido: R$" + total);
    }
}
