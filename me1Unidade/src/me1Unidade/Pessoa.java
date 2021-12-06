package me1Unidade;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Pessoa {
	String cpf;
	String nome;
	String dataNa;
	String dataCa;
	
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
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
	public String getDataCa() {
		return dataCa;
	}
	public void setDataCa(String dataCa) {
		this.dataCa = dataCa;
	}
	public void DataCa() {
	Calendar hoje = new GregorianCalendar();			
	this.dataCa = String.format("%d/%d/%d",
		hoje.get(Calendar.DAY_OF_MONTH), hoje.get(Calendar.MONTH)+1, 
		hoje.get(Calendar.YEAR));
	}
}

