package src.Model.Dao;

import src.Model.Entities.Cliente;
import src.Model.Dao.connection.ConnectionFactory;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {
    public void adicionarCliente(Cliente cliente) {
        String sql = "INSERT INTO clientes (nome, email, telefone) VALUES (?, ?, ?)";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, cliente.getNome());
            pstmt.setString(2, cliente.getEmail());
            pstmt.setString(3, cliente.getTelefone());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public List<Cliente> listarClientes() {
        List<Cliente> clientes = new ArrayList<>();
        String sql = "SELECT id, nome, email, telefone, pontos_fidelidade FROM clientes";
        try (Connection conn = ConnectionFactory.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Cliente cliente = new Cliente(
                    rs.getString("nome"),
                    rs.getString("cpf"),
                    rs.getString("telefone"),
                    rs.getInt("pontos_fidelidade"),
                    new ArrayList<>()
                );
                clientes.add(cliente);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clientes;
    }
    public void atualizarPontosFidelidade(int clienteId, int novosPontos) {
        String sql = "UPDATE clientes SET pontos_fidelidade = ? WHERE id = ?";
        try (Connection conn = ConnectionFactory.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, novosPontos);
            pstmt.setInt(2, clienteId);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void removerCliente(int clienteId) {
        String sql = "DELETE FROM clientes WHERE id = ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, clienteId);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public Cliente buscarClientePorId(int clienteId) {
        String sql = "SELECT id, nome, email, telefone, pontos_fidelidade FROM clientes WHERE id = ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, clienteId);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return new Cliente(
                        rs.getString("nome"),
                        rs.getString("cpf"),
                        rs.getString("telefone"),
                        rs.getInt("pontos_fidelidade"),
                        new ArrayList<>()
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
