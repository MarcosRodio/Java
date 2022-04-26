package Lambdas;

public class Produto {

	String nome;
	double preco;
	double desconto;
	
	public Produto(String nome, double preco, double desconto) {
	
		this.nome = nome;
		this.preco = preco;
		this.desconto = desconto;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public double getDesconto() {
		return desconto;
	}

	public void setDesconto(double desconto) {
		this.desconto = desconto;
	}
	
	public String toString() {
		double precoFinal = (preco * (1-getDesconto()));
		return "Nome: "+ getNome() + " tem preço de R$ "+getPreco()+"."+"\n"+
				"Preço com desconto "+ precoFinal;
	}
	
	
}
