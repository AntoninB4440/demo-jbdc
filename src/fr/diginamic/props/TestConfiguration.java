package fr.diginamic.props;

import java.util.ResourceBundle;

public class TestConfiguration {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ResourceBundle monFichierConf = ResourceBundle.getBundle("database");

		/*
		 * Boucle sur le fichier Enumeration<String> keys = monFichierConf.getKeys();
		 * 
		 * while (keys.hasMoreElements()) { String key = keys.nextElement();
		 * System.out.println(monFichierConf.getString(key)); }
		 */

		String driverName = monFichierConf.getString("database.driver");

		System.out.println(driverName);
	}

}
