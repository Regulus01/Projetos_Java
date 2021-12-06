package telas.telaLogin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import sons.Sons;
import telas.menuPrincipal.MenuPrincipal;

@SuppressWarnings("serial")
public class TelaLogin extends JFrame{
	private JButton btEntrar = new JButton();
	private JTextField boxUsuario = new JTextField("jose");
	private JTextField boxSenha = new JTextField("123");
	JLabel Background ;
	public boolean confirmarLogin = false;
	
	public TelaLogin() {
		this.setTitle("Tela Login");
		setSize(500, 400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		
		
		getContentPane().add(boxUsuario);
		boxUsuario.setBounds(190, 110, 120, 25);
		
		getContentPane().add(boxSenha);
		boxSenha.setBounds(190, 230, 120, 25);
		
		getContentPane().add(btEntrar);
		btEntrar.setIcon(new ImageIcon(getClass().getResource("btEntrarLogin.png")));
		btEntrar.setBounds(180, 290, 150, 50);
		
		btEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				Sons.playAudioClick();
				if(boxUsuario.getText().strip().equals("jose") 
						&& boxSenha.getText().strip().equals("123")) {
					confirmarLogin = true;
					MenuPrincipal Menu = new MenuPrincipal();
					Menu.setVisible(true);
					Sons.playAudioIniciar();
											
				}
				else {
					JOptionPane.showMessageDialog(null, "Usuário ou senha Incorretos");
				}
	
			}
		});
		
		Background = new JLabel();
		Background.setIcon(new ImageIcon(getClass().getResource("bkLogin.png")));
		getContentPane().add(Background);
		Background.setBounds(0, 0, 486, 362);

		
	}
}
