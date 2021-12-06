package main;

import java.util.ArrayList;

import classes.ConsultaMedica;
import classes.Medico;
import classes.Pessoa;
import telas.telaLogin.TelaLogin;

public class Main {
	
	public static int contadorConsulta = 1;
	public static ArrayList<Medico> medicosCadastrados = new ArrayList<>();
	public static ArrayList<Pessoa> pessoasCadastradas = new ArrayList<>();
	public static ArrayList<ConsultaMedica> consultasCadastradas = new ArrayList<>();
	public static void main(String[] args) {
		TelaLogin Login = new TelaLogin();
		Login.setVisible(true);

	}
}
