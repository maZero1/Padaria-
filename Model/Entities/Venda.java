package Model.Entities;

import java.sql.Date;
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
    }
}
