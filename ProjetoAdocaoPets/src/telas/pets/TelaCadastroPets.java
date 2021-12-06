package telas.pets;

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

import classes.pets.Cao;
import classes.pets.Gato;
import classes.pets.Passaro;
import classes.pets.Pets;
import principal.Main;
import sons.Sons;

@SuppressWarnings("serial")
public class TelaCadastroPets extends JFrame {
	private JButton btConfirmar = new JButton();

	JTextField boxNome = new JTextField();

	JTextField boxApelido = new JTextField();

	JTextField boxCodigoUnico = new JTextField();

	JTextField boxSexo = new JTextField();

	JTextField boxPeso = new JTextField();

	JTextField boxIdadeAprox = new JTextField();

	JTextField boxTipoRacao = new JTextField();

	JTextField boxQntRacao = new JTextField();

	JRadioButton rbMasculino = new JRadioButton("Macho");

	JRadioButton rbFeminino = new JRadioButton("Fêmea");

	ButtonGroup bgSexo = new ButtonGroup();

	JRadioButton rbCao = new JRadioButton("Cão");

	JRadioButton rbGato = new JRadioButton("Gato");

	JRadioButton rbPassaro = new JRadioButton("Passaro");

	ButtonGroup bgPets = new ButtonGroup();

	JRadioButton rbPePorte = new JRadioButton("Pequeno");
	JRadioButton rbMePorte = new JRadioButton("Médio");
	JRadioButton rbGrPorte = new JRadioButton("Grande");
	ButtonGroup bgTipoRacao = new ButtonGroup();
	private JLabel Background;

	public TelaCadastroPets() {

		this.setTitle("Cadastro Adotante");
		setSize(900, 800);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		// direcao(esquerda-direira +, posiçao(cima+,baixo-), tamanho(largura)
		// tamanho(altura)

		btConfirmar = new JButton();
		btConfirmar.setIcon(new ImageIcon(getClass().getResource("btConfirmarF.png")));

		btConfirmar.setBounds(400, 650, 150, 50);
		this.add(btConfirmar);

		getContentPane().add(boxCodigoUnico);
		boxCodigoUnico.setBounds(350, 120, 250, 25);

		getContentPane().add(rbMasculino);
		rbMasculino.setBounds(350, 260, 110, 28);

		getContentPane().add(rbFeminino);
		rbFeminino.setBounds(460, 260, 110, 28);

		bgSexo.add(rbMasculino);
		bgSexo.add(rbFeminino);

		getContentPane().add(rbCao);
		rbCao.setBounds(310, 190, 80, 28);

		getContentPane().add(rbGato);
		rbGato.setBounds(435, 190, 80, 28);

		getContentPane().add(rbPassaro);
		rbPassaro.setBounds(545, 190, 80, 28);

		bgPets.add(rbCao);
		bgPets.add(rbPassaro);
		bgPets.add(rbGato);

		getContentPane().add(boxPeso);
		boxPeso.setBounds(325, 310, 40, 25);

		getContentPane().add(boxIdadeAprox);
		boxIdadeAprox.setBounds(510, 310, 60, 25);

		getContentPane().add(boxNome);
		boxNome.setBounds(300, 380, 110, 25);

		getContentPane().add(boxApelido);
		boxApelido.setBounds(500, 380, 110, 25);
		//

		getContentPane().add(rbPePorte);
		rbPePorte.setBounds(320, 470, 80, 25);

		getContentPane().add(rbMePorte);
		rbMePorte.setBounds(420, 470, 80, 25);

		getContentPane().add(rbGrPorte);
		rbGrPorte.setBounds(520, 470, 80, 25);

		bgTipoRacao.add(rbPePorte);
		bgTipoRacao.add(rbMePorte);
		bgTipoRacao.add(rbGrPorte);

		//
		getContentPane().add(boxQntRacao);
		boxQntRacao.setBounds(290, 550, 350, 25);

		btConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				Sons.playAudioClick();
				Pets novopet = new Pets();
				Gato consultar = new Gato();
				boolean bPorte = false;
				boolean bSexo = false;
				boolean bTipo = false;
				String porte = "";
				String sexo = "";

				if (rbMasculino.isSelected()) {
					sexo = "Masculino";
					bSexo = true;

				} else if (rbFeminino.isSelected()) {
					sexo = "Feminino";
					bSexo = true;

				} else {
					JOptionPane.showMessageDialog(null, "Você precisa selecionar o sexo do animal");
				}

				if (rbPePorte.isSelected()) {
					porte = "Pequeno porte";
					bPorte = true;

				} else if (rbMePorte.isSelected()) {
					porte = "Medio porte";
					bPorte = true;
				} else if (rbGrPorte.isSelected()) {
					porte = "Grande porte";
					bPorte = true;
				} else {
					JOptionPane.showMessageDialog(null, "Você precisa selecionar o porte da ração");
				}

				System.out.println(consultar.ConsultaAdotantes(boxCodigoUnico.getText()));
				if (!(novopet.ConsultaPets(boxCodigoUnico.getText())) && !(boxCodigoUnico.getText().isBlank())) {
					if (rbCao.isSelected()) {
						bTipo = true;
						if (bPorte && bSexo) {
							Sons.playAudioLatir();
							Object[] optionsCao = { "Em pelo", "Raso", "Curto", "Semi Longo" };
							int escolha = JOptionPane.showOptionDialog(null, "Tipo de Pelagem", "",
									JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, optionsCao,
									optionsCao[0]);
							System.out.println(escolha);
							Cao novoGato = new Cao();
							try {
								novoGato.cadastroCaes(boxCodigoUnico.getText(), boxNome.getText(), boxApelido.getText(),
										sexo, Double.parseDouble(boxPeso.getText()),
										Integer.parseInt(boxIdadeAprox.getText()), porte,
										Double.parseDouble(boxQntRacao.getText()), (String) optionsCao[escolha]);

								novopet.setCodigoUnico(boxCodigoUnico.getText());
								Main.petsCadastrados.add(novopet);

								JOptionPane.showMessageDialog(null, "Pet Cadastrado com sucesso!");
							} catch (java.lang.NumberFormatException e) {
								JOptionPane.showMessageDialog(null,
										"As caixas de Idade, Quantidade de Ração e Peso precisam de números inteiros!");
							}
						}

					}

					if (rbGato.isSelected()) { // gato inicio
						bTipo = true;
						if (bPorte && bSexo) {
							Sons.playAudioMiau();
							Object[] optionsGato = { "Sim", "Não" };
							int escolha = JOptionPane.showOptionDialog(null, "O gato é domesticado?", "",
									JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, optionsGato,
									optionsGato[0]);
							System.out.println(escolha);
							Gato novoGato = new Gato();
							try {
								novoGato.cadastroGatos(boxCodigoUnico.getText(), boxNome.getText(),
										boxApelido.getText(), sexo, Double.parseDouble(boxPeso.getText()),
										Integer.parseInt(boxIdadeAprox.getText()), porte,
										Double.parseDouble(boxQntRacao.getText()), (escolha == 0 ? true : false));
								novopet.setCodigoUnico(boxCodigoUnico.getText());
								Main.petsCadastrados.add(novopet);

								JOptionPane.showMessageDialog(null, "Pet Cadastrado com sucesso!");
							} catch (java.lang.NumberFormatException e) {
								JOptionPane.showMessageDialog(null,
										"As caixas de Idade, Quantidade de Ração e Peso precisam de números inteiros!");
							}

						}
					} // gato fim

					if (rbPassaro.isSelected()) {
						bTipo = true;
						if (bPorte && bSexo) {
							Sons.playAudioGrita();
							Object[] optionsAsas = { "Sim", "Não" };
							int escolha = JOptionPane.showOptionDialog(null, "Asas cortadas?", boxNome.getText(),
									JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, optionsAsas,
									optionsAsas[0]);
							System.out.println(escolha);
							Passaro novoPassaro = new Passaro();
							try {
								novoPassaro.cadastroPassaro(boxCodigoUnico.getText(), boxNome.getText(),
										boxApelido.getText(), sexo, Double.parseDouble(boxPeso.getText()),
										Integer.parseInt(boxIdadeAprox.getText()), porte,
										Double.parseDouble(boxQntRacao.getText()), (escolha == 0 ? true : false));
								novopet.setCodigoUnico(boxCodigoUnico.getText());
								Main.petsCadastrados.add(novopet);

								JOptionPane.showMessageDialog(null, "Pet Cadastrado com sucesso!");
							} catch (java.lang.NumberFormatException e) {
								JOptionPane.showMessageDialog(null,
										"As caixas de Idade, Quantidade de Ração e Peso precisam de números inteiros!");
							}

						}

					} else if (!bTipo) {
						JOptionPane.showMessageDialog(null, "Você precisa selocinar o Tipo do PET");
					}
				} // cadastro pets
				else {
					JOptionPane.showMessageDialog(null, "Codigo de pet já está cadastrado");
				}
			}
		});

		Background = new JLabel();
		Background.setIcon(new javax.swing.ImageIcon(getClass().getResource("BkCadastroPets.png")));
		getContentPane().add(Background);
		Background.setBounds(0, 0, 885, 762);
	}

}
