package models;

public abstract class Pagamento {
    protected double valor;

    public Pagamento(double valor) {
        this.valor = valor;
    }

    public double getValor() {
        return valor;
    }

    // Método abstrato para retornar o tipo de pagamento
    public abstract String getMetodoPagamento();
}

