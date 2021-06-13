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
      String query = "INSERT INTO pessoas (nome, cpf, is_professor) "
        + "VALUES (?, ?, ?)";
      this.pst = this.conn.prepareStatement(query);
      this.pst.setString(1, pessoa.getNome()); 
      this.pst.setString(2, pessoa.getCPF()); 
      this.pst.setBoolean(3, pessoa.isProfessor());
      int rowsAffected = this.pst.executeUpdate();
      if(rowsAffected > 0) {
        System.out.println("Cadastrado com sucesso!");
        return true;
      }
      this.pst.close();
    } catch (SQLException e) {
      System.err.println("PessoaModel::salvar SQLException");
      System.err.println("CPF já cadastrado!");
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
        System.out.printf("CODIGO: %4d | %s: %-40s | CPF: %11s\n", id, entidade, nome, cpf);
      }
      this.rs.close();
      this.pst.close();
    } catch (SQLException e) {
      System.err.println("PessoaModel::getAll SQLException");
      System.err.println(e.getMessage());
    } catch (Exception e) {
      System.err.println("PessoaModel::getAll Exception");
      e.printStackTrace();
    }
  }

  public void update(Pessoa pessoa) {
    try {
      this.pst = this.conn.prepareStatement(
        "UPDATE pessoas SET nome = ? WHERE id = ? AND is_professor = ?");
      this.pst.setString(1, pessoa.getNome());
      this.pst.setInt(2, pessoa.getId());
      this.pst.setBoolean(3, pessoa.isProfessor());
      this.pst.setMaxRows(1);
      int rowsAffected = this.pst.executeUpdate();
      if(rowsAffected > 0) {
        System.out.println("Atualizado com sucesso!");
      } else {
        System.out.println("ID não encontrado!");
      }
      this.pst.close();
    } catch (SQLException e) {
      System.err.println("PessoaModel::update SQLException");
      System.err.println(e.getMessage());
    } catch (Exception e) {
      System.err.println("PessoaModel::update Exception");
      e.printStackTrace();
    }
  }

  public boolean delete(int id, boolean isProfessor) {
    boolean result = false;
    String auxEntidade = isProfessor ? "Professor" : "Aluno";
    String auxEntidade2 = isProfessor ? "disciplina" : "matrícula";
    try {
      this.pst = this.conn.prepareStatement(
        "DELETE FROM pessoas WHERE id = ? AND is_professor = ?"
      );
      this.pst.setInt(1, id);
      this.pst.setBoolean(2, isProfessor);
      this.pst.setMaxRows(1);
      int rowsAffected = this.pst.executeUpdate();
      if (rowsAffected == 1) {
        result = true; 
        System.out.println(auxEntidade + " excluido com sucesso!");
      } else {
        System.out.printf("Erro ao excluir %s", auxEntidade);
        System.out.printf("ID não encontrado!");
      }
      this.pst.close();
    } catch (SQLException e) {
      System.err.println("PessoaModel::delete SQLException");
      System.out.printf("Verifique se o %s esta registrado em uma %s!", auxEntidade, auxEntidade2);
    } catch (Exception e) {
      System.err.println("PessoaModel::delete Exception");
      e.printStackTrace();
    }
    return result;
  }

  public boolean searchName(String name, Boolean isProfessor) {
    boolean result = false;
    try {
      this.pst = this.conn.prepareStatement(
        "SELECT * FROM pessoas WHERE nome LIKE '%"+name+"%' AND is_professor = ?"
      );
      this.pst.setBoolean(1, isProfessor);
      this.rs = this.pst.executeQuery();
      while(this.rs.next()) {
        result = true;
        Integer id = this.rs.getInt("id");
        String nome = this.rs.getString("nome");
        String cpf = this.rs.getString("cpf");
        System.out.printf("CODIGO: %4d | NOME: %-40s | CPF: %11s\n", id, nome, cpf);
      }
      this.rs.close();
      this.pst.close();
    } catch (SQLException e) {
      System.err.println("PessoaModel::delete SQLException");
    } catch (Exception e) {
      System.err.println("PessoaModel::delete Exception");
      e.printStackTrace();
    }
    return result;
  }
}
