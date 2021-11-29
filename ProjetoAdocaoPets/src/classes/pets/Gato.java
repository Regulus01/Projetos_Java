package classes.pets;

import javax.swing.JOptionPane;

import classes.funcoes.Funcoes;
import principal.Main;

public class Gato extends Pets{
	private Boolean domesticado;

	public Boolean getDomesticado() {
		return domesticado;
	}

	public void setDomesticado(Boolean domesticado) {
		this.domesticado = domesticado;
	}
	
	public void cadastroGatos(String codigoUnico, String nome,String apelido, String sexo, double peso, int idadeAprox,
			String tipoRacao, Double qntRacao, Boolean domesticado) {
		Gato novoPet = new Gato();
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
		novoPet.setDomesticado(domesticado);
		Main.gatosCadastrados.add(novoPet);
		
	}
	
	public void exibirInformacoes(String codigoUnico) {
		for(Gato consultarGato : Main.gatosCadastrados) {
			if(consultarGato.getCodigoUnico().equals(codigoUnico)) {
			JOptionPane.showMessageDialog(null, "Tipo: Gato"
										  + "\n\nCodigo do Pet: " + consultarGato.getCodigoUnico()
										  + "\nNome: " + consultarGato.getNome()
										  + "\nApelido: " + consultarGato.getApelido()
										  + "\nSexo: " + consultarGato.getSexo()
										  + "\nIdade: " + consultarGato.getIdadeAprox()
										  + "\nTipo Ração: " + consultarGato.getTipoRacao()
										  + "\nQuantidade de Ração: " + consultarGato.getQntRacao()
										  + "\nCpf do Adotante: " + consultarGato.getCpfAdotante()
										  + "\nData Entrada: " + consultarGato.getDataEntrada()
										  + "\nData Saída: " + consultarGato.getDataSaida()
										  + "\n\nDomesticado: " + (consultarGato.getDomesticado() ? "Sim" : "Não"));
			}
		}


	}
	
	public Boolean ConsultaAdotantes(String codigo) {
		for (Gato consulta : Main.gatosCadastrados) {
			if (consulta.getCodigoUnico().equals(codigo)) {
				
				return true;
			}
		}

		return false;
	}
	

}
