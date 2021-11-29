package telasFuncionario;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import classes.funcionarios.Funcionario;
import sons.SomClick;

@SuppressWarnings("serial")
public class TelaCadastro extends JFrame {

	private JButton btConfirmar = new JButton();

	JLabel textNome = new JLabel(); //nome
	JTextField boxNome = new JTextField();

	JTextField boxCpf = new JTextField();
	JLabel textCpf = new JLabel();// cpf

	JTextField boxDataNasc = new JTextField();
	JLabel textDataNasc = new JLabel(); // data nasc

	JTextField boxEndereco = new JTextField();
	JLabel textEndereco = new JLabel(); // endereco

	JTextField boxSalario = new JTextField();
	JLabel textSalario = new JLabel(); // salario

	JLabel textCargo = new JLabel(); //cargo
	JRadioButton rbAnalista = new JRadioButton("Analista");
	JRadioButton rbGerente = new JRadioButton("Gerente");
	ButtonGroup bgCargo = new ButtonGroup();

	JLabel textStatus = new JLabel(); // status
	JRadioButton rbAtivo = new JRadioButton("Ativo");
	JRadioButton rbInativo = new JRadioButton("Inativo");
	ButtonGroup bgStatus = new ButtonGroup();
	
	private JLabel Background;
	public TelaCadastro() {

		this.setTitle("Cadastro Funcionario");
		setSize(700, 600);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		// direcao(esquerda-direira +, posiçao(cima+,baixo-), tamanho(largura)
		// tamanho(altura)

		btConfirmar = new JButton();
		btConfirmar.setIcon(new ImageIcon(getClass().getResource("Confirmar.png")));
		btConfirmar.setBounds(275, 430, 150, 50);
		this.add(btConfirmar);
		// nome

		getContentPane().add(textNome);
		textNome.setBounds(330, 15, 50, 30);

		getContentPane().add(boxNome);
		boxNome.setBounds(175, 50, 350, 25);

		// cpf
		getContentPane().add(textCpf);
		textCpf.setBounds(340, 70, 50, 30);

		getContentPane().add(boxCpf);
		boxCpf.setBounds(290, 100, 120, 25);

		// data nascimento
		getContentPane().add(textDataNasc);
		textDataNasc.setBounds(295, 125, 150, 30);

		getContentPane().add(boxDataNasc);
		boxDataNasc.setBounds(290, 150, 120, 25);
		// Endereco
		getContentPane().add(textEndereco);
		textEndereco.setBounds(320, 175, 250, 30);

		getContentPane().add(boxEndereco);
		boxEndereco.setBounds(180, 200, 350, 25);
		// radio box
		getContentPane().add(textCargo);
		textCargo.setBounds(330, 225, 110, 28);

		getContentPane().add(rbAnalista);
		rbAnalista.setBounds(260, 250, 110, 28);

		getContentPane().add(rbGerente);
		rbGerente.setBounds(370, 250, 110, 28);

		bgCargo.add(rbAnalista);
		bgCargo.add(rbGerente);

		// radio box 2

		getContentPane().add(textStatus);
		textStatus.setBounds(330, 280, 110, 28);

		getContentPane().add(rbAtivo);
		rbAtivo.setBounds(260, 300, 110, 28);

		getContentPane().add(rbInativo);
		rbInativo.setBounds(370, 300, 110, 28);

		bgStatus.add(rbAtivo);
		bgStatus.add(rbInativo);
		// Salario
		getContentPane().add(textSalario);
		textSalario.setBounds(330, 340, 120, 25);

		getContentPane().add(boxSalario);
		boxSalario.setBounds(290, 370, 120, 25);

		btConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				String cargo = "";
				String status = "";
				if (rbAnalista.isSelected()) {
					cargo = "Analista";
		
				} else {
					cargo = "Gerente";
				}

				if (rbAtivo.isSelected()) {
					status = "Ativo";		
				} else {
					status = "Inativo";	
				}
				
				SomClick.playAudio();
				if (Funcionario.verificarCpf(boxCpf.getText())) {
					try {
						Funcionario novoFuncionario = new Funcionario();

						novoFuncionario.cadastroFuncionario(boxCpf.getText(), 
								boxNome.getText(), boxDataNasc.getText(),
								boxEndereco.getText(), status, 
								Double.parseDouble(boxSalario.getText()), 
								cargo);
						JOptionPane.showMessageDialog(null, "Funcionario "
								+ "cadastrado com sucesso!");
					} catch (NumberFormatException e) {
						JOptionPane.showMessageDialog(null, "Campos "
								+ "não preenchidos");
					}
				}

				else {
					JOptionPane.showMessageDialog(null, "Funcionario "
							+ "já possui um cadastro!");
				}
			}
			
		});
		
		Background = new JLabel();
		Background.setIcon(new javax.swing.ImageIcon
		(getClass().getResource("bkTelaCadastroF2.png"))); 
		getContentPane().add(Background);	
		Background.setBounds(0, 0, 700, 600);
	}

}
