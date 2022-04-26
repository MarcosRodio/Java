
public class Carro extends Veiculo {
	
	private String motor;
	
	@Override
	public void acelerar() {
		System.out.println("Acelerando com motor...");
	}

	public String getMotor() {
		return motor;
	}

	public void setMotor(String motor) {
		this.motor = motor;
	}
	
}
