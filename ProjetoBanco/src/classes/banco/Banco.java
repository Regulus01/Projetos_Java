package classes.banco;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JOptionPane;

import principal.Principal;

public class Banco {

	private String codigo;
	private String cnpj;
	private String nome;
	private String dataCadastro;


	public String getDataCadastro() {
		return dataCadastro;
	}

	public void cadastrarBanco(String codigo, String cnpj, String nome) {
		Banco novoBanco = new Banco();
		novoBanco.codigo = codigo;
		novoBanco.nome = nome;
		novoBanco.cnpj = cnpj;
		dataCadastro();
		novoBanco.dataCadastro = this.dataCadastro;
		Principal.bancosCadastrados.add(novoBanco);
	}

	public void alterarBancoNome(String cnpj, String nome) {
		for (Banco banco : Principal.bancosCadastrados) {
			if (banco.getCnpj().equals(cnpj)) {
				banco.setNome(nome);
				break;
			}
		}

	}
	
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public void alterarBancoCodigo(String cnpj, String nome) {
		for (Banco banco : Principal.bancosCadastrados) {
			if (banco.getCnpj().equals(cnpj)) {
				banco.setCodigo(nome);
				break;
			}
		}

	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void consultarBancos(String cnpj) {
		for (Banco banco : Principal.bancosCadastrados) {
			if (banco.getCnpj().equals(cnpj)) {
				JOptionPane.showMessageDialog(null, "Cnpj: " + banco.getCnpj() 
						+ "\nCodigo: " + banco.getCodigo()
						+ "\nNome: " + banco.getNome() 
						+ "\nData de Cadastro: " + banco.getDataCadastro());		
			} 

		}
	}

	public String getCodigo() {
		return codigo;
	}


	public String getNome() {
		return nome;
	}

	public String getCnpj() {
		return cnpj;
	}
	
	public void dataCadastro() {
		Calendar hoje = new GregorianCalendar();			
		this.dataCadastro = String.format("%d/%d/%d",
			hoje.get(Calendar.DAY_OF_MONTH), hoje.get(Calendar.MONTH)+1, 
			hoje.get(Calendar.YEAR));
		}
	
	public boolean verificarBanco(String cnpj) {
		for (Banco banco : Principal.bancosCadastrados) {
			if (banco.getCnpj().equals(cnpj)) {

				return true;
			} 
	}
			return false;
		
	}
	
	public boolean verificarCodigo(String Codigo) {
		for (Banco banco : Principal.bancosCadastrados) {
			if (banco.getCodigo().equals(Codigo)) {
				return true;
			} 
	}
			return false;
		
	}

}
