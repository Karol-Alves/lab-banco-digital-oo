package com.example.demo;

import com.example.demo.Conta;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

public class Banco {

	@Getter
	@Setter
	private String nome;

	private List<Conta> contas = new ArrayList<>();


	public void adicionarConta(Conta conta) {
		contas.add(conta);
	}

	public void listarContas() {
		for (Conta conta : contas) {
			conta.imprimirExtrato();
		}
	}


}
