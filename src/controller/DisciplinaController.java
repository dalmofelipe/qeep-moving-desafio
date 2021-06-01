package controller;

import entidades.Disciplina;
import models.DisciplinaModel;
import utils.Terminal;

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
}
