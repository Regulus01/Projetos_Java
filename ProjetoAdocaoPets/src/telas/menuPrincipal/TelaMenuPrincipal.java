package telas.menuPrincipal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import sons.Sons;
import telas.adotantes.MenuAdotantes;
import telas.adotar.AdotarPet;
import telas.pets.MenuPets;
import telas.relatorios.MenuRelatorios;

@SuppressWarnings("serial")
public class TelaMenuPrincipal extends JFrame{
	private JButton btAdotantes;
	private JButton btPets;
	private JButton btAdocao;
	private JButton btRelatorio;
	private JLabel Background;
	
	public TelaMenuPrincipal() {

		this.setTitle("Adoções UNIT");
		setBounds(900, 200, 900, 735);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		// direcao(esquerda-direira +, posiçao(cima+,baixo-), tamanho(largura)
				// tamanho(altura)
		btAdotantes = new JButton();
		btAdotantes.setBounds(650, 40, 150, 50);
		btAdotantes.setIcon(new ImageIcon(getClass().getResource("btAdotantes.png")));
		this.add(btAdotantes);
	
	
		btPets = new JButton();
		btPets.setBounds(650, 110, 150, 50);
		btPets.setIcon(new ImageIcon(getClass().getResource("btPets.png")));
		this.add(btPets);
		
		btAdocao = new JButton();
		btAdocao.setBounds(650, 180, 150, 50);
		btAdocao.setIcon(new ImageIcon(getClass().getResource("btAdocao.png")));
		this.add(btAdocao);
		
		btRelatorio = new JButton();
		btRelatorio.setBounds(650, 250, 150, 50);
		btRelatorio.setIcon(new ImageIcon(getClass().getResource("btRelatorio.png")));
		this.add(btRelatorio);
	    
		btAdotantes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				Sons.playAudioClick();
				MenuAdotantes Menu = new MenuAdotantes();
				Menu.setVisible(true);
			}
		});
		
		btPets.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				Sons.playAudioClick();
				MenuPets tela = new MenuPets();
				tela.setVisible(true);
			}
		});
		
		btAdocao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				Sons.playAudioClick();
				AdotarPet tela = new AdotarPet();
				tela.setVisible(true);
	
			}
		});
		
		btRelatorio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				Sons.playAudioClick();
				MenuRelatorios tela = new MenuRelatorios();
				tela.setVisible(true);
	
			}
		});
		
		Background = new JLabel();
		Background.setIcon(new ImageIcon(getClass().getResource("TelaMenuPrincipal.png"))); 
		getContentPane().add(Background);	
		Background.setBounds(0, 0, 900, 700);
	}

}
