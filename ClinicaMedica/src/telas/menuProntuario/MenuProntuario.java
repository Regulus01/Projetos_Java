package telas.menuProntuario;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import classes.ConsultaMedica;
import classes.Medico;
import classes.Pessoa;
import main.Main;
import sons.Sons;

@SuppressWarnings("serial")
public class MenuProntuario extends JFrame {

	private JButton btRegistro = new JButton();
	private JButton btConsulta = new JButton();

	JLabel Background;

	public MenuProntuario() {
		this.setTitle("Menu Prontuario");
		setBounds(1000, 500, 829, 680);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);

		btRegistro.setBounds(340, 120, 150, 50);
		btRegistro.setIcon(new ImageIcon(getClass().getResource("btRegistrar.png")));
		this.add(btRegistro);

		btConsulta.setBounds(340, 200, 150, 50);
		btConsulta.setIcon(new ImageIcon(getClass().getResource("btConsultar.png")));
		this.add(btConsulta);
		
		
		btRegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				Sons.playAudioClick();
				RegistrarProntuario telaMenuProntuario = new RegistrarProntuario();
				telaMenuProntuario.setVisible(true);
	
			}
		});
		
		
		btConsulta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				Sons.playAudioClick();
			
				String cpf = JOptionPane.showInputDialog("CPF");
				String crm = JOptionPane.showInputDialog("CRM");
				try {
				for(ConsultaMedica prontuario : Main.consultasCadastradas) {
					if(prontuario.getCrmMedico() == Integer.parseInt(crm) 
							&& prontuario.getCpfPaciente().equals(cpf) && !prontuario.getStatusConsulta().equals("Cancelada")) {
						JOptionPane.showMessageDialog(null, "Consulta Número: " + prontuario.getCodigoConsulta()
													 + "\n\nAtendimento: " + prontuario.getProntuarioAtendimento()
													 + "\n\nMedicamentos prescritos: " + prontuario.getProntuarioMedicacoes());
														
					}
				}
				if(!Pessoa.consultarCpf(cpf.strip())) {
					JOptionPane.showMessageDialog(null, "Cpf não cadastrado");
				}
				try {
				if(!Medico.consultarCrm(Integer.parseInt(crm.strip()))) {
					JOptionPane.showMessageDialog(null, "Crm não cadastrado");
				}
				}
				catch(NumberFormatException e)
				{
					JOptionPane.showMessageDialog(null, "Crm não cadastrado");
				}
				}
				catch(NullPointerException e) {
					JOptionPane.showMessageDialog(null, "Você precisa informar dados");
				}
			}
		});
		
		Background = new JLabel();
		Background.setIcon(new ImageIcon(getClass().getResource("bkMenuProntuario.png")));
		getContentPane().add(Background);
		Background.setBounds(0, -20, 829, 680);
	}
}
