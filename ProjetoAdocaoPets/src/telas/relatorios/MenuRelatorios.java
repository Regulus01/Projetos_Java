package telas.relatorios;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import classes.pets.Relatorios;
import sons.Sons;


@SuppressWarnings("serial")
public class MenuRelatorios extends JFrame{

	private JButton btRpets = new JButton();
	
	private JButton btRprovisoes = new JButton();
	
	JLabel Background;
	public MenuRelatorios() {
		this.setTitle("Relatório Pets");
		setSize(500, 300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		
		getContentPane().add(btRpets);
		btRpets.setBounds(315, 50, 150, 50);
		btRpets.setIcon(new ImageIcon(getClass().getResource("btPetsRelatorio.png")));
		
		getContentPane().add(btRprovisoes);
		btRprovisoes.setBounds(315, 140, 150, 50);
		btRprovisoes.setIcon(new ImageIcon(getClass().getResource("btRacoes.png")));
		
		btRpets.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				Sons.playAudioClick();
				Relatorios novoRelatorio = new Relatorios();
				novoRelatorio.petsSemAdotar();
			}
		});

		btRprovisoes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				Sons.playAudioClick();
				Relatorios novoRelatorio = new Relatorios();
				novoRelatorio.relatorioProvisoes();

			}
		});
		
		
		Background = new JLabel();
		Background.setIcon(new ImageIcon(getClass().getResource("bkRelatorio.png"))); 
		getContentPane().add(Background);	
		Background.setBounds(-15, 0, 500, 300);
	}
	
}
