package mg.puc.modelos;

import mg.puc.Urna;

/***
 * Representa uma lista de urnas.
 * @author rafaella-matos
 */
public class ListaUrna {

	private ItemListaUrna primeiroItem = null;
	private ItemListaUrna itemAtual = null;
	
	/***
	 * Adiciona uma urna na coleção.
	 * @param urna A urna a ser adicionada.
	 */
	public void adicionarUrna(Urna urna) {
		ItemListaUrna item = new ItemListaUrna(urna);
		
		if (this.primeiroItem == null) {
			this.primeiroItem = item;
		} else {
			this.primeiroItem.setProximo(item);
		}
	}
	
	/***
	 * Obtém o próximo item na coleção, a partir da última interação na coleção.
	 * @return O próximo item da coleção.
	 */
	public Urna obterProximaUrna() {
		if (this.itemAtual == null) {
			// Caso ainda não tenha se iniciado alguma interação.
			if (this.primeiroItem == null) {
				return null;
			} else {
				this.itemAtual = this.primeiroItem;
				return this.itemAtual.getUrna();
			}
		} else {
			// Caso já exista alguma interação anterior.
			this.itemAtual = this.itemAtual.getProximo();
			if (this.itemAtual == null) {
				return null;
			} else {
				return this.itemAtual.getUrna();
			}
		}
	}
	
	/***
	 * Reinicia o marcador para interações na coleção.
	 */
	public void reiniciarInteracao() {
		this.itemAtual = null;
	}
	
	/***
	 * Representa um item na lista de urnas. A classe é declarada como privada, dentro de ListaUrna, por
	 * somente ser utilizada como apoio para a lista.
	 * @author rafaella-matos
	 */
	private class ItemListaUrna {
		private ItemListaUrna proximo = null;
		private Urna urna = null;
		
		/***
		 * Obtém o próximo registro da lista.
		 */
		public ItemListaUrna getProximo() {
			return this.proximo;
		}
		
		/***
		 * Configura a referência ao item seguinte a este.
		 * @param item A referência ao item posterior a este.
		 */
		public void setProximo(ItemListaUrna item) {
			this.proximo = item;
		}
		
		/***
		 * Obtém a urna associada a esse item da lista.
		 */
		public Urna getUrna() {
			return this.urna;
		}
		
		/***
		 * Initializa uma nova instância de Urna.
		 * @param urna A urna para inicialização.
		 */
		public ItemListaUrna(Urna urna) {
			this.urna = urna;
		}	
	}
}
