package telas.menuConsulta;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import classes.ConsultaMedica;
import classes.Pessoa;
import main.Main;
import sons.Sons;

@SuppressWarnings("serial")
public class MenuConsulta extends JFrame{
	private JButton btMarcarConsulta = new JButton();
	private JButton btConsultarHorarios = new JButton();
	private JButton btCancelarConsulta = new JButton();
	private JButton btConsultarConsulta = new JButton();
	private JLabel Background;
	public MenuConsulta() {
		
		this.setTitle("Menu Consulta");
		setBounds(1000, 500, 829, 680);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		getContentPane().add(btMarcarConsulta);
		btMarcarConsulta.setIcon(new ImageIcon(getClass().getResource("btAgendar.png")));
		btMarcarConsulta.setBounds(340, 50, 150, 50);
		
		getContentPane().add(btConsultarHorarios);
		btConsultarHorarios.setIcon(new ImageIcon(getClass().getResource("btConsultarHorarios.png")));
		btConsultarHorarios.setBounds(340, 120, 150, 50);
		
		getContentPane().add(btCancelarConsulta);
		btCancelarConsulta.setIcon(new ImageIcon(getClass().getResource("btCancelar.png")));
		btCancelarConsulta.setBounds(340, 190, 150, 50);
		
		getContentPane().add(btConsultarConsulta);
		btConsultarConsulta.setIcon(new ImageIcon(getClass().getResource("btConsultarConsulta.png")));
		btConsultarConsulta.setBounds(340, 260, 150, 50);
		
		btMarcarConsulta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				Sons.playAudioClick();
				CadastroConsulta cadastroConsulta = new CadastroConsulta();
				cadastroConsulta.setVisible(true);
				
			}
		});
		
		btConsultarHorarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				Sons.playAudioClick();
				String data = JOptionPane.showInputDialog("Data da consulta");
				String crm = JOptionPane.showInputDialog("Digite o crm do médico");
				try {
				ConsultaMedica.consultarHorarios(data, Integer.parseInt(crm));
				}
				catch(NumberFormatException e){
					JOptionPane.showMessageDialog(null, "Você precisa informar um crm");
				}
				
			}
		});
		
		btCancelarConsulta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				Sons.playAudioClick();
				CancelarConsulta cancelarConsulta = new CancelarConsulta();
				cancelarConsulta.setVisible(true);
				
			}
		});
		
		btConsultarConsulta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				Sons.playAudioClick();
				boolean confirm = true;
				String cpf = JOptionPane.showInputDialog("Digite o CPF do paciente");
				String data = JOptionPane.showInputDialog("Data da consulta");
				for(ConsultaMedica imprimirDados : Main.consultasCadastradas) {
					if(imprimirDados.getCpfPaciente().equals(cpf) 
							&& imprimirDados.getDataConsulta().equals(data)) {
						JOptionPane.showMessageDialog(null, "Dados Consulta"
													+ "\n\nCódigo: " + imprimirDados.getStatusConsulta()
													+ "\n\nCpf Paciente: " + imprimirDados.getCpfPaciente()
													+ "\nCrm do médico: " + imprimirDados.getCrmMedico()
													+ "\n\nData Consulta: " + imprimirDados.getDataConsulta()
													+ "\nHorario: " + imprimirDados.getHorarioConsulta()
													+ "\nStatus: " + imprimirDados.getStatusConsulta());
													confirm = false;
					}
						
							
				}
				
				if(!Pessoa.consultarCpf(cpf)) {
					JOptionPane.showMessageDialog(null, "Cpf do paciente não está cadastrado");
				}
				else if(confirm) {
					JOptionPane.showMessageDialog(null, "Sem consultas no periodo");
				}
		
			}
		});
		
		Background = new JLabel();
		Background.setIcon(new ImageIcon(getClass().getResource("bkMenuConsulta.png")));
		getContentPane().add(Background);
		Background.setBounds(0, -20, 829, 680);
		
	}
	
}
