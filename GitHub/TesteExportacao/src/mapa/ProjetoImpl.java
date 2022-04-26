package br.unicesumar.mapa;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import br.unicesumar.mapa.Exceptions.DadoConsultadoException;

public class ProjetoImpl implements ProjetoDAO {
	// Collection que irá armazenar todos os projetos
	private static Set<Projeto> projetos = new HashSet<>();

	@Override
	public void adicionar(Projeto projeto) {
		projetos.add(projeto);
	}

	@Override
	public List<Projeto> listar() {
		List<Projeto> lista = new ArrayList<>();
		//System.out.println(projetos.toString());
		lista.addAll(projetos);
		return lista;
	}

	@Override
	public Projeto consultarPorNome(String nome) throws DadoConsultadoException {
		Projeto p = new Projeto();
		for (Projeto item : projetos) {
			if (item.getNome().equalsIgnoreCase(nome)) {
				p = item;
				break;
			} else {
				
			}

	}
		
		return p;
}

	@Override
	public Projeto alterar(String nome, Projeto projeto) throws DadoConsultadoException {
		for (Projeto item : projetos) {
			if (item.getNome().equalsIgnoreCase(nome)) {
				projetos.remove(item);
				projetos.add(projeto);
		}
		}
		return projeto;
	}
	@Override
	public void excluir(Projeto projeto) throws DadoConsultadoException, UnsupportedOperationException {
		projetos.remove(projeto);
	}

	@Override
	public void excluir(String nome) throws DadoConsultadoException, UnsupportedOperationException {
		if (projetos.isEmpty()) System.out.println("Não existem Projetos Cadastrados."
				+ "\nPara cadastrar volte ao menu anterior e digite a opção [1] - Cadastrar.5");

		for (Projeto item : projetos) {
			if (item.getNome().equalsIgnoreCase(nome)) {
				projetos.remove(item);
				System.out.println("Projeto excluido com sucesso!");
			} else {
				System.out.println("Não encontrado");
			}

		}
	}
}
