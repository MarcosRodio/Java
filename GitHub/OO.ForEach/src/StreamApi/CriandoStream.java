package StreamApi;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class CriandoStream {
	
	public static void main(String[] args) {
		
		Consumer<Object> print = System.out::print;
		Consumer<Object> println = System.out::println;
		Stream<String> langs = Stream.of("Java ", "Lua ", "JS\n");
		langs.forEach(print);
		
		String [] maisLangs = {"Python ", "Lisp ", "Pearl ", "Go\n" };
		
		Stream.of(maisLangs).forEach(print);
		
		Arrays.stream(maisLangs).forEach(print);
		Arrays.stream(maisLangs,1,3).forEach(print);//utilizando indice
		List<String> outrasLang = Arrays.asList("\nC ", "PHP ", "Kotlin\n");
		outrasLang.stream().forEach(print);
		outrasLang.parallelStream().forEach(print);
		//Stream.generate(() -> "a").forEach(print);
		//Stream.iterate(0, n -> n + 1).forEach(println);
	}

}
