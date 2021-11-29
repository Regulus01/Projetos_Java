package classes.cliente;

import javax.swing.JOptionPane;

import principal.Principal;



public class PessoaFisica extends Pessoa{
	private String cpf;
	

	public String getCpf() {
		return cpf;
	}
	
	public void cadastrarPessoaF(String nome, String endereco, String dataNascimento,
			String status, String cpf) {
		PessoaFisica novaPessoa = new PessoaFisica();
		novaPessoa.nome = nome;
		novaPessoa.endereco = endereco;
		novaPessoa.dataNascimento = dataNascimento;
		novaPessoa.status = status;
		dataCadastro();
		novaPessoa.dataCadastro = this.dataCadastro;
		novaPessoa.cpf = cpf;
		Principal.pessoasFisica.add(novaPessoa);
		
	}
	public void exibirPessoaF(String cpf) {
		for (PessoaFisica pessoa : Principal.pessoasFisica) {
			if (pessoa.getCpf().equals(cpf)) {
				JOptionPane.showMessageDialog(null, "Cpf: " + pessoa.getCpf() 
						+ "\nNome: " + pessoa.getNome()
						+ "\nData Nascimento: " + pessoa.getDataNascimento() 
						+ "\nEndereco: " + pessoa.getEndereco()
						+ "\n\nStatus: " + pessoa.getStatus()
						+ "\n\nData Cadastro: " + pessoa.getDataCadastro());		
			} 
	}		
	
	}
	
	public boolean verificarCpf(String cpf) {
		for (PessoaFisica pessoa : Principal.pessoasFisica) {
			if (pessoa.getCpf().equals(cpf)) {

				return false;
			} 
	}
			return true;
		
		
	}

}
