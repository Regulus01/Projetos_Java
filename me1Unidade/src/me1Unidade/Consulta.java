package me1Unidade;


public class Consulta extends Pessoa {
	int numeroDaConsulta;
	int crmDoutor; 
	String doutor;
	String dataConsulta;
	String horarioConsulta;
	Boolean consultaRetorno = false;
	String statusConsulta;
	double valorConsulta = 0.0;
	
	public int getCrmDoutor() {
		return crmDoutor;
	}
	public void setCrmDoutor(int crmDoutor) {
		this.crmDoutor = crmDoutor;
	}
	public String getDataConsulta() {
		return dataConsulta;
	}
	public void setDataConsulta(String dataConsulta) {
		this.dataConsulta = dataConsulta;
	}
	public String getHorarioConsulta() {
		return horarioConsulta;
	}
	public void setHorarioConsulta(String horarioConsulta) {
		this.horarioConsulta = horarioConsulta;
	}
	public Boolean getConsultaRetorno() {
		return consultaRetorno;
	}
	public void setConsultaRetorno(Boolean consultaRetorno) {
		this.consultaRetorno = consultaRetorno;
	}
	public String getStatusConsulta() {
		return statusConsulta;
	}
	public void setStatusConsulta(String statusConsulta) {
		this.statusConsulta = statusConsulta;
	}
	public double getValorConsulta() {
		return valorConsulta;
	}
	public void setValorConsulta(double valorConsulta) {
		this.valorConsulta = valorConsulta;
	}
	public int getNumeroDaConsulta() {
		return numeroDaConsulta;
	}
	public void setNumeroDaConsulta(int numeroDaConsulta) {
		this.numeroDaConsulta = numeroDaConsulta;
	}
	
	public String getDoutor() {
		return doutor;
	}
	public void setDoutor(String doutor) {
		this.doutor = doutor;
	}

}
