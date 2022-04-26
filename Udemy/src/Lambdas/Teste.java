package Lambdas;

public class Teste {
public static void main(String[] args) {
	Calculo soma = new Soma();
	Calculo multiplica = new Multiplica();
	
	System.out.println(soma.executar(2,3));
	System.out.println(multiplica.executar(2,3));
	
	Calculo calculoPolimorfico = new Soma();
	System.out.println(calculoPolimorfico.executar(2,3));
	
	calculoPolimorfico = new Multiplica();
	System.out.println(calculoPolimorfico.executar(2,3));
}
}
