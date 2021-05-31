package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import database.PostgreConnection;

public class Model {
  
  protected Connection conn;
  protected Statement st;
  protected PreparedStatement pst;
  protected ResultSet rs;

  public Model() {
    var pg = new PostgreConnection("postgres", "12345678");
    this.conn = pg.connect();
  }

}
