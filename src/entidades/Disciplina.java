package entidades;

public class Disciplina {
  
  private Integer id;
  private String nome;
  private Integer cargaHoraria;
  private Integer idProfessor;

  public Disciplina(Integer id, String nome, Integer cargaHoraria, Integer idProfessor) {
    this.id = id;
    this.nome = nome;
    this.cargaHoraria = cargaHoraria;
    this.idProfessor = idProfessor;
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

  public Integer getCargaHoraria() {
    return cargaHoraria;
  }

  public void setCargaHoraria(Integer cargaHoraria) {
    this.cargaHoraria = cargaHoraria;
  }

  public Integer getIdProfessor() {
    return idProfessor;
  }

  public void setIdProfessor(Integer idProfessor) {
    this.idProfessor = idProfessor;
  }

  @Override
  public String toString() {
    return "Disciplina [ID=" + id + ", Nome=" + nome + ", Carga Horária=" + cargaHoraria + ", ID Professor=" + idProfessor
        + "]";
  }
}
