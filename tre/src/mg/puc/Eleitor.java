package mg.puc;

public class Eleitor {

  private final String nome;
  private final long numeroTitulo;
  private final String nomeMunicipio;
  private final String zona;
  private final String secao;
  private final String caminho;

  public Eleitor(String nome, long numeroTitulo, String nomeMunicipio, String zona, String secao) {
    this.nome = nome;
    this.numeroTitulo = numeroTitulo;
    this.nomeMunicipio = nomeMunicipio;
    this.zona = zona;
    this.secao = secao;
    this.caminho = caminho;
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

  @Override public String toString() {
    return nome + ';' + numeroTitulo + ';' + nomeMunicipio + ';' + zona + ';' + secao;
  }
}
