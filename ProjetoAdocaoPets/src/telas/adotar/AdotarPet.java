package telas.adotar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import classes.adotantes.Pessoa;
import classes.funcoes.Funcoes;
import classes.pets.Cao;
import classes.pets.Gato;
import classes.pets.Passaro;
import classes.pets.Pets;
import principal.Main;
import sons.Sons;

@SuppressWarnings("serial")
public class AdotarPet extends JFrame {
	JTextField boxCpf = new JTextField();
	JTextField boxCodigoPet = new JTextField();
	JButton btConfirmar = new JButton();
	JLabel Background;

	public AdotarPet() {
		this.setTitle("Adoção");
		setBounds(1000, 500, 500, 300);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);

		getContentPane().add(boxCpf);
		boxCpf.setBounds(195, 50, 110, 25);

		getContentPane().add(boxCodigoPet);
		boxCodigoPet.setBounds(195, 120, 110, 25);

		getContentPane().add(btConfirmar);
		btConfirmar.setBounds(175, 180, 150, 50);
		btConfirmar.setIcon(new ImageIcon(getClass().getResource("btConfirmarAd.png")));

		btConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				Sons.playAudioClick();
				Pessoa novoAdotante = new Pessoa();
				Pets novoPet = new Pets();
				boolean confirmarAdocao = false;
				boolean confirmarAdotante = novoAdotante.ConsultaAdotantes(boxCpf.getText());
				boolean confirmarPet = novoPet.ConsultaPets(boxCodigoPet.getText());
				if (!confirmarAdotante) {
					JOptionPane.showMessageDialog(null, "O cpf não está cadastrado!");
				} else if (!confirmarPet) {
					JOptionPane.showMessageDialog(null, "O Código do pet não está cadastrado!");
				}

				else {
					Gato consultaGato = new Gato();
					Cao consultaCaes = new Cao();
					Passaro consultaPassaro = new Passaro();
					if (consultaGato.ConsultaPets(boxCodigoPet.getText())) {
						for (Gato consultarGato : Main.gatosCadastrados) {
							if (consultarGato.getCodigoUnico().equals(boxCodigoPet.getText())
									&& consultarGato.getCpfAdotante().equals("Sem Adotante")) {
								consultarGato.setCpfAdotante(boxCpf.getText());
								consultarGato.setDataSaida(Funcoes.dataAtual());
								consultarGato.exibirInformacoes(boxCodigoPet.getText());
								JOptionPane.showMessageDialog(null, "O pet foi adotado com sucesso!");
								confirmarAdocao = true;

							}
						}

					}

					if (consultaCaes.ConsultaPets(boxCodigoPet.getText())) {
						for (Cao consultarCao : Main.caesCadastrados) {
							if (consultarCao.getCodigoUnico().equals(boxCodigoPet.getText())
									&& consultarCao.getCpfAdotante().equals("Sem Adotante")) {
								consultarCao.setCpfAdotante(boxCpf.getText());
								consultarCao.setDataSaida(Funcoes.dataAtual());
								consultaCaes.exibirInformacoes(boxCodigoPet.getText());
								JOptionPane.showMessageDialog(null, "O pet foi adotado com sucesso!");
								confirmarAdocao = true;
							}
						}

					}
					if (consultaPassaro.ConsultaPets((boxCodigoPet.getText()))) {
						for (Passaro consultarPassaro : Main.passarosCadastrados) {
							if (consultarPassaro.getCodigoUnico().equals(boxCodigoPet.getText())
									&& consultarPassaro.getCpfAdotante().equals("Sem Adotante")) {
								consultarPassaro.setCpfAdotante(boxCpf.getText());
								consultarPassaro.setDataSaida(Funcoes.dataAtual());
								consultarPassaro.exibirInformacoes(boxCodigoPet.getText());
								JOptionPane.showMessageDialog(null, "O pet foi adotado com sucesso!");
								confirmarAdocao = true;
							}
						}

					}
					if (!confirmarAdocao) {
						JOptionPane.showMessageDialog(null, "O pet se encontra adotado!");
					}
				}

			}

		});

		Background = new JLabel();
		Background.setIcon(new javax.swing.ImageIcon(getClass().getResource("BKAdotar.png")));
		getContentPane().add(Background);
		Background.setBounds(0, -210, 829, 680);

	}
}
