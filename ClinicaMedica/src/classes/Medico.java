package classes;

import javax.swing.JOptionPane;

import main.Main;

public class Medico extends Pessoa {
	private int crm;
	private boolean status;

	public void cadastrar(String cpf, String nome, String endereco, int crm, boolean status) {
		super.cadastrar(cpf, nome, endereco);
		this.crm = crm;
		this.status = status;
	}

	public int getCrm() {
		return crm;
	}

	public boolean getStatus() {
		return status;
	}

	public static boolean consultarCpf(String cpf) {
		for (Medico cpfConsulta : Main.medicosCadastrados) {
			if (cpfConsulta.getCpf().equals(cpf.strip())) {
				return true;
			}
		}
		return false;
	}

	public static boolean consultarCrm(int crm) {
		for (Medico crmConsulta : Main.medicosCadastrados) {
			if (crmConsulta.getCrm() == crm) {
				return true;
			}
		}
		return false;
	}

	public static boolean medicoAtivo(int crm) {
		for (Medico crmConsulta : Main.medicosCadastrados) {
			if (crmConsulta.getCrm() == crm) {
				if (crmConsulta.getStatus() == true) {
					return true;
				}

			}
		}
		return false;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public void consultarMedico(int crm) {
		boolean confirm = true;
		for (Medico consulta : Main.medicosCadastrados) {
			if (consulta.getCrm() == crm) {
				JOptionPane.showMessageDialog(null, "              Ficha do Médico" + "\n\nCrm: " + consulta.getCrm()
						+ "\n\nCpf: " + consulta.getCpf() + "\nNome: " + consulta.getNome() + "\nEndereço: "
						+ consulta.getEndereco() + "\n\nStatus: " + (consulta.getStatus() ? "Ativo" : "Inativo"));
				confirm = false;

			}
		}
		if (confirm) {
			JOptionPane.showMessageDialog(null, "Médico não possui cadastro");
		}

	}

}
