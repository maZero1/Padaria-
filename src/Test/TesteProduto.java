package src.Test;

import src.Model.Entities.Produto;
import src.Controller.ProdutoController;

public class TesteProduto {
    public static void main(String[] args) {
        ProdutoController produtoController = new ProdutoController();

        // Adicionar um novo produto
        Produto novoProduto = new Produto("Pão Francês", 0.50, "Padaria", 100, 20, null);
        produtoController.adicionarProduto(novoProduto);

        // Listar todos os produtos
        System.out.println("Lista de Produtos:");
        for (Produto produto : produtoController.listarProdutos()) {
            System.out.println("Nome: " + produto.getNome() + ", Preço: " + produto.getPreco() + ", Estoque: " + produto.getQuantidadeEstoque());
        }

        // Atualizar o estoque de um produto (supondo que o ID do produto seja 1)
        produtoController.atualizarEstoque(1, 80);

        // Remover um produto (supondo que o ID do produto seja 1)
        produtoController.removerProduto(1);
    }
    
}
