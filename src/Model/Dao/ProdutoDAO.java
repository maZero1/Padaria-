package src.Model.Dao;

import src.Model.Entities.Produto;
import src.Model.Dao.connection.ConnectionFactory;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO {
    public void adicionarProduto(Produto produto) {
        String sql = "INSERT INTO produto (nome, preco, quantidade_estoque) VALUES (?, ?, ?)";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, produto.getNome());
            pstmt.setDouble(2, produto.getPreco());
            pstmt.setInt(3, produto.getQuantidadeEstoque());
            pstmt.executeUpdate();
            System.out.println("Produto adicionado com sucesso.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public List<Produto> listarProdutos() {
        List<Produto> produtos = new ArrayList<>();
        String sql = "SELECT * FROM produto";
        try (Connection conn = ConnectionFactory.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Produto produto = new Produto(
                        rs.getString("nome"),
                        rs.getDouble("preco"),
                        rs.getString("tipo"),
                        rs.getInt("quantidade_estoque"),
                        rs.getInt("estoque_minimo"),
                        (Integer) rs.getObject("custo_pontos")
                );
                produtos.add(produto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return produtos;
    }
    public void atualizarEstoque(int produtoId, int novaQuantidade) {
        String sql = "UPDATE produto SET quantidade_estoque = ? WHERE id = ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, novaQuantidade);
            pstmt.setInt(2, produtoId);
            pstmt.executeUpdate();
            System.out.println("Estoque atualizado com sucesso.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void removerProduto(int produtoId) {
        String sql = "DELETE FROM produto WHERE id = ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, produtoId);
            pstmt.executeUpdate();
            System.out.println("Produto removido com sucesso.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
