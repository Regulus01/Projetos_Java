package telas.menuConsulta;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import classes.ConsultaMedica;
import classes.Medico;
import classes.Pessoa;
import main.Main;
import sons.Sons;

@SuppressWarnings("serial")
public class CadastroConsulta extends JFrame {

	private JButton btConfirmar = new JButton();

	private JTextField boxCpf = new JTextField();

	private JTextField boxCrm = new JTextField();

	private JTextField boxDataConsulta = new JTextField();
	
	private JLabel Background;

	public CadastroConsulta() {

		this.setTitle("Cadastro Consulta");
		setSize(700, 500);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);

		btConfirmar.setBounds(275, 350, 150, 50);
		btConfirmar.setIcon(new ImageIcon(getClass().getResource("btConfirmar.png")));
		this.add(btConfirmar);

		getContentPane().add(boxCrm);
		boxCrm.setBounds(290, 80, 120, 25);
		boxCrm.setHorizontalAlignment(JLabel.CENTER);

		getContentPane().add(boxCpf);
		boxCpf.setBounds(290, 170, 120, 25);
		boxCpf.setHorizontalAlignment(JLabel.CENTER);

		getContentPane().add(boxDataConsulta);
		boxDataConsulta.setBounds(290, 260, 120, 25);
		boxDataConsulta.setHorizontalAlignment(JLabel.CENTER);

		btConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				Sons.playAudioClick();
				boolean cpfPacienteExistente = Pessoa.consultarCpf(boxCpf.getText().strip());
				boolean crmMedicoExistente = Medico.consultarCrm(Integer.parseInt(boxCrm.getText().strip()));
				boolean medicoAtivo = Medico.medicoAtivo(Integer.parseInt(boxCrm.getText().strip()));
				ConsultaMedica novaConsulta = new ConsultaMedica();
				if (medicoAtivo && crmMedicoExistente && cpfPacienteExistente) {
					Object[] options = { "Manhã", "Tarde" };
					int escolha = JOptionPane.showOptionDialog(null, "", "Selecione o turno da consulta",
							JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
					if (escolha == 0) {
						Object[] optionsTurno1 = { "8", "9", "10", "11", "12" };
						int escolhaTurno1 = JOptionPane.showOptionDialog(null, "", "Selecione o horário consulta",
								JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, optionsTurno1,
								optionsTurno1[0]);
						
						if (ConsultaMedica.verificarHorario(Integer.parseInt(boxCrm.getText()),
								boxDataConsulta.getText(), (String) optionsTurno1[escolhaTurno1], "Agendada")) {
							JOptionPane.showMessageDialog(null,"Existe uma consulta marcada nesse horário" 
														+ "selecione outro horário");

						} else {
							novaConsulta.cadastrarConsulta(Main.contadorConsulta, boxDataConsulta.getText(),
									(String) optionsTurno1[escolhaTurno1], Integer.parseInt(boxCrm.getText()),
									boxCpf.getText(), "Agendada");
							Main.consultasCadastradas.add(novaConsulta);
							Main.contadorConsulta++;
				
							JOptionPane.showMessageDialog(null, "A consulta foi Agendada");
						}

					}

					else if (escolha == 1) {
						Object[] optionsTurno2 = { "14", "15", "16", "17", "18" };
						int escolhaTurno2 = JOptionPane.showOptionDialog(null, "", "Selecione o horário da consulta",
								JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, optionsTurno2,
								optionsTurno2[0]);
				
						if (ConsultaMedica.verificarHorario(Integer.parseInt(boxCrm.getText()),
								boxDataConsulta.getText(), (String) optionsTurno2[escolhaTurno2], "Agendada")) {
							JOptionPane.showMessageDialog(null,"Existe uma consulta marcada nesse horário" 
														+ "selecione outro horário");

						} else {
							novaConsulta.cadastrarConsulta(Main.contadorConsulta, boxDataConsulta.getText(),
									(String) optionsTurno2[escolhaTurno2], Integer.parseInt(boxCrm.getText()),
									boxCpf.getText(), "Agendada");
							Main.consultasCadastradas.add(novaConsulta);
							Main.contadorConsulta++;
						
							JOptionPane.showMessageDialog(null, "A consulta foi Agendada");
						}
					}

				}

				if (!medicoAtivo) {
					JOptionPane.showMessageDialog(null, "O medico está inativo, escolha outro Médico");
				}
				if (!crmMedicoExistente) {
					JOptionPane.showMessageDialog(null, "Crm do médico não está cadastrado");
				}
				if (!cpfPacienteExistente) {
					JOptionPane.showMessageDialog(null, "Cpf do paciente não possui cadastro");
				}
				System.out.println(cpfPacienteExistente);
				System.out.println(crmMedicoExistente);
			}
		});
		
		Background = new JLabel();
		Background.setIcon(new ImageIcon(getClass().getResource("bkCadastroConsulta.png")));
		getContentPane().add(Background);
		Background.setBounds(0, -110, 829, 680);
	}
}
