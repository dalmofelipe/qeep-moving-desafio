

public class MainDesafio01 {
  public static void main(String[] args) {
    System.out.println("Hello World!");
  }
}


/*

    // SELECT COM VARIAVEIS
    System.out.println("\nSELECT ALL Tab Funcionarios com WHERE e variaveis");
    PreparedStatement pst = conn.prepareStatement("SELECT * FROM funcionarios WHERE salario > ? AND genero = 'f'");
    pst.setDouble(1, 5000d);

    rs = pst.executeQuery();

    while (rs.next()) {
      int cod = rs.getInt("cod_func");
      String nome = rs.getString("nome");
      String endereco = rs.getString("endereco");
      String genero = rs.getString("genero");
      double salario = rs.getDouble("salario");

      System.out.printf("Funcionario(a)[CodFunc:%d, Nome:%s, Endereço:%s, Genero:%s, Salario:%.2f]\n", 
        cod, nome, endereco, genero, salario);
    }
    

    // INSERT COM VARIAVEIS
    System.out.println("\nINSERT COM VARIAVEIS");
    String query = "INSERT INTO funcionarios (nome, endereco, genero, salario)"
      + "VALUES (?, ?, ?, ?)";
    pst = conn.prepareStatement(query);
    pst.setString(1, "Dalmo F Torres de Paula"); 
    pst.setString(2, "Alameda dos Anjos, 5"); 
    pst.setString(3, "m"); 
    pst.setDouble(4, 15000); 
    int rowsAffected = pst.executeUpdate();
    if(rowsAffected > 0) {
      System.out.println("Funcionário cadastrado com sucesso!");
    }
    

    // UPDATE COM VARIAVEIS
    System.out.println("\nUPDATE COM VARIAVEIS");
    query = "UPDATE funcionarios SET nome = ?, salario = ? WHERE cod_func = ?";
    pst = conn.prepareStatement(query);
    pst.setString(1, "Dalmo Felipe"); 
    pst.setDouble(2, 25000);
    pst.setDouble(3, 8);
    rowsAffected = pst.executeUpdate();
    if(rowsAffected > 0) {
      System.out.println("Funcionário atualizado com sucesso!");
    }


    // DELETE COM VARIAVEIS
    System.out.println("\nDELETE COM VARIAVEIS");
    String nome = "Torres";
    query = "DELETE FROM funcionarios WHERE nome LIKE '%"+nome+"%'";
    pst = conn.prepareStatement(query);
    rowsAffected = pst.executeUpdate();
    if(rowsAffected > 0) {
      System.out.println("Funcionário(as) excluído(as) com sucesso!");
    }


















public boolean incluir(Object o) {
  String sInstrucaoSQL;
  sMensagemErro = "";
  Cliente cliente = (Cliente) o;
  try {
    objConexaoBD.conecta();
    sInstrucaoSQL = "insert into " + NOME_TABELA + campo+ "values( ?,?,?,?,?,?,?,?,?,?,?,?)";
    PreparedStatement stmt = objConexaoBD.con.prepareStatement(sInstrucaoSQL);
    stmt.setInt(1, cliente.getCodCliente());
    stmt.setString(2, cliente.getNome());
    stmt.setString(3, cliente.getEndereco());
    stmt.setString(4, cliente.getFone());
    stmt.setInt(5, cliente.getIdade());
    stmt.setString(6, cliente.getSexo());
    stmt.setFloat(7, (float) cliente.getRendaMensal());
    stmt.execute();
    stmt.close();
    objConexaoBD.desconecta();
  }
  catch(SQLException ex) { 
    sMensagemErro = "SQLException: " + ex.getMessage();
  }
  if(sMensagemErro.equals("")) return true;
  else return false;
}
//*/
