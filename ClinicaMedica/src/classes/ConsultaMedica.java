package classes;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import main.Main;

public class ConsultaMedica {
	private int codigoConsulta;
	private String dataConsulta;
	private String horarioConsulta;
	private int crmMedico;
	private String cpfPaciente;
	
	private String prontuarioAtendimento;
	private String prontuarioMedicacoes;

	private String statusConsulta; // Agendada, Realizada, Cancelada

	public void cadastrarConsulta(int codigoConsulta, String dataConsulta, String horarioConsulta, int crmMedico,
			String cpfPaciente, String statusConsulta) {
		
		this.codigoConsulta = codigoConsulta;
		this.dataConsulta = dataConsulta;
		this.horarioConsulta = horarioConsulta;
		this.crmMedico = crmMedico;
		this.cpfPaciente = cpfPaciente;
		this.statusConsulta = statusConsulta;
	}

	public static boolean verificarHorario(int crm, String dataConsulta, String horarioConsulta, String status) {
		for (ConsultaMedica consultaAgendada : Main.consultasCadastradas) {
			if (consultaAgendada.getCrmMedico() == crm && consultaAgendada.dataConsulta.equals(dataConsulta)
					&& consultaAgendada.getStatusConsulta().equals("Agendada") && 
					consultaAgendada.getHorarioConsulta().equals(horarioConsulta)) {
				return true;
			}

		}
		return false;
	}

	public static void consultarHorarios(String dataConsulta, int crm) {
		ArrayList<String> horariosManha = new ArrayList<>();
		horariosManha.add("8");
		horariosManha.add("9");
		horariosManha.add("10");
		horariosManha.add("11");
		horariosManha.add("12");
		ArrayList<String> horariosTarde = new ArrayList<>();
		horariosTarde.add("14");
		horariosTarde.add("15");
		horariosTarde.add("16");
		horariosTarde.add("17");
		horariosTarde.add("18");
		
		boolean confirm = true;
		for (ConsultaMedica consultaAgendada : Main.consultasCadastradas) {
			if (consultaAgendada.dataConsulta.equals(dataConsulta)
					&& consultaAgendada.getStatusConsulta().equals("Agendada") && 
					consultaAgendada.getCrmMedico() == crm) {
					if(Integer.parseInt(consultaAgendada.getHorarioConsulta()) >= 8 
							&& Integer.parseInt(consultaAgendada.getHorarioConsulta()) <= 12) {
					horariosManha.remove(consultaAgendada.getHorarioConsulta());
					confirm = false;
					}
					else {
					horariosTarde.remove(consultaAgendada.getHorarioConsulta());
					confirm = false;
					}
			}
			
		}
		if(confirm) {
			JOptionPane.showMessageDialog(null, "O CRM informado não está cadastrado ou não existe");
		}
		else {
			JOptionPane.showMessageDialog(null, "Data: " + dataConsulta + 
					"\n\nHorários manhã: " + horariosManha
					+ "\n\nHorários Tarde: " + horariosTarde);
		}
	}

	// gets and setters
	public void setStatusConsulta(String statusConsulta) {
		this.statusConsulta = statusConsulta;
	}

	public String getDataConsulta() {
		return dataConsulta;
	}

	public String getHorarioConsulta() {
		return horarioConsulta;
	}

	public int getCrmMedico() {
		return crmMedico;
	}

	public String getStatusConsulta() {
		return statusConsulta;
	}

	public String getProntuarioMedicacoes() {
		return prontuarioMedicacoes;
	}

	public void setProntuarioMedicacoes(String prontuarioMedicacoes) {
		this.prontuarioMedicacoes = prontuarioMedicacoes;
	}
	
	public String getProntuarioAtendimento() {
		return prontuarioAtendimento;
	}

	public void setProntuarioAtendimento(String prontuario) {
		this.prontuarioAtendimento = prontuario;
	}
	
	
	public int getCodigoConsulta() {
		return codigoConsulta;
	}

	public String getCpfPaciente() {
		return cpfPaciente;
	}

}
