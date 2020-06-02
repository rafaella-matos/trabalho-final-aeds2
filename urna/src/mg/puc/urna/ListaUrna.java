package mg.puc.urna;

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
}
