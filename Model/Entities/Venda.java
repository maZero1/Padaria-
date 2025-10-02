package Model.Entities;

import java.sql.Date;
import java.util.List;

public class Venda {
    private Integer id;
    private Cliente cliente;
    private Date vendaData;
    private List<ItemVenda> itens;
    private double total;
}
