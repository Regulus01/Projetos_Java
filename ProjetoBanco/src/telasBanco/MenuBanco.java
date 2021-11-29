package telasBanco;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import classes.banco.Banco;
import sons.SomClick;

@SuppressWarnings("serial")
public class MenuBanco extends JFrame{
	private JButton btCadastro;
	private JButton btAlterarBanco;
	private JButton btConsultar;
	private JLabel Background;
	
	public MenuBanco() {
		this.setTitle("Menu Banco");
		setBounds(1000, 500, 380, 198);
		getContentPane().setLayout(null);
		
		btCadastro = new JButton();
		btCadastro.setBounds(10, 10, 150, 50);
		btCadastro.setIcon(new javax.swing.ImageIcon
				(getClass().getResource("btCadastro.png")));
		this.add(btCadastro);

		btAlterarBanco = new JButton();
		btAlterarBanco.setBounds(200, 10, 150, 50);
		btAlterarBanco.setIcon(new javax.swing.ImageIcon
				(getClass().getResource("btAlterar.png")));
		this.add(btAlterarBanco);
		
		btConsultar = new JButton();
		btConsultar.setBounds(10, 90, 150, 50);
		btConsultar.setIcon(new javax.swing.ImageIcon
				(getClass().getResource("btConsultar.png")));
		this.add(btConsultar);
		
		
		btCadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {	
				SomClick.playAudio();
				Banco novoBanco = new Banco();
				
				String cnpj = (JOptionPane.showInputDialog("Cnpj").strip());
				while(cnpj.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Caixa vazia digite "
							+ "novamente");
					cnpj = (JOptionPane.showInputDialog("Cnpj"));
				}
				if(novoBanco.verificarBanco(cnpj) == false && !(cnpj.isEmpty())) {
			
				String Codigo = (JOptionPane.showInputDialog("Codigo"));
				System.out.println(novoBanco.verificarCodigo(Codigo));
				if(novoBanco.verificarCodigo(Codigo) == false) {
				String Nome = (JOptionPane.showInputDialog("Nome"));
				novoBanco.cadastrarBanco(Codigo, cnpj, Nome);	
				JOptionPane.showMessageDialog(null, "Cadastro concluído!");
				}
				else {
					JOptionPane.showMessageDialog(null, "Código do banco está "
							+ "cadastrado!");
				}
				}
				else {
					JOptionPane.showMessageDialog(null, "Cnpj do banco está "
							+ "cadastrado!");
				}
		
				
			}
		});
		
		btConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				SomClick.playAudio();
				Banco consulBanco = new Banco();
				String cnpj = (JOptionPane.showInputDialog("Cnpj"));
				
				consulBanco.consultarBancos(cnpj);

				if(consulBanco.verificarBanco(cnpj) == false) {
					JOptionPane.showMessageDialog(null, 
							"Banco não está cadastrado");
				}
				}
			});
		
		btAlterarBanco.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				SomClick.playAudio();
				TelaAlteracao tela = new TelaAlteracao();
				tela.setVisible(true);
				
			}		
			});
			
		Background = new JLabel();
		Background.setIcon(new javax.swing.ImageIcon
		(getClass().getResource("menuBancoLayout.png"))); 
		getContentPane().add(Background);	
		Background.setBounds(-10, -40, 420, 200);
	}
}
