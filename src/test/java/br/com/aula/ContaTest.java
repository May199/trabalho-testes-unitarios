package br.com.aula;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class ContaTest {

	@Test
	public void deveCreditar() {

		// Cenario Tipo Conta CORRENTE
		Cliente cliente = new Cliente("João");
		Conta c = new Conta(cliente, 123, 10, TipoConta.CORRENTE);

		// Cenario Tipo Conta POUPANCA
		Cliente newcliente = new Cliente("Manu");

		// Para que a ação creditar funciona é só adicionar um número de conta positivo
		Conta newc = new Conta(newcliente, -123, 10, TipoConta.POUPANCA);

		if(!c.getContaInvalido() & !newc.getContaInvalido()){
			// Ação
			c.creditar(5);
			newc.creditar(10);

			// Verificação
			System.out.println("Conta 1: "+ c.getTipoConta());
			System.out.println("Conta 2: "+ newc.getTipoConta());
		}
	}
}
