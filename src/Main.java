import controller.DisciplinaController;
import controller.PessoaController;
import entidades.Aluno;
import entidades.Disciplina;
import entidades.Professor;

import utils.Front;
import utils.Terminal;

public class Main {
  public static void main(String[] args) {
    
    // MENU PRINCIPAL
    while(true) {
      Terminal.clearScreen();
      Front.boxTitulo("DESAFIO 01 - GESTÃO DE DISCIPLINAS");
      Front.menuPrincipal();    
      var opcaoNivel01 = Terminal.getInt();
      switch(opcaoNivel01) {
        case 1:
          // MENU DE CADASTROS
          while(true) {
            Terminal.clearScreen();
            Front.menuCadastros();
            var opcaoNivel02 = Terminal.getInt();
            switch(opcaoNivel02){
              case 1: 
                // OPÇÕES DE CADASTROS DE ALUNOS
              case 2: 
                // OPÇÕES DE CADASTROS DE PROFESSORES
              case 3: 
                // OPÇÕES DE CADASTROS DE DISCIPLINAS
                while(true) {
                  var auxEntidade = "";
                  Terminal.clearScreen();
                  switch(opcaoNivel02) {
                    case 1: auxEntidade = "Aluno"; break;
                    case 2: auxEntidade = "Professor"; break;
                    case 3: auxEntidade = "Disciplina"; break;
                  }
                  Front.menuCadastrosEntidades(auxEntidade);
                  int opcaoNivel03 = Terminal.getInt();
                  switch(opcaoNivel03){
                    // cadastrar aluno/professor/disciplina
                    case 1:
                      System.out.println("\n===== Cadastrar " + auxEntidade + " ====="); 
                      switch(opcaoNivel02) {
                        case 1: // aluno
                        case 2: // professor
                          /*Ao selecionar cadastrar, o sistema pedira para digitar os valores dos campos Nome e CPF e após 
                          a digitação do último campo deverá inserir no banco de dados e voltar para a lista de opções.  
                          Caso já exista um aluno/professor com o mesmo CPF, apresentar uma mensagem informando o fato.*/
                          System.out.println("Informe o Nome: ");
                          var auxNome = Terminal.teclado.nextLine();
                          System.out.println("Informe o CPF: ");
                          var auxCPF = Terminal.teclado.nextLine();
                          var auxPessoa = opcaoNivel02 == 1 ? new Aluno(null, auxNome, auxCPF) : new Professor(null, auxNome, auxCPF);
                          PessoaController.cadastrar(auxPessoa);
                          break;
                        case 3: // disciplina
                          /*Ao selecionar cadastrar, o sistema pedira para digitar os valores dos campos Codigo da Disciplina, 
                          Nome da Disciplina, Carga Horaria, Codigo do Professor e após a digitação do último campo deverá 
                          inserir no banco de dados e voltar para a lista de opções. Caso o código do professor não existir, 
                          ou já existir uma disciplina com o mesmo nome, apresentar uma mensagem informando o fato.*/
                          System.out.println("Informe o CÓDIGO: ");
                          var auxCodigo = Terminal.getInt();
                          System.out.println("Informe o NOME: ");
                          auxNome = Terminal.teclado.nextLine();
                          System.out.println("Informe a CARGA HORÁRIA: ");
                          var auxCargaHoraria = Terminal.getInt();
                          System.out.println("Informe o CÓDIGO do professor: ");
                          int auxCodProfessor = Terminal.getInt();
                          var disciplina = new Disciplina(auxCodigo, auxNome, auxCargaHoraria, auxCodProfessor);
                          DisciplinaController.cadastrar(disciplina);
                          break;
                      }
                      break;
                  
                    case 2: // alterar aluno/professor
                      /*Ao selecionar alterar, o sistema pedira o codigo do aluno/professor, o novo nome do 
                      aluno/professor e após a digitação procerá com a alteração dos dados no banco de dados. 
                      Caso, não exista um aluno/professor com este código será apresentado uma mensagem 
                      informando o fato e o usuário deverá digitar um enter para voltar para a lista de opções. 
                      Não será permitido a alteração do CPF.*/
                      System.out.println("\n===== Alterar dados do " + auxEntidade + " =====");
                      System.out.println("Infome o codigo: ");
                      var auxCodigo = Terminal.getInt();
                      System.out.println("Informe o novo nome: ");
                      var auxNome = Terminal.teclado.nextLine();
                      switch(opcaoNivel02) {
                        case 1: // alunos
                        case 2: /* ===== ALTERAR ALUNO OU PROFESSOR  ===== */
                          var auxPessoa = opcaoNivel02 == 1 ? new Aluno(auxCodigo, auxNome, null) : new Professor(auxCodigo, auxNome, null);
                          PessoaController.alterar(auxPessoa);
                          break;
                        case 3: // disciplina
                          /*Ao selecionar alterar, o sistema pedira o codigo da disciplina, o novo nome da disciplina, 
                          a nova carga horária, o novo código do professor e após a digitação procerá com a alteração dos 
                          dados no banco de dados. Caso, não exista uma disciplina com este código será apresentado uma 
                          mensagem informando o fato e o usuário deverá digitar um enter para voltar para a lista de opções.*/
                          System.out.println("Informe a nova carga horária: ");
                          var auxCargaHoraria = Terminal.getInt();
                          System.out.println("Infome o codigo do professor: ");
                          var auxIdProfessor = Terminal.getInt();
                          var auxDisciplina = new Disciplina(auxCodigo, auxNome, auxCargaHoraria, auxIdProfessor);
                          DisciplinaController.alterar(auxDisciplina);
                          break;
                      }
                      break;
                    case 3: /* ===== OPCAO DISCIPLINA  ===== */
                      System.out.println("\n===== Excluir dados do " + auxEntidade + " =====");
                      System.out.printf("Infome o codigo do %s: ", auxEntidade);
                      auxCodigo = Terminal.getInt();
                      switch(opcaoNivel02) {
                        case 1: // alunos
                        case 2: // professor
                          var auxPessoa = opcaoNivel02 == 1 ? new Aluno(auxCodigo, null, null) : new Professor(auxCodigo, null, null);
                          PessoaController.excluir(auxPessoa);
                          break;
                        case 3: // disciplina
                          var auxDisciplina = new Disciplina(auxCodigo, null, null, null);
                          DisciplinaController.excluir(auxDisciplina);
                          break;
                      }
                      break;
                    case 4: 
                      /*
                      Ao selecionar consultar, o sistema pedira para digitar o nome do aluno e procederá com 
                      a consulta no banco de dados pelo nome utilizando LIKE. Após a consulta o sistema exibirá 
                      os dados do aluno e aguardará o usuário digitar um enter para voltar para a lista de opções.
                       Caso não exista nenhum aluno com o nome informado, exibir uma mensagem informando o fato.
                      */
                      System.out.println("\n===== Consultar dados do " + auxEntidade + " =====");
                      System.out.println("Consulta nome: ");
                      auxNome = Terminal.teclado.nextLine();
                      switch(opcaoNivel02) {
                        case 1: 
                        case 2:
                          var auxPessoa = opcaoNivel02 == 1 ? new Aluno(null, auxNome, null) : new Professor(null, auxNome, null); 
                          PessoaController.consultar(auxPessoa); 
                        break; 
                        case 3: DisciplinaController.consultar(auxNome); break;
                      }                      
                      break;
                    case 5: // listar todos alunos/professores/disciplinas
                      System.out.println("\n===== Listar todos " + auxEntidade + " =====");
                      switch(opcaoNivel02) {
                        case 1:
                        case 2: PessoaController.listar(opcaoNivel02); break;
                        case 3: DisciplinaController.listar(); break;
                      }
                      break;
                  }
                  if(opcaoNivel03 == 6) break; 
                }
                break;
              // volta ao menu principal
              case 4: break;
            }
            if(opcaoNivel02 == 4) break; 
          }
          break;
        case 2: 
          // MENU DE MATRÍCULAS
          System.out.println("Matrículas");
          break;
        case 3: 
          // MENU DE RELATÓRIOS
          System.out.println("Relatórios");
          break;
        case 4: break; 
      }


      if(opcaoNivel01 == 4) break; 
    }
    System.out.println("Programa Finalizado!");
    System.out.println("");
    Terminal.teclado.close();
  }
}
