package telas.adotantes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import classes.adotantes.Pessoa;
import sons.Sons;

@SuppressWarnings("serial")
public class MenuAdotantes extends JFrame{
	private JButton btCadastro;
	private JButton btConsulta;
	
	JLabel Background;

	public MenuAdotantes() {
		this.setTitle("Agencia");
		setBounds(1000, 500, 829, 680);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);

		btCadastro = new JButton();
		btCadastro.setBounds(340, 120, 150, 50);
		btCadastro.setIcon(new ImageIcon(getClass().getResource
				("btCadastroAdotante.png")));
		this.add(btCadastro);
		
		btConsulta = new JButton();
		btConsulta.setBounds(340, 200, 150, 50);
		btConsulta.setIcon(new ImageIcon(getClass().getResource
				("btConsultaAdotantes.png")));
		this.add(btConsulta);
		
		btCadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				Sons.playAudioClick();
				new TelaCadastroAdotantes();
	
			}
		});
		
		btConsulta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				Sons.playAudioClick();
				String Cpf = JOptionPane.showInputDialog("Cpf");
				Pessoa consulta = new Pessoa();	
				if(consulta.ConsultaAdotantes(Cpf)) {
			
					consulta.RetornarInformacoes(Cpf);
					}
				else {
					JOptionPane.showMessageDialog(null, "Cpf não possui cadastro");
				}
				
			}
		});
		
		Background = new JLabel();
		Background.setIcon(new javax.swing.ImageIcon
		(getClass().getResource("BKmenuPets.png"))); 
		getContentPane().add(Background);	
		Background.setBounds(0, 0, 829, 680);
	}
}
