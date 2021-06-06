package entidades;

public class Pessoa {

  protected Integer id;
  protected String nome;
  protected String cpf;
  protected Boolean isProfessor;
  
  public Boolean isProfessor () {
    return this.isProfessor;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
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
}
