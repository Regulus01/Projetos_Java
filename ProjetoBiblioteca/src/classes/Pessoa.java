package classes;

public class Pessoa {
	private String Cpf;
	private String Nome;
	private String Endereco;
	private int totalEmprestimo = 0;
	
	public int getTotalEmprestimo() {
		return totalEmprestimo;
	}
	public void setTotalEmprestimo(int totalEmprestimo) {
		this.totalEmprestimo = totalEmprestimo;
	}
	public String getCpf() {
		return Cpf;
	}
	public void setCpf(String cpf) {
		Cpf = cpf;
	}
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}
	public String getEndereco() {
		return Endereco;
	}
	public void setEndereco(String endereco) {
		Endereco = endereco;
	}


}
