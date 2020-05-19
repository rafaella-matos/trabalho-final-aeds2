package mg.puc;

public class Urna {
  private String nomeMunicipio;
  private String zonaEleitoral;
  private String secao;

  public Urna(String nomeMunicipio, String zonaEleitoral, String secao) {
    this.nomeMunicipio = nomeMunicipio;
    this.zonaEleitoral = zonaEleitoral;
    this.secao = secao;
  }

  public String getNomeMunicipio() {
    return nomeMunicipio;
  }

  public void setNomeMunicipio(String nomeMunicipio) {
    this.nomeMunicipio = nomeMunicipio;
  }

  public String getZonaEleitoral() {
    return zonaEleitoral;
  }

  public void setZonaEleitoral(String zonaEleitoral) {
    this.zonaEleitoral = zonaEleitoral;
  }

  public String getSecao() {
    return secao;
  }

  public void setSecao(String secao) {
    this.secao = secao;
  }

}
