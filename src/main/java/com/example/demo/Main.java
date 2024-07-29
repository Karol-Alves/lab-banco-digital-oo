package com.example.demo;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Digite o nome do cliente: ");
		String nomeCliente = scanner.nextLine();

		Cliente cliente = new Cliente();
		cliente.setNome(nomeCliente);

		Conta contaCorrente = new ContaCorrente(cliente);
		Conta contaPoupanca = new ContaPoupanca(cliente);

		boolean continuar = true;

		while (continuar) {
			System.out.println("\nEscolha uma operação:");
			System.out.println("1. Depositar na Conta Corrente");
			System.out.println("2. Sacar da Conta Corrente");
			System.out.println("3. Transferir para Conta Poupança");
			System.out.println("4. Imprimir Extratos");
			System.out.println("5. Sair");
			System.out.print("Opção: ");

			int opcao = scanner.nextInt();

			switch (opcao) {
				case 1:
					System.out.print("Digite o valor para depósito: ");
					double valorDeposito = scanner.nextDouble();
					contaCorrente.depositar(valorDeposito);
					break;

				case 2:
					System.out.print("Digite o valor para saque: ");
					double valorSaque = scanner.nextDouble();
					contaCorrente.sacar(valorSaque);
					break;

				case 3:
					System.out.print("Digite o valor para transferir: ");
					double valorTransferencia = scanner.nextDouble();
					contaCorrente.transferir(valorTransferencia, contaPoupanca);
					break;

				case 4:
					System.out.println("\nExtrato Conta Corrente:");
					contaCorrente.imprimirExtrato();
					System.out.println("\nExtrato Conta Poupança:");
					contaPoupanca.imprimirExtrato();
					break;

				case 5:
					continuar = false;
					break;

				default:
					System.out.println("Opção inválida. Tente novamente.");
			}
		}

		scanner.close();
		System.out.println("Operações finalizadas.");
	}
}

