package mg.puc.modelos;

/**
 * Representa uma lista genérica.
 * 
 * @author
 * @param <E> O tipo do elemento para definir a lista.
 */
public class Lista<E> {

	protected Celula<E> primeiro;
	protected Celula<E> ultimo;

	/**
	 * Initializa uma nova instância da lista.
	 */
	public Lista() {
		primeiro = null;
		ultimo = primeiro;
	}

	/**
	 * Insere um elemento ao final da lista.
	 * 
	 * @param elemento
	 */
	public void inserir(E elemento) {

		if (this.primeiro == null) {
			this.primeiro = new Celula<E>(elemento, null);
			this.ultimo = this.primeiro;
		} else {
			Celula<E> celula = new Celula<E>(elemento, null);
			this.ultimo.proximo = celula;
		}

	}

	/**
	 * Remove um elemento da lista.
	 * 
	 * @param elemento O elemento a ser removido.
	 * @return O elemento removido, ou nulo.
	 */
	public E retirar(E elemento) {
		Celula<E> proximo, anterior;

		if (this.primeiro.equals(elemento) && this.ultimo.equals(elemento)) {
			this.primeiro = null;
			this.ultimo = null;
			return elemento;
		} else {
			anterior = primeiro;
			proximo = primeiro.proximo;

			while (proximo != null) {
				if (proximo.item.equals(elemento)) {
					anterior.proximo = proximo.proximo;
					return proximo.item;
				} else {
					anterior = proximo;
					proximo = proximo.proximo;
				}
			}
		}

		return null;
	}

	/**
	 * Localiza um elemento na lista.
	 * 
	 * @param item
	 * @return
	 */
	public E localizar(E item) {
		Celula<E> celulaLocalizada = localizarCelula(item);
		if (celulaLocalizada == null) {
			return null;
		}
		return celulaLocalizada.item;
	}

	private Celula<E> localizarCelula(E item) {
		Celula<E> aux;

		aux = primeiro.proximo;

		while (aux != null) {
			if (aux.item.equals(item)) {
				return aux;
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

	/**
	 * Obtém o primeiro elemento da lista.
	 * 
	 * @return O primeiro elemento da lista.
	 */
	public Celula<E> getPrimeiro() {
		return this.primeiro;
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

	/**
	 * Representa uma célula da lista.
	 * 
	 * @author
	 *
	 * @param <E> O tipo de elemento da célula.
	 */
	public static class Celula<E> {
		private E item;
		public Celula<E> proximo;

		/**
		 * Obtém o item associado à célula atual.
		 * 
		 * @return O item associado.
		 */
		public E getItem() {
			return this.item;
		}

		/**
		 * Inicializa uma célula.
		 * 
		 * @param elemento O elemento que será contido na célula.
		 * @param proximo  O próximo elemento para a célula.
		 */
		public Celula(E elemento, Celula<E> proximo) {
			this.item = elemento;
			this.proximo = proximo;
		}
	}
}
