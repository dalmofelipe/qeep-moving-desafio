package models;

import java.sql.SQLException;

public class MatriculaModel extends Model {
   
   public boolean matricular(int idDisciplina, int idAluno) {
      boolean result = false;
      try {
         String sql = 
         "INSERT INTO matriculas (id_disciplina, id_pessoa) "
         +"VALUES (?, (SELECT p.id "
         +"FROM pessoas p "
         +"WHERE p.id = ? AND is_professor = FALSE));";
         this.pst = this.conn.prepareStatement(sql);
         this.pst.setInt(1, idDisciplina);
         this.pst.setInt(2, idAluno);
         this.rs = this.pst.executeQuery();
         if(rs.next()) {
            System.out.println("tem proximo - matricular");
         }
         this.rs.close();
         this.pst.close();
      } 
      catch (SQLException e) {
         System.out.println("Erro ao matricular Aluno!");
         System.err.println("MatriculaModel::matricular SQLException\n" + e.getMessage());
      } catch (Exception e) {
         System.err.println("MatriculaModel::matricular Exception");
         e.printStackTrace();
      }
      return result;
   }

   public boolean remover(int idDisciplina, int idAluno) {
      boolean result = false;
      try {
         String sql = "DELETE FROM matriculas WHERE id_disciplina = ? AND id_pessoa = ?";
         this.pst = this.conn.prepareStatement(sql);
         this.pst.setInt(1, idDisciplina);
         this.pst.setInt(2, idAluno);
         this.rs = this.pst.executeQuery();
         if(rs.next()) {
            System.out.println("tem proximo - remover");
         }
         this.rs.close();
         this.pst.close();
      } 
      catch (SQLException e) {
         System.out.println("Erro ao remover matricula!");
         System.err.println("MatriculaModel::remover SQLException\n" + e.getMessage());
      } catch (Exception e) {
         System.err.println("MatriculaModel::remover Exception");
         e.printStackTrace();
      }
      return result;
   }

   public boolean alunosDisciplina(int idDisciplina) {
      boolean result = false;
      try {
         String sql = 
         "SELECT p.nome AS aluno, d.nome AS disciplina, d.id AS codigo "
         +"FROM pessoas p, disciplinas d, matriculas m "
         +"WHERE d.id = ? "
         +"AND m.id_pessoa = p.id AND m.id_disciplina = d.id";
         this.pst = this.conn.prepareStatement(sql);
         this.pst.setInt(1, idDisciplina);
         this.rs = this.pst.executeQuery();
         if(rs.next()) {
            String disciplina = this.rs.getString("disciplina");
            System.out.println("\nALUNOS MATRICULADOS NA DISCIPLINA");
            System.out.printf("CODIGO: %6d | DISCIPLINA: %-20s\n", idDisciplina, disciplina);
            System.out.println("ALUNOS: ");
            String aluno = this.rs.getString("aluno");
            System.out.printf("\n - %-40s", aluno);
            while(rs.next()) {
               aluno = this.rs.getString("aluno");
               System.out.printf("\n - %-40s", aluno);
            }
            System.out.println();
         } else {
            System.out.println("Nenhum registro encontrado!");
         }
         this.rs.close();
         this.pst.close();
      } 
      catch (SQLException e) {
         System.out.println("Erro ao consultar Alunos de uma Disciplina!");
         System.err.println("MatriculaModel::alunosDisciplina SQLException\n" + e.getMessage());
      } catch (Exception e) {
         System.err.println("MatriculaModel::alunosDisciplina Exception");
         e.printStackTrace();
      }
      return result;
   }

   public boolean disciplinasAluno(int idAluno) {
      boolean result = false;
      try {
         String sql = 
         "SELECT p.nome AS aluno, d.nome AS disciplina, d.id AS codigo "
         +"FROM pessoas p, disciplinas d, matriculas m "
         +"WHERE p.id = ? "
         +"AND m.id_pessoa = p.id AND m.id_disciplina = d.id";
         this.pst = this.conn.prepareStatement(sql);
         this.pst.setInt(1, idAluno);
         this.rs = this.pst.executeQuery();
         if(rs.next()) {
            String aluno = this.rs.getString("aluno");
            System.out.println("\nDISCIPLINAS DO ALUNO\n");
            System.out.printf("CODIGO: %6d | ALUNO: %-20s\n", idAluno, aluno);
            System.out.println("DISCIPLINAS: ");
            String disciplina = this.rs.getString("disciplina");
            System.out.printf("\n - %-20s", disciplina);
            while(rs.next()) {
               disciplina = this.rs.getString("disciplina");
               System.out.printf("\n - %-20s", disciplina);
            }
            System.out.println();
         } else {
            System.out.println("Nenhum registro encontrado!");
         }
         this.rs.close();
         this.pst.close();
      } 
      catch (SQLException e) {
         System.out.println("Erro ao consulat Disciplinas de um Aluno!");
         System.err.println("MatriculaModel::disciplinasAluno SQLException\n" + e.getMessage());
      } catch (Exception e) {
         System.err.println("MatriculaModel::disciplinasAluno Exception");
         e.printStackTrace();
      }
      return result;
   }
}
