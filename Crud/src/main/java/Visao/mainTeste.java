package Visao;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Modelo.Pessoa;


public class mainTeste {
	
	public static void main(String[] args) {
		
	
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("crud");
		EntityManager em = emf.createEntityManager();
		
		Scanner entrada = new Scanner(System.in);
		System.out.println("Nome: ");
		String nome = entrada.nextLine();
		System.out.println("Email: ");
		String email = entrada.nextLine();
		System.out.println("CPF: ");
		String cpf = entrada.nextLine();
		
		Pessoa novoUsuario = new Pessoa (nome,cpf, email);
		
		
		entrada.close();
		em.getTransaction().begin();
		em.persist(novoUsuario);
		em.getTransaction().commit();
	}
}
