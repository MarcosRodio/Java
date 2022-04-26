package TratamentoDeErros;

public class Aluno {
	
	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void testeMetodo() {
		System.out.println("Entrando no Metodo...");
	}
	
	public double divida(double dividendo, double divisor)
	throws ArithmeticException{
		if(divisor == 0) {
			divisor = 1.0;
			throw new ArithmeticException("Divisor não pode ser 0");
			
			
		}
		return 0;
	}

}
