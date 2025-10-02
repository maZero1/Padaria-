package Model.Entities;

public class Cliente {
    private Integer id;
    private String nome;
    private String cpf;
    private String telefone;
    private int pontosFidelidade;

    public Cliente(String nome, String cpf, String telefone, int pontosFidelidade) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.pontosFidelidade = 0; // Inicializa com 0 pontos
    }
}
