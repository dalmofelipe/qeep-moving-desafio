package controller;

import entidades.Pessoa;
import models.PessoaModel;
import utils.Terminal;
import utils.Validacoes;

public class PessoaController {

  public static void cadastrar(Pessoa pessoa) {
    if (Validacoes.cpfIsValid(pessoa.getCPF())) {
      var db = new PessoaModel();
      // pesquisar se o pessoa.cpf do aluno/professor já existe no banco
      var resultado = db.buscarCPF(pessoa.getCPF());
      if(resultado == null) {
        // inserir aluno/professor no banco de dados
        db.salvar(pessoa);
      } else {
        System.out.println("CPF já Cadastrado!");
        Terminal.pressEnterToContinue();
      }
    } else {
      System.out.println("CPF Inválido, digite o CPF com ponto e traço!");
      Terminal.pressEnterToContinue();
    }
  }

  public static void listar(int opcaoNivel02) {
    var db = new PessoaModel();
    if(opcaoNivel02 == 1) 
      db.getAll(false); 
    else db.getAll(true);
    Terminal.pressEnterToContinue();
  }
}
