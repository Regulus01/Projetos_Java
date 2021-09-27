package me1Unidade;

import java.util.ArrayList;
import java.util.Scanner;

public class Principal {
	public static void main(String[] args) {
		ArrayList<Medico> medCadastrados = new ArrayList<>();
		ArrayList<Pessoa> paciCadastrados = new ArrayList<>();
		ArrayList<Consulta> consultaAgendada = new ArrayList<>();
		int contador = 1;
		Scanner sc = new Scanner(System.in);
		int opM = 0;
		int op = 0;
        // vers: 1.5
		do
		{
			System.out.println("          Menu principal\n");
			System.out.println("1 - Menu Médico\n" // 100%
					+ "2 - Menu de pacientes\n" // 100%
					+ "3 - Menu de consultas\n" // 100%
					+ "4 - Relatório financeiro\n" //100%
					+ "5 - Sair\n"); // 100%

			op = sc.nextInt();

			if (op == 1) { // inicio do bloco função médico
				opM = 0;
				while (opM != 5) {

					System.out.println("\n          Menu Médico          \n");
					System.out.println("1 - Cadastrar Médicos\n" 
					                 + "2 - Reativar Médico\n"
							         + "3 - Relatorio Médicos Cadastrados\n" 
					                 + "4 - Inativar Médico\n" + "5 - Sair\n");
					opM = sc.nextInt();
					switch (opM) {
					case 1: {
						Medico medico = new Medico();
						System.out.println("        Cadastramento médico\n");
						System.out.print("Digite seu cpf: ");
						medico.setCpf(sc.next());
						System.out.print("Digite o CRM: ");
						medico.setCrm(sc.nextInt());
						System.out.print("Digite seu nome: ");
						medico.setNome(sc.next());
						System.out.print("Digite sua data de nascimento: ");
						medico.setDataNa(sc.next());
						medico.dataCadastro();
						medCadastrados.add(medico);
						System.out.println("\n Médico cadastrado com sucesso!");
						break;

					}
					case 3: {
						System.out.println("Relatório de Médicos Cadastrados");
						for (Medico Dados : medCadastrados) {
							System.out.printf("\nCpf: %s\nCrm: %d\n" 
						                    + "Nome: %s\nData Nascimento: %s\n"
											+ "Ativo: %b\nData Cadastro: %s",
									Dados.getCpf(), Dados.getCrm(), 
									Dados.getNome(), Dados.getDataNa(),
									Dados.getAtivoInativo(), 
									Dados.getDataCadastro());
							System.out.println("\n---------------------------");
						}
						System.out.println("\nDigite qualquer "
								+ "tecla para continuar...");
						sc.next();
						System.out.println("\n");
						break;
					}
					case 2: {
						System.out.println("            Reativar médico\n");
						System.out.println("Digite o crm do médico "
								         + "para reativação");
						int crm = sc.nextInt();
						for (Medico Dados : medCadastrados) {
							if (crm == Dados.getCrm() & 
									Dados.getAtivoInativo() == false) {
								Dados.setAtivoInativo(true);
								break;
							} else {
								System.out.println("O médico está atualmente "
										+ "ativo ou" + " não está cadastrado");
							}
						}
						break;
					}
					case 4: {
						System.out.println("           Inativar médico\n");
						System.out.println("Digite o crm do médico "
								+ "para Inativação");
						int crm = sc.nextInt();
						for (Medico Dados : medCadastrados) {
							if (crm == Dados.getCrm() & 
								Dados.getAtivoInativo() == true) {
								Dados.setAtivoInativo(false);
								break;
							} else {
								System.out.println("O médico está atualmente "
										+ "inativo ou" 
										+ " não está cadastrado");
							}
						}
						break;
					}

					default:
						break;
					}
				}
			} // Fim do bloco funçao de médico

			if (op == 2) { // inicio do bloco função paciente
				opM = 0;
				while (opM != 3) {

					System.out.println("\n          Menu Paciente          \n");
					System.out.println("1 - Cadastrar Paciente\n" 
					+ "2 - Relatorio Pacientes Cadastrados\n" + "3 - Sair\n");
					opM = sc.nextInt();

					switch (opM) {
					case 1: {
						Pessoa paciente = new Pessoa();
						System.out.println("             Cadastro paciente\n");
						System.out.println("Digite o CPF: ");
						paciente.setCpf(sc.next());
						System.out.println("Digite o Nome: ");
						paciente.setNome(sc.next());
						System.out.println("Digite a Data de Nascimento: ");
						paciente.setDataNa(sc.next());
						paciente.DataCa();
						paciCadastrados.add(paciente);
						System.out.println("\nPaciente Cadastrado "
								          + "com sucesso!");
						break;

					}

					case 2: {
						System.out.println("  Relatório de Pacientes "
								+ "Cadastrados");
						for (Pessoa Dados : paciCadastrados) {
							System.out.printf("\nCpf: %s\n" 
						               + "Nome: %s\nData Nascimento: %s\n" 
									   + "Data Cadastro: %s",
									Dados.getCpf(), Dados.getNome(), 
									Dados.getDataNa(), Dados.getDataCa());
						System.out.println("\n---------------------------");	
						}
						System.out.println("\n");
						break;
					}

					default:
						break;
					}
				}
			} // fim do bloco opcão 2

			if (op == 3) {
				int Opc = 0;
				while (Opc != 4) {
					System.out.println("\n          Menu Consulta         \n");
					System.out.println("1 - Cadastro de Consultas\n" // 100%
							+ "2 - Relatório de consultas agendadas\n"// 100%
							+ "3 - Cancelamento de consultas\n" + "4 - Sair");

					Opc = sc.nextInt();
					switch (Opc) {

					case 1: {
						Consulta marcarConsulta = new Consulta();

						System.out.println("     Cadastro de consultas    \n");
						System.out.println("Digite seu cpf: ");
						String cpf = sc.next();
						for (Pessoa Dados : paciCadastrados) {
						if ((Dados.getCpf()).equals(cpf)) {
							    marcarConsulta.setCpf(Dados.getCpf());
							    marcarConsulta.setNome(Dados.getNome());
							    break;
						}
						}
						System.out.println("Digite o crm do médico");
						int crm = sc.nextInt();
						for (Medico Dados : medCadastrados) {
							if (crm == Dados.getCrm() 
									&& Dados.getAtivoInativo() == true) {
								marcarConsulta.setCrmDoutor(Dados.getCrm());
								marcarConsulta.setDoutor(Dados.getNome());
								
								System.out.println("Digite a data para "
										+ "agendamento da consulta: ");
								marcarConsulta.setDataConsulta(sc.next());
								System.out.println("Digite o horário "
										+ "da consulta: ");
								marcarConsulta.setHorarioConsulta(sc.next());
								System.out.println("Consulta de retorno? "
										+ "[S/N]");
								String retorno = sc.next();
								if (retorno.equalsIgnoreCase("S")) {
									marcarConsulta.setConsultaRetorno(true);
								} else {
									marcarConsulta.setValorConsulta(280.00);
								}
								marcarConsulta.setStatusConsulta("Ativa");
								marcarConsulta.setNumeroDaConsulta(contador);
								contador++;
								consultaAgendada.add(marcarConsulta);

								System.out.println("Consulta agendada "
										+ "com sucesso!");
								break;
							} else {
								System.out.println("\nMédico Inativado reative "
										+ "o médico ou " 
										+ "aloque outro médico\n");
						
							}
						}
	
						break;
					} // fim do bloco cadastro consulta
					case 2: {
						System.out.println("     Relatório "
								+ "consultas agendadas     \n");
						System.out.print("Digite a data referente "
								+ "a consulta: ");
						String data = sc.next();
						System.out.print("Digite o crm do médico: ");
						int crm = sc.nextInt();
						System.out.println();
			
						for (Consulta consultas : consultaAgendada) {
							if ((consultas.getStatusConsulta()).equals("Ativa")
								& (consultas.getDataConsulta()).equals(data) 
								& consultas.getCrmDoutor() == crm) {
							System.out.printf("Número consulta: %d\n" 
							+ "Nome paciente: %s\n" + "Cpf do paciente: %s\n"
						    + "Doutor alocado: %s\n" + "Data da consulta: %s\n" 
							+ "Retorno: %b\n"
							+ "Status: %s\n" + "Valor: R$ %.2f\n",
									consultas.getNumeroDaConsulta(), 
									consultas.getNome(), consultas.getCpf(),
									consultas.getDoutor(),
									consultas.getDataConsulta(), 
									consultas.getConsultaRetorno(),
									consultas.getStatusConsulta(), 
									consultas.getValorConsulta());
						System.out.println("\n---------------------------");
							}
						}
						break;
					}

					case 3: {
						System.out.println("     Cancelamento de consulta  \n");
						System.out.println("Digite o cpf do paciente");
						String cpf = sc.next();
						System.out.println("Digite a data da consulta");
						String data = sc.next();
						System.out.println("Digite o crm do Médico");
						int crm = sc.nextInt();
						for (Consulta consultas : consultaAgendada) {
							if (consultas.getStatusConsulta().equals("Ativa") 
							&& consultas.getCpf().equals(cpf)
							&& consultas.getCrmDoutor() == crm 
							&& consultas.getDataConsulta().equals(data)) {
								consultas.setValorConsulta(0.0);
								consultas.setStatusConsulta("Inativo");
								System.out.println("Consulta número: " 
								+ consultas.getNumeroDaConsulta() 
								+ " Inativada");
							}

						}
					} // case 3 fim
					default:
						break;

					}

				}
			} // fim do bloco opc 3

			if (op == 4) {
				double total = 0.0;
				ArrayList<Consulta> relatorioFinanceiro = new ArrayList<>();
				System.out.println("           Relatório financeiro     \n");
				System.out.println("Digite a data referente a consulta");
				String data = sc.next();
				for (Consulta cons : consultaAgendada) {
					if (data.equals(cons.getDataConsulta()) 
							& cons.getStatusConsulta().equals("Ativa"))
						relatorioFinanceiro.add(cons);
					    total += cons.getValorConsulta();

				}
				for (Consulta relatorio : relatorioFinanceiro) {
					if(relatorio.statusConsulta.equals("Ativa")) {
					System.out.printf("\nNúmero da consulta: %d\n" 
				    + "Valor da consulta: %.2f\n\n",
				relatorio.getNumeroDaConsulta(), relatorio.getValorConsulta());
				}
					}
				System.out.println("\nLucro total na data: " + total);
				System.out.println("\nDigite qualquer "
						+ "tecla para continuar...");
				sc.next();

			}
		} while (op != 5); // fim do while

		System.out.println("Obrigado galera, até a próxima, "
				+ "deixa o like e ativa o sininho de notificações!");
		sc.close();
	} // fim do bloco main
} // fim da classe
