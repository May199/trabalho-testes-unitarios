package br.com.aula;

public class Conta {

	private final Cliente cliente;
	private final int numeroConta;
	private int saldo;
	private final TipoConta tipoConta;
	private final boolean contaInvalido;

	public Conta(Cliente cliente, int numeroConta, int saldo, TipoConta tipoConta) {
		this.cliente = cliente;
		this.numeroConta = numeroConta;
		this.saldo = saldo;
		this.tipoConta = tipoConta;

		// Não deve cadastrar conta com número de conta inválido (Altere a implementação!).
		if(numeroConta < 1){
			System.out.println("Não é possível cadastrar conta com número negativo.");
			contaInvalido = true;
		}
		else {
			contaInvalido = false;
		}
	}

	public void creditar(int valor) {
		this.saldo = this.getSaldo() + valor;
	}

	public void debitar(int valor) {
		this.saldo = this.getSaldo() - valor;
	}

	public TipoConta getTipoConta() {
		return tipoConta;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public int getNumeroConta() {
		return numeroConta;
	}

	public int getSaldo() { return saldo; }

	public  boolean getContaInvalido(){return contaInvalido;}
}
