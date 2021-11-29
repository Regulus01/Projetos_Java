package classes.funcionarios;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JOptionPane;

import principal.Principal;



public class Funcionario {
	private String cpf;
	private String nome;
	private String dataNascimento;
	private String endereco;
	private String dataCadastro;
	private String status;
	private double salario;
	private String cargo;
	
	public void cadastroFuncionario(String cpf, String nome, String dataNasc,
			String endereco, String status, double salario, String cargo) {
		Funcionario Func = new Funcionario();
		
		Func.cpf = cpf;
		Func.nome = nome;
		Func.dataNascimento = dataNasc;
		Func.endereco = endereco;
		dataCadastro();
		Func.dataCadastro = dataCadastro;
		Func.endereco = endereco;
		Func.status = status;
		Func.salario = salario;
		Func.cargo = cargo;
		Principal.FuncionariosCadastro.add(Func);
		
	}
	
	public String getCpf() {
		return cpf;
	}

	public void dataCadastro() {
		Calendar hoje = new GregorianCalendar();			
		this.dataCadastro = String.format("%d/%d/%d",
			hoje.get(Calendar.DAY_OF_MONTH), hoje.get(Calendar.MONTH)+1, 
			hoje.get(Calendar.YEAR));
		}
	
	public static boolean verificarCpf(String Cpf) {	
			for (Funcionario funcionario : Principal.FuncionariosCadastro) {
				if (funcionario.getCpf().equals(Cpf)) {

					return false;
				} 
		}
				return true;
			
				
	}
	
	public void consultarFuncionario(String cpf) {
		for (Funcionario funcionario : Principal.FuncionariosCadastro) {
			if (funcionario.getCpf().equals(cpf)) {
				JOptionPane.showMessageDialog(null, "Cpf: " + funcionario.getCpf() 
						+ "\nNome: " + funcionario.getNome()
						+ "\nData Nascimento: " + funcionario.getDataNascimento() 
						+ "\nEndereco: " + funcionario.getEndereco()
						+ "\nStatus: " + funcionario.getStatus()
						+ "\nCargo: " + funcionario.getCargo()
						+ "\nSalario: R$ " + funcionario.getSalario()
						+ "\n\nData Cadastro: " + funcionario.getDataCadastro());		
			} 

		}
	}
	
	public void alterarSalario(double Salario, String cpf) {

		for(Funcionario func: Principal.FuncionariosCadastro) {
			if(func.getCpf().equals(cpf)) {
				func.setSalario(Salario);
				JOptionPane.showMessageDialog(null, "Salario Alterado");
				break;
			}
		}
				
	}
	
	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public String getNome() {
		return nome;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public String getDataCadastro() {
		return dataCadastro;
	}

	public String getCargo() {
		return cargo;
	}
}
