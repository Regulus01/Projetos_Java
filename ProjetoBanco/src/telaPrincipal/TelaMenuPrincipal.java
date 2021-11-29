package telaPrincipal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import sons.SomClick;
import telasAgencia.PrincipalAgencia;
import telasBanco.MenuBanco;
import telasCliente.menuCliente;
import telasFuncionario.TelaFuncionario;


@SuppressWarnings("serial")
public class TelaMenuPrincipal extends JFrame {
	private JButton btBanco;
	private JButton btFuncionario;
	private JButton btAgencia;
	private JButton btCliente;
	private JLabel Background;
	
	JButton clickSound = new JButton("somBotao");
	public TelaMenuPrincipal() {

		this.setTitle("Menu PrincipalAgencia");
		setBounds(800, 400, 670, 372);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		btBanco = new JButton();
		btBanco.setBounds(450, 20, 150, 50);
		btBanco.setIcon(new javax.swing.ImageIcon
				(getClass().getResource("btBanco.png")));
		this.add(btBanco);
	
	
		btFuncionario = new JButton();
		btFuncionario.setBounds(450, 90, 150, 50);
		btFuncionario.setIcon(new javax.swing.ImageIcon
				(getClass().getResource("btFuncionario.png")));
		this.add(btFuncionario);
		
		btAgencia = new JButton();
		btAgencia.setBounds(450, 160, 150, 50);
		btAgencia.setIcon(new javax.swing.ImageIcon
				(getClass().getResource("btAgencia.png")));
		this.add(btAgencia);
		
		btCliente = new JButton();
		btCliente.setBounds(450, 230, 150, 50);
		btCliente.setIcon(new javax.swing.ImageIcon
				(getClass().getResource("btCliente.png")));
		this.add(btCliente);
	     
		btBanco.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				SomClick.playAudio();
				MenuBanco Menu = new MenuBanco();
				Menu.setVisible(true);
			}
		});
		btFuncionario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				SomClick.playAudio();
				TelaFuncionario Menu = new TelaFuncionario();
				Menu.setVisible(true);
	
			}
		});
		
		btAgencia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				SomClick.playAudio();
				PrincipalAgencia Menu = new PrincipalAgencia();
				Menu.setVisible(true);
	
			}
		});
		
		btCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				SomClick.playAudio();
				menuCliente Menu = new menuCliente();
				Menu.setVisible(true);
	
			}
		});
		Background = new JLabel();
		Background.setIcon(new javax.swing.ImageIcon
		(getClass().getResource("MenuPrincipalLabel.gif"))); 
		getContentPane().add(Background);	
		Background.setBounds(0, 0, 670, 372);
	}
}
