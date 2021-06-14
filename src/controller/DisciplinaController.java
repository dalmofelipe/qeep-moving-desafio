package controller;

import entidades.Disciplina;
import models.DisciplinaModel;
import utils.Terminal;
import utils.Validacoes;

public class DisciplinaController {

  public static void cadastrar(Disciplina disciplina) {
    var db = new DisciplinaModel();
    db.salvar(disciplina);
    Terminal.pressEnterToContinue();
  }

  public static void listar() {
    var db = new DisciplinaModel();
    db.getAll();
    Terminal.pressEnterToContinue();
  }

  public static void alterar(Disciplina disciplina) {

    boolean validaID1 = Validacoes.integerGreatherZero(disciplina.getId(), "ID DISCIPLINA deve ser um valor positivo!");
    boolean validaString1 = Validacoes.stringNoEmpty(disciplina.getNome(), "O campo NOME DISCIPLINA não pode ser vazio!");
    boolean validaID2 = Validacoes.integerGreatherZero(disciplina.getIdProfessor(), "ID PROFESSOR Inválido!");

    if(validaID1 && validaString1 && validaID2) {
      var db = new DisciplinaModel();
      if(db.update(disciplina)) {
        db.closeConn();
        return;
      };
    } 
    
    Terminal.pressEnterToContinue();
  }
  
  public static void excluir(Disciplina d) {

    boolean validaID1 = Validacoes.integerGreatherZero(d.getId(), "ID DISCIPLINA Inválido!");
    boolean validaID2 = Validacoes.integerGreatherZero(d.getIdProfessor(), "ID PROFESSOR Inválido!");
    boolean validaCH = Validacoes.integerGreatherZero(d.getCargaHoraria(), "CARGA HORÁRIA deve ser um valor positivo!");
    boolean validaNome = Validacoes.notNull(d.getNome(), "O campo NOME não pode ser vazio!");

    if(validaID1 && validaID2 && validaCH && validaNome) {
      var db = new DisciplinaModel();
      db.delete(d.getId());
      db.closeConn();
    }

    Terminal.pressEnterToContinue();
  }

  public static void consultar(String termo) {
    if(Validacoes.stringNoEmpty(termo, "Preecha um NOME para consultar!")) {
      var db = new DisciplinaModel();
      System.out.println("\nRESULTADO DA CONSULTA");
      if(!db.searchName(termo)) System.out.println("Nada encontrado com o termo digitado!");
      db.closeConn();
    }
    Terminal.pressEnterToContinue();
  }
}
