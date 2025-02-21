package models;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private Cliente cliente;
    private List<Produto> produtos;
    private double total;

    // Construtor
    public Pedido(Cliente cliente) {
        this.cliente = cliente;
        this.produtos = new ArrayList<>();
        this.total = 0.0;
    }
    
    public void getProdutos() {
		// TODO Auto-generated method stub
		
	}

    // Método para adicionar produto ao pedido
    public void adicionarProduto(Produto produto, int quantidade) {
        produto.reduzirEstoque(quantidade);  // Supondo que Produto tem um método reduzirEstoque
        produtos.add(produto);
        total += produto.getPreco() * quantidade;  // Supondo que Produto tem um método getPreco
    }

    // Na classe Pedido
    public void finalizarPedido(Pagamento pagamento) {
        System.out.println("\n=== Pedido Finalizado ===");
        System.out.println("Cliente: " + cliente.getNome());
        System.out.println("Email: " + cliente.getEmail());
        System.out.println("Endereço de entrega: " + cliente.getEndereco());
        
        // Exibe os produtos no pedido
        System.out.println("\nProdutos:");
        for (Produto produto : produtos) {
            System.out.println("- " + produto.getNome() + " - R$" + produto.getPreco() + " x Quantidade: " + produto.getQuantidade());
        }
        
        System.out.println("\nTotal: R$" + total);

        // Exibe os detalhes do pagamento
        System.out.println("Método de pagamento: " + pagamento.getMetodoPagamento());
        System.out.println("Valor pago: R$" + pagamento.getValor());

        System.out.println("\n=== Fim do Pedido ===");
    }

    
    

}
