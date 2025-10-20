package src.Model.Entities;

//import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private Integer id;
    private String nome;
    private String email;
    private String cpf;
    private String telefone;
    private int pontosFidelidade;
    private List<Venda> vendas;

    public Cliente(String nome, String cpf, String telefone, String email, int pontosFidelidade) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.email = email;
        this.pontosFidelidade = pontosFidelidade;
    }
    public int getId() {
        return id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getCpf() {
        return cpf;
    }
    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    public int getPontosFidelidade() {
        return pontosFidelidade;
    }
    public void setPontosFidelidade(int pontosFidelidade) {
        if(pontosFidelidade >= 0) {
            this.pontosFidelidade = pontosFidelidade;
        }
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
