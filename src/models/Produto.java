package models;

class Produto {
    private String nome;
    private double preco;
    private int estoque;
    
    public Produto(String nome, double preco, int estoque) {
        this.nome = nome;
        this.preco = preco;
        this.estoque = estoque;
    }
    
    public boolean reduzirEstoque(int quantidade) {
        if (estoque >= quantidade) {
            estoque -= quantidade;
            return true;
        } else {
            System.out.println("Estoque insuficiente!");
            return false;
        }
    }
    
    public double getPreco() { return preco; }
    public String getNome() { return nome; }
    
    @Override
    public String toString() {
        return nome + " - R$" + preco + " (Estoque: " + estoque + ")";
    }
}