package classes.pets;

import javax.swing.JOptionPane;

import classes.funcoes.Funcoes;
import principal.Main;

public class Passaro extends Pets{
	private Boolean asasCortadas;

	public Boolean getAsasCortadas() {
		return asasCortadas;
	}

	public void setAsasCortadas(Boolean asasCortadas) {
		this.asasCortadas = asasCortadas;
	}
	
	public void cadastroPassaro(String codigoUnico, String nome,String apelido, String sexo, double peso, int idadeAprox,
			String tipoRacao, Double qntRacao, Boolean Asas) {
		Passaro novoPet = new Passaro();
		novoPet.setCodigoUnico(codigoUnico);
		novoPet.setNome(nome);
		novoPet.setSexo(sexo);
		novoPet.setApelido(apelido);
		novoPet.setIdadeAprox(idadeAprox);
		novoPet.setTipoRacao(tipoRacao);
		novoPet.setPeso(peso);
		novoPet.setQntRacao(qntRacao);
		novoPet.setCpfAdotante("Sem Adotante");
		novoPet.setDataEntrada(Funcoes.dataAtual());
		novoPet.setAsasCortadas(Asas);
		Main.passarosCadastrados.add(novoPet);
		
	}
	
	public void exibirInformacoes(String codigoUnico) {	
		for(Passaro consultarCao : Main.passarosCadastrados) {
			if(consultarCao.getCodigoUnico().equals(codigoUnico)) {
			JOptionPane.showMessageDialog(null, "Tipo: Pássaro"
										  + "\n\nCodigo do Pet: " + consultarCao.getCodigoUnico()
										  + "\nNome: " + consultarCao.getNome()
										  + "\nApelido: " + consultarCao.getApelido()
										  + "\nSexo: " + consultarCao.getSexo()
										  + "\nIdade: " + consultarCao.getIdadeAprox()
										  + "\nTipo Ração: " + consultarCao.getTipoRacao()
										  + "\nQuantidade de Ração: " + consultarCao.getQntRacao()
										  + "\nCpf do Adotante: " + consultarCao.getCpfAdotante()
										  + "\nData Entrada: " + consultarCao.getDataEntrada()
										  + "\nData Saída: " + consultarCao.getDataSaida()
										  + "\n\nAsas cortadas: " + (consultarCao.getAsasCortadas() ? "Sim" : "Não"));
										
			}
		}
	}

}
