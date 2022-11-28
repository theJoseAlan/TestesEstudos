import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ExemploJDBC {
    public static void main(String[] args) throws SQLException {

        Connection conn = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/mildevs", "postgres","04032000");

        System.out.println("Conectado!");
        conn.close();

    }
}