package br.com.energia.si.poo2.swing.util.jdbc;

import br.com.energia.si.poo2.swing.util.jdbc.ConnectionFactory;
import br.com.energia.si.poo2.swing.util.properties.PropertiesReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class CriarBanco {	
	
    private static final String SQL_TABELA_MODALIDADE = "create table if not exists MODALIDADE (" +
    		"             ID_MODALIDADE INT NOT NULL PRIMARY KEY AUTO_INCREMENT ," +
    		"             DESCRICAO_MODALIDADE VARCHAR(45)" +
    		
    		"             );";
    

   
    private static final String SQL_TABELA_CURSO = "create table if not exists CURSO (" +
    		"             ID_CURSO INT NOT NULL PRIMARY KEY AUTO_INCREMENT," +
    		"             DESCRICAO_CURSO VARCHAR(45) NOT NULL," +
    		"             ID_MODALIDADE INT NOT NULL," +
    		"             CONSTRAINT PK_ID_MODALIDADE_CURSO" +
    		"             FOREIGN KEY (ID_MODALIDADE) REFERENCES MODALIDADE(ID_MODALIDADE)" +
    		"             ON DELETE CASCADE" +
    		"             ON UPDATE CASCADE" +
    		"             );";
    
   
    CriarBanco() {
        criarTabelas();
    }

    public static void criarTabelas() {
        Connection connection = null;
        try {

            connection = ConnectionFactory.getInstance().getConnection();

            Statement stm = connection.createStatement();
            
            System.out.println("::: Criando Tabelas");

            stm.executeUpdate(SQL_TABELA_MODALIDADE);
            System.out.println("::: Tabela MODALIDADE criada com sucesso");
            
          
            
            stm.executeUpdate(SQL_TABELA_CURSO);
            System.out.println("::: Tabela CURSO criada com sucesso");
            
          
            System.out.println("::: Tabelas Criadas");

        } catch (Exception e) {
            e.printStackTrace();;
        } finally {
            ConnectionFactory.getInstance().closeConnection(connection);
        }
    }

    public static void main(String[] args) {
        criarBanco();
        criarTabelas();
    }
    
     public static void criarBanco() {
        System.out.println("::: Criando Banco de Dados");
        Connection connection = null;
        try {
            connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/?user=root&password=root");
                    //"jdbc:postgresql://localhost:5432/?user=postgres&password="+senha); 
                    //"jdbc:mysql://localhost:3306/?user=root&password="+senha);
            Statement statement = connection.createStatement();
            statement.executeUpdate("create database " + PropertiesReader.getDatabaseName());
            System.out.println("::: Banco criado");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}


