package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class PostgreConnection {
    
  static String driverJDBC = "org.postgresql.Driver";
  private String pgUrl = "jdbc:postgresql://localhost:5432/";
  private String username;
  private String password;
  

  public PostgreConnection(String username, String password) {
    this.username = username;
    this.password = password;
    this.pgUrl += "desafio";
  }

  public PostgreConnection(String username, String password, String database) {
    this.username = username;
    this.password = password;
    this.pgUrl += database;
  }

  public Connection getConnection() {
    if(this.loadDriverJDbC()) {
      try {
        var props = new Properties();
        props.setProperty("user", this.username);
        props.setProperty("password", this.password);
    
        return DriverManager.getConnection(pgUrl, props);
      } catch(Exception e) {
        System.out.println("Erro conectar ao banco!");
        System.err.println(e.getMessage());
      }
    }
    return null;
  }

  boolean loadDriverJDbC() {
    try {
      // System.out.println("Carregando Driver JDBC...");
      Class.forName(driverJDBC);
      // System.out.println("Driver carregado com sucesso!");
      return true;
    } catch (Exception e) {
      System.err.println("Erro ao carregar o driver JDBC...");
      System.err.print(e.getMessage());
    }
    return false;
  }
}
