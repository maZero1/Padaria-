package src.Model.Dao.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConnectionFactory {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/padaria_bd"; 
        String user = "postgres";
        String password = "PGCEAVI"; 
        try {
            Class.forName("org.postgresql.Driver");
            System.out.println("Driver JDBC carregado com sucesso!");

            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("✅ Conexão estabelecida com sucesso!");

            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT version();");

            if (rs.next()) {
                System.out.println("Versão do PostgreSQL: " + rs.getString(1));
            }
            rs.close();
            stmt.close();
            conn.close();
            System.out.println("🔒 Conexão encerrada com sucesso.");
        } catch (Exception e) {
            System.err.println("❌ Erro ao conectar: " + e.getMessage());
        }
    }

    public static Connection getConnection() {
        throw new UnsupportedOperationException("Unimplemented method 'getConnection'");
    }
}
