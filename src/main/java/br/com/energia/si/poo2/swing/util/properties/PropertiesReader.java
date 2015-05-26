package br.com.energia.si.poo2.swing.util.properties;


import java.io.FileInputStream;
import java.util.Properties;

/**
 *
 * @author Juliano Torquato
 */
public class PropertiesReader {
    
    private static String PATH = "src/main/java/config.properties";
    private static Properties file = new Properties();
    
    static {
        try {
            file.load(new FileInputStream(PATH));
        } catch (Exception e) {
            System.err.println("[Erro] PropertiesReader ao ler arquivo: "+ e);
        }
    }    
    
    public static String getNomeBanco(){
        return file.getProperty("banco.dados.url");
    }
    
    /**
    * @return the databaseHost
    */
    public static String getDatabaseHost() {
           return file.getProperty("banco.dados.host");
    }

    /**
    * @return the databasePort
    */
    public static String getDatabasePort() {
           return file.getProperty("banco.dados.port");
    }

    /**
    * @return the databaseName
    */
    public static String getDatabaseName() {
           return file.getProperty("banco.dados.name");
    }

    /**
    * @return the databaseUser
    */
    public static String getDatabaseUser() {
           return file.getProperty("banco.dados.usuario");
    }

    /**
    * @return the databaseUser
    */
    public static String getDatabasePassword() {
           return file.getProperty("banco.dados.senha");
    }
}
