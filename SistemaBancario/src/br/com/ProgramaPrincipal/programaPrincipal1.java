package br.com.ProgramaPrincipal;
import java.util.Scanner;
import br.com.DAO.pessoaFisicaDAO;
import br.com.DAO.pessoaJuridicaDAO;
import br.com.POJO.pessoaFisicaPOJO;
import br.com.POJO.pessoaJuridicaPOJO;


public class programaPrincipal1 {
	
	public static void main(String[] args) {
	
		Scanner input = new Scanner(System.in);
		pessoaJuridicaDAO PessoaJuridica = new pessoaJuridicaDAO();
		pessoaFisicaDAO PessoaFisica = new pessoaFisicaDAO();
		int opcao = 0;
		
		do {
			menu();
			opcao = input.nextInt();
			

			switch(opcao) {
				case 1: 
					System.out.println("\nOpção 1 - Cadastre novo Cliente");
					cadastraCliente(input);
					break;
				case 2:
					System.out.println("\nOpção 2 - Remova um Cliente com base no Número da Conta");
					RemoveCliente(input);
					
					break;
				case 3:
					System.out.println("\nOpção 3 - Consulte o Cliente com base no Número da Conta");
					ConsultaCliente(input);
					
					break;
				case 4:
					System.out.println("\nOpção 4 - Informe o número da conta e novo limite do Cheque Especial");
					AlterarChequeEspecial(input);
					
					break;
				case 5:
					
					System.out.println("\nOpção 5 - Informe os números das contas e valor a ser transferido");
					TranferenciaCliente(input);
					
					
					break;
				case 6:
					System.out.println("\nOpção 6 - Informe o número da conta e valor a ser adicionado");
					RealizarDeposito(input);
					
					break;
				case 7:
					System.out.println("\nOpção 7 - Relatório de todos os clientes");
					System.out.println(PessoaJuridica.ConsultaClientesPJ());
					System.out.println(PessoaFisica.ConsultaClientesPF());
					
					break;
				case 8:
					System.out.println("\nOpção 8 - Total de saldo de todos os clientes: ");
					System.out.print("R$"+PessoaJuridica.saldoTotalClientes()); 
					System.out.println("\n");
					
					break;
				case 0:
					System.out.println("Programa encerrado");
					
					
					
					break;
				default: 
					System.out.println("FALHA: Digite uma opção válida");
			}
		}while(opcao!=0);
		
		input.close();
	}

	public static void menu() {
		System.out.println("Digite o número da operação desejada:");
		System.out.println("1 - Cadastrar novo cliente");
		System.out.println("2 - Remover cliente de sua carteira");
		System.out.println("3 - Consultar cliente");
		System.out.println("4 - Aumentar/Diminuir limite do Cheque Especial");
		System.out.println("5 - Realizar Transferência entre clientes");
		System.out.println("6 - Depósito em conta");
		System.out.println("7 - Gerar Relatório de clientes");
		System.out.println("8 - Total de saldo depositado");
		System.out.println("0 - Finalizar");
	}

	private static void AlterarChequeEspecial(Scanner input) {
		
		System.out.println("Informe o tipo da sua conta: \n"
				+ "Cliente Pessoa Física - (1) ou Pessoa Jurídica - (2):");
		 int tipo = input.nextInt();
		
		System.out.println("\n4 - Altere o cheque especial com base no Número da Conta");
		System.out.println("Informe o número da conta:");
		 int NumConta = input.nextInt();
		 
		System.out.println("Informe o novo valor do cheque especial: ");
		double ValorCheque = input.nextDouble();
		
		 switch(tipo) {
			case 1: 
				pessoaFisicaDAO PessoaFisica = new pessoaFisicaDAO();
				PessoaFisica.alteraChequeEspecial(ValorCheque, NumConta);
				break;
				
			case 2:
				pessoaJuridicaDAO PessoaJuridica = new pessoaJuridicaDAO();
				PessoaJuridica.alteraChequeEspecial(ValorCheque,NumConta);
				break;
			}
	}

	private static void TranferenciaCliente(Scanner input) {
		int tipoContaTransferidor;
		int numeroContaTransferidor;
		int numeroContaDestino;
		double  ValorTransferir;
		
		System.out.println("Informe o tipo da sua conta: \n"
				+ "Cliente Pessoa Física - (1) ou Pessoa Jurídica - (2):");
		 tipoContaTransferidor = input.nextInt();
		
		System.out.println("Número da conta do transferidor: ");
		numeroContaTransferidor = input.nextInt();
		
		System.out.println("Informe qual o tipo da conta que deseja fazer transferência: \n"
				+ "Cliente Pessoa Física - (1) ou Pessoa Jurídica - (2):");
		int tipoContaDestino = input.nextInt();
		
		System.out.println("Número da conta : ");
		 numeroContaDestino = input.nextInt();
		
		
		System.out.println("Informe o valor: ");
		ValorTransferir = input.nextDouble();
		
		
		
		switch(tipoContaDestino) {
		case 1: 
			pessoaFisicaDAO PessoaFisica = new pessoaFisicaDAO();
			PessoaFisica.TransferenciaClienteParaPF(numeroContaDestino, numeroContaTransferidor, ValorTransferir, tipoContaTransferidor);
			break;
			
		case 2:
			pessoaJuridicaDAO PessoaJuridica = new pessoaJuridicaDAO();
			PessoaJuridica.TransferenciaClienteParaPJ(numeroContaDestino,numeroContaTransferidor,ValorTransferir,  tipoContaTransferidor);
			break;
		}
		
	}

	private static void cadastraCliente(Scanner input) {
		int numeroConta;
		String agencia; 
		String telefone;
		double saldo;
		double chequeEspecial;
		
		System.out.println("Cliente Pessoa Física - (1) ou Pessoa Jurídica - (2):");
		int tipo = input.nextInt();
		
		System.out.println("Número da Conta: ");
		numeroConta = input.nextInt();
		input.nextLine();
		
		System.out.println("Agência: ");
		agencia = input.nextLine();
		
		System.out.println("Telefone: ");
		telefone = input.nextLine();
		
		System.out.println("Saldo da Conta: ");
		saldo = input.nextDouble();
		input.nextLine();
		
		System.out.println("Cheque Especial: ");
		chequeEspecial = input.nextDouble();
		input.nextLine();
		
		if(tipo == 1) {
			String cpf, nome;
			int idade;
			System.out.println("CPF do Titular: ");
			cpf = input.nextLine();
			System.out.println("Nome do Titular: ");
			nome = input.nextLine();
			System.out.println("Idade do Titular: ");
			idade = input.nextInt();
			
			pessoaFisicaPOJO  PF = new pessoaFisicaPOJO(numeroConta, agencia, telefone, saldo, chequeEspecial, cpf, nome, idade);
			pessoaFisicaDAO DAO = new pessoaFisicaDAO();
			DAO.insereCliente(PF);
		}else if(tipo == 2) {
			String cnpj, razaoSocial, nomeFantasia;
			System.out.println("CNPJ: ");
			cnpj = input.nextLine();
			System.out.println("Razão Social: ");
			razaoSocial = input.nextLine();
			System.out.println("Nome Fantasia: ");
			nomeFantasia = input.nextLine();
			
			pessoaJuridicaPOJO PJ = new pessoaJuridicaPOJO(numeroConta, agencia, telefone, saldo, chequeEspecial, 
				cnpj, razaoSocial, nomeFantasia);
			pessoaJuridicaDAO DAO = new pessoaJuridicaDAO();
			DAO.InsereCliente(PJ);
		}
		
	}
	
	private static void RemoveCliente(Scanner input) {
		int numeroConta;
		int opcao;
		
		System.out.println("Cliente Pessoa Física - (1) ou Pessoa Jurídica - (2):");
		opcao = input.nextInt();
		
		switch(opcao) {
			case 1: 
				System.out.println("\n2 - Remova um Cliente com base no Número da Conta");
				System.out.println("Número da Conta: ");
				numeroConta = input.nextInt();
				
				pessoaFisicaDAO PessoaFisica = new pessoaFisicaDAO();
				PessoaFisica.removeCliente(numeroConta);
				
				break;
				
			case 2:
				System.out.println("\n2 - Remova um Cliente com base no Número da Conta");
				System.out.println("Número da Conta: ");
				numeroConta = input.nextInt();
				
				pessoaJuridicaDAO PessoaJuridica = new pessoaJuridicaDAO();
				PessoaJuridica.removeCliente(numeroConta);
				break;
				
		}
		
							
		
		
	}
	
	private static void ConsultaCliente(Scanner input) {
		int numeroConta;
		int opcao;
		
		System.out.println("1 - Para pessoa Física \n2- Para Pessoa Juridica");
		opcao = input.nextInt();
		
		switch(opcao) {
			case 1: 
				System.out.println("\n3 -  Consulte o Cliente com base no Número da Conta");
				System.out.println("Número da Conta: ");
				numeroConta = input.nextInt();
				
				pessoaFisicaDAO PessoaFisica = new pessoaFisicaDAO();
				PessoaFisica.ConsultaCliente(numeroConta); 
				System.out.println();

				
				break;
			case 2:
				System.out.println("\n3 - Consulte o Cliente com base no Número da Conta");
				System.out.println("Número da Conta: ");
				numeroConta = input.nextInt();


				pessoaJuridicaDAO PessoaJuridica = new pessoaJuridicaDAO();
				PessoaJuridica.ConsultaCliente(numeroConta);
				System.out.println();
				break;
		}
		
	}

	private static void RealizarDeposito(Scanner input) {
		int numeroConta;
		int opcao;
		double ValorDepo;
		
		System.out.println("1 - Para pessoa Física \n2- Para Pessoa Juridica");
		opcao = input.nextInt();
		
		switch(opcao) {
			case 1: 
				System.out.println("\n6 - Realize um deposito com base no Número da Conta");
				System.out.println("Número da Conta: ");
				numeroConta = input.nextInt();
				
				System.out.println("Valor do deposito: ");
				ValorDepo = input.nextDouble();
				
				pessoaFisicaDAO PessoaFisica = new pessoaFisicaDAO();
				PessoaFisica.Depositar(numeroConta, ValorDepo); 
				System.out.println();

				
				break;
			case 2:
				System.out.println("\n6 - Consulte o Cliente com base no Número da Conta");
				System.out.println("Número da Conta: ");
				numeroConta = input.nextInt();
				
				System.out.println("Valor do deposito: ");
				ValorDepo = input.nextDouble();

				pessoaJuridicaDAO PessoaJuridica = new pessoaJuridicaDAO();
				PessoaJuridica.Depositar(numeroConta, ValorDepo );
				System.out.println();
				break;
		}
		
	}

}
