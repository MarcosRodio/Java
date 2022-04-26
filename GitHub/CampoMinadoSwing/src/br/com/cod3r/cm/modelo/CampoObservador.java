package br.com.cod3r.cm.modelo;

@FunctionalInterface
public interface CampoObservador {
	
	public void eventoocorreu(Campo campo, CampoEvento evento); 
}
