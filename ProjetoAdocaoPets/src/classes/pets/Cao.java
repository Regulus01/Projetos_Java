package classes.pets;

import javax.swing.JOptionPane;

import classes.funcoes.Funcoes;
import principal.Main;

public class Cao extends Pets{
	private String TipoPelagem;

	public String getTipoPelagem() {
		return TipoPelagem;
	}

	public void setTipoPelagem(String tipoPelagem) {
		TipoPelagem = tipoPelagem;
	}
	
	public void cadastroCaes(String codigoUnico, String nome,String apelido, String sexo, double peso, int idadeAprox,
			String tipoRacao, Double qntRacao, String Pelagem) {
		Cao novoPet = new Cao();
		novoPet.setCodigoUnico(codigoUnico);
		novoPet.setNome(nome);
		novoPet.setSexo(sexo);
		novoPet.setApelido(apelido);
		novoPet.setIdadeAprox(idadeAprox);
		novoPet.setPeso(peso);
		novoPet.setTipoRacao(tipoRacao);
		novoPet.setQntRacao(qntRacao);
		novoPet.setCpfAdotante("Sem Adotante");
		novoPet.setDataEntrada(Funcoes.dataAtual());
		novoPet.setTipoPelagem(Pelagem);
		Main.caesCadastrados.add(novoPet);
		
	}
	
	public void exibirInformacoes(String codigoUnico) {
		for(Cao consultarCao : Main.caesCadastrados) {
			if(consultarCao.getCodigoUnico().equals(codigoUnico)) {
			JOptionPane.showMessageDialog(null,"Tipo: Cão" 
										  +"\n\nCodigo do Pet: " + consultarCao.getCodigoUnico()
										  + "\nNome: " + consultarCao.getNome()
										  + "\nApelido: " + consultarCao.getApelido()
										  + "\nSexo: " + consultarCao.getSexo()
										  + "\nIdade: " + consultarCao.getIdadeAprox()
										  + "\nTipo Ração: " + consultarCao.getTipoRacao()
										  + "\nQuantidade de Ração: " + consultarCao.getQntRacao()
										  + "\nCpf do Adotante: " + consultarCao.getCpfAdotante()
										  + "\nData Entrada: " + consultarCao.getDataEntrada()
										  + "\nData Saída: " + consultarCao.getDataSaida()
										  + "\n\nPelagem: " + consultarCao.getTipoPelagem());
											
			}
		}

	}
	

}
