package Aula3;

public class Carro extends Veiculo{
	
	public Carro() {
		this.instanciarLocomocao();
	}
	
	private String motor;
	
	
		
	public String getMotor() {
		return motor;
	}


	public void setMotor(String motor) {
		this.motor = motor;
	}

	@Override
	public void instanciarLocomocao() {
		locomocao = new Motor();
		
	}
	
	@Override
	public void acelerar() {
		
		locomocao.acelerar();
	}

	
	public void parar() {
		System.out.println("Parar");
		
	}

	
}
