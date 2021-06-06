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

  public static void listar(int entidade) {
    var db = new PessoaModel();
    if(entidade == 1) 
      db.getAll(false); 
    else db.getAll(true);
    Terminal.pressEnterToContinue();
  }

  public static void alterar(Pessoa pessoa) {
    if(pessoa.getId() > 0 && pessoa.getNome().length() > 0) {
      var db = new PessoaModel();
      db.update(pessoa);
    } else {
      System.out.println("Preencha corretamente os campos ID e Novo Nome!");   
      System.out.println("ID deve ser um inteiro positivo!");   
      System.out.println("Novo nome não pode ser vazio!");   
    }
    Terminal.pressEnterToContinue();
  }

  public static void excluir(Pessoa p) {
    if(p.getId() > 0 && p.getNome() == null && p.getCPF() == null) {
      var db = new PessoaModel();
      db.delete(p.getId(), p.isProfessor());
    } else {  
      System.out.println("ID deve ser um inteiro positivo!");   
    }
    Terminal.pressEnterToContinue();
  }

  public static void consultar(Pessoa p) {
    if(!p.getNome().isEmpty()) {
      var db = new PessoaModel();
      System.out.println("\nRESULTADO DA CONSULTA");
      if(!db.searchName(p.getNome(), p.isProfessor())) System.out.println("Nada encontrado com o termo digitado!");
    } else {  
      System.out.println("Preecha um NOME para consultar!");
    }
    Terminal.pressEnterToContinue();
  }
}
