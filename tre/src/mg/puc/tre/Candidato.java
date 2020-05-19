package mg.puc;

public class Candidato {
  private String nome;
  private long numero;
  private String siglaPartido;
  private Cargo cargo;

  public Candidato(String nome, long numero, String siglaPartido, Cargo cargo) {
    this.nome = nome;
    this.numero = numero;
    this.siglaPartido = siglaPartido;
    this.cargo = cargo;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public long getNumero() {
    return numero;
  }

  public void setNumero(long numero) {
    this.numero = numero;
  }

  public String getSiglaPartido() {
    return siglaPartido;
  }

  public void setSiglaPartido(String siglaPartido) {
    this.siglaPartido = siglaPartido;
  }

  public Cargo getCargo() {
    return cargo;
  }

  public void setCargo(Cargo cargo) {
    this.cargo = cargo;
  }
}
