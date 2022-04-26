package Br.Unicesumar.Atividade1;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		double delta = 0;
		Equacoes e1 = new Equacoes();
		do {
			try {
				e1.capturaDados();
				delta = e1.delta();
				e1.valida(delta);
			} catch (Exception e) {
				System.out.println("\nDELTA: NEGATIVO");
				System.out.println("\nA EQUAÇÃO NÃO POSSUI VALOR REAL.");
			}
			if (delta > 0) {
				System.out.println("\nA EQUAÇÃO POSSUI DUAS RAIZES REAIS E DISTINTAS.");
				e1.raizesX(delta);
			} else if (delta == 0) {
				System.out.println("\nA EQUAÇÃO POSSUI RAIZES REAIS E IGUAIS.");
				e1.raizesX(delta);
			}

		} while (repete());
		System.out.println("ENCERRANDO O PROGRAMA...");

	}

	public static boolean repete() {
		boolean sim = false;
		System.out.println("QUER RESOLVER OUTRA EQUAÇÃO? - S/N \n");
		Scanner entrada = new Scanner(System.in);
		String opcao = entrada.next();
		if (opcao.equalsIgnoreCase("s"))
			sim = true;
		entrada.close();
		return sim;

	}
}
