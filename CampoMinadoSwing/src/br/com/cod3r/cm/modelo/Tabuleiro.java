package br.com.cod3r.cm.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;



public class Tabuleiro implements CampoObservador {

	private final int linhas;
	public int getLinhas() {
		return linhas;
	}

	public int getColunas() {
		return colunas;
	}

	public int getMinas() {
		return minas;
	}

	public List<Campo> getCampos() {
		return campos;
	}

	public List<Consumer<Boolean>> getObservadores() {
		return observadores;
	}

	private final int colunas;
	private final int minas;

	private final List<Campo> campos = new ArrayList<>();
	private final List<Consumer<Boolean>> observadores = new ArrayList<>();

	public Tabuleiro(int linhas, int colunas, int minas) {
		this.linhas = linhas;
		this.colunas = colunas;
		this.minas = minas;

		gerarCampos();
		associarVizinhos();
		sortearMinas();
	}
	
	public void paraCadaCampo(Consumer<Campo> funcao) {
		campos.forEach(funcao);
	}
	public void registrarObservador(Consumer<Boolean> observador) {
		observadores.add(observador);
	}
	
	private void notificarObservadores(boolean resultado) {
		observadores.stream().forEach(obs -> obs.accept(resultado));
	}
	public void abrir(int linha, int coluna) {
	
		campos.parallelStream().filter(c -> c.getLinha() == linha && c.getColuna() == coluna)
		.findFirst()
		.ifPresent(c -> c.abrir());;
	}
	
		
	public void alterarMarcacao(int linha, int coluna) {
		campos.parallelStream().filter(c -> c.getLinha() == linha && c.getColuna() == coluna)
		.findFirst()
		.ifPresent(c -> c.alternarMarcacao());;
		
	}

	private void gerarCampos() {
		for (int linha = 0; linha < linhas; linha++) {
			for (int coluna = 0; coluna < colunas; coluna++) {
				Campo campo = new Campo(linha,coluna);
				campo.registrarObservador(this);
				campos.add(new Campo(linha, coluna));
			}
		}
	}

	private void associarVizinhos() {
		for (Campo c1 : campos) {
			for (Campo c2 : campos) {
				c1.adicionarVizinho(c2);
			}
		}
	}

	private void sortearMinas() {
		long minasarmadas = 0;
		Predicate<Campo> minado = c -> c.isMinado();
		do {
			int aleatorio = (int) (Math.random() * campos.size());
			campos.get(aleatorio).minar();
			minasarmadas = campos.stream().filter(minado).count();
		} while (minasarmadas < minas);
	}

	public boolean objetivoAlcancado() {
		return campos.stream().allMatch(c -> c.objetivoAlcancado());
	}

	public void reinicializar() {
		campos.stream().forEach(c -> c.reiniciar());
		sortearMinas();
	}

	@Override
	public void eventoocorreu(Campo campo, CampoEvento evento) {
		if(evento == CampoEvento.EXPLODIR) {
			mostrarMinas();
			notificarObservadores(false);
		}else if(objetivoAlcancado()) {
			notificarObservadores(true);
		}
	}
	
	private void mostrarMinas() {
		campos.stream().filter(c -> c.isMinado()).forEach(c -> c.setAberto(true));
	}
}