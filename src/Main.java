import java.util.Scanner;

import controller.DisciplinaController;
import controller.PessoaController;
import entidades.Aluno;
import entidades.Disciplina;
import entidades.Pessoa;
import entidades.Professor;

import utils.Front;
import utils.Terminal;

public class Main {
  public static void main(String[] args) {

    var teclado = new Scanner(System.in);
    int opcaoNivel01, opcaoNivel02, opcaoNivel03, auxCargaHoraria, auxCodigo;
    String auxNome, auxCPF, auxEntidade = "";
    Pessoa auxPessoa;

    // MENU PRINCIPAL
    while(true) {
      Terminal.clearScreen();
      Front.boxTitulo("DESAFIO 01 - GESTÃO DE DISCIPLINAS");
      Front.menuPrincipal();    
      opcaoNivel01 = Terminal.getInt(teclado);
      switch(opcaoNivel01) {
        case 1:
          // MENU DE CADASTROS
          while(true) {
            Terminal.clearScreen();
            Front.menuCadastros();
            opcaoNivel02 = Terminal.getInt(teclado);
            switch(opcaoNivel02){
              case 1: 
                // MENU DE CADASTROS DE ALUNOS
              case 2: 
                // MENU DE CADASTROS DE PROFESSORES
              case 3: 
                // MENU DE CADASTROS DE DISCIPLINAS
                while(true) {
                  Terminal.clearScreen();
                  switch(opcaoNivel02) {
                    case 1: auxEntidade = "Aluno"; break;
                    case 2: auxEntidade = "Professor"; break;
                    case 3: auxEntidade = "Disciplina"; break;
                  }
                  Front.menuCadastrosEntidades(auxEntidade);
                  opcaoNivel03 = Terminal.getInt(teclado);
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
                          auxNome = teclado.nextLine();
                          System.out.println("Informe o CPF: ");
                          auxCPF = teclado.nextLine();
                          auxPessoa = opcaoNivel02 == 1 ? new Aluno(auxNome, auxCPF) : new Professor(auxNome, auxCPF);

                          PessoaController.cadastrar(auxPessoa);
                          break;
                        case 3: // disciplina
                          /*Ao selecionar cadastrar, o sistema pedira para digitar os valores dos campos Codigo da Disciplina, 
                          Nome da Disciplina, Carga Horaria, Codigo do Professor e após a digitação do último campo deverá 
                          inserir no banco de dados e voltar para a lista de opções. Caso o código do professor não existir, 
                          ou já existir uma disciplina com o mesmo nome, apresentar uma mensagem informando o fato.*/
                          System.out.println("Informe o CÓDIGO: ");
                          auxCodigo = Terminal.getInt(teclado);
                          System.out.println("Informe o NOME: ");
                          auxNome = teclado.nextLine();
                          System.out.println("Informe a CARGA HORÁRIA: ");
                          auxCargaHoraria = Terminal.getInt(teclado);
                          System.out.println("Informe o CÓDIGO do professor: ");
                          int auxCodProfessor = Terminal.getInt(teclado);
                          
                          var disciplina = new Disciplina(auxCodigo, auxNome, auxCargaHoraria, auxCodProfessor);

                          DisciplinaController.cadastrar(disciplina);
                          break;
                      }
                      break;
                  
                    case 2: // alterar aluno/professor/disciplina
                      /*Ao selecionar alterar, o sistema pedira o codigo do aluno/professor/disciplina, o novo nome do 
                      aluno/professor/disciplina e após a digitação procerá com a alteração dos dados no banco de dados. 
                      Caso, não exista um aluno/professor/disciplina com este código será apresentado uma mensagem 
                      informando o fato e o usuário deverá digitar um enter para voltar para a lista de opções. 
                      Não será permitido a alteração do CPF.*/
                      System.out.println("\n===== Alterar dados do " + auxEntidade + " =====");
                      System.out.println("Infome o codigo: ");
                      auxCodigo = Terminal.getInt(teclado);
                      System.out.println("Informe o novo nome: ");
                      auxNome = teclado.nextLine();
                      switch(opcaoNivel02) {
                        case 1: // alunos
                        case 2: // professor
                          // TODO: salvar alterações
                          break;
                        case 3: // disciplina
                          /*Ao selecionar alterar, o sistema pedira o codigo da disciplina, o novo nome da disciplina, 
                          a nova carga horária, o novo código do professor e após a digitação procerá com a alteração dos 
                          dados no banco de dados. Caso, não exista uma disciplina com este código será apresentado uma 
                          mensagem informando o fato e o usuário deverá digitar um enter para voltar para a lista de opções.*/
                          System.out.println("Informe a nova carga horária: ");
                          auxCargaHoraria = Terminal.getInt(teclado);
                          // TODO: salvar alterações
                          break;
                      }
                      
                      
                      Terminal.pressEnterToContinue();
                      break;
                    case 3: 
                      System.out.println("\n===== Excluir dados do " + auxEntidade + " =====");
                      System.out.println("Excluir"); 
                      
                      Terminal.pressEnterToContinue();
                      break;
                    case 4: 
                      System.out.println("\n===== Consultar dados do " + auxEntidade + " =====");
                      System.out.println("Consultar "); 
                      Terminal.pressEnterToContinue();
                      break;
                    case 5: // listar todos alunos/professores/disciplinas
                      System.out.println("\n===== Listar todos " + auxEntidade + " =====");
                      switch(opcaoNivel02) {
                        case 1:
                        case 2: PessoaController.listar(opcaoNivel02); break;
                        case 3: DisciplinaController.listar(); break;
                      }
                      break;
                    
                    // volta ao menu de cadastros
                    case 6: break; 
                  }
                  if(opcaoNivel03 == 6) break; else continue;
                }
                break;
              // volta ao menu principal
              case 4: break;
            }
            if(opcaoNivel02 == 4) break; else continue;
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
        case 0: break; 
      }


      if(opcaoNivel01 == 4) break; else continue;
    }
    System.out.println("Programa Finalizado!");
    System.out.println("");
    teclado.close();
  }
}
