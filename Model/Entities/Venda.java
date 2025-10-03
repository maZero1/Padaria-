package Model.Entities;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Venda {
    private Integer id;
    private Cliente cliente;
    private Date vendaData;
    private List<ItemVenda> itens;
    private double total;

    public Venda(Cliente cliente, Date vendaData, List<ItemVenda> itens, double total) {
        this.cliente = cliente;
        this.vendaData = vendaData;
        this.itens = itens;
        this.total = total;
        this.itens = new ArrayList<>();
        //Relacionamento Bidirecional
        cliente.getVendas().add(this);
    }
    public Integer getId() {
        return id;
    }
    public Cliente getCliente() {
        return cliente;
    }
    public Date getVendaData() {
        return vendaData;
    }
    public List<ItemVenda> getItens() {
        return itens;
    }
    public double getTotal() {
        return total;
    }
    public void adicionarItem(ItemVenda item) {
        this.itens.add(item);
        this.total += item.getSubtotal();
    }
    public void removerItem(ItemVenda item) {
        if (this.itens.remove(item)) {
            this.total -= item.getSubtotal();
        }
    }
}
