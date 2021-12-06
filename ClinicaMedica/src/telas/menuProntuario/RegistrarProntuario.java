package telas.menuProntuario;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import classes.ConsultaMedica;
import main.Main;
import sons.Sons;

@SuppressWarnings("serial")
public class RegistrarProntuario extends JFrame {

	private JButton btConfirmar = new JButton();

	private JTextField boxCpf = new JTextField();

	private JTextField boxCrm = new JTextField();

	private JTextField boxData = new JTextField();

	private JTextField boxHorario = new JTextField();

	private JLabel Background;
	
	public RegistrarProntuario() {

		this.setTitle("Registro de Prontuario");
		setSize(700, 800);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);

		btConfirmar.setIcon(new ImageIcon(getClass().getResource("btConfirmar.png")));
		btConfirmar.setBounds(275, 630, 150, 50);
		this.add(btConfirmar);

		getContentPane().add(boxCrm);
		boxCrm.setBounds(290, 80, 120, 25);
		boxCrm.setHorizontalAlignment(JLabel.CENTER);

		getContentPane().add(boxCpf);
		boxCpf.setBounds(290, 170, 120, 25);
		boxCpf.setHorizontalAlignment(JLabel.CENTER);

		getContentPane().add(boxData);
		boxData.setBounds(220, 280, 280, 25);
		boxData.setHorizontalAlignment(JLabel.CENTER);

		getContentPane().add(boxHorario);
		boxHorario.setBounds(175, 390, 380, 25);
		boxHorario.setHorizontalAlignment(JLabel.CENTER);

		btConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				Sons.playAudioClick();
				boolean confirm = true;
				for (ConsultaMedica consulta : Main.consultasCadastradas) {
					if (consulta.getCpfPaciente().equals(boxCpf.getText().strip())
							&& consulta.getCrmMedico() == (Integer.parseInt(boxCrm.getText().strip()))
							&& consulta.getDataConsulta().equals(boxData.getText())
							&& consulta.getHorarioConsulta().equals(boxHorario.getText())
							&& consulta.getStatusConsulta().equals("Agendada")) {
						JOptionPane.showMessageDialog(null, "Consulta número: " + consulta.getCodigoConsulta());
						String atendimento = JOptionPane.showInputDialog("Atendimento");
						String medicamento = JOptionPane.showInputDialog("Medicamentos");
						consulta.setProntuarioAtendimento(atendimento);
						consulta.setProntuarioMedicacoes(medicamento);
						consulta.setStatusConsulta("Realizada");
						JOptionPane.showMessageDialog(null, "Consulta Finalizada com sucesso!");
						confirm = false;
					}
				}
				if(confirm) {
					JOptionPane.showMessageDialog(null, "Há campos com erro");
				}
				
			}
		});
		
		Background = new JLabel();
		Background.setIcon(new ImageIcon(getClass().getResource("bkCadastroProntuario.png")));
		getContentPane().add(Background);
		Background.setBounds(0, -20, 700, 800);
	}
}
