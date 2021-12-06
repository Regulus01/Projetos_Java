package telas.menuMedico;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import classes.Medico;
import main.Main;
import sons.Sons;

@SuppressWarnings("serial")
public class CadastroMedico extends JFrame {

	private JButton btConfirmar = new JButton();

	private JTextField boxCpf = new JTextField();

	private JTextField boxCrm = new JTextField();

	private JTextField boxNome = new JTextField();

	private JTextField boxEndereco = new JTextField();

	JRadioButton rbAtivo = new JRadioButton("Ativo");
	JRadioButton rbInativo = new JRadioButton("Inativo");
	ButtonGroup bgStatus = new ButtonGroup();
	
	JLabel Background;

	public CadastroMedico() {

		this.setTitle("Cadastro Médico");
		setSize(700, 800);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);

		btConfirmar.setIcon(new ImageIcon(getClass().getResource("btConfirmar.png")));
		btConfirmar.setBounds(275, 630, 150, 50);
		this.add(btConfirmar);

		getContentPane().add(boxCrm);
		boxCrm.setBounds(290, 80, 120, 25);
		boxCrm.setHorizontalAlignment(JLabel.CENTER);

		getContentPane().add(boxCpf);
		boxCpf.setBounds(290, 170, 120, 25);
		boxCpf.setHorizontalAlignment(JLabel.CENTER);

		getContentPane().add(boxNome);
		boxNome.setBounds(220, 280, 280, 25);
		boxNome.setHorizontalAlignment(JLabel.CENTER);
		
		getContentPane().add(boxEndereco);
		boxEndereco.setBounds(175, 390, 380, 25);
		boxEndereco.setHorizontalAlignment(JLabel.CENTER);
		
		getContentPane().add(rbAtivo);
		rbAtivo.setBounds(265, 490, 80, 28);
		getContentPane().add(rbInativo);
		rbInativo.setBounds(375, 490, 80, 28);

		bgStatus.add(rbAtivo);
		bgStatus.add(rbInativo);

		btConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				Sons.playAudioClick();
				boolean status = false;
				Medico novoMedico = new Medico();
				boolean confirmCrm = false;
				
				Boolean confirmCpf = Medico.consultarCpf(boxCpf.getText().strip());
				try {
					confirmCrm = Medico.consultarCrm(Integer.parseInt(boxCrm.getText().strip()));
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "O crm deve conter somente números!");

				}

				if (rbAtivo.isSelected()) {
					status = true;
				}

				else if (rbInativo.isSelected()) {
					status = false;
					
				} else {
					JOptionPane.showMessageDialog(null, "Você precisa selecionar o Status");
				}

				boolean caixasVazias = boxCpf.getText().isBlank() || boxCrm.getText().isBlank()
						|| boxNome.getText().isBlank() || boxEndereco.getText().isBlank();
				
				if (confirmCpf) {
					JOptionPane.showMessageDialog(null, "O Cpf informado, já possui cadastro");
				}

				if (confirmCrm) {
					JOptionPane.showMessageDialog(null, "O Crm informado, já possui cadastro");
				}
				
				try {
				if ((!confirmCpf && !confirmCrm) && (rbAtivo.isSelected() || rbInativo.isSelected())
						&& !caixasVazias) {
					novoMedico.cadastrar(boxCpf.getText().strip(), boxNome.getText().strip(),
							boxEndereco.getText().strip(), Integer.parseInt(boxCrm.getText().strip()), status);
					Main.medicosCadastrados.add(novoMedico);
					boxCpf.setText("");
					boxNome.setText("");
					boxEndereco.setText("");
					boxCrm.setText("");
					bgStatus.clearSelection();
					JOptionPane.showMessageDialog(null, "Cadastro Concluído!");
				}
				}
				catch(NumberFormatException e) {
					System.out.println();
				}
				
				if (caixasVazias){
					JOptionPane.showMessageDialog(null, "Há caixas de texto vazias!");
				}

			}
		});
		
		Background = new JLabel();
		Background.setIcon(new ImageIcon(getClass().getResource("TelaCadastro.png")));
		getContentPane().add(Background);
		Background.setBounds(0, -20, 700, 800);
	}
}
