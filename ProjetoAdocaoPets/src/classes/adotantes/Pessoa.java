package classes.adotantes;

import javax.swing.JOptionPane;

import classes.funcoes.Funcoes;
import principal.Main;

public class Pessoa {

	private String cpf;
	private String nome;
	private String endereco;
	private String telefone;
	private String dataCadastro;

	public void CadastroPessoas(String cpf, String nome, String endereco, String telefone) {
		Pessoa novaPessoa = new Pessoa();
		novaPessoa.cpf = cpf;
		novaPessoa.nome = nome;
		novaPessoa.endereco = endereco;
		novaPessoa.telefone = telefone;
		novaPessoa.dataCadastro = Funcoes.dataAtual();
		Main.pessoasCadastradas.add(novaPessoa);

	}

	public String getDataCadastro() {
		return dataCadastro;
	}

	public String getCpf() {
		return cpf;

	}

	public Boolean ConsultaAdotantes(String cpf) {
		for (Pessoa consulta : Main.pessoasCadastradas) {
			if (consulta.getCpf().equals(cpf)) {
				
				return true;
			}
		}

		return false;
	}

	public void RetornarInformacoes(String cpf) {
		for (Pessoa consulta : Main.pessoasCadastradas) {
			if (consulta.getCpf().equals(cpf)) {
				JOptionPane.showMessageDialog(null, "Cpf: " + consulta.getCpf()
				+ "\nNome: " + consulta.getNome()
				+ "\nCPF: " + consulta.getCpf()
				+ "\nEndereço: " + consulta.getEndereco()
				+ "\nTelefone: " + consulta.getTelefone()
				+ "\n\nData Cadastro: " + consulta.getDataCadastro());		
			}
	}

}

	public String getNome() {
		return nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public String getTelefone() {
		return telefone;
	}
	
}
