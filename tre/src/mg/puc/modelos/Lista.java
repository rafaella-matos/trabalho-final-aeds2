package mg.puc.modelos;

import java.util.Objects;

public class Lista<E> {

  private final Celula<E> primeiro;
  private Celula<E> ultimo;

  public Lista() {
    primeiro = new Celula<E>();

    ultimo = primeiro;
  }

  public void inserirFinal(E elemento) {
    Celula<E> aux = new Celula<E>();

    ultimo.proximo = aux;

    aux.item = elemento;

    ultimo = ultimo.proximo;
  }

  public E retirar(int hash) {
    Celula<E> aux, anterior;

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

  public E localizar(int hash) {
    Celula<E> aux;

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
    Celula<E> aux = primeiro.proximo;

    while (aux != null) {
      tamanho++;
      aux = aux.proximo;
    }

    return tamanho;
  }

  @Override
  public String toString() {
    Celula<E> aux = primeiro.proximo;
    StringBuilder sb = new StringBuilder();
    while (aux != null) {
      sb.append(aux.toString());
      aux = aux.proximo;
    }
    return sb.toString();
  }

  private static class Celula<E> {
    E item;
    public Celula<E> proximo;

    Celula() {
    }

    Celula(E elemento, Celula<E> proximo) {
      this.item = elemento;
      this.proximo = proximo;
    }
  }
}

