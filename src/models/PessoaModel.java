package models;

import java.sql.SQLException;

import entidades.Pessoa;
import entidades.Professor;

public class PessoaModel extends Model {

  public Pessoa buscarCPF(String value) {
    Pessoa pessoa = null;
    try {
      this.pst = this.conn.prepareStatement("SELECT * FROM pessoas WHERE cpf = ?");
      this.pst.setString(1, value);
      this.pst.setMaxRows(1); 
      this.rs = this.pst.executeQuery();

      if(rs.next()) {
        int id = this.rs.getInt("id");
        String nome = this.rs.getString("nome");
        String cpf = this.rs.getString("cpf");
        // System.out.printf("ID:%d, NOME:%s, CPF:%s", id, nome, cpf);
        pessoa = new Professor(id, nome, cpf);
      }
      
      this.rs.close();
      this.pst.close();
    } catch (SQLException e) {
      System.err.println("PessoaModel::buscarCPF SQLException");
      System.err.println(e.getMessage());
    } catch (Exception e) {
      System.err.println("PessoaModel::buscarCPF Exception");
      System.err.println(e.getMessage());
    }
    return pessoa;
  }

  public boolean salvar(Pessoa pessoa) {
    try {
      String query = "INSERT INTO pessoas (nome, cpf, is_professor)"
        + "VALUES (?, ?, ?)";
      pst = conn.prepareStatement(query);
      pst.setString(1, pessoa.getNome()); 
      pst.setString(2, pessoa.getCPF()); 
      pst.setBoolean(3, pessoa.isProfessor());

      int rowsAffected = pst.executeUpdate();
      if(rowsAffected > 0) {
        System.out.println("Cadastrado com sucesso!");
        return true;
      } else {
        System.err.println("CPF já cadastrado!");
      }
    } catch (SQLException e) {
      System.err.println("PessoaModel::salvar SQLException");
      System.err.println(e.getMessage());
    } catch (Exception e) {
      System.err.println("PessoaModel::salvar Exception");
      System.err.println(e.getMessage());
    }
    return false;
  }

  public void getAll(boolean isProfessor) {
    try {
      this.pst = this.conn.prepareStatement("SELECT * FROM pessoas WHERE is_professor = ?");
      this.pst.setBoolean(1, isProfessor);
      this.rs = pst.executeQuery();
      String entidade = isProfessor ? "Professores" : "Alunos";
      System.out.printf("\nEXIBINDO %s!\n", entidade);
      while (rs.next()) {
        int id = rs.getInt("id");
        String nome = rs.getString("nome");
        String cpf = rs.getString("cpf");
        System.out.printf("CODIGO: %d | %s: %s | CPF: %s\n", id, entidade, nome, cpf);
      }
      this.rs.close();
      this.pst.close();
      this.conn.close();
    } catch (SQLException e) {
      System.err.println("PessoaModel::getAll SQLException");
      System.err.println(e.getMessage());
    } catch (Exception e) {
      System.err.println("PessoaModel::getAll Exception");
      e.printStackTrace();
    }
  }
}
