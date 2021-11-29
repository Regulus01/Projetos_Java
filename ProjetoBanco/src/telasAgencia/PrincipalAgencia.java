package telasAgencia;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import classes.banco.Agencia;
import sons.SomClick;

@SuppressWarnings("serial")
public class PrincipalAgencia extends JFrame {
	private JButton btCadastro;
	private JButton btConsulta;
	
	JLabel Background;

	public PrincipalAgencia() {
		this.setTitle("Agencia");
		setBounds(1000, 500, 829, 680);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);

		btCadastro = new JButton();
		btCadastro.setBounds(340, 120, 150, 50);
		btCadastro.setIcon(new javax.swing.ImageIcon(getClass().getResource
				("cadastrarAgencia.png")));
		this.add(btCadastro);
		
		btConsulta = new JButton();
		btConsulta.setBounds(340, 200, 150, 50);
		btConsulta.setIcon(new javax.swing.ImageIcon(getClass().getResource
				("btconsultaAgencia.png")));
		this.add(btConsulta);
		
		btCadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				SomClick.playAudio();
				CadastroAgencia telaCadastro = new CadastroAgencia();
				telaCadastro.setVisible(true);

			}
		});
		
		btConsulta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				SomClick.playAudio();
				Agencia agencia = new Agencia();
				String cnpj = JOptionPane.showInputDialog(null, "Codigo Banco");
				agencia.consultarAgencia(cnpj);
				

			}
		});
		
		Background = new JLabel();
		Background.setIcon(new javax.swing.ImageIcon
		(getClass().getResource("BackgroundAgencia.png"))); 
		getContentPane().add(Background);	
		Background.setBounds(0, 0, 829, 680);
	}
}
