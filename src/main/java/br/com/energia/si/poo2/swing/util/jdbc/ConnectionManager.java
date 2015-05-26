package br.com.energia.si.poo2.swing.util.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Classe para efetuar conexao com banco de dados.
 * 
 * BDs: ORACLE, POSTGRES, MYSQL, SQLSERVER
 * 
 * @author Juliano
 *
 */
public class ConnectionManager {

	public static enum BD {ORACLE, POSTGRES, MYSQL, SQLSERVER};
	
	private String typeBD;
	
	private String classUrlDataBase;
	
	private String urlDataBase;
	
	private String user;
	
	private String password;
	
	private String host;
	
	private int port;
	
	private String nameDataBase;
	
	private Connection connection;
	
	
	public String getUser() {
		return user;
	}

	public String getHost() {
		return host;
	}

	public int getPort() {
		return port;
	}

	public String getNameDataBase() {
		return nameDataBase;
	}

	public Connection getConnection() {
		return connection;
	}

	public Statement getStatement() throws SQLException {
		return getConnection().createStatement();
	}

	/**
	 * Recebe os dados e cria uma conexao com o banco de dados.
	 * 
	 * @param typeBD
	 * @param _host
	 * @param _port
	 * @param _user
	 * @param _password
	 * @param _nameDataBase
	 */
	public ConnectionManager(BD typeBD, String _host, int _port, String _user, String _password, String _nameDataBase) {
		
		this.typeBD = typeBD.toString();
		
		this.host = _host;
		this.port = _port;
		this.user = _user;
		this.password = _password;
		this.nameDataBase = _nameDataBase;
		
		if(this.user == null || this.password == null ||
				this.host == null || this.port == 0) {	
			
			return;
			
		}
		
		this.classUrlDataBase();
		this.checkDriver();
		this.makeUrlDatabase();
		this.connecting();
	}
	
	/**
	 * Verifica se existe o driver de conexão na library.
	 * 
	 * @param classUrlDataBase
	 */
	private void checkDriver() {
		
		try {		
			
			Class.forName(classUrlDataBase);			
			
		} catch (ClassNotFoundException cnf) {
			
			System.out.println("Driver não encontrado " + classUrlDataBase);
			System.out.println("Messagem: " + cnf.getMessage());
		}
		
	}
	
	/**
	 * Define a classe de url do banco de dados.
	 */
	private void classUrlDataBase() {
		
		if(this.typeBD.equals(BD.ORACLE.toString())) this.classUrlDataBase = "oracle.jdbc.OracleDriver";
		if(this.typeBD.equals(BD.POSTGRES.toString())) this.classUrlDataBase = "org.postgresql.Driver";
		if(this.typeBD.equals(BD.MYSQL.toString())) this.classUrlDataBase = "com.mysql.jdbc.Driver";
		if(this.typeBD.equals(BD.SQLSERVER.toString())) this.classUrlDataBase = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	}
	
	/**
	 * Define a url de conexao do banco de dados.
	 */
	private void makeUrlDatabase() {
		
		if(this.typeBD.equals(BD.ORACLE.toString())) 
			this.urlDataBase = "jdbc:oracle:thin:@" + getHost() + ":" + getPort() + ":" + getNameDataBase();
		
		if(this.typeBD.equals(BD.POSTGRES.toString())) 
			this.urlDataBase = "jdbc:postgresql://" + getHost() + ":" + getPort() + "/" + getNameDataBase();
		
		if(this.typeBD.equals(BD.MYSQL.toString())) 
			this.urlDataBase = "jdbc:mysql://" + getHost() + ":" + getPort() + "/" + getNameDataBase();
		
		if(this.typeBD.equals(BD.SQLSERVER.toString())) 
			this.urlDataBase = "jdbc:sqlserver://" + getHost() + ":" + getPort() + ";databaseName=" + getNameDataBase();
	}
	
	/**
	 * Faz a conexao com os parametros passado.
	 */
	private void connecting() {
		
		try {			
                    this.connection = DriverManager.getConnection(this.urlDataBase, this.user, this.password);
			
		}catch (SQLException se) {
			
			System.out.println("Nao foi possivel efetuar a conexao: " + se.getMessage());
		}
	}

}