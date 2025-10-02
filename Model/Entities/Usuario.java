package Model.Entities;

public class Usuario {
    private Integer id;
    private String nome;
    private String login;
    private String senhaHash;
    private PerfilUsuario perfil; // Enum para definir o perfil do usuário (ENUM: ADMIN, FUNCIONARIO)
}
