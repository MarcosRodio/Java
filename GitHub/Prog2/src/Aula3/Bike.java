package Aula3;

public class Bike extends Veiculo{

	public Bike() {
		this.instanciarLocomocao();
	}
	
	@Override
	public void instanciarLocomocao() {
		locomocao = new Pedal();
		
	}

	@Override
	public void acelerar() {
	locomocao.acelerar();
		
	}

	
	
}
