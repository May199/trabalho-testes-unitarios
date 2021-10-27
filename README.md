<h1 align="center"> Teste e Validação de Sistemas </h1>

<h1 align="center"> Atividade desenvolvida na Universidade de Fortaleza(UNIFOR) </h1>

### Descrição

> Com base no estudo de explicado em sala, elabore os testes unitários para os cenários abaixo:

### Casos de Testes

- [x] Deve cadastrar uma conta.
- [x] Não deve cadastrar conta com número de conta já existente.
- [x] Não deve cadastrar conta com número de conta inválido (Altere a implementação!).
- [x] Não deve cadastrar conta com nome de cliente já existente.
- [x] Deve realizar transferência entre contas Corrente e Poupança.
- [x] Deve-se verificar a existência da conta de origem no banco.
- [x] Não deve permitir que uma conta de origem do tipo Poupança fique com saldo negativo.
- [x] Deve verificar existência da conta de destino no banco.
- [x] Não deve permitir transferir um valor negativo (Altere a implementação!).

### Solução

> Os testes unitários foram realizados e bem sucedidos, adicionamos algumas validações nas classes `Banco.java`, `Conta.java`. 

> Antes de executar os testes, também adicionamos algumas validações para verificação de entradas.

### Configuração de Ambiente
> Estamos utilizando a versão do java  `11.0.11` e foi necessario modificar a tag `<properties>` no arquivo `pom.xml` dessa forma: 

```
<properties>
    <maven.compiler.source>11.0.11</maven.compiler.source>
    <maven.compiler.target>11.0.11</maven.compiler.target>
    <java.version>11</java.version>
</properties>
```

### Equipe

- #### Emanuelle Neves
- #### Matheus Rodrigues
- #### Rafael Tavares
- #### Dante Dantas
