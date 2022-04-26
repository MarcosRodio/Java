package Lambdas;

import java.util.function.Predicate;

public class PredicadoComposicao {

	public static void main(String[] args) {
		Predicate<Integer> isPar = num -> num % 2 == 0;
		
		Predicate<Integer> isTresDigitos = num -> num >= 100 && num <= 999;
		
		Predicate <Integer> isImpar = num -> num % 2 != 0;
		
		System.out.println(isPar.test(22));
		
		System.out.println(isTresDigitos.test(133));
		
		System.out.println(isPar.and(isTresDigitos).test(122));
		
		System.out.println(isPar.or(isTresDigitos).test(99));
		
		System.out.println(isImpar.and(isTresDigitos).test(133));
		
		
	}
}
