package models;

public class PagamentoBoleto extends Pagamento {
    private String codigoBoleto;

    // Construtor da classe PagamentoBoleto
    public PagamentoBoleto(double valor, String codigoBoleto) {
        super(valor);  // Chama o construtor da classe pai (Pagamento), passando o valor do pagamento
        this.codigoBoleto = codigoBoleto;  // Inicializa o código do boleto
    }

    // Método para obter o método de pagamento (nesse caso, 'Boleto')
    @Override
    public String getMetodoPagamento() {
        return "Boleto";  // Retorna o tipo de pagamento
    }

    // Método para acessar o código do boleto, caso precise dele em algum outro lugar
    public String getCodigoBoleto() {
        return codigoBoleto;
    }
}



