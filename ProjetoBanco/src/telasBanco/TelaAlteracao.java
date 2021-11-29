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
public class TelaAlteracao extends JFrame{
	private JButton btAlterarNome;
	private JButton btAlterarCodigo;
	private JLabel Background;
	public TelaAlteracao() {
		this.setTitle("Alteraçoes");
		setBounds(1000, 500, 640, 360);
		getContentPane().setLayout(null);
		
		btAlterarNome = new JButton();
		btAlterarNome.setIcon(new javax.swing.ImageIcon
				(getClass().getResource("btNome.png")));
		btAlterarNome.setBounds(450, 20, 150, 50);
		this.add(btAlterarNome);
		
		btAlterarCodigo = new JButton();
		btAlterarCodigo.setIcon(new javax.swing.ImageIcon
				(getClass().getResource("btCodigo.png")));
		
		btAlterarCodigo.setBounds(450, 90, 150, 50);
		this.add(btAlterarCodigo);
		
		
		btAlterarNome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				SomClick.playAudio();
				Banco banco = new Banco();
				String cnpj = (JOptionPane.showInputDialog("Cnpj"));
				if(banco.verificarBanco(cnpj)) {
					banco.consultarBancos(cnpj);
					String nome = (JOptionPane.showInputDialog("Novo Nome"));
					banco.alterarBancoNome(cnpj, nome);
					JOptionPane.showMessageDialog(null, "Nome do banco alterado!");
					banco.consultarBancos(cnpj);
				}
				else {
					JOptionPane.showMessageDialog(null, 
							"Cnpj do banco não esta cadastrado!");
				}
				}
			});
		
		btAlterarCodigo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				SomClick.playAudio();
				Banco banco = new Banco();
				String cnpj = (JOptionPane.showInputDialog("Cnpj"));
				if(banco.verificarBanco(cnpj)) {
					banco.consultarBancos(cnpj);
					String codigo = (JOptionPane.showInputDialog("Novo Codigo"));
					banco.alterarBancoCodigo(cnpj, codigo);
					JOptionPane.showMessageDialog(null, "Nome do banco alterado!");
					banco.consultarBancos(cnpj);
				}
				else {
					JOptionPane.showMessageDialog(null, 
							"Código do banco não esta cadastrado!");
				}
				}
			});
		
		Background = new JLabel();
		Background.setIcon(new javax.swing.ImageIcon
		(getClass().getResource("bkAlteracao.gif"))); 
		getContentPane().add(Background);	
		Background.setBounds(0, 0, 640, 360);
	}
	

}
