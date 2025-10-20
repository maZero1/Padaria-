package src.Controller;

import src.Model.Dao.ProdutoDAO;
import src.Model.Entities.Produto;
import java.util.List;

public class ProdutoController {
    private ProdutoDAO produtoDAO;

    public ProdutoController() {
        this.produtoDAO = new ProdutoDAO();
    }
    public void adicionarProduto(Produto produto) {
        produtoDAO.adicionarProduto(produto);   
    }
    public List<Produto> listarProdutos() {
        return produtoDAO.listarProdutos();
    }
    public void atualizarEstoque(int produtoId, int novaQuantidade) {
        produtoDAO.atualizarEstoque(produtoId, novaQuantidade);
    }
    public void removerProduto(int produtoId) {
        produtoDAO.removerProduto(produtoId);
    }
}
