package models;

public class PagamentoCartaoCredito extends Pagamento {
    private String numeroCartao;
    private String nomeTitular;
    private int mesValidade;
    private int anoValidade;

    // Construtor da classe PagamentoCartaoCredito
    public PagamentoCartaoCredito(double valor, String numeroCartao, String nomeTitular, int mesValidade, int anoValidade) {
        super(valor);  // Chama o construtor da classe pai (Pagamento), passando o valor do pagamento
        this.numeroCartao = numeroCartao;
        this.nomeTitular = nomeTitular;
        this.mesValidade = mesValidade;
        this.anoValidade = anoValidade;
    }

	public String getNumeroCartao() {
		return numeroCartao;
	}

	public void setNumeroCartao(String numeroCartao) {
		this.numeroCartao = numeroCartao;
	}

	public String getNomeTitular() {
		return nomeTitular;
	}

	public void setNomeTitular(String nomeTitular) {
		this.nomeTitular = nomeTitular;
	}

	public int getMesValidade() {
		return mesValidade;
	}

	public void setMesValidade(int mesValidade) {
		this.mesValidade = mesValidade;
	}

	public int getAnoValidade() {
		return anoValidade;
	}

	public void setAnoValidade(int anoValidade) {
		this.anoValidade = anoValidade;
	}

	// Implementação do método getMetodoPagamento, retornando "Cartão de Crédito"
    @Override
    public String getMetodoPagamento() {
        return "Cartão de Crédito";  // Retorna o tipo de pagamento
    }
    
}



