package src.Model.Entities;

public class Usuario {
    private Integer id;
    private String nome;
    private String login;
    private String senhaHash;
    private PerfilUsuario perfil; // Enum para definir o perfil do usuário (ENUM: ADMIN, FUNCIONARIO)

    public enum PerfilUsuario {
        ADMIN,
        FUNCIONARIO
    }
    public Integer getId() {
        return id;
    }
    public String getNome() {
        return nome;
    }
    public String getLogin() {
        return login;
    }
    public String getSenhaHash() {
        return senhaHash;
    }
    public PerfilUsuario getPerfil() {
        return perfil;
    }
}
