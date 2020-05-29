package mg.puc;

public class Partido {

  private final String nome;
  private final String sigla;
  private final String caminho;

  public Partido(String nome, String sigla) {
    this.nome = nome;
    this.sigla = sigla;
    this.caminho = caminho;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getSigla() {
    return sigla;
  }

  public void setSigla(String sigla) {
    this.sigla = sigla;
  }

  @Override public String toString() {
    return "mg.puc.Partido{" +
          "nome='" + nome + '\'' +
          ", sigla='" + sigla + '\'' +
          '}';
  }
}
