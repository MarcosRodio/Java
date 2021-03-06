package StreamApi;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.UnaryOperator;

public class Map {
	
	public static void main(String[] args) {
		Consumer<String> print = System.out::print;
		
		List<String> marcas = Arrays.asList(" Bmw", " honda", "  	 Audi");
		
		marcas.stream().map(m -> m.toUpperCase()).forEach(print);
		
		UnaryOperator<String> maiuscula = n-> n.toUpperCase();
		
		UnaryOperator<String> primeiraLetra = n-> n.charAt(0)+"";
		
		UnaryOperator<String> grito = n-> n+"!!!  ";
		System.out.println("");
		marcas.stream().map(maiuscula).forEach(print);
		System.out.println();
		marcas.stream().map(maiuscula).map(primeiraLetra).forEach(print);
		System.out.println();
		marcas.stream().map(maiuscula).map(grito).forEach(print);
 	}

}
