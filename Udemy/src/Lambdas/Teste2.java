package Lambdas;

public class Teste2 {
	public static void main(String[] args) {
		//expressao lambda ou seja uma fun��o anonima "lambda functions"
		Calculo calculo = (x,y) -> {
			return x + y;
		};
		System.out.println(calculo.executar(2,3));
	}
}
