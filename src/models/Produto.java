package models;

public class Produto {
    private String nome;
    private double preco;
    private int quantidade;
    private int estoque;

    public Produto(String nome, double preco, int quantidade, int estoque) {
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
        this.estoque = estoque;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public int getQuantidade() {
        return quantidade;
    }
    
    public int estoque() {
        return estoque;
    }

    // Reduz a quantidade de estoque
    public void reduzirEstoque(int quantidade) {
        if (this.quantidade >= quantidade) {
            this.quantidade -= quantidade;
        } else {
            System.out.println("Estoque insuficiente!");
        }
    }
}
