package Model.Entities;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private Integer id;
    private String nome;
    private String cpf;
    private String telefone;
    private int pontosFidelidade;
    private List<Venda> vendas;

    public Cliente(String nome, String cpf, String telefone, int pontosFidelidade, List<Venda> vendas) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.pontosFidelidade = 0; // Inicializa com 0 pontos
        this.vendas = new ArrayList<>();
    }
    public int getId() {
        return id;
    }
    public String getNome() {
        return nome;
    }
    public String getCpf() {
        return cpf;
    }
    public String getTelefone() {
        return telefone;
    }
    public int getPontosFidelidade() {
        return pontosFidelidade;
    }
    public void adicionarPontos(int pontos) {
        this.pontosFidelidade += pontos;
    }
    public boolean usarPontos(int pontos) {
        if (pontos <= this.pontosFidelidade) {
            this.pontosFidelidade -= pontos;
            return true;
        }
        return false; // Não há pontos suficientes
    }
    public List<Venda> getVendas() {
        return vendas;
    }
}
