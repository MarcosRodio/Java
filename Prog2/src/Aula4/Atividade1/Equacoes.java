package Br.Unicesumar.Atividade1;

import java.util.Scanner;

public class Equacoes {

	private double var_a;
	private double var_b;
	private double var_c;

	public void capturaDados() {
		Scanner entrada = new Scanner(System.in);
		System.out.println("VAMOS RESOLVER A EQUAÇÃO DE 2° GRAU.\n");
		System.out.print("QUAL O VALOR DE A: ");
		var_a = entrada.nextDouble();
		System.out.print("QUAL O VALOR DE B: ");
		var_b = entrada.nextDouble();
		System.out.print("QUAL O VALOR DE C: ");
		var_c = entrada.nextDouble();

	}

	public double delta() {
		return (var_b * var_b) - (4 * var_a * var_c);
	}

	public void raizesX(double delta) {
		double x1 = (-var_b + Math.sqrt(delta)) / (2 * var_a);
		double x2 = (-var_b - Math.sqrt(delta)) / (2 * var_a);
		System.out.println("VALORES DE X =  X': " + x1 + ", " + "X'': " + x2);
	}

	public double valida(double delta) {
		if (delta < 0) {
			throw new ArithmeticException("A EQUAÇÃO NÃO POSSUI VALOR REAL.");
		}
		return delta;
	}

	public double getVar_a() {
		return var_a;
	}

	public void setVar_a(double var_a) {
		this.var_a = var_a;
	}

	public double getVar_b() {
		return var_b;
	}

	public void setVar_b(double var_b) {
		this.var_b = var_b;
	}

	public double getVar_c() {
		return var_c;
	}

	public void setVar_c(double var_c) {
		this.var_c = var_c;
	}

}
