package Aula3;

public class Moto extends Veiculo {

	private String motor;
	
	private int ano;
	
	public Moto() {
		this.instanciarLocomocao();
		
	}
	
	public String getMotor() {
		return motor;
	}

	public void setMotor(String motor) {
		this.motor = motor;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	@Override
	public void acelerar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void instanciarLocomocao() {
		locomocao = new Motor();
		
	}

}
