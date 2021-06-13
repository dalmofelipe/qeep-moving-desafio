package controller;

import models.MatriculaModel;
import utils.Validacoes;
import utils.Terminal;

public class MatriculaController {

   public static void matricularAluno(int idDisciplina, int idAluno) {

      boolean validaID1 = Validacoes.integerGreatherZero(idDisciplina, "ID Disciplina é Inválido!");
      boolean validaID2 = Validacoes.integerGreatherZero(idAluno, "ID Aluno é Inválido!");

      if(validaID1 && validaID2) {
         var db = new MatriculaModel();
         db.matricular(idDisciplina, idAluno);
         db.closeConn();
      }

      Terminal.pressEnterToContinue();
   }

   public static void removerMatricula(int idDisciplina, int idAluno) {

      boolean validaID1 = Validacoes.integerGreatherZero(idDisciplina, "ID Disciplina é Inválido!");
      boolean validaID2 = Validacoes.integerGreatherZero(idAluno, "ID Aluno é Inválido!");

      if(validaID1 && validaID2) {
         var db = new MatriculaModel();
         db.remover(idDisciplina, idAluno);
         db.closeConn();
      }

      Terminal.pressEnterToContinue();
   }

   public static void listarAlunosDisciplina(int idDisciplina) {

      boolean validaID = Validacoes.integerGreatherZero(idDisciplina, "ID Disciplina é Inválido!");

      if(validaID) {
         var db = new MatriculaModel();
         db.alunosDisciplina(idDisciplina);
         db.closeConn();
      }

      Terminal.pressEnterToContinue();
   }

   public static void listarDisciplinasAluno(int idAluno) {

      boolean validaID = Validacoes.integerGreatherZero(idAluno, "ID Aluno é Inválido!");

      if(validaID) {
         var db = new MatriculaModel();
         db.disciplinasAluno(idAluno);
         db.closeConn();
      }

      Terminal.pressEnterToContinue();
   }
}
