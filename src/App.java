package src;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class App {

    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/padaria_bd"; // Altere o nome do seu banco
        String user = "postgres";
        String password = "PGCEAVI"; // coloque sua senha correta

        try {
            // Carregar o driver manualmente (opcional nas versões novas)
            Class.forName("org.postgresql.Driver");
            System.out.println("Driver JDBC carregado com sucesso!");

            // Conectar ao banco
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("✅ Conexão estabelecida com sucesso!");

            // Criar um statement
            Statement stmt = conn.createStatement();

            // Executar uma query simples
            ResultSet rs = stmt.executeQuery("SELECT version();");

            // Mostrar resultado
            if (rs.next()) {
                System.out.println("Versão do PostgreSQL: " + rs.getString(1));
            }

            // Fechar recursos
            rs.close();
            stmt.close();
            conn.close();
            System.out.println("🔒 Conexão encerrada com sucesso.");

        } catch (Exception e) {
            System.err.println("❌ Erro ao conectar: " + e.getMessage());
        }
    }
}

