package src.Controller;

import src.Model.Entities.Venda;
import src.Model.Dao.ItemVendaDAO;
import src.Model.Dao.VendaDAO;

public class VendaController {
    private VendaDAO vendaDAO;
    private ItemVendaDAO itemVendaDAO;

    public VendaController() {
        this.vendaDAO = new VendaDAO();
        this.itemVendaDAO = new ItemVendaDAO();
    }
    public void registrarVenda(Venda venda) throws Exception {
        int idGerado = vendaDAO.registrarVenda(venda);
        if (idGerado != -1) {
            itemVendaDAO.registrarItens(idGerado, venda.getItens());
            System.out.println("Venda registrada com sucesso! ID: " + idGerado);
        } else {
            System.err.println("Erro ao registrar venda!");
        }
    }
}
