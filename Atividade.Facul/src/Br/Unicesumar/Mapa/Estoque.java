package Br.Unicesumar.Mapa;

import java.util.ArrayList;
import java.util.Scanner;

public class Estoque {

	ArrayList<Produto> produtos = new ArrayList<Produto>();

	
	 void AddItem(String nome, double preco, int qtde, String uniMedida) {
		Produto p = new Produto();
		this.produtos.add(p);
        p.setNome(nome);
        p.setPreco(preco);
        p.setQuantidade(qtde);
        p.setUniMedida(uniMedida);
    }


 void imprime(){
    for (Produto item : produtos) {
       
            System.out.println("NOME: "+item.getNome()+".");
            System.out.println("PREÇO: R$ "+item.getPreco()+".");
            System.out.println("QUANTIDADE: " +item.getQuantidade()+" "+item.getUniMedida()+"(S).");
        }
    }
}