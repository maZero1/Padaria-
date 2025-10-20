package src.Model.Entities;

public class Produto {
    private Integer id;
    private String nome;
    private double preco;
    private String tipo;
    private int quantidadeEstoque;
    private int estoqueMinimo;
    private Integer custoPontos;

    public Produto(String nome, double preco, String tipo, int quantidadeEstoque, int estoqueMinimo, Integer custoPontos) {
        this.nome = nome;
        this.preco = preco;
        this.tipo = tipo;
        this.quantidadeEstoque = quantidadeEstoque;
        this.estoqueMinimo = estoqueMinimo;
        this.custoPontos = custoPontos;
    }
    public Integer getId() {
        return id;
    }
    public String getNome() {
        return nome;
    }
    public double getPreco() {
        return preco;
    }
    public String getTipo() {
        return tipo;
    }
    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }
    public int getEstoqueMinimo() {
        return estoqueMinimo;
    }
    public Integer getCustoPontos() {
        return custoPontos;
    }
    public void reduzirEstoque(int quantidade) {
        if (quantidade <= this.quantidadeEstoque) {
            this.quantidadeEstoque -= quantidade;
        } else {
            throw new IllegalArgumentException("Quantidade insuficiente em estoque.");
        }
    }
    public boolean isEstoqueBaixo() {
        boolean baixo = this.quantidadeEstoque < this.estoqueMinimo;
        if (baixo) {
            System.out.println("Estoque baixo para o produto: " + this.nome);
        }
        return baixo;
    }
}
