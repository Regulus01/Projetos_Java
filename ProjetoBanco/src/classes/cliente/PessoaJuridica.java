package classes.cliente;

import javax.swing.JOptionPane;

import principal.Principal;

public class PessoaJuridica extends Pessoa{
	private String cnpj;
	private int incricaoEstadual;
	

	public String getCnpj() {
		return cnpj;
	}
	
	public void cadastrarPessoaJ(String nome, String endereco, String dataNascimento,
			String status, String cnpj, int incricaoEstadual) {
		PessoaJuridica novaPessoa = new PessoaJuridica();
		novaPessoa.nome = nome;
		novaPessoa.endereco = endereco;
		novaPessoa.dataNascimento = dataNascimento;
		novaPessoa.status = status;
		dataCadastro();
		novaPessoa.dataCadastro = this.dataCadastro;
		novaPessoa.cnpj = cnpj;
		novaPessoa.incricaoEstadual = incricaoEstadual;
		Principal.pessoasJuridica.add(novaPessoa);
		
	}
	public int getIncricaoEstadual() {
		return incricaoEstadual;
	}

	public void exibirPessoaJ(String cpf) {
		for (PessoaJuridica pessoa : Principal.pessoasJuridica) {
			if (pessoa.getCnpj().equals(cpf)) {
				JOptionPane.showMessageDialog(null, "Cnpj: " + pessoa.getCnpj()
						+ "\nIncrição Estadual: " + pessoa.getIncricaoEstadual()
						+ "\nNome: " + pessoa.getNome()
						+ "\nData Nascimento: " + pessoa.getDataNascimento() 
						+ "\nEndereco: " + pessoa.getEndereco()
						+ "\n\nStatus: " + pessoa.getStatus()
						+ "\n\nData Cadastro: " + pessoa.getDataCadastro());		
			} 
	}		
	
	}
	
	public boolean verificarCnpj(String cnpj) {
		for (PessoaJuridica pessoa : Principal.pessoasJuridica) {
			if (pessoa.getCnpj().equals(cnpj)) {

				return false;
			} 
	}
			return true;
			
		
	}
}
