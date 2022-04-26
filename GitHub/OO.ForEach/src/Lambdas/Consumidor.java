package Lambdas;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;



public class Consumidor {

	public static void main(String[] args) {
		
		Produto p1 = new Produto ("Notebook",3000,0.25);
		Produto p2 = new Produto ("Caneta",7,0.07);
		Produto p3 = new Produto ("Carderno",19.80,0.03);
		Produto p4 = new Produto ("Borracha",3.45,0.18);
		Produto p5 = new Produto ("Lapis",3000,0.25);
		Consumer<Produto> imprimir = valor -> System.out.printf("Produto: "+ valor.getNome()+" "+"Preço: "+valor.getPreco()+"\n");
		
		imprimir.accept(p1);
		
		List<Produto> produto = Arrays.asList(p1,p2,p3,p4,p5); 
		System.out.println("************");
		produto.forEach(imprimir);
		System.out.println("************");
		produto.forEach(prod -> System.out.println("Desconto:"+prod.getDesconto()));
		System.out.println("************");
		produto.forEach(p-> System.out.println("Preço: "+p.preco));
		System.out.println("************");
		produto.forEach(System.out::println);
		
		
	}
}
