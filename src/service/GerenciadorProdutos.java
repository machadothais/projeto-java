package service;

import models.Produto;
import exceptions.ProdutoNaoEncontradoException;
import java.util.ArrayList;
import java.util.List;

public class GerenciadorProdutos {
    private List<Produto> produtos;

    public GerenciadorProdutos() {
        this.produtos = new ArrayList<>();
    }

    public void adicionarProduto(Produto produto) {
        produtos.add(produto);
    }

    public Produto buscarProdutoPorNome(String nome) {
        return produtos.stream()
                .filter(produto -> produto.getNome().equalsIgnoreCase(nome))
                .findFirst()
                .orElseThrow(() -> new ProdutoNaoEncontradoException("Produto não encontrado: " + nome));
    }

    public void listarProdutos() {
        if (produtos.isEmpty()) {
            System.out.println("Nenhum produto cadastrado.");
            return;
        }

        System.out.println("\n=== Lista de Produtos ===");
        for (Produto produto : produtos) {
            System.out.println(produto.getNome() + " - R$" + produto.getPreco() + " (Estoque: " + produto.getQuantidade() + ")");
        }
    }
}
