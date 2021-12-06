package classes;

import javax.swing.JOptionPane;

import main.Main;

public class Pessoa {
	private String cpf;
	private String nome;
	private String endereco;
	
	public void cadastrar(String cpf, String nome, String endereco) {
		this.cpf = cpf;
		this.nome = nome;
		this.endereco = endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getCpf() {
		return cpf;
	}

	public String getNome() {
		return nome;
	}

	public String getEndereco() {
		return endereco;
	}

	
	public static boolean consultarCpf(String cpf) {
		for (Pessoa cpfConsulta : Main.pessoasCadastradas) {
			if (cpfConsulta.getCpf().equals(cpf.strip())) {
				return true;
			}
		}
		return false;
	}
	
	public static void consultarPaciente(String cpf) {
		boolean confirm = true;
		for (Pessoa consulta : Main.pessoasCadastradas) {
			if (consulta.getCpf().equals(cpf)) {
				JOptionPane.showMessageDialog(null, "              Ficha do Paciente"
											+ "\n\nCpf: " + consulta.getCpf()
											+ "\nNome: " + consulta.getNome()
											+ "\nEndereço: " + consulta.getEndereco());
											confirm = false;
											
			}
		}
		if(confirm) {
			JOptionPane.showMessageDialog(null, "O paciente não possui cadastro");
		}

	}
}
