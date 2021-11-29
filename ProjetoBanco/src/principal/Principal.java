package principal;

import java.util.ArrayList;

import classes.banco.Agencia;
import classes.banco.Banco;
import classes.cliente.PessoaFisica;
import classes.cliente.PessoaJuridica;
import classes.funcionarios.Funcionario;
import sons.SomClick;
import telaPrincipal.TelaMenuPrincipal;

public class Principal {
	
	public static ArrayList<PessoaFisica> pessoasFisica = new ArrayList<>();
	public static ArrayList<PessoaJuridica> pessoasJuridica = new ArrayList<>();
	public static ArrayList<Funcionario> FuncionariosCadastro = new ArrayList<>();
	public static ArrayList<Agencia> agenciaCadastradas = new ArrayList<>();
	public static ArrayList<Banco> bancosCadastrados = new ArrayList<>();
	
	public static void main(String[] args) {
		SomClick.AudioOpenProgram();
		TelaMenuPrincipal Menu = new TelaMenuPrincipal();
		Menu.setVisible(true);
		
	}

}
