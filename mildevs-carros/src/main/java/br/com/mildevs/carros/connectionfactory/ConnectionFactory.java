package br.com.mildevs.carros.connectionfactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	public static Connection getConnection() {
		try {
			
			return DriverManager.getConnection(
					"jdbc:postgresql://localhost:5432/mildevs", "postgres", "04032000");
			
		} catch (SQLException e) {
			System.err.println("Erro ao estabelecer conexão");
			return null;
		}
	}
}
