package telas.menuPaciente;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import classes.Pessoa;
import main.Main;
import sons.Sons;

@SuppressWarnings("serial")
public class CadastroPaciente extends JFrame {
	private JButton btConfirmar = new JButton();

	private JTextField boxCpf = new JTextField();

	private JTextField boxNome = new JTextField();

	private JTextField boxEndereco = new JTextField();

	private JLabel Background;

	public CadastroPaciente() {

		this.setTitle("Cadastro Paciente");
		setSize(700, 600);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);

		btConfirmar.setIcon(new ImageIcon(getClass().getResource("btConfirmar.png")));
		btConfirmar.setBounds(275, 430, 150, 50);
		this.add(btConfirmar);

		getContentPane().add(boxCpf);
		boxCpf.setBounds(290, 120, 120, 25);
		boxCpf.setHorizontalAlignment(JLabel.CENTER);

		getContentPane().add(boxNome);
		boxNome.setBounds(220, 220, 280, 25);
		boxNome.setHorizontalAlignment(JLabel.CENTER);

		getContentPane().add(boxEndereco);
		boxEndereco.setBounds(175, 320, 380, 25);
		boxEndereco.setHorizontalAlignment(JLabel.CENTER);

		btConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				Sons.playAudioClick();
				Pessoa novaPessoa = new Pessoa();
				Boolean confirmCpf = Pessoa.consultarCpf(boxCpf.getText().strip());

				boolean caixasVazias = boxCpf.getText().isBlank() || boxNome.getText().isBlank()
						|| boxEndereco.getText().isBlank();

				if (confirmCpf) {
					JOptionPane.showMessageDialog(null, "O Cpf informado, já possui cadastro");
				}

				try {
					if (!confirmCpf && !caixasVazias) {
						novaPessoa.cadastrar(boxCpf.getText().strip(), boxNome.getText().strip(),
								boxEndereco.getText().strip());
						Main.pessoasCadastradas.add(novaPessoa);
						boxCpf.setText("");
						boxNome.setText("");
						boxEndereco.setText("");
						JOptionPane.showMessageDialog(null, "Cadastro Concluído!");
					}
				} catch (NumberFormatException e) {
					System.out.println();
				}

				if (caixasVazias) {
					JOptionPane.showMessageDialog(null, "Há caixas de texto vazias!");
				}

			}
		});

		Background = new JLabel();
		Background.setIcon(new ImageIcon(getClass().getResource("bkCadastroPaciente.png")));
		getContentPane().add(Background);
		Background.setBounds(0, -20, 700, 600);
	}
}
