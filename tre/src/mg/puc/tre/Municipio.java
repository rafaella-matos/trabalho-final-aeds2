package mg.puc;

public class Municipio {

  private String nome;
  private String estado;
  private long habitantes;
  private String vagas;

  public Municipio(String nome, String estado, long habitantes, String vagas) {
    this.nome = nome;
    this.estado = estado;
    this.habitantes = habitantes;
    this.vagas = vagas;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getEstado() {
    return estado;
  }

  public void setEstado(String estado) {
    this.estado = estado;
  }

  public long getHabitantes() {
    return habitantes;
  }

  public void setHabitantes(long habitantes) {
    this.habitantes = habitantes;
  }

  public String getVagas() {
    return vagas;
  }

  public void setVagas(String vagas) {
    this.vagas = vagas;
  }
}
