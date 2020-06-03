package mg.puc.modelos;

public class ListaEleitores {

  private final Celula primeiro;
  private Celula ultimo;

  public ListaEleitores() {
    primeiro = new Celula();

    ultimo = primeiro;
  }

  public void inserirFinal(Eleitor elemento) {
    Celula aux = new Celula();

    ultimo.proximo = aux;

    aux.item = elemento;

    ultimo = ultimo.proximo;
  }

  public Eleitor retirar(int hash) {
    Celula aux, anterior;

    anterior = primeiro;

    aux = primeiro.proximo;

    while (aux != null) {
      if (aux.item.hashCode() == hash) {
        anterior.proximo = aux.proximo;

        if (aux == ultimo) {
          ultimo = anterior;
        }
        return aux.item;
      } else {
        anterior = aux;
        aux = aux.proximo;
      }
    }
    return null;
  }

  public Eleitor localizar(int hash) {
    Celula aux;

    aux = primeiro.proximo;

    while (aux != null) {
      if (aux.item.hashCode() == hash) {
        return aux.item;
      } else {
        aux = aux.proximo;
      }
    }
    return null;
  }

  public Boolean listaVazia() {
    return primeiro == ultimo;
  }

  public int tamanho() {
    int tamanho = 0;
    Celula aux = primeiro.proximo;

    while (aux != null) {
      tamanho++;
      aux = aux.proximo;
    }

    return tamanho;
  }

  @Override
  public String toString() {
    Celula aux = primeiro.proximo;
    StringBuilder sb = new StringBuilder();
    while (aux != null) {
      sb.append(aux.toString());
      aux = aux.proximo;
    }
    return sb.toString();
  }

  private static class Celula {
    Eleitor item;
    public Celula proximo;
  }
}
