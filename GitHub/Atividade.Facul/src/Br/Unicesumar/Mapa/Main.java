package Br.Unicesumar.Mapa;


public class Main {
	public static void main(String[] args) {
		
		
		Estoque itens = new Estoque ();
		Produto p = new Produto();
		
		itens.AddItem("Arroz", 10.00, 1, "Pacote");
		itens.AddItem("Feijão", 9.99, 1, "Pacote");
		
		itens.imprime();
	}
}