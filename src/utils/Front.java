package utils;

public class Front {
  
  public static void boxTitulo(String titulo) {
    int aux = (78 - titulo.length()) / 2;
    System.out.println("\n+------------------------------------------------------------------------------+");
    // System.out.print("|");
    for(int i = 0; i < aux; i++) System.out.print(" ");
    System.out.print(titulo.toUpperCase());
    for(int i = 0; i < aux; i++) System.out.print(" ");
    //System.out.print("|\n");
    System.out.println("\n+------------------------------------------------------------------------------+");
  }

  public static void menuPrincipal() {
    System.out.println("\nMenu Principal\n");
    System.out.println("1 - Cadastros");
    System.out.println("2 - Matricula");
    System.out.println("3 - Relatorios");
    System.out.println("4 - Sair");
    System.out.print("\n\nDigite a opção desejada: ");
  }

  public static void menuCadastros() {
    // System.out.println("\n--------------------------------------------------------------------------------\n");
    // System.out.println("Menu Cadastros\n");
    boxTitulo(" GESTÃO DE CADASTROS");
    System.out.println("\n1 - Alunos");
    System.out.println("2 - Professores");
    System.out.println("3 - Disciplinas");
    System.out.println("4 - Menu Principal");
    System.out.print("\n\nDigite a opção desejada: ");
  }

  public static void acaoCadastrosEntidades(String entidade) {
    // System.out.println("\n--------------------------------------------------------------------------------\n");
    // System.out.printf("Menu Cadastro de %s\n\n", entidade);
    boxTitulo("AÇÕES DE CADASTRO DE " + entidade.toUpperCase());
    System.out.println("\n1 - Cadastrar");
    System.out.println("2 - Alterar");
    System.out.println("3 - Excluir");
    System.out.println("4 - Consultar ");
    System.out.println("5 - Listar Todos");
    System.out.println("6 - Menu Anterior");
    System.out.print("\n\nDigite a opção desejada: ");
  }
  
  public static void menuMatriculas() {
    // System.out.println("\n--------------------------------------------------------------------------------\n");
    // System.out.println("Menu Matricula\n");
    boxTitulo("GESTÃO DE MATRÍCULAS");
    System.out.println("\n1 - Cadastrar");
    System.out.println("2 - Remover");
    System.out.println("3 - Alunos de uma Disciplina");
    System.out.println("4 - Disciplinas de um Aluno");
    System.out.println("5 - Menu Anterior");
    System.out.print("\n\nDigite a opção desejada: ");
  }

}
