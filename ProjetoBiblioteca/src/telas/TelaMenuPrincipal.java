package telas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import classes.Emprestimo;
import classes.Livros;
//classes dos itens
import classes.Pessoa;


@SuppressWarnings("serial")
public class TelaMenuPrincipal extends JFrame {

	private JButton cadastroPe; // Cadas pessoas Item C
	private JButton consultaPe; // consulta de pessoas ITEM D
	private JButton cadastroLivros; // item e
	private JButton consultaLivros; // item f
	private JButton registroEmprestimo; // item g
	private JButton relatorioEmprestimo; // item h
	private JButton registroDevolucao; // item i

	public TelaMenuPrincipal() {
		this.setTitle("Menu Principal");
		setBounds(0, 0, 400, 450);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		cadastroPe = new JButton();
		cadastroPe.setText("Cadastrar Pessoa");
		cadastroPe.setBounds(10, 10, 150, 50);
		this.add(cadastroPe);

		consultaPe = new JButton();
		consultaPe.setText("Consulta Pessoa");
		consultaPe.setBounds(200, 10, 150, 50);
		this.add(consultaPe);

		cadastroLivros = new JButton();
		cadastroLivros.setText("Cadastrar Livros");
		cadastroLivros.setBounds(10, 80, 150, 50);
		this.add(cadastroLivros);

		consultaLivros = new JButton();
		consultaLivros.setText("Consulta Livros");
		consultaLivros.setBounds(10, 160, 150, 50);
		this.add(consultaLivros);

		registroEmprestimo = new JButton();
		registroEmprestimo.setText("Registrar Emprestimo");
		registroEmprestimo.setBounds(10, 240, 150, 50);
		this.add(registroEmprestimo);

		relatorioEmprestimo = new JButton();
		relatorioEmprestimo.setText("Relatorio Emprestimo");
		relatorioEmprestimo.setBounds(200, 240, 150, 50);
		this.add(relatorioEmprestimo);

		registroDevolucao = new JButton();
		registroDevolucao.setText("Registro Devolucão");
		registroDevolucao.setBounds(100, 320, 150, 50);
		this.add(registroDevolucao);

		ArrayList<Pessoa> usuarioCadastro = new ArrayList<>();
		cadastroPe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				Pessoa pessoa = new Pessoa();
				pessoa.setNome(JOptionPane.showInputDialog("Nome"));
				pessoa.setCpf(JOptionPane.showInputDialog("Cpf"));
				String temp = pessoa.getCpf();
				pessoa.setEndereco(JOptionPane.showInputDialog("Endereco"));
				boolean confirm = true;
				for (Pessoa cpfD : usuarioCadastro) {
					if (temp.equals(cpfD.getCpf())) {
						JOptionPane.showMessageDialog(null, 
								"Usuário já possui cadastro");
						confirm = false;
						break;
					}
				}
				if (confirm) {
					usuarioCadastro.add(pessoa);
					JOptionPane.showMessageDialog(null, 
							"Cadastro Realizado com sucesso!");

				}
			}
		}); // fim do bloco para cadastrar pessoas qC

		consultaPe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				String cpf = "";
				cpf = (JOptionPane.showInputDialog("Cpf"));
				boolean confirm = true;
				for (Pessoa cpfD : usuarioCadastro) {
					if (cpf.equals(cpfD.getCpf())) {
						JOptionPane.showMessageDialog(null, "Cpf: " 
					+ cpfD.getCpf() + "\n" + "Nome: " + cpfD.getNome()
								+ "\n" + "Endereco: " + cpfD.getEndereco());
						confirm = false;
						break;

					}
					}
				if (confirm) {
					JOptionPane.showMessageDialog(null, "O cpf informado "
							+ "não está cadastrado");
				}

			}
		}); // fim do bloco para cadastrar pessoas qD
		
		ArrayList<Livros> livrosCadastrados = new ArrayList<>();
		cadastroLivros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				Livros livro = new Livros();
				livro.setIsbn(JOptionPane.showInputDialog("Isbn"));
				livro.setTitulo(JOptionPane.showInputDialog("Titulo"));
				livro.setAutor(JOptionPane.showInputDialog("Autor"));
				livro.setEditora(JOptionPane.showInputDialog("Editora"));
				livro.setEdicao(JOptionPane.showInputDialog("Edicao"));
				String temp = livro.getIsbn();
				boolean confirm = true;
				for (Livros livro1 : livrosCadastrados) {
					if (temp.equals(livro1.getIsbn())) {
						JOptionPane.showMessageDialog(null, 
								"Livro já cadastrado");
						confirm = false;
						break;
					}
				}
				if (confirm) {
					livrosCadastrados.add(livro);
					JOptionPane.showMessageDialog(null, 
							"Cadastro Realizado com sucesso!");

				}
				}
			}); // fim do bloco para cadastrar pessoas qE
		
		consultaLivros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				String titulo = "";
				titulo = (JOptionPane.showInputDialog("Titulo"));
				boolean confirm = true;
				for (Livros titulo1 :  livrosCadastrados) {
					if (titulo.equals(titulo1.getTitulo())) {
						JOptionPane.showMessageDialog(null, 
						  "ISBN: " + titulo1.getIsbn()
						+ "\nTitulo: " + titulo1.getTitulo() 
						+ "\nAutor: " + titulo1.getAutor()
					    + "\nEditora: "+ titulo1.getEditora() 
					    + "\nEdicao: " + titulo1.getEdicao()
					    + "\nStatus: " + 
					    (titulo1.getStatus() ? "Emprestado" : "Dísponível"));
						confirm = false;
					
					}

					}
					if (confirm) {
						JOptionPane.showMessageDialog(null, "O livro informado "
								+ "não está cadastrado");
				}
				
			}
		}); // fim do bloco para cadastrar livros qF
		
		ArrayList<Emprestimo> Emprestimos = new ArrayList<>();
		registroEmprestimo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
			Emprestimo novoEmprestimo = new Emprestimo();
			novoEmprestimo.setCpf((JOptionPane.showInputDialog("Cpf")));
			String tempCpf = novoEmprestimo.getCpf();
			novoEmprestimo.setIsbn(JOptionPane.showInputDialog("ISBN"));
			String tempIsbn = novoEmprestimo.getIsbn();
			novoEmprestimo.setDataInicio(JOptionPane.showInputDialog("Data inicio"));
			novoEmprestimo.setDataFim(JOptionPane.showInputDialog("Data fim"));
			novoEmprestimo.setDataDevolucao(JOptionPane.showInputDialog("Data "
					+ "Devolucao"));
			
			boolean confirmCpf = true;
			
				for (Pessoa cpf1 : usuarioCadastro) {
					if (tempCpf.equals(cpf1.getCpf())) {
						novoEmprestimo.setNome(cpf1.getNome());
						confirmCpf = false;
						break;
					}
						}
				// não entra
				if (confirmCpf) {
					JOptionPane.showMessageDialog(null, "O cpf informado "
							+ "não está cadastrado");
					}
					
				boolean confirm = true;
				int contador = 0;
				for (Livros isbn1 :  livrosCadastrados) {
					if (tempIsbn.equals(isbn1.getIsbn())) {
						if(isbn1.getStatus() == false) {
							confirm = false;
							contador++;
						}
						break;
						}
					if(confirm) {
						contador++;
					}
					if (confirm) {
						JOptionPane.showMessageDialog(null, "O livro "
								+ "se encontra emprestado");
					}
					if (contador < 1) {
						JOptionPane.showMessageDialog(null, "O ISBN informado "
								+ "não está cadastrado");
					}
				}
				
				boolean emprestar = true;
				for (Pessoa emprestimo : usuarioCadastro) {
					if (emprestimo.getCpf().equals(tempCpf)) {
						if(emprestimo.getTotalEmprestimo() >= 1) {
						JOptionPane.showMessageDialog(null, "O usuário "
								+ "já possui um emprestimo");
						emprestar = false;
							break;
						}
						else {
							emprestimo.setTotalEmprestimo(1);
							break;
						}
					 }
				    }
					
				System.out.println(confirm);
				System.out.println(emprestar);
				System.out.println(confirmCpf);
				if(confirm == false && emprestar && confirmCpf == false) {
					for (Livros isbn1 : livrosCadastrados) {
						if (tempIsbn.equals(isbn1.getIsbn())) {
							novoEmprestimo.setTitulo(isbn1.getTitulo());
							novoEmprestimo.setAutor(isbn1.getAutor());
							isbn1.setStatus(true);
							break;
							}
						}
					
					novoEmprestimo.setStatus(true);
					novoEmprestimo.setAndamento(true);
					Emprestimos.add(novoEmprestimo);
					
					JOptionPane.showMessageDialog(null, "Emprestimo realizado"
							+ " com sucesso!");
					
				}
				else {
					
					JOptionPane.showMessageDialog(null, "Não é possível realizar"
							+ " o emprestimo..");
				}
			}

		}); // fim do bloco para realizar emprestimos qG
		
		relatorioEmprestimo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				String dataE = JOptionPane.showInputDialog("Data emprestimo");
				
				boolean teste = true;
				for(Emprestimo data : Emprestimos)
				{
					if(dataE.equals(data.getDataInicio()))
					{
						JOptionPane.showMessageDialog(null,
								 "Usuario"
								+ "\n\nCPF: " + data.getCpf() 
								+ "\nNome: " + data.getNome()
								+ "\n\nInformações do livro"
								+ "\n\nISBN: " + data.getIsbn()
								+ "\nTitulo: " + data.getTitulo()
								+ "\nAutor: " + data.getAutor()
								+ "\n\nInformacoes do emprestimo"
								+ "\n\nStatus: " + (data.getStatus() ? 
										"Em Andamento" : "Concluído")
								+ "\nData inicio: " + data.getDataInicio()
								+ "\nData fim: " + data.getDataFim());
						
						teste = false;
					}
				}
				if(teste) {
					JOptionPane.showMessageDialog(null, "Sem emprestimos "
							+ "nessa data");
				}
				
			}
		}); // fim do bloco para cadastrar pessoas qH
		
		registroDevolucao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				String teste = "";
				String cpfF = JOptionPane.showInputDialog("Digite o cpf");
				for(Emprestimo cpfF1 : Emprestimos)
				{
					if(cpfF1.getCpf().equals(cpfF))
					{	
						cpfF1.setStatus(false);
						teste = cpfF1.getIsbn();
						break;
					}
				}
				
				for(Livros livro : livrosCadastrados) {
					if(teste.equals(livro.getIsbn()))
					{
						JOptionPane.showMessageDialog(null, 
								"Livro devolvido");
						livro.setStatus(false);
						break;
					}
				}
				for(Pessoa cpfF1 : usuarioCadastro)
				{
					if(cpfF1.getCpf().equals(cpfF))
					{
						cpfF1.setTotalEmprestimo(-1);
						JOptionPane.showMessageDialog(null, "Devolução "
								+ "feita com sucesso! ");	
					}
				}
			}
			
	 });
	}

}