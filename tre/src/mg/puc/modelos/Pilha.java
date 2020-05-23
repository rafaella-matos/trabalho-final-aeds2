package mg.puc.modelos;

public class Pilha<E> {

  private final Celula<E> fundo;

  private Celula<E> topo;

  public Pilha() {
    Celula<E> aux = new Celula<>(null, null);
    fundo = aux;
    topo = aux;
  }

  public void empilhar(E elem) {
    Celula<E> aux = new Celula<>(elem, null);
    aux.proximo = topo;
    aux.item = elem;

    topo = aux;
  }

  public E desempilhar() {
    E aux = null;

    if (!pilhaVazia()) {
      aux = topo.item;

      topo = topo.proximo;

    }
    return (aux);
  }

  public Boolean pilhaVazia() {
    return fundo == topo;
  }

  public E obterTopo() {
    return topo.item;
  }

  public int obterNumeroItens() {
    int tamanho = 0;
    Celula<E> celula = topo;
    while (celula.proximo != null) {
      celula = celula.proximo;
      tamanho++;
    }
    return tamanho;
  }

  private static class Celula<E> {
    E item;
    public Celula<E> proximo;

    Celula(E element, Celula<E> proximo) {
      this.item = element;
      this.proximo = proximo;
    }
  }
}

