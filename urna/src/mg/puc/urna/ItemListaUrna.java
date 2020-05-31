package mg.puc.urna;

/***
 * Representa um item na lista de urnas.
 * @author rafaella-matos
 */
public class ItemListaUrna {
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
