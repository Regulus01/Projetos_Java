package classes;

public class Emprestimo extends Livros{
	private String Cpf;
	private String nome;
	private String dataInicio;
	private String dataFim;
	private String dataDevolucao;
	private boolean andamento = false;
	
	public String getCpf() {
		return Cpf;
	}
	public void setCpf(String cpf) {
		Cpf = cpf;
	}
	public String getDataInicio() {
		return dataInicio;
	}
	public void setDataInicio(String dataInicio) {
		this.dataInicio = dataInicio;
	}
	public String getDataFim() {
		return dataFim;
	}
	public void setDataFim(String dataFim) {
		this.dataFim = dataFim;
	}
	public String getDataDevolucao() {
		return dataDevolucao;
	}
	public void setDataDevolucao(String dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}
	public boolean isAndamento() {
		return andamento;
	}
	public void setAndamento(boolean andamento) {
		this.andamento = andamento;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
}
