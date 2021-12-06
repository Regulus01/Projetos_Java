package telas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public class telaLogin extends JFrame {
	private JButton Login;


	public telaLogin() {
		this.setTitle("Login");
		setBounds(0, 0, 250, 250);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		Login = new JButton();
		Login.setText("Login");
		Login.setBounds(70, 100, 100, 50);
		this.add(Login);

		Login.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				String user;
				String pass;

				user = JOptionPane.showInputDialog("Digite seu usuário");
				pass = JOptionPane.showInputDialog("Digite sua senha");

				if (checkLogin(user, pass)) {
					JOptionPane.showMessageDialog(null, "Logado com sucesso!");
					TelaMenuPrincipal Menu = new TelaMenuPrincipal();
					Menu.setVisible(true);

		

				} else {
					JOptionPane.showMessageDialog(null, "Login invalido!");
				}
			}
		});
	}

	public boolean checkLogin(String login, String senha) {
		return login.equals("jose") && senha.equals("@123");

	}
}
