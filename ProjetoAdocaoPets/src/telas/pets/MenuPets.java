package telas.pets;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import classes.pets.Cao;
import classes.pets.Gato;
import classes.pets.Passaro;
import classes.pets.Pets;
import sons.Sons;

@SuppressWarnings("serial")
public class MenuPets extends JFrame {
	private JButton btCadastro;
	private JButton btConsulta;

	JLabel Background;

	public MenuPets() {
		this.setTitle("Menu Pets");
		setBounds(1000, 500, 829, 680);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);

		btCadastro = new JButton();
		btCadastro.setBounds(340, 120, 150, 50);
		btCadastro.setIcon(new ImageIcon(getClass().getResource("btCadastrarPet.png")));
		this.add(btCadastro);

		btConsulta = new JButton();
		btConsulta.setBounds(340, 200, 150, 50);
		btConsulta.setIcon(new ImageIcon(getClass().getResource("btConsultarPet.png")));
		this.add(btConsulta);

		btCadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
		
				Sons.playAudioClick();
				new TelaCadastroPets();

			}
		});

		btConsulta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				Sons.playAudioClick();
				String codigo = JOptionPane.showInputDialog("Código do pet");
		
				Gato consultaGato = new Gato();
				Cao consultaCaes = new Cao();
				Passaro consultaPassaro = new Passaro();
				
				consultaCaes.exibirInformacoes(codigo);
				consultaGato.exibirInformacoes(codigo);
				consultaPassaro.exibirInformacoes(codigo);
				
				Pets consulta = new Pets();
				if(!(consulta.ConsultaPets(codigo))) {
					
					JOptionPane.showMessageDialog(null, "Não há animais cadastrados com esse Codigo");
					
				}

			}
		});

		Background = new JLabel();
		Background.setIcon(new javax.swing.ImageIcon(getClass().getResource("BKmenuPets.png")));
		getContentPane().add(Background);
		Background.setBounds(0, 0, 813, 643);

	}
}
