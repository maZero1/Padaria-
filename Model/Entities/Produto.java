package Model.Entities;

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
}
