package Lambdas;

import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;

public class OperadorBinario {
public static void main(String[] args) {
	
	BinaryOperator<Double> media = (n1,n2) -> (n1+n2)/2;
	System.out.println(media.apply(9.8, 5.7));
	
	BiFunction<Double, Double, String> status = (n1,n2)->((n1+n2)/2) >= 7 ? "Aprovado": "Reprovado";
	
	BiFunction<Double, Double, String> status2 = (n1,n2)->{
		double notafinal =(n1+n2)/2;
		return notafinal>= 7 ? "Aprovado": "Reprovado";
		};
	
	System.out.println(status.apply(9.0, 8.0));
	System.out.println(status2.apply(9.0, 7.2));
	
	Function<Double , String > conceito =
			m -> m >= 7 ?"Aprovado": "Reprovado";
		System.out.println(media.andThen(conceito).apply(9.7, 4.1));	
			
}
}
