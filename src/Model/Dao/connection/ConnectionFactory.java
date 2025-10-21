package src.Model.Dao.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    private static final String URL = "jdbc:postgresql://localhost:5432/padaria_bd";
    private static final String USER = "postgres";
    private static final String PASSWORD = "PGCEAVI";

    public static Connection getConnection() {
        try {
            Class.forName("org.postgresql.Driver");

            // Retorna a conexão
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            System.err.println("Driver não encontrado: " + e.getMessage());
            return null;
        } catch (SQLException e) {
            System.err.println("Erro na conexão: " + e.getMessage());
            return null;
        }
    }
}
