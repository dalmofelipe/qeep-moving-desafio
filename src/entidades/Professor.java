package entidades;

public class Professor extends Pessoa {

  public Professor(Integer id, String nome, String cpf) {
    this.id = id;
    this.nome = nome;
    this.cpf = cpf;
    this.isProfessor = true;
  }

  @Override
  public String toString() {
    return "Professor [ID=" + id + ", Nome=" + nome + ", CPF=" + cpf + "]";
  }
}
