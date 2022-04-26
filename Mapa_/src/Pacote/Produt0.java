package Pacote;
public class Produt0 {
    
    private String nome;
    private double preco;
    private String unidade;
    private int quantidadeEmEstoque;
    String getQuantidadeEmEstoque;

    public String getNome() {
        return nome;
    }
    public String getUnidade(){
        return unidade;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    
    public double getPreco() {
        return preco;
         }
    
    public void setPreco(double preco) {
        this.preco = preco;
    }
       
    
    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    public int getQuantidadeEmEstoque() {
        return quantidadeEmEstoque;
    }

    public void setQuantidadeEmEstoque(int quantidadeEmEstoque) {
        this.quantidadeEmEstoque = quantidadeEmEstoque;
    }

    @Override
    public String toString() {
        return "NOME: " + nome + "\n" +
                "UNIDADE: " + unidade + "\n" +
                "QUANTIDADE: " + quantidadeEmEstoque;
    }

    public void setAdicionarQuantidade(int quantidade) {
        this.quantidadeEmEstoque+=quantidade;
    }

    public void setDiminuirQuantidade(int quantidade) {
        this.quantidadeEmEstoque-=quantidade;
    }

}