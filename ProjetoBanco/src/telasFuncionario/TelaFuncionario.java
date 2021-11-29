package telasFuncionario;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import classes.funcionarios.Funcionario;
import sons.SomClick;

@SuppressWarnings("serial")
public class TelaFuncionario extends JFrame {
	private JLabel Background;
	private JButton btCadastro;
	private JButton btAlterarSalario;
	private JButton btConsultar;
	JTextField caixa = new JTextField(30);

	public TelaFuncionario() {
		this.setTitle("TelaFuncionario");
		setBounds(1000, 500, 829, 680);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		btCadastro = new JButton();
		btCadastro.setBounds(340, 120, 150, 50);
		btCadastro.setIcon(new javax.swing.ImageIcon
				(getClass().getResource("btCadastroF.png")));
		this.add(btCadastro);
		
		btAlterarSalario = new JButton();
		btAlterarSalario.setBounds(340, 200, 150, 50);
		btAlterarSalario.setIcon(new javax.swing.ImageIcon
				(getClass().getResource("btSalario.png")));
		this.add(btAlterarSalario);
		
		btConsultar = new JButton();
		btConsultar.setBounds(340, 280, 150, 50);
		btConsultar.setIcon(new javax.swing.ImageIcon
				(getClass().getResource("btConsulta.png")));
		this.add(btConsultar);

		btCadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {	
			SomClick.playAudio();
			new TelaCadastro();
			}
		});
		
		btConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {	
			SomClick.playAudio();
			Funcionario consulta = new Funcionario();
			String cpf = JOptionPane.showInputDialog("Cpf");
			if(Funcionario.verificarCpf(cpf) == false) {
				consulta.consultarFuncionario(cpf);
			}
			else {
				JOptionPane.showMessageDialog(null, "Não há usuários "
						+ "cadastrado com esse cpf");	
			}
			
			}
		});
		
		btAlterarSalario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {	
			SomClick.playAudio();
			double salario = 0.0;
			Funcionario consulta = new Funcionario();
			String cpf = JOptionPane.showInputDialog("Cpf");
			if(Funcionario.verificarCpf(cpf) == false) {
				String salario1 = JOptionPane.showInputDialog("Salario");
				salario = Double.parseDouble(salario1);
				System.out.println(salario);
				consulta.alterarSalario(salario, cpf);
			}
			else {
				JOptionPane.showMessageDialog(null, "Não há usuários "
						+ "cadastrado com esse cpf");	
			}
			
			}
		});
		
		Background = new JLabel();
		Background.setIcon(new javax.swing.ImageIcon
		(getClass().getResource("BackGroundFuncionario.png"))); 
		getContentPane().add(Background);	
		Background.setBounds(0, 0, 829, 680);
	}
}
