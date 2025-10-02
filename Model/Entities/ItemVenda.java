package Model.Entities;

public class ItemVenda {
    private Produto produto;
    private int quantidade;
    private double subTotal;

    public ItemVenda(Produto produto, int quantidade, double subTotal) {
        this.produto = produto;
        this.quantidade = quantidade;
        this.subTotal = subTotal;
    }
}
