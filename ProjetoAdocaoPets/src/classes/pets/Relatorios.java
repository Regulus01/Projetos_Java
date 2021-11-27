package classes.pets;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import principal.Main;

public class Relatorios {
	
	
	public void relatorioProvisoes() {
		double somaPequenoGatos = 0;
		double somaMedioGatos = 0;
		double somaGrandeGatos = 0;

		double somaPequenoCaes = 0;
		double somaMedioCaes = 0;
		double somaGrandeCaes = 0;

		double somaPequenoPassaros = 0;
		double somaMedioPassaros = 0;
		double somaGrandePassaros = 0;

		for (Gato provi : Main.gatosCadastrados) {
			if (provi.getCpfAdotante().equals("Sem Adotante")) {
				if (provi.getTipoRacao().equals("Pequeno porte")) {
					somaPequenoGatos += provi.getQntRacao();
				} else if (provi.getTipoRacao().equals("Medio porte")) {
					somaMedioGatos += provi.getQntRacao();
				} else if (provi.getTipoRacao().equals("Grande porte")) {
					somaGrandeGatos += provi.getQntRacao();
				}
			}
		}

		for (Cao provi : Main.caesCadastrados) {
			if (provi.getCpfAdotante().equals("Sem Adotante")) {
				if (provi.getTipoRacao().equals("Pequeno porte")) {
					somaPequenoCaes += provi.getQntRacao();
				} else if (provi.getTipoRacao().equals("Medio porte")) {
					somaMedioCaes += provi.getQntRacao();
				} else if (provi.getTipoRacao().equals("Grande porte")) {
					somaGrandeCaes += provi.getQntRacao();
				}
			}
		}

		for (Passaro provi : Main.passarosCadastrados) {
			if (provi.getCpfAdotante().equals("Sem Adotante")) {
				if (provi.getTipoRacao().equals("Pequeno porte")) {
					somaPequenoPassaros += provi.getQntRacao();
				} else if (provi.getTipoRacao().equals("Medio porte")) {
					somaMedioPassaros += provi.getQntRacao();
				} else if (provi.getTipoRacao().equals("Grande porte")) {
					somaGrandePassaros += provi.getQntRacao();
				}
			}
		}
		JOptionPane.showMessageDialog(null, "Relatório provisões" 
									 + "\n\nRações Gatos"
									 + "\n\nPequeno Porte: " + somaPequenoGatos
									 + "\nMedio Porte: " + somaMedioGatos
									 + "\nGrande Porte: " + somaGrandeGatos
									 + "\n\nRações Cães"
									 + "\n\nPequeno Porte: " + somaPequenoCaes
									 + "\nMedio Porte: " + somaMedioCaes
									 + "\nGrande Porte: " + somaGrandeCaes
									 + "\n\nRações Passaros"
									 + "\n\nPequeno Porte: " + somaPequenoPassaros
									 + "\nMedio Porte: " + somaMedioPassaros
									 + "\nGrande Porte: " + somaGrandePassaros);
	}
	
	
	public void petsSemAdotar() {
		ArrayList<String> pets = new ArrayList<>();
		
		for (Gato provi : Main.gatosCadastrados) {
			if (provi.getCpfAdotante().equals("Sem Adotante")) {
				pets.add(provi.getCodigoUnico());
			}
		}

		for (Cao provi : Main.caesCadastrados) {
			if (provi.getCpfAdotante().equals("Sem Adotante")) {
				pets.add(provi.getCodigoUnico());
			}
		}

		for (Passaro provi : Main.passarosCadastrados) {
			if (provi.getCpfAdotante().equals("Sem Adotante")) {
				pets.add(provi.getCodigoUnico());
			}
		}
		
	
		for(String petsAdo : pets) {
			JOptionPane.showMessageDialog(null, petsAdo);
			
		}
		
		if(pets.size() == 0) {
			JOptionPane.showMessageDialog(null, "Sem pets disponíveis para adoção");
		}
		
	}
}


	

