package entidades;

public class Aluno extends Pessoa {
 
  public Aluno(String nome, String cpf) {
    this.nome = nome;
    this.cpf = cpf;
    isProfessor = false;
  }
  public Aluno(int id, String nome, String cpf) {
    this.id = id;
    this.nome = nome;
    this.cpf = cpf;
    isProfessor = false;
  }

  @Override
  public String toString() {
    return "Aluno [ID=" + id + ", Nome=" + nome + ", CPF=" + cpf + "]";
  }
}
