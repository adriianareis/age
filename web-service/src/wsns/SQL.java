package wsns;

import java.sql.*;

public class SQL {

	public static String ConnectionString = "jdbc:sqlserver://localhost:59145;"
			+ "databaseName=teste;"
			+ "user=teste;"
			+ "password=teste;";
	
	// função para executar queries e retornar um ResultSet
	public static ResultSet runQuery(String query){
		try {
			// criar e abrir conexão
			Connection connection = DriverManager.getConnection(ConnectionString);
			// criar comando sql
			Statement stmt = connection.createStatement();
			// exeuctar query
			return stmt.executeQuery(query);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			System.out.println(query);
			return null;
		}
	}
	
	
	public static int runCommand(String query) {
		try {
			// criar e abrir conexão
			Connection connection = DriverManager.getConnection(ConnectionString);
			// criar comando sql
			Statement stmt = connection.createStatement();
			// exeuctar query
			return stmt.executeUpdate(query);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			System.out.println(query);
			return 0;
		}
	}
	
}

