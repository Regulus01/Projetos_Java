package classes.pets;

import principal.Main;

public class Pets {
	private String codigoUnico;
	private String nome;
	private String apelido;
	private String sexo;
	private double peso;
	private int idadeAprox;
	private String tipoRacao;
	private double qntRacao;
	private String cpfAdotante;
	private String dataEntrada;
	
	public String getApelido() {
		return apelido;
	}
	public void setApelido(String apelido) {
		this.apelido = apelido;
	}

	private String dataSaida = null;
	public String getCodigoUnico() {
		return codigoUnico;
	}
	public void setCodigoUnico(String codigoUnico) {
		this.codigoUnico = codigoUnico;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public double getPeso() {
		return peso;
	}
	public void setPeso(double peso) {
		this.peso = peso;
	}
	public int getIdadeAprox() {
		return idadeAprox;
	}
	public void setIdadeAprox(int idadeAprox) {
		this.idadeAprox = idadeAprox;
	}
	public String getTipoRacao() {
		return tipoRacao;
	}
	public void setTipoRacao(String tipoRacao) {
		this.tipoRacao = tipoRacao;
	}
	public double getQntRacao() {
		return qntRacao;
	}
	public void setQntRacao(double qntRacao) {
		this.qntRacao = qntRacao;
	}
	public String getCpfAdotante() {
		return cpfAdotante;
	}
	public void setCpfAdotante(String cpfAdotante) {
		this.cpfAdotante = cpfAdotante;
	}
	public String getDataEntrada() {
		return dataEntrada;
	}
	public void setDataEntrada(String dataEntrada) {
		this.dataEntrada = dataEntrada;
	}
	public String getDataSaida() {
		return dataSaida;
	}
	public void setDataSaida(String dataSaida) {
		this.dataSaida = dataSaida;
	}
	
	public Boolean ConsultaPets(String codigo) {
		for (Pets consulta : Main.petsCadastrados) {
			if (consulta.getCodigoUnico().equals(codigo)) {
				
				return true;
			}
		}

		return false;
	}


}
