package br.com.cod3r.cm.visao;

import javax.swing.JFrame;

import br.com.cod3r.cm.modelo.Tabuleiro;

@SuppressWarnings("serial")
public class TelaPrincipal extends JFrame {
	
	TelaPrincipal(){
		Tabuleiro tabuleiro = new Tabuleiro(16,30,50);
		add( new PainelTabuleiro(tabuleiro));
		
		setTitle("Campo Minado");
		setVisible(true);
		setSize(690,438);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		
	};
	public static void main(String[] args) {
		new TelaPrincipal();
	
	
	}

}
