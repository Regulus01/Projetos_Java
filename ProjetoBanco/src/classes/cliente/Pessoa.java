package classes.cliente;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Pessoa {
	protected String nome;
	protected String endereco;
	protected String dataNascimento;
	protected String dataCadastro;
	protected String status;

	
	public String getNome() {
		return nome;
	}


	public String getEndereco() {
		return endereco;
	}


	public String getDataNascimento() {
		return dataNascimento;
	}


	public String getDataCadastro() {
		return dataCadastro;
	}


	public String getStatus() {
		return status;
	}


	public void dataCadastro() {
		Calendar hoje = new GregorianCalendar();			
		this.dataCadastro = String.format("%d/%d/%d",
			hoje.get(Calendar.DAY_OF_MONTH), hoje.get(Calendar.MONTH)+1, 
			hoje.get(Calendar.YEAR));
		}
}
