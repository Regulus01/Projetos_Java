package telas.adotantes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import classes.adotantes.Pessoa;
import sons.Sons;

@SuppressWarnings("serial")
public class TelaCadastroAdotantes extends JFrame {
	private JButton btConfirmar = new JButton();

	JTextField boxCpf = new JTextField();

	JTextField boxNome = new JTextField();

	JTextField boxEndereco = new JTextField();

	JTextField boxTelefone = new JTextField();

	private JLabel Background;

	public TelaCadastroAdotantes() {

		this.setTitle("Cadastro Adotante");
		setSize(700, 600);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		// direcao(esquerda-direira +, posiçao(cima+,baixo-), tamanho(largura)
		// tamanho(altura)

		btConfirmar = new JButton();
		btConfirmar.setIcon(new ImageIcon(getClass()
				.getResource("btConfirmarF.png")));
		btConfirmar.setBounds(275, 430, 150, 50);
		this.add(btConfirmar);

		getContentPane().add(boxCpf);
		boxCpf.setBounds(290, 60, 120, 25);

		
		getContentPane().add(boxNome);
		boxNome.setBounds(220, 150, 250, 25);

		getContentPane().add(boxEndereco);
		boxEndereco.setBounds(175, 250, 350, 25);
		
		getContentPane().add(boxTelefone);
		boxTelefone.setBounds(175, 350, 350, 25);
	
	
		btConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
			Sons.playAudioClick();
			Pessoa novaPessoa = new Pessoa();
			if(!(novaPessoa.ConsultaAdotantes(boxCpf.getText())) && !(boxCpf.getText().isEmpty())) {
			novaPessoa.CadastroPessoas(boxCpf.getText(), boxNome.getText(), 
					boxEndereco.getText(), boxTelefone.getText());
			JOptionPane.showMessageDialog(null, "Cadastro concluido");
			}
			else if((boxCpf.getText().isEmpty())) {
				JOptionPane.showMessageDialog(null, "Caixa de Cpf vazia");
			}
			else {
				JOptionPane.showMessageDialog(null, "Pessoa Já cadastrada");
			}
			}
		});
		Background = new JLabel();
		Background.setIcon(new javax.swing.ImageIcon
		(getClass().getResource("BKcadastroAdotantes.png"))); 
		getContentPane().add(Background);	
		Background.setBounds(0, 0, 700, 600);
	}
}
