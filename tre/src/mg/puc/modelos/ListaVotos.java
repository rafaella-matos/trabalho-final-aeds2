package mg.puc.modelos;

import javax.naming.OperationNotSupportedException;

import mg.puc.Candidato;
import mg.puc.Voto;

/**
 * Representa uma lista de votos.
 * 
 * @author rafaella-matos
 */
public class ListaVotos extends Lista<Voto> {

	/**
	 * Inicializa a listagem de votos para os candidatos.
	 * 
	 * @param candidatos A lista de candidatos.
	 */
	public ListaVotos(ListaCandidatos candidatos) {
		Celula<Candidato> aux = candidatos.primeiro;

		while (aux != null) {
			this.inserir(new Voto(aux.getItem().getNumero()));
			aux = aux.proximo;
		}
	}

	/**
	 * Registra um voto para um candidato.
	 * 
	 * @param numeroCandidato
	 * @throws OperationNotSupportedException
	 */
	public void registrar(long numeroCandidato) throws OperationNotSupportedException {

		Voto voto = localizar(numeroCandidato);
		if (voto == null) {
			throw new OperationNotSupportedException(
					"N�o � poss�vel registrar voto para um candidato n�o previamente associado.");
		}

		voto.incrementar();
	}

	/**
	 * Localiza o voto para um determinado n�mero de candidato.
	 * 
	 * @param numeroCandidato O n�mero de candidato para pesquisa.
	 * @return A quantidade de votos associada.
	 */
	public Voto localizar(long numeroCandidato) {
		Celula<Voto> aux;

		aux = primeiro;

		while (aux != null) {
			if (aux.getItem().getNumeroCandidato() == numeroCandidato) {
				return aux.getItem();
			} else {
				aux = aux.proximo;
			}
		}

		return null;
	}

}
