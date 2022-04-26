	package br.unicesumar.mapa;

import java.util.List;

public interface ProjetoDAO {
	 
	    void adicionar(Projeto projeto);
	    List<Projeto> listar();
	    Projeto consultarPorNome(String nome) throws br.unicesumar.mapa.Exceptions.DadoConsultadoException;
	    Projeto alterar(String nome, Projeto projeto) throws br.unicesumar.mapa.Exceptions.DadoConsultadoException;
	    void excluir(Projeto projeto) throws br.unicesumar.mapa.Exceptions.DadoConsultadoException, UnsupportedOperationException;
	    void excluir(String nome) throws br.unicesumar.mapa.Exceptions.DadoConsultadoException, UnsupportedOperationException;
	}

