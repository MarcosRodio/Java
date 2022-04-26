package Modelo;

import java.util.Scanner;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "produtos")
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	private String nome;
	
	private Double preco;

	private int unidades;
	
	public Produto() {
		
	}
	
	

	public Produto(String nome, Double preco, int unidades) {
		this.nome = nome;
		this.preco = preco;
		this.unidades = unidades;
	}



	public int getUnidades() {
		return unidades;
	}



	public void setUnidades(int unidades) {
		this.unidades = unidades;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}
	
	
	public static Produto novoProduto () {
		Produto novoProduto = new Produto();
		@SuppressWarnings("resource")
		Scanner entrada = new Scanner(System.in);
		@SuppressWarnings("resource")
		Scanner entrada2 = new Scanner(System.in);
		System.out.println("Informe o nome do produto: ");
		novoProduto.setNome(entrada.nextLine());
		System.out.println("Informe o preco do produto: ");
		novoProduto.setPreco(entrada2.nextDouble());
		System.out.println("Informe quantas unidades do produto: ");
		novoProduto.setUnidades(entrada2.nextInt());
		
		//entrada.close();
		//entrada2.close();
		return novoProduto;
	}
		public static Produto selecionaProduto () {
			Produto novoProduto = new Produto();
			@SuppressWarnings("resource")
			Scanner entrada = new Scanner(System.in);
			System.out.println("Informe o id do produto: ");
			novoProduto.setId(entrada.nextLong());
			
		return novoProduto;
	}

}
