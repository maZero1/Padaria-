package src.Model.Dao;

import src.Model.Entities.Venda;
import src.Model.Dao.connection.ConnectionFactory;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VendaDAO {
    public int registrarVenda(Venda venda) {
        String sqlInsert = "INSERT INTO vendas (cliente_id, data, total) VALUES (?, ?, ?)";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sqlInsert, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setInt(1, venda.getCliente().getId());
            pstmt.setDate(2, venda.getVendaData());
            pstmt.setDouble(3, venda.getTotal());
            ResultSet rs = pstmt.executeQuery();

            int affectedRows = pstmt.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("Falha ao registrar a venda, nenhuma linha afetada.");
            }
            try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    return generatedKeys.getInt(1);
                } else {
                    throw new SQLException("Falha ao registrar a venda, nenhum ID obtido.");
                }
            }
        } catch (SQLException e) {
            System.err.println("Erro ao registrar venda: " + e.getMessage());
            return -1;
        }
    }
}
