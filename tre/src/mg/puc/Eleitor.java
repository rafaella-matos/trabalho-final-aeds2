package mg.puc;

public class Eleitor {

  private String nome;
  private long numeroTitulo;
  private String nomeMunicipio;
  private String zona;
  private String secao;

  public Eleitor(String nome, long numeroTitulo, String nomeMunicipio, String zona, String secao) {
    this.nome = nome;
    this.numeroTitulo = numeroTitulo;
    this.nomeMunicipio = nomeMunicipio;
    this.zona = zona;
    this.secao = secao;
  }

  public String getNome() {
    return nome;
  }

  public long getNumeroTitulo() {
    return numeroTitulo;
  }

  public String getNomeMunicipio() {
    return nomeMunicipio;
  }

  public String getZona() {
    return zona;
  }

  public String getSecao() {
    return secao;
  }
}
