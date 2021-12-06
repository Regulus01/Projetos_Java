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
import main.Main;
import sons.Sons;

@SuppressWarnings("serial")
public class CancelarConsulta extends JFrame {
	
	private JButton btConfirmar = new JButton();

	private JTextField boxCpf = new JTextField();

	private JTextField boxCrm = new JTextField();

	private JTextField boxDataConsulta = new JTextField();

	private JTextField boxHorarioConsulta = new JTextField();
	
	private JLabel Background;
	
	public CancelarConsulta() {

		this.setTitle("Cancelar Consulta");
		setSize(700, 600);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);

		btConfirmar.setBounds(275, 450, 150, 50);
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

		getContentPane().add(boxHorarioConsulta);
		boxHorarioConsulta.setBounds(290, 350, 120, 25);
		boxHorarioConsulta.setHorizontalAlignment(JLabel.CENTER);

		btConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				Sons.playAudioClick();
				boolean confirm = true;
				for (ConsultaMedica cancelarConsulta : Main.consultasCadastradas) {
					if (Integer.parseInt(boxCrm.getText()) == cancelarConsulta.getCrmMedico()
							&& boxCpf.getText().equals(cancelarConsulta.getCpfPaciente())
							&& boxDataConsulta.getText().equals(cancelarConsulta.getDataConsulta())
							&& boxHorarioConsulta.getText().equals(cancelarConsulta.getHorarioConsulta())
							&& cancelarConsulta.getStatusConsulta().equals("Agendada")) {
						cancelarConsulta.setStatusConsulta("Cancelada");
						JOptionPane.showMessageDialog(null, "Consulta Cancelada com sucesso");
						confirm = false;
					}
				}
				if(confirm) {
					JOptionPane.showMessageDialog(null, "Não há consultas com esse dados, revise os textos");
				}
				

			}
		});
		
		Background = new JLabel();
		Background.setIcon(new ImageIcon(getClass().getResource("bkCancelamento.png")));
		getContentPane().add(Background);
		Background.setBounds(0, -20, 700, 600);
	}
}
