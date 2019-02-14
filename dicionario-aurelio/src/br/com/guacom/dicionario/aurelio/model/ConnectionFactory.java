package br.com.guacom.dicionario.aurelio.model;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {
	private static Properties props;
	
	public static Connection getConnection() {
		props = new Properties();
		try {
			props.load(Files.newBufferedReader(Paths.get("config.properties")));
			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection(props.getProperty("connection"), props.getProperty("user"), props.getProperty("pass"));
		} catch (SQLException | IOException | ClassNotFoundException ex) {
			System.out.println("Erro: " + ex.getMessage());
		}
		return null;
	}
}
