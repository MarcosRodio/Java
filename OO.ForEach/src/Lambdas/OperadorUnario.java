package Lambdas;

import java.util.function.UnaryOperator;

public class OperadorUnario {
	
	public static void main(String[] args) {
		
		UnaryOperator<Integer> maisDois = n ->	n + 2;
		UnaryOperator<Integer> vezesDois = n ->	n * 2;
		UnaryOperator<Integer> Quadrado = n ->	n * n;
		
		int resultado = maisDois
				.andThen(vezesDois)
				.andThen(Quadrado)
				.apply(0);
		
		int resultado2 = Quadrado.compose(vezesDois).compose(maisDois).apply(0);
		
		System.out.println(resultado);
		System.out.println(resultado2);
		
	}

}
