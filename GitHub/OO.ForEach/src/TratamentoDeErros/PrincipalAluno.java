package TratamentoDeErros;

public class PrincipalAluno {
	public static void main(String[] args) {
		
		try {
			Aluno obj = null;
		obj.testeMetodo();	
			System.out.println("Chegou ao fim do Try...");
		} catch (Exception e) {

			System.out.println("Exception: ->" + e);

		}finally{
			System.out.println("Passou pelo Finally...");
		}
	
		Aluno obj2 = new Aluno();
		obj2.divida(2, 0);
	}
}
