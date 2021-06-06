package controller;

import entidades.Disciplina;
import models.DisciplinaModel;
import utils.Terminal;

public class DisciplinaController {
  

  public static boolean pesquisarID(Integer id) {
    if(id > 0) {
      var db = new DisciplinaModel();
      return db.hasID(id);
    } else {
      System.out.println("Informe um ID válido!");
    }
    return false;
  }

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
    if(disciplina.getId() > 0) {
      if(disciplina.getNome().length() > 0) {
        if(disciplina.getIdProfessor() > 0) {
          var db = new DisciplinaModel();
          if(db.update(disciplina)) return;
        } else {
          System.out.println("Informe um ID DO PROFESSOR válido!");
        }
      } else {
        System.out.println("O campo NOME não pode ser vazio!");
      }
    } else {
      System.out.println("Informe um ID válido!");
    }
    Terminal.pressEnterToContinue();
  }
  
  public static void excluir(Disciplina d) {
    if(d.getId() > 0 && d.getNome() == null && d.getCargaHoraria() == null && d.getIdProfessor() == null) {
      var db = new DisciplinaModel();
      db.delete(d.getId());
    } else {
      System.out.println("Informe um ID válido!");
    }
    Terminal.pressEnterToContinue();
  }

  public static void consultar(String termo) {
    if(!termo.isEmpty()) {
      var db = new DisciplinaModel();
      System.out.println("\nRESULTADO DA CONSULTA");
      if(!db.searchName(termo)) System.out.println("Nada encontrado com o termo digitado!");
    } else {  
      System.out.println("Preecha um NOME para consultar!");
    }
    Terminal.pressEnterToContinue();
  }
}
