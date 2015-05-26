package br.com.energia.si.poo2.swing.util.jdbc;

import br.com.energia.si.poo2.swing.util.jdbc.ConnectionManager.BD;
import br.com.energia.si.poo2.swing.util.properties.PropertiesReader;
import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionFactory {
	private Connection connection;
	//	Singleton
	private static ConnectionFactory instance = new ConnectionFactory();
        
        private ConnectionFactory() {}
        
	public static ConnectionFactory getInstance() {
		return instance;
	}

	public Connection getConnection() {
		try {
                    if (connection == null || connection.isClosed()) {
                        connect();
                    }
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}

	private void connect() {
            try {
                ConnectionManager con = new ConnectionManager(BD.MYSQL, 
                        PropertiesReader.getDatabaseHost(), Integer.parseInt(PropertiesReader.getDatabasePort()), 
                            PropertiesReader.getDatabaseUser(), PropertiesReader.getDatabasePassword(), 
                            PropertiesReader.getDatabaseName());

                connection = con.getConnection();

            } catch (Exception e) {
                    e.printStackTrace();
            }
	}
        
        public void closeConnection(Connection con) {
            try {
                if (connection != null) {
                    connection.close();
                    con.close();
                }

            } catch(Exception _e) {
                    System.err.println("CONEXAO.JAVA: " + _e);
            }
        }
}
