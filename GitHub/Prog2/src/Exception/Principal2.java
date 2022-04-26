package Exception;

import java.util.Scanner;

public class Principal2 {
	
	public static void main(String[] args) {
		Pessoa pessoa = new Pessoa();
		
		
		System.out.println("Informe o nome");
		pessoa.setNome(coletaDados());
		do{
		try {
		System.out.println("Informe a Idade");
		pessoa.setIdade(coletaDados());
		System.out.println(pessoa);
		break;
		}catch(IdadeException e) {
			System.out.println(e.getMessage());
		}
		}while(true);
	}
	
	private static String coletaDados() {
		Scanner entrada = new Scanner(System.in);
		String resposta = entrada.nextLine();
		return resposta;
		
		
	}
}
		
		
	

