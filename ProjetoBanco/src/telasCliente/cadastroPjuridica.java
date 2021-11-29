package telasCliente;

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

import classes.cliente.PessoaJuridica;
import sons.SomClick;

@SuppressWarnings("serial")
public class cadastroPjuridica extends  JFrame{
	private JButton btConfirmar = new JButton();

	JLabel textNome = new JLabel(); // nome -
	JTextField boxNome = new JTextField();

	JTextField boxCnpj = new JTextField();
	JLabel textCnpj = new JLabel();// cpf -

	JTextField boxDataNasc = new JTextField();
	JLabel textDataNasc = new JLabel(); // data nasc -

	JTextField boxEndereco = new JTextField();
	JLabel textEndereco = new JLabel(); // endereco -
	
	JTextField boxIncricaoEs = new JTextField();
	JLabel textIncricaoEs = new JLabel(); // endereco -

	JLabel textStatus = new JLabel(); // status
	JRadioButton rbAtivo = new JRadioButton();
	JRadioButton rbInativo = new JRadioButton();
	ButtonGroup bgStatus = new ButtonGroup();

	private JLabel Background;

	public cadastroPjuridica() {

		this.setTitle("Cadastro Pessoa Juridica");
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
		getContentPane().add(textCnpj);
		textCnpj.setBounds(340, 70, 50, 30);

		getContentPane().add(boxCnpj);
		boxCnpj.setBounds(290, 100, 120, 25);

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
		//
		getContentPane().add(textIncricaoEs);
		textIncricaoEs.setBounds(320, 200, 250, 30);

		getContentPane().add(boxIncricaoEs);
		boxIncricaoEs.setBounds(180, 250, 350, 25);

		// radio box 2

		getContentPane().add(textStatus);
		textStatus.setBounds(330, 280, 110, 28);

		getContentPane().add(rbAtivo);
		rbAtivo.setBounds(260, 330, 110, 28);

		getContentPane().add(rbInativo);
		rbInativo.setBounds(370, 330, 110, 28);

		bgStatus.add(rbAtivo);
		bgStatus.add(rbInativo);

		btConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				SomClick.playAudio();
				String status = "";

				if (rbAtivo.isSelected()) {
					status = "Ativo";
				} else {
					status = "Inativo";
				}

				try {
					PessoaJuridica pessoa = new PessoaJuridica();
				
					pessoa.cadastrarPessoaJ(boxNome.getText(), 
							boxEndereco.getText(), boxDataNasc.getText(), status,
							boxCnpj.getText(), 
							Integer.parseInt(boxIncricaoEs.getText()));
					JOptionPane.showMessageDialog(null, "Pessoa Juridica " 
							+ "cadastrado com sucesso!");

				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "Ocorreu um Erro");
				}

			}
		});
		Background = new JLabel();
		Background.setIcon(new javax.swing.ImageIcon
				(getClass().getResource("backGroundClienteJuridico.png")));
		getContentPane().add(Background);
		Background.setBounds(0, 0, 700, 600);
	}
}
