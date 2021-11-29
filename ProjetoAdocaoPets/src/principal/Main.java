package principal;

import java.util.ArrayList;

import classes.adotantes.Pessoa;
import classes.pets.Cao;
import classes.pets.Gato;
import classes.pets.Passaro;
import classes.pets.Pets;
import telas.menuPrincipal.TelaMenuPrincipal;

public class Main {
	
	public static ArrayList<Pessoa> pessoasCadastradas = new ArrayList<>();
	public static ArrayList<Pets> petsCadastrados = new ArrayList<>();
	public static ArrayList<Gato> gatosCadastrados = new ArrayList<>();
	public static ArrayList<Cao> caesCadastrados = new ArrayList<>();
	public static ArrayList<Passaro> passarosCadastrados = new ArrayList<>();
	
	public static void main(String[] args) {
		TelaMenuPrincipal telaInicial = new TelaMenuPrincipal();
		telaInicial.setVisible(true);
	
	}
}
