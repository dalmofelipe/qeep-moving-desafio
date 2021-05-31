package entidades;

public class Matricula {
  
  private int id;
  private int idDisciplina;
  private String cpfAluno;
  
  public Matricula(int idDisciplina, String cpfAluno) {
    this.idDisciplina = idDisciplina;
    this.cpfAluno = cpfAluno;
  }

  public Matricula(int id, int idDisciplina, String cpfAluno) {
    this.id = id;
    this.idDisciplina = idDisciplina;
    this.cpfAluno = cpfAluno;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getIdDisciplina() {
    return idDisciplina;
  }

  public void setIdDisciplina(int idDisciplina) {
    this.idDisciplina = idDisciplina;
  }

  public String getCpfAluno() {
    return cpfAluno;
  }

  public void setCpfAluno(String cpfAluno) {
    this.cpfAluno = cpfAluno;
  }

  @Override
  public String toString() {
    return "Matricula [cpfAluno=" + cpfAluno + ", id=" + id + ", idDisciplina=" + idDisciplina + "]";
  }
  
  
}
