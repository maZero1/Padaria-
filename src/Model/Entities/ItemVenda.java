package src.Model.Entities;

public class ItemVenda {
    private Produto produto;
    private int quantidade;
    private double subTotal;

    public ItemVenda(Produto produto, int quantidade, double subTotal) {
        this.produto = produto;
        this.quantidade = quantidade;
        this.subTotal = subTotal;
    }
    public ItemVenda(Produto produto, int quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
        this.subTotal = produto.getPreco() * quantidade;
    }
    public int getIdProduto() {
        return produto.getId();
    }
    public Produto getProduto() {
        return produto;
    }
    public int getQuantidade() {
        return quantidade;
    }
    public double getSubtotal() {
        return subTotal;
    }
}
