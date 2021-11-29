package telasAgencia;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import classes.banco.Agencia;
import classes.banco.Banco;
import sons.SomClick;

@SuppressWarnings("serial")
public class CadastroAgencia extends JFrame {
	private JButton btConfirmar = new JButton();

	JTextField boxCodBanco = new JTextField();

	JTextField boxNome = new JTextField();

	JTextField boxCnpj = new JTextField();

	JTextField boxCodAgencia = new JTextField();

	JTextField boxEndereco = new JTextField();

	JTextField boxGerente = new JTextField();

	private JLabel Background;

	public CadastroAgencia() {

		this.setTitle("Cadastro Funcionario");
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

		getContentPane().add(boxCodBanco);
		boxCodBanco.setBounds(290, 50, 120, 25);

		getContentPane().add(boxCnpj);
		boxCnpj.setBounds(290, 110, 120, 25);


		getContentPane().add(boxCodAgencia);
		boxCodAgencia.setBounds(290, 170, 120, 25);
		
		getContentPane().add(boxNome);
		boxNome.setBounds(250, 230, 190, 25);

		getContentPane().add(boxEndereco);
		boxEndereco.setBounds(175, 290, 350, 25);
		
		getContentPane().add(boxGerente);
		boxGerente.setBounds(290, 360, 120, 25);
		btConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {	
			SomClick.playAudio();
			
			Banco validarBanco = new Banco();
			
			if(validarBanco.verificarBanco(boxCnpj.getText())) {
				try {
			Agencia novaAgencia = new Agencia();
			novaAgencia.cadastrarAgencia(boxCodBanco.getText(), 
					boxCodAgencia.getText(), boxCnpj.getText(), 
					boxNome.getText(), boxEndereco.getText(), 
					boxGerente.getText());
			JOptionPane.showMessageDialog(null, "Agencia "
					+ " cadastrada com sucesso!");
				} catch(NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "Campos "
							+ "não preenchidos");
				}
				
			}
			else {
				JOptionPane.showMessageDialog(null, "Cnpj "
						+ " não possui um cadastro!");
			
			
			}
			}
		});
		Background = new JLabel();
		Background.setIcon(new javax.swing.ImageIcon
		(getClass().getResource("bkCadastroFunc.png"))); 
		getContentPane().add(Background);	
		Background.setBounds(0, 0, 700, 600);
	}
}
