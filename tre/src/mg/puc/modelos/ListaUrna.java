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
	 * Adiciona uma urna na cole��o.
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
	 * Obt�m o pr�ximo item na cole��o, a partir da �ltima intera��o na cole��o.
	 * @return O pr�ximo item da cole��o.
	 */
	public Urna obterProximaUrna() {
		if (this.itemAtual == null) {
			// Caso ainda n�o tenha se iniciado alguma intera��o.
			if (this.primeiroItem == null) {
				return null;
			} else {
				this.itemAtual = this.primeiroItem;
				return this.itemAtual.getUrna();
			}
		} else {
			// Caso j� exista alguma intera��o anterior.
			this.itemAtual = this.itemAtual.getProximo();
			if (this.itemAtual == null) {
				return null;
			} else {
				return this.itemAtual.getUrna();
			}
		}
	}
	
	/***
	 * Reinicia o marcador para intera��es na cole��o.
	 */
	public void reiniciarInteracao() {
		this.itemAtual = null;
	}
	
	/***
	 * Representa um item na lista de urnas. A classe � declarada como privada, dentro de ListaUrna, por
	 * somente ser utilizada como apoio para a lista.
	 * @author rafaella-matos
	 */
	private class ItemListaUrna {
		private ItemListaUrna proximo = null;
		private Urna urna = null;
		
		/***
		 * Obt�m o pr�ximo registro da lista.
		 */
		public ItemListaUrna getProximo() {
			return this.proximo;
		}
		
		/***
		 * Configura a refer�ncia ao item seguinte a este.
		 * @param item A refer�ncia ao item posterior a este.
		 */
		public void setProximo(ItemListaUrna item) {
			this.proximo = item;
		}
		
		/***
		 * Obt�m a urna associada a esse item da lista.
		 */
		public Urna getUrna() {
			return this.urna;
		}
		
		/***
		 * Initializa uma nova inst�ncia de Urna.
		 * @param urna A urna para inicializa��o.
		 */
		public ItemListaUrna(Urna urna) {
			this.urna = urna;
		}	
	}
}
