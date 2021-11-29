package telasCliente;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import classes.cliente.PessoaFisica;
import classes.cliente.PessoaJuridica;
import sons.SomClick;

@SuppressWarnings("serial")
public class menuCliente extends JFrame{
	
	private JButton btPfisica;
	private JButton btPjuridica;
	private JButton btConsultaFisica;
	private JButton btConsultaJuridica;
	
	private JLabel BackGround;
	public menuCliente() {
	this.setTitle("Menu Cliente");
	setBounds(1000, 500, 829, 680);
	setLocationRelativeTo(null);
	getContentPane().setLayout(null);

	btPfisica = new JButton();
	btPfisica.setBounds(340, 120, 150, 50);
	btPfisica.setIcon(new javax.swing.ImageIcon(getClass().getResource
			("cadFisica.png")));
	this.add(btPfisica);
	
	btPjuridica = new JButton();
	btPjuridica.setBounds(340, 200, 150, 50);
	btPjuridica.setIcon(new javax.swing.ImageIcon(getClass().getResource
			("cadJuridica.png")));
	this.add(btPjuridica);
	
	btConsultaFisica = new JButton();
	btConsultaFisica.setBounds(340, 280, 150, 50);
	btConsultaFisica.setIcon(new javax.swing.ImageIcon(getClass().getResource
			("consultaFisica.png")));
	this.add(btConsultaFisica);
	
	btConsultaJuridica = new JButton();
	btConsultaJuridica.setBounds(340, 360, 150, 50);
	btConsultaJuridica.setIcon(new javax.swing.ImageIcon(getClass().getResource
			("consultaJuridica.png")));
	this.add(btConsultaJuridica);
	
	btPfisica.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent evt) {
			SomClick.playAudio();
			cadastroPfisica tela = new cadastroPfisica();
			tela.setVisible(true);

		}
	});
	
	btPjuridica.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent evt) {
			SomClick.playAudio();
			cadastroPjuridica tela = new cadastroPjuridica();
			tela.setVisible(true);

		}
	});
	
	btConsultaFisica.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent evt) {
			SomClick.playAudio();
			PessoaFisica pessoa = new PessoaFisica();
			String cpf = JOptionPane.showInputDialog("Cpf");
			
			if(pessoa.verificarCpf(cpf) == false) {
				pessoa.exibirPessoaF(cpf);
			}
			else {
				JOptionPane.showMessageDialog(null, "Não há clientes "
						+ "cadastrado com esse cpf");	
			}
	
		}
	});
	
	btConsultaJuridica.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent evt) {
			SomClick.playAudio();
			
			PessoaJuridica pessoa = new PessoaJuridica();
			String cnpj = JOptionPane.showInputDialog("Cnpj");
			
			if(pessoa.verificarCnpj(cnpj) == false) {
				pessoa.exibirPessoaJ(cnpj);
			}
			else {
				JOptionPane.showMessageDialog(null, "Não há clientes Juridicos "
						+ "cadastrado com esse cnpj");	
			}
			

		}
	});
	
	BackGround = new JLabel();
	BackGround.setIcon(new javax.swing.ImageIcon
	(getClass().getResource("saberBkCliente.png"))); 
	getContentPane().add(BackGround);	
	BackGround.setBounds(0, 0, 829, 680);
	}
	
}

