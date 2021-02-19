package fr.diginamic.props;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class TestConnection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * try { // Etape 1 : charger le driver, qui est fournie par la librairie de la
		 * DB DriverManager.registerDriver(new Driver());
		 * 
		 * 
		 * } catch (SQLException e) { // TODO Auto-generated catch block
		 * System.out.println("Impossible de charger le driver"); }
		 */
		String password = System.getProperty("password");
		// Run as configuration -> Arguments -> VMArguments -Dpassword=password

		ResourceBundle monFichierConf = ResourceBundle.getBundle("database");
		String driverClass = monFichierConf.getString("database.driver");
		String databaseUrl = monFichierConf.getString("database.url");
		String databaseRoot = monFichierConf.getString("database.user");
		// String databasePW = monFichierConf.getString("database.password");

		try {
			// Etape 1 : charger le driver, qui est fournie par la librairie de la DB
			Class.forName(driverClass);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Impossible de charger le driver");
		}

		try {
			// Etape 2: je demande au DriverManager de me fournir une connexion à une BDD
			// Mysql

			Connection connection = DriverManager.getConnection(databaseUrl, databaseRoot, password);
			System.out.println(connection.isClosed());

			// Etape3 : Creation d'un statement

			Statement statement = connection.createStatement();
			// executeUpdate pour INSERT DELETE AND UPDATE execute pour CREATE TABLE

			// statement.executeUpdate("insert into abonne (nom,prenom) values
			// ('Java','Cours')");

			statement.executeUpdate("delete from abonne where abonne.prenom = 'Cours'");

			connection.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage());
		}

	}

}
