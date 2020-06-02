package mg.puc.urna;

/***
 * Representa um item na lista de urnas.
 * @author rafaella-matos
 */
public class ItemListaUrna {
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
