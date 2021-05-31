package models;

import java.sql.SQLException;

import entidades.Disciplina;

public class DisciplinaModel extends Model {
  
  public boolean salvar(Disciplina disciplina) {
    boolean result = false;
    try {
      this.pst = this.conn.prepareStatement(
        "INSERT INTO disciplinas (id, nome, carga_horaria, id_pessoa)"
        +" SELECT ?, ?, ?, ?"
        +" FROM pessoas p "
        +" WHERE p.id = ? AND p.is_professor = TRUE");
      this.pst.setInt(1, disciplina.getId());
      this.pst.setString(2, disciplina.getNome());
      this.pst.setInt(3, disciplina.getCargaHoraria());
      this.pst.setInt(4, disciplina.getIdProfessor());
      this.pst.setInt(5, disciplina.getIdProfessor());
      this.pst.setMaxRows(1);
      int rowsAffected = this.pst.executeUpdate();
      if(rowsAffected > 0) {
        System.out.println("Disciplina Cadastrada com sucesso!");
        result = true; 
      } else {
        System.out.println("Erro ao salvar Disciplina! Verique os códigos da disciplina e/ou do professor!");
      }
      this.pst.close();
      this.conn.close();
    } catch (SQLException e) {
      System.err.println("DisciplinaModel::salvar SQLException = " + e.getMessage());
    } catch (Exception e) {
      System.err.println("DisciplinaModel::salvar Exception = " + e.getMessage());
    }
    return result;
  }

  public void getAll() {
    try {
      this.st = this.conn.createStatement();
      this.rs = st.executeQuery("SELECT d.id, d.nome, d.carga_horaria, p.nome AS prof_nome"
      +" FROM disciplinas d, pessoas p"
      +" WHERE d.id_pessoa = p.id");
      System.out.printf("\nEXIBINDO Disciplinas!\n");
      while (rs.next()) {
        int id = rs.getInt("id");
        String nome = rs.getString("nome");
        int ch = rs.getInt("carga_horaria");
        String nomeProf = rs.getString("prof_nome");
        System.out.printf("CODIGO: %d | DISCIPLINA: %s | CARGA HORARIA: %d horas | PROFESSOR: %s\n", id, nome, ch, nomeProf);
      }
      this.rs.close();
      this.st.close();
      this.conn.close();
    } catch (SQLException e) {
      System.err.println("DisciplinaModel::getAll SQLException");
      System.err.println(e.getMessage());
    } catch (Exception e) {
      System.err.println("DisciplinaModel::getAll Exception");
      System.err.println(e.getMessage());
    }
  }
}
