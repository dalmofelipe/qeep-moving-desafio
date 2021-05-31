package entidades;

public class Pessoa {

  protected int id;
  protected String nome;
  protected String cpf;
  static boolean isProfessor;
  
  public boolean isProfessor () {
    return isProfessor;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getCPF() {
    return cpf;
  }

  public void setCPF(String cpf) {
    this.cpf = cpf;
  }

  public static void setProfessor(boolean isProfessor) {
    Pessoa.isProfessor = isProfessor;
  }
  
}
