package classes.banco;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JOptionPane;

import principal.Principal;



public class Agencia {
	private String codBanco;
	private String codAgencia;
	private String cnpj;
	private String nome;
	private String dataAbertura;
	private String endereco;
	private String gerente;


	public void cadastrarAgencia(String codBanco, String codAgencia, String cnpj,
			String nome, String endereco, String gerente) {
		Agencia novaAgencia = new Agencia();
		novaAgencia.codBanco = codBanco;
		novaAgencia.codAgencia = codAgencia;
		novaAgencia.cnpj = cnpj;
		novaAgencia.nome = nome;
		novaAgencia.endereco = endereco;
		novaAgencia.gerente = gerente;
		dataCadastro();
		novaAgencia.gerente = this.dataAbertura;
		Principal.agenciaCadastradas.add(novaAgencia);
		
	}
	public void consultarAgencia(String codigo) {
		for (Agencia agencia : Principal.agenciaCadastradas) {
			if (agencia.getCodAgencia().equals(codigo)) {
				JOptionPane.showMessageDialog(null, "Cod Banco: " 
						+ agencia.getCodBanco() 
						+ "\nCod Agencia: " + agencia.getCodAgencia()
						+ "\nCnpj: " + agencia.getCnpj() 
						+ "\nNome: " + agencia.getNome()
						+ "\nData Abertura: " + agencia.getDataAbertura()
						+ "\nEndereco: " + agencia.getEndereco()
						+ "\nGerente: R$ " + agencia.getGerente()
						+ "\n\nData Abertura: " + agencia.getDataAbertura());		
			} 

		}
	}
	
	public String getCodBanco() {
		return codBanco;
	}

	public String getCodAgencia() {
		return codAgencia;
	}

	public String getCnpj() {
		return cnpj;
	}

	public String getNome() {
		return nome;
	}

	public String getDataAbertura() {
		return dataAbertura;
	}

	public String getEndereco() {
		return endereco;
	}

	public String getGerente() {
		return gerente;
	}

	public void dataCadastro() {
		Calendar hoje = new GregorianCalendar();			
		this.dataAbertura = String.format("%d/%d/%d",
			hoje.get(Calendar.DAY_OF_MONTH), hoje.get(Calendar.MONTH)+1, 
			hoje.get(Calendar.YEAR));
		}
	
	
}
