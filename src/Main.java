import controller.DisciplinaController;
import controller.MatriculaController;
import controller.PessoaController;
import entidades.Aluno;
import entidades.Disciplina;
import entidades.Professor;
import utils.Front;
import utils.Terminal;

public class Main {
  public static void main(String[] args) {
    
    menuPrincipal();
    
    System.out.println("Programa Finalizado!\n");
    Terminal.teclado.close();
  }


  public static void menuPrincipal() {
    while(true) {
      Terminal.clearScreen();
      Front.boxTitulo("DESAFIO 01 - GESTÃO DE DISCIPLINAS");
      Front.menuPrincipal();
      // NIVEL 1 - seleciona o menu de CADASTROS/MATRICULAS/RELATORIOS
      var opcaoNivel01 = Terminal.getInt();

      // finaliza programa
      if(opcaoNivel01 == 4) break; 

      switch(opcaoNivel01) {
        case 1: menuCadastros(); break;
        case 2: menuMatriculas(); break;
        case 3: menuRelatorios(); break;
      }
    }
  }

  public static void menuCadastros() {
    // MENU DE CADASTROS
    while(true) {
      Terminal.clearScreen();
      Front.menuCadastros();
      // NIVEL 2 em CADASTROs - seleciona entre ALUNOS/PROFESSOR/DISCIPLINA
      var opcaoNivel02 = Terminal.getInt();

      // volta ao menu principal
      if(opcaoNivel02 == 4) break; 

      // esse programa realiza o cadastro das tres entidades com o mesmo menu!

      if(opcaoNivel02 >= 1 && opcaoNivel02 <= 3)
      while(true) 
      {
        var auxEntidade = "";
        Terminal.clearScreen();
        switch(opcaoNivel02) {
          case 1: auxEntidade = "Aluno"; break;
          case 2: auxEntidade = "Professor"; break;
          case 3: auxEntidade = "Disciplina"; break;
        }

        Front.acaoCadastrosEntidades(auxEntidade);
        // NIVEL 3 - seleciona a ação entre CADASTRAR/ALTERAR/EXCLUIR/CONSULTAR/LISTAR
        int opcaoNivel03 = Terminal.getInt();

        // volta ao menu de cadastros
        if(opcaoNivel03 == 6) break; 

        switch(opcaoNivel03)
        {
          // cadastrar aluno/professor/disciplina
          case 1:
            System.out.println("\n===== Cadastrar " + auxEntidade + " ====="); 
            switch(opcaoNivel02) {
              case 1: // aluno
              case 2: // professor
                System.out.println("Informe o Nome: ");
                var auxNome = Terminal.teclado.nextLine();
                System.out.println("Informe o CPF: ");
                var auxCPF = Terminal.teclado.nextLine();
                var auxPessoa = opcaoNivel02 == 1 ? new Aluno(null, auxNome, auxCPF) : new Professor(null, auxNome, auxCPF);
                PessoaController.cadastrar(auxPessoa);
              break;

              case 3: // disciplina
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
        
          case 2: // alterar aluno/professor/disciplina
            System.out.println("\n===== Alterar dados do " + auxEntidade + " =====");
            System.out.println("Infome o codigo: ");
            var auxCodigo = Terminal.getInt();
            System.out.println("Informe o novo nome: ");
            var auxNome = Terminal.teclado.nextLine();
            switch(opcaoNivel02) {
              case 1: 
              case 2: // alunos e professores
                var auxPessoa = opcaoNivel02 == 1 ? new Aluno(auxCodigo, auxNome, null) : new Professor(auxCodigo, auxNome, null);
                PessoaController.alterar(auxPessoa);
              break;

              case 3: // disciplina
                System.out.println("Informe a nova carga horária: ");
                var auxCargaHoraria = Terminal.getInt();
                System.out.println("Infome o codigo do professor: ");
                var auxIdProfessor = Terminal.getInt();
                var auxDisciplina = new Disciplina(auxCodigo, auxNome, auxCargaHoraria, auxIdProfessor);
                DisciplinaController.alterar(auxDisciplina);
              break;
            }
          break;

          case 3: // Excluir aluno/professor/disciplina
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

          case 4: // consultar aluno/professor/disciplina
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
          
          case 5:
            System.out.println("\n===== Listar todos " + auxEntidade + " =====");
            switch(opcaoNivel02) {
              case 1:
              case 2: PessoaController.listar(opcaoNivel02); break;
              case 3: DisciplinaController.listar(); break;
            }
          break;
        }
      }
    }
  }


  public static void menuMatriculas() {
    // MENU DE MATRÍCULAS
    while(true) {
      Terminal.clearScreen();
      Front.menuMatriculas();
      var opcaoNivel02 = Terminal.getInt();

      // volta ao menu principal
      if(opcaoNivel02 == 5) break;

      switch(opcaoNivel02) {
        case 1: 
          System.out.println("\n===== Matricular Aluno =====");
          System.out.println("Código da disciplina: ");
          int auxCodigoDisciplina = Terminal.getInt();
          System.out.println("Código do aluno: ");
          int auxCodigoAluno = Terminal.getInt();
          MatriculaController.matricularAluno(auxCodigoDisciplina, auxCodigoAluno);
        break;

        case 2: 
          System.out.println("\n===== Excluir Matricula de Aluno =====");
          System.out.println("Código da Disciplina: ");
          auxCodigoDisciplina = Terminal.getInt();
          System.out.println("Código do Aluno");
          auxCodigoAluno = Terminal.getInt();
          MatriculaController.removerMatricula(auxCodigoDisciplina, auxCodigoAluno);
        break;
        
        case 3:
          System.out.println("\n===== Listar Alunos de uma Disciplina ====="); 
          System.out.println("Código da Disciplina: ");
          auxCodigoDisciplina = Terminal.getInt();
          MatriculaController.listarAlunosDisciplina(auxCodigoDisciplina);
        break;

        case 4: 
          System.out.println("\n===== Listar Disciplinas de um Aluno ====="); 
          System.out.println("Código do Aluno: ");
          auxCodigoAluno = Terminal.getInt();
          MatriculaController.listarDisciplinasAluno(auxCodigoAluno);
        break;
      }
    }
  }

  public static void menuRelatorios() {
    System.out.println("MENU de RELATÓRIOS");
    System.out.println("W.i.P");
    Terminal.pressEnterToContinue();
  }
}
