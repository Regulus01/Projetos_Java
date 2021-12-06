package telas.menuMedico;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import classes.Medico;
import main.Main;
import sons.Sons;

@SuppressWarnings("serial")
public class MenuMedico extends JFrame {
	private JButton btCadastro = new JButton();
	private JButton btConsulta = new JButton();
	private JButton btAlterar = new JButton();
	JLabel Background;

	public MenuMedico() {
		this.setTitle("Menu Medico");
		setBounds(1000, 500, 715, 642);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);

		btCadastro.setBounds(300, 100, 150, 50);
		btCadastro.setIcon(new ImageIcon(getClass().getResource("btCadastrar.png")));
		this.add(btCadastro);

		btConsulta.setBounds(300, 180, 150, 50);
		btConsulta.setIcon(new ImageIcon(getClass().getResource("btConsultar.png")));
		this.add(btConsulta);

		btAlterar.setBounds(300, 260, 150, 50);
		btAlterar.setIcon(new ImageIcon(getClass().getResource("btAlterar.png")));
		this.add(btAlterar);

		btCadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				Sons.playAudioClick();
				CadastroMedico telaCadastro = new CadastroMedico();
				telaCadastro.setVisible(true);

			}
		});

		btConsulta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				Sons.playAudioClick();
				String crm = JOptionPane.showInputDialog("Crm");
				Medico consultarMedico = new Medico();
				try {
					consultarMedico.consultarMedico(Integer.parseInt(crm.strip()));
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "Digite somente números");

				} catch (NullPointerException e) {
					System.out.println();
				}

			}
		});

		btAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				Sons.playAudioClick();
				Medico alterarMedico = new Medico();
				String crm = JOptionPane.showInputDialog("Crm");
				try {
					if (Medico.consultarCrm(Integer.parseInt(crm.strip()))) {
						alterarMedico.consultarMedico(Integer.parseInt(crm.strip()));
						Object[] options = { "Status", "Endereço" };
						int escolha = JOptionPane.showOptionDialog(null, "", "Alterar", JOptionPane.YES_NO_OPTION,
								JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
						if (escolha == 0) {
							for (Medico consulta : Main.medicosCadastrados) {
								if (consulta.getCrm() == Integer.parseInt(crm.strip())) {
									Object[] optionsStatus = { "Ativar", "Inativar" };
									int escolhaStatus = JOptionPane.showOptionDialog(null, "", "Status",
											JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,
											optionsStatus, options[0]);
									if (escolhaStatus == 0 && consulta.getStatus() == false) {
										consulta.setStatus(true);
										JOptionPane.showMessageDialog(null, "Médico Ativado");
									} else if (escolhaStatus == 1 && consulta.getStatus() == true) {
										consulta.setStatus(false);
										JOptionPane.showMessageDialog(null, "Médico Inativado");
									} else if (escolhaStatus == 0 && consulta.getStatus() == true) {
										JOptionPane.showMessageDialog(null,
												"O médico já estava ativo, não foram feitas alterações");
									} else if (escolhaStatus == 1 && consulta.getStatus() == false) {
										JOptionPane.showMessageDialog(null,
												"O médico já estava Inativo, " + "não foram feitas alterações");
									}
								}
							}

						} else if (escolha == 1) {
							String novoEndereco = JOptionPane.showInputDialog(null, "Endereço");
							for (Medico consulta : Main.medicosCadastrados) {
								if (consulta.getCrm() == Integer.parseInt(crm.strip())) {
									consulta.setEndereco(novoEndereco);
									JOptionPane.showMessageDialog(null, "Endereço alterado com sucesso!");
								}
							}
						}

					} else {
						JOptionPane.showMessageDialog(null, "Cpf não cadastrado");
					}

				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "Digite somente números");
				} catch (NullPointerException e) {
					System.out.println();

				}
			}

		});

		Background = new JLabel();
		Background.setIcon(new ImageIcon(getClass().getResource("bkMenuMedico.png")));
		getContentPane().add(Background);
		Background.setBounds(0, -90, 700, 800);

	}
}
