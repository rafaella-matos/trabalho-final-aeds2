package mg.puc.urna;

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
}
