package Infra;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import Modelo.Produto;

public class DAO <E>{

	private static EntityManagerFactory emf;
	private EntityManager em;
	private Class <E> classe;
	
	static {
		
		try { 
		emf = Persistence.createEntityManagerFactory("Cadastro");
			
	}catch (Exception e) {
		// logar -> log4j
	}
}
	
	
	public DAO() {
		this(null);
	}


	public DAO(Class <E> classe) {
		em = emf.createEntityManager();
		this.classe = classe;
	}
	
	public DAO<E> abrirT(){
		em.getTransaction().begin();
		return this;
	}
	
	public DAO<E> fecharT(){
		em.getTransaction().commit();
		return this;
	} 
	
	public DAO<E> incluir(E entidade){
		em.persist(entidade);
		return this;
	}
	
	public DAO<E> remove(E entidade){
		
		em.getTransaction().begin();
		em.remove(em.merge(entidade));
		em.getTransaction().commit();
		em.close();
		
		return this;
	}
	
	public DAO<E> alterar(E entidade){
		Produto produto = new Produto();
		
		em.getTransaction().begin();
		produto = em.find(Produto.class,2L);
		em.detach(entidade); // tira o objeto do estado gerenciado
		produto.setNome("cola");
		produto.setPreco(2.25);
		em.merge(produto); // torna o objeto gerenciado novamente
		
		em.getTransaction().commit(); // finaliza a transação
		em.close();
		emf.close();
		return this;
	}
	
	
	
	public DAO<E> incluirAtomico(E entidade){
		
		return this.abrirT().incluir(entidade).fecharT();
	}
	//sobrecarga de metodos sem passar parametros para o obter todos
	public List<E> obterTodos(){
				
		return this.obterTodos(10,0);
		
	}
	
	//limit e deslocamento servem para paginar a consulta ex limit 10 deslocamento 0 traz os 10 primeiros resultados - limit 10 deslocalmento 10 traz os proximos 10 e assim por diante.
	public List<E> obterTodos(int limit, int deslocamento){
		if(classe == null) {
			throw new UnsupportedOperationException("Classe Nula");
		}
		
		String jpql = "select e from " + classe.getName() + " e";
		TypedQuery<E> query = em.createQuery(jpql, classe);
		query.setMaxResults(limit);
		query.setFirstResult(deslocamento);
		
		return query.getResultList();
		
	}
	
public E obterPorId(Object id) {
	
	return em.find(classe, id);
}

public E obterPorNome(Object nome) {
	
	return em.find(classe, nome);
}


public List<E> consultar (String nomeConsulta, Object... params){
	TypedQuery<E> query = em.createNamedQuery(nomeConsulta, classe);
	
	for (int i = 0; i < params.length; i++) {
		query.setParameter(params[i].toString(), params[i+1]);
	}
	return query.getResultList();
}

public E consultarUm (String nomeConsulta, Object... params){
	List<E> lista = consultar(nomeConsulta, params);
	
	return lista.isEmpty() ? null : lista.get(0);
}
	
	public void fechar(){
		em.close();
	}
}