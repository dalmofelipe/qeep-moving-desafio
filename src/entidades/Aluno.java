package entidades;

public class Aluno extends Pessoa {

  public Aluno(Integer id, String nome, String cpf) {
    this.id = id;
    this.nome = nome;
    this.cpf = cpf;
    this.isProfessor = false;
  }

  @Override
  public String toString() {
    return "Aluno [ID=" + id + ", Nome=" + nome + ", CPF=" + cpf + "]";
  }
}
