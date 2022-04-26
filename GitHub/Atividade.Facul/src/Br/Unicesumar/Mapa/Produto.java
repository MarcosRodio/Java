package Br.Unicesumar.Mapa;

public class Produto {
    private String nome;
    private double preco;
    private int quantidade;
    private String uniMedida;

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public String getUniMedida() {
        return uniMedida;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public void setUniMedida(String uniMedida) {
        this.uniMedida = uniMedida;
    }
}