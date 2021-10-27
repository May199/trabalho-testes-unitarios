package br.com.aula;

import java.util.ArrayList;
import java.util.List;

import br.com.aula.exception.ContaJaExistenteException;
import br.com.aula.exception.ContaNaoExistenteException;
import br.com.aula.exception.ContaSemSaldoException;

public class Banco {

	private List<Conta> contas = new ArrayList<Conta>();

	public Banco() {}
	public Banco(List<Conta> contas) {
		this.contas = contas;
	}

	public void cadastrarConta(Conta conta) throws ContaJaExistenteException {

		for (Conta c : contas) {
			boolean isNomeClienteIgual = c.getCliente().getNome().equals(conta.getCliente().getNome());
			boolean isNumeroContaIgual = c.getNumeroConta() == conta.getNumeroConta();

			// Não deve cadastrar conta com número de conta já existente
			if (isNomeClienteIgual || isNumeroContaIgual) {
				throw new ContaJaExistenteException();
			}
		}
		
		this.contas.add(conta);

	}

	public void efetuarTransferencia(int numeroContaOrigem, int numeroContaDestino, int valor, int tipoConta)
			throws ContaNaoExistenteException, ContaSemSaldoException {

		Conta contaOrigem = this.obterContaPorNumero(numeroContaOrigem);
		Conta contaDestino = this.obterContaPorNumero(numeroContaDestino);

		// Deve-se verificar a existência da conta de origem no banco/destino
		boolean isContaOrigemExistente = contaOrigem != null;
		boolean isContaDestinoExistente = contaDestino != null;

        // Não deve permitir transferir um valor negativo (Altere a implementação!)
		if (valor >= 1){
			// Deve-se verificar a existência da conta de origem no banco/destino
			if (isContaOrigemExistente && isContaDestinoExistente) {
				boolean isContaOrigem;
				boolean isSaldoContaOrigemNegativo;

				if(tipoConta == 1) {
					isContaOrigem = contaOrigem.getTipoConta().equals(TipoConta.CORRENTE);
					isSaldoContaOrigemNegativo = contaOrigem.getSaldo() - valor < 0;

					if (isContaOrigem && isSaldoContaOrigemNegativo) {
						throw new ContaSemSaldoException();
					}else{
						contaOrigem.debitar(valor);
						contaDestino.creditar(valor);
					}
				}
				// Não deve permitir que uma conta de origem do tipo Poupança fique com saldo negativo
				if(tipoConta == 2){
					isContaOrigem = contaOrigem.getTipoConta().equals(TipoConta.POUPANCA);
					isSaldoContaOrigemNegativo = contaOrigem.getSaldo() - valor < 0;

					if(isContaOrigem && isSaldoContaOrigemNegativo){
						System.out.println("Conta do tipo poupança não pode ficar com saldo negativo, saldo atual: "+ contaOrigem.getSaldo());
					}
					else{
						contaOrigem.debitar(valor);
						contaDestino.creditar(valor);
					}
				}


			} else {
				throw new ContaNaoExistenteException();
			}
		}
		else{
			System.out.println("Insira um valor válido positivo diferente de: "+ valor);
		}
	}

	public Conta obterContaPorNumero(int numeroConta) {

		for (Conta c : contas) {
			if (c.getNumeroConta() == numeroConta) {
				return c;
			}
		}
		return null;
	}

	public List<Conta> obterContas() {
		return this.contas;
	}
}
