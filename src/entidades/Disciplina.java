package entidades;

public class Disciplina {
  
  private int id;
  private String nome;
  private int cargaHoraria;
  private int idProfessor;
  
  public Disciplina(String nome, int cargaHoraria, int idProfessor) {
    this.nome = nome;
    this.cargaHoraria = cargaHoraria;
    this.idProfessor = idProfessor;
  }

  public Disciplina(int id, String nome, int cargaHoraria, int idProfessor) {
    this.id = id;
    this.nome = nome;
    this.cargaHoraria = cargaHoraria;
    this.idProfessor = idProfessor;
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

  public int getCargaHoraria() {
    return cargaHoraria;
  }

  public void setCargaHoraria(int cargaHoraria) {
    this.cargaHoraria = cargaHoraria;
  }

  public int getIdProfessor() {
    return idProfessor;
  }

  public void setIdProfessor(int idProfessor) {
    this.idProfessor = idProfessor;
  }

  @Override
  public String toString() {
    return "Disciplina [ID=" + id + ", Nome=" + nome + ", Carga Horária=" + cargaHoraria + ", ID Professor=" + idProfessor
        + "]";
  }
}
