package Modelo;

import java.util.Scanner;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "nome", length = 200, nullable = false)
	private String nome;
	
	@Column(name = "preco", nullable = false, precision = 11, scale = 2)//precision tamanho do campo scale casas decimais
	private Double preco;
	
	private int unidade;
	
	public Produto() {
		
	}
	
	

	public Produto(String nome, Double preco) {
		this.nome = nome;
		this.preco = preco;
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
	
	public int getUnidade() {
		return unidade;
	}



	public void setUnidade(int unidade) {
		this.unidade = unidade;
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
		
		System.out.println("Informe o numero de unidades: ");
		novoProduto.setUnidade(entrada2.nextInt());
	
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
