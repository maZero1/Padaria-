package src.Model.Dao;

import src.Model.Entities.ItemVenda;
import src.Model.Dao.connection.ConnectionFactory;
import java.sql.*;
import java.util.List;

public class ItemVendaDAO {
    public void registrarItens(int idVenda, List<ItemVenda> itens) {
        String sql = "INSERT INTO item_venda (id_venda, id_produto, quantidade, subtotal) VALUES (?, ?, ?, ?)";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            for (ItemVenda item : itens) {
                stmt.setInt(1, idVenda);
                stmt.setInt(2, item.getIdProduto());
                stmt.setInt(3, item.getQuantidade());
                stmt.setDouble(4, item.getSubtotal());
                stmt.addBatch();
            }
            stmt.executeBatch();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
