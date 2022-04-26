package Lambdas;

public class CalculoTeste {
public static void main(String[] args) {
	
	Calculo calculo = new Soma();
	 calculo = new Multiplicar();

	
	
	System.out.println("Soma: "+calculo.executar(2, 2));
	System.out.println("Multiplicação: "+calculo.executar(3, 3));
	
}
}
