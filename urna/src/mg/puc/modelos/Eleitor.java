package mg.puc.modelos;

public class Eleitor {

  private String nome;
  private int numeroTitulo;
  private String nomeMunicipio;
  private String zona;
  private String secao;

  public Eleitor(String nome, int numeroTitulo, String nomeMunicipio, String zona, String secao) {
    this.nome = nome;
    this.numeroTitulo = numeroTitulo;
    this.nomeMunicipio = nomeMunicipio;
    this.zona = zona;
    this.secao = secao;
  }

  public String getNome() {
    return nome;
  }

  public int getNumeroTitulo() {
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

  @Override
  public int hashCode() {
    return numeroTitulo;
  }
}
