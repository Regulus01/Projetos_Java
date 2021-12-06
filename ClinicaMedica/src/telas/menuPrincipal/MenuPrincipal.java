package telas.menuPrincipal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import classes.ConsultaMedica;
import classes.Pessoa;
import main.Main;
import sons.Sons;
import telas.menuConsulta.MenuConsulta;
import telas.menuMedico.MenuMedico;
import telas.menuPaciente.MenuPaciente;
import telas.menuProntuario.MenuProntuario;

@SuppressWarnings("serial")
public class MenuPrincipal extends JFrame {
	private JLabel Background;
	private JButton btMedico = new JButton();
	private JButton btPaciente = new JButton();
	private JButton btConsulta = new JButton();
	private JButton btProntuario = new JButton();
	private JButton btRelatorio = new JButton();

	public MenuPrincipal() {
		this.setTitle("Menu Principal");
		setSize(900, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		getContentPane().add(btMedico);
		btMedico.setIcon(new ImageIcon(getClass().getResource("btMenuMedico.png")));
		btMedico.setBounds(650, 50, 150, 50);

		getContentPane().add(btPaciente);
		btPaciente.setIcon(new ImageIcon(getClass().getResource("btMenuPaciente.png")));
		btPaciente.setBounds(650, 120, 150, 50);

		getContentPane().add(btConsulta);
		btConsulta.setIcon(new ImageIcon(getClass().getResource("btMenuConsulta.png")));
		btConsulta.setBounds(650, 190, 150, 50);

		getContentPane().add(btProntuario);
		btProntuario.setIcon(new ImageIcon(getClass().getResource("btMenuProntuario.png")));
		btProntuario.setBounds(650, 260, 150, 50);

		getContentPane().add(btRelatorio);
		btRelatorio.setIcon(new ImageIcon(getClass().getResource("btRelatorioConsultas.png")));
		btRelatorio.setBounds(650, 330, 150, 50);

		btMedico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				Sons.playAudioClick();
				MenuMedico telaMenuMedico = new MenuMedico();
				telaMenuMedico.setVisible(true);

			}
		});

		btPaciente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				Sons.playAudioClick();
				MenuPaciente telaMenuPaciente = new MenuPaciente();
				telaMenuPaciente.setVisible(true);

			}
		});

		btConsulta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				Sons.playAudioClick();
				MenuConsulta telaMenuConsulta = new MenuConsulta();
				telaMenuConsulta.setVisible(true);

			}
		});

		btProntuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				Sons.playAudioClick();
				MenuProntuario telaMenuProntuario = new MenuProntuario();
				telaMenuProntuario.setVisible(true);

			}
		});

		btRelatorio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				Sons.playAudioClick();
				String data = JOptionPane.showInputDialog("Data");
				String crm = JOptionPane.showInputDialog("Crm");
				boolean confirm = true;
				for (ConsultaMedica consulta : Main.consultasCadastradas) {
					if (consulta.getDataConsulta().equals(data)
							&& consulta.getCrmMedico() == (Integer.parseInt(crm.strip()))
							&& (consulta.getStatusConsulta().equals("Agendada")
									|| consulta.getStatusConsulta().equals("Realizada"))) {
						String nomePaciente = "";
						for (Pessoa nomePessoa : Main.pessoasCadastradas) {
							if (nomePessoa.getCpf().equals(consulta.getCpfPaciente())) {
								nomePaciente = nomePessoa.getNome();
								break;
							}
						}
						JOptionPane.showMessageDialog(null, "Consulta N: " + consulta.getCodigoConsulta()
								+ "\n\nCpf do paciente: " + consulta.getCpfPaciente() + "\nNome do paciente: "
								+ nomePaciente + "\n\nData: " + consulta.getDataConsulta() + "\nHorario: "
								+ consulta.getHorarioConsulta() + "\n\nStatus: " + consulta.getStatusConsulta());
						confirm = false;
					}

				}
				if (confirm) {
					JOptionPane.showMessageDialog(null, "Crm ou data errados, digite novamente");
				}

			}
		});

		Background = new JLabel();
		Background.setIcon(new ImageIcon(getClass().getResource("bkMenuPrincipal.png")));
		getContentPane().add(Background);
		Background.setBounds(0, 0, 1000, 700);

	}

}
