package telas.menuPaciente;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import classes.Pessoa;
import main.Main;
import sons.Sons;

@SuppressWarnings("serial")
public class MenuPaciente extends JFrame {

	private JButton btCadastro = new JButton();
	private JButton btConsulta = new JButton();
	private JButton btAlterar = new JButton();
	private JLabel Background;

	public MenuPaciente() {

		this.setTitle("Menu Pessoa");
		setBounds(1000, 500, 829, 680);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);

		btCadastro.setBounds(340, 120, 150, 50);
		btCadastro.setIcon(new ImageIcon(getClass().getResource("btCadastrar.png")));
		this.add(btCadastro);

		btConsulta.setBounds(340, 200, 150, 50);
		btConsulta.setIcon(new ImageIcon(getClass().getResource("btConsulta.png")));
		this.add(btConsulta);

		btAlterar.setBounds(340, 280, 150, 50);
		btAlterar.setIcon(new ImageIcon(getClass().getResource("btAlterarDados.png")));
		this.add(btAlterar);

		btCadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				Sons.playAudioClick();
				CadastroPaciente cadastroPaciente = new CadastroPaciente();
				cadastroPaciente.setVisible(true);

			}
		});

		btConsulta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				Sons.playAudioClick();
				String cpf = JOptionPane.showInputDialog(null, "Cpf ");
				Pessoa.consultarPaciente(cpf);

			}
		});

		btAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				Sons.playAudioClick();
				String cpf = JOptionPane.showInputDialog(null, "Cpf");
				for(Pessoa alterar : Main.pessoasCadastradas) {
					if(alterar.getCpf().equals(cpf))
					{
						String novoEndereco = JOptionPane.showInputDialog(null,"Novo Endereço");
						alterar.setEndereco(novoEndereco);
						break;
					}
					
				}

			}
		});
		
		Background = new JLabel();
		Background.setIcon(new ImageIcon(getClass().getResource("bkMenuPaciente.png")));
		getContentPane().add(Background);
		Background.setBounds(0, -20, 829, 680);
	}
}
