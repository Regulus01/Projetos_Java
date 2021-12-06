package me1Unidade;

import java.util.Calendar;
import java.util.GregorianCalendar;


public class Medico {
	String cpf;
	int crm;
	String nome;
	String dataNa;
	Boolean ativoInativo = true;
	String DataCadastro;
	
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public int getCrm() {
		return crm;
	}
	public void setCrm(int crm) {
		this.crm = crm;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDataNa() {
		return dataNa;
	}
	public void setDataNa(String dataNa) {
		this.dataNa = dataNa;
	}
    
	public Boolean getAtivoInativo() {
		return ativoInativo;
	}

	public void setAtivoInativo(Boolean ativoInativo) {
		this.ativoInativo = ativoInativo;
	}
	public String getDataCadastro() {
		return this.DataCadastro;
	}
	public void dataCadastro() {
		Calendar hoje = new GregorianCalendar();			
		this.DataCadastro = String.format("%d/%d/%d",
			hoje.get(Calendar.DAY_OF_MONTH), hoje.get(Calendar.MONTH)+1, 
			hoje.get(Calendar.YEAR));
	}
	
}
