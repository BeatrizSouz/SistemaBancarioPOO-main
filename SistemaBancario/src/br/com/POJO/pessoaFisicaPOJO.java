package br.com.POJO;

public class pessoaFisicaPOJO extends Cliente {

	private String cpf;
	private String nome;
	private int idade;
	
	public pessoaFisicaPOJO(int numeroConta, String agencia, String telefone, double saldo, double chequeEspecial, 
			String cpf, String nome, int idade) {
		super(numeroConta, agencia, telefone, saldo, chequeEspecial);
		this.cpf = cpf;
		this.nome = nome;
		this.idade = idade;
	}

	public pessoaFisicaPOJO() {
		super();
	}
	
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}
	
	@Override
	public String toString () {
		return "\nCliente Pessoa Fisica -----------------------------------------------------------------------------------------"
				+"\n[NúmeroConta = " + getNumeroConta() 
				+"\n|Nome =" + nome 
				+"\n|Idade = " + idade
				+"\n|CPF = " + cpf
				+"\n|Agência = " + getAgencia() 
				+"\n|Telefone = " + getTelefone() 
				+"\n|Saldo = " + getSaldo() 
				+"\n|Cheque Especial =" + getChequeEspecial() +"]" 
				+ "\n-------------------------------------------------------------------------------------------------------------\n";
	}
	
}
