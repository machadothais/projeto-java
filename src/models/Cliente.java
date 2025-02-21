package models;

public class Cliente extends Pessoa {
    private String endereco;

    public Cliente(String nome, String email, String endereco) {
        super(nome, email); 
        this.endereco = endereco;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    @Override
    public void exibirInformacoes() {
        System.out.println("Cliente: " + nome);
        System.out.println("Email: " + email);
        System.out.println("Endereço: " + endereco);
    }

	public String getNome() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getEmail() {
		// TODO Auto-generated method stub
		return null;
	}
}
