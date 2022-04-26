package Aula3;

public class PrincipalVeiculo {

	public static void main(String[] args) {
		Veiculo obj = new Carro();
		
		obj.acelerar();
		
		obj = new Bike();
		
		obj.acelerar();
	}
}
