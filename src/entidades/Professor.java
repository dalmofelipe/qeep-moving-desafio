package entidades;

public class Professor extends Pessoa {

  public Professor(String nome, String cpf) {
    this.nome = nome;
    this.cpf = cpf;
    isProfessor = true;
  }
  public Professor(int id, String nome, String cpf) {
    this.id = id;
    this.nome = nome;
    this.cpf = cpf;
    isProfessor = true;
  }

  @Override
  public String toString() {
    return "Professor [ID=" + id + ", Nome=" + nome + ", CPF=" + cpf + "]";
  }
}
